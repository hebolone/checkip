/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package checkip;

import java.util.*;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;


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
     public void Send() throws MessagingException {
    // Creazione di una mail session
    Properties props = new Properties();
    props.put("mail.smtp.host", "smtp.ilmegliodelweb.com");
    Session session = Session.getDefaultInstance(props);

    // Creazione del messaggio da inviare
    MimeMessage message = new MimeMessage(session);
    message.setSubject(m_Subject);
    message.setText(m_Body);

    // Aggiunta degli indirizzi del mittente e del destinatario
    InternetAddress fromAddress = new InternetAddress(m_From);
    InternetAddress toAddress = new InternetAddress(m_To);
    message.setFrom(fromAddress);
    message.setRecipient(Message.RecipientType.TO, toAddress);

    // Invio del messaggio
    Transport.send(message);
  }
}
