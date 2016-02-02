/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package checkip;
/*
import java.util.*;
import javax.mail.*;
import javax.mail.internet.*;
import javax.activation.*;
*/
/**
 *
 * @author simone
 */
public class SendEmail {
    public SendEmail(String iFrom, String iTo, String iSubject, String iBody) {
        m_From = iFrom;
        m_To = iTo;
        m_Subject = iSubject;
        m_Body = iBody;
    }
    //   *** MEMBERS ***
    private final String m_From, m_To, m_Subject, m_Body;
    //   *** METHODS ***
/*    public boolean Send(String [] args) {
        boolean retValue = false;
        // Recipient's email ID needs to be mentioned.
        //String to = "abcd@gmail.com";

        // Sender's email ID needs to be mentioned
        //String from = "web@gmail.com";

        // Assuming you are sending email from localhost
        String host = "localhost";

        // Get system properties
        Properties properties = System.getProperties();

        // Setup mail server
        properties.setProperty("mail.smtp.host", host);

        // Get the default Session object.
        Session session = Session.getDefaultInstance(properties);

        try{
           // Create a default MimeMessage object.
           MimeMessage message = new MimeMessage(session);

           // Set From: header field of the header.
           message.setFrom(new InternetAddress(m_From));

           // Set To: header field of the header.
           message.addRecipient(Message.RecipientType.TO, new InternetAddress(m_To));

           // Set Subject: header field
           message.setSubject("This is the Subject Line!");

           // Now set the actual message
           message.setText("This is actual message");

           // Send message
           Transport.send(message);
           retValue = true;
        }
        catch (MessagingException mex) {
           mex.printStackTrace();
        }
        return retValue;
    }*/
}
