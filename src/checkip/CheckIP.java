/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package checkip;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import javax.mail.MessagingException;

/**
 *
 * @author simone
 */
public class CheckIP {
    public static void main(String[] args) {
        CGetIP getIP = new CGetIP();
        String ip = null;
        boolean canContinue = true;
        try {
            CGetIP.CResponse response = getIP.GetIP();
            if(response.IsOk)
                ip = response.Message;
            else
                canContinue = false;
        }
        catch(IOException ex) {
            System.out.println("IO Exception while getting IP");
            canContinue = false;
        }
        String recordedIP = null;
        if(canContinue) {
            try {
                recordedIP = ReadTextFile();
            }
            catch(Exception e) {
                System.out.println("Error reading recorded file");
                canContinue = false;
            }
        }
        if(canContinue) {
            if(recordedIP == null ? ip != null : !recordedIP.equals(ip)) {
                //  Send e-mail
                SendEmail se = new SendEmail("Simone-Raspberry", "polo.simone@gmail.com", "New IP", ip);
                try {
                    se.Send();
                    //  Save to record file
                    WriteTextFile(ip);
                }
                catch(MessagingException me) {
                    
                }
            }
        }
        System.out.println(ip);
    }
    //  *** MEMBERS ***
    private static final String m_RecordFile = "ip.txt";
    //  *** METHODS ***
    private static String ReadTextFile() throws FileNotFoundException, IOException {
        StringBuilder sb = new StringBuilder();
        try(BufferedReader br = new BufferedReader(new FileReader(m_RecordFile))) {
            String line = br.readLine();
            while(line != null) {
                sb.append(line);
                sb.append(System.lineSeparator());
                line = br.readLine();
            }
            br.close();
        }
        catch(Exception e) {
            //  ...
        }
        return sb.toString();
    }
    private static void WriteTextFile(String iIP) {
        try(BufferedWriter bw = new BufferedWriter(new FileWriter(m_RecordFile))) {
            bw.write(iIP);
            bw.close();
        }
        catch(Exception e) { }
    }
}
