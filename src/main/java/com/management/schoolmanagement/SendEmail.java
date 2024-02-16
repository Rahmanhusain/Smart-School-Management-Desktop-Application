//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.management.schoolmanagement;

import javax.mail.*;
import javax.mail.Message.RecipientType;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

public class SendEmail {
    public SendEmail() {
    }

    public static void sendmail(String Email, String password, String UserID) {
        String to = Email;
        final String from = "ritchiedennis793@gmail.com";
        String host = "smtp.gmail.com";
        Properties properties = System.getProperties();
        properties.put("mail.smtp.host", host);
        properties.put("mail.smtp.port", "465");
        properties.put("mail.smtp.ssl.enable", "true");
        properties.put("mail.smtp.auth", "true");
        Session session = Session.getInstance(properties, new Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(from, "ftisfslbpdcnyaaj");
            }
        });
        session.setDebug(true);

        try {
            MimeMessage message = new MimeMessage(session);
            message.setFrom(new InternetAddress(from));
            message.addRecipient(RecipientType.TO, new InternetAddress(to));
            message.setSubject("Forget Password- SSM");
            message.setText("Hello User Your Password for User ID- " + UserID + " is [ " + password + " ],\nthank you.");
            System.out.println("sending...");
            Transport.send(message);
            System.out.println("Sent message successfully....");
        } catch (MessagingException var9) {
            var9.printStackTrace();
        }

    }
}
