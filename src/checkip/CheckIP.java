/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package checkip;

import java.io.IOException;

/**
 *
 * @author simone
 */
public class CheckIP {
    public static void main(String[] args) {
        CGetIP getIP = new CGetIP();
        String ip;
        try {
            CGetIP.CResponse response = getIP.GetIP();
            ip = response.Message;
        }
        catch(IOException ex) {
            ip = "IO Exception while getting IP";
        }
       
        System.out.println(ip);
    }
}
