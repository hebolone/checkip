/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package checkip;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 *
 * @author simone
 */
public class CGetIP {
    public CGetIP() {
        
    }
    public class CResponse {
        public CResponse(boolean iIsOk, String iMessage) {
            IsOk = iIsOk;
            Message = iMessage;
        }
        public final boolean IsOk;
        public final String Message;
    }
    private final String m_Url = "http://ipecho.net/plain";
    public CResponse GetIP() throws IOException {
        URL url;
        try {
            url = new URL(m_Url);
        }
        catch(MalformedURLException mue) {
            return new CResponse(false, "Malformed Url");
        }
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        //int code = conn.getResponseCode();
        DataInputStream input = new DataInputStream(conn.getInputStream());
        int c;
        StringBuilder resultBuf = new StringBuilder();
        while((c = input.read()) != -1) {
            resultBuf.append((char) c);
        }
        input.close();
        return new CResponse(true, resultBuf.toString());
    }
}
//------------------------------------------------------------------------------
 