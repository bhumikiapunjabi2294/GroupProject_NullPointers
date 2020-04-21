///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package Business.EmailSend;
//import java.util.Properties;
//
//import javax.mail.Message;
//import javax.mail.MessagingException;
//import javax.mail.PasswordAuthentication;
//import javax.mail.Session;
//import javax.mail.Transport;
//import javax.mail.internet.InternetAddress;
//import javax.mail.internet.MimeMessage;
//import javax.mail.*;  
//import javax.mail.internet.*;  
///**
// *
// * @author Yash
// */
//public class GenrateEmail {
//    private String email;
//
//    public GenrateEmail(String email) {
//        this.email=email;
//    }
//    String to = "bhumikapunjabi2294@gmail.com";
//
//// Add sender
//        String from = "yashthakkar248@gmail.com";
//        final String username = "yashthakkar248@gmail.com";//your Gmail username 
//        final String password = "Yt123456789@";//your Gmail password
//
//        String host = "smtp.gmail.com";
//
//        Properties props = new Properties();
//        props.put("mail.smtp.auth", "true");
//        props.put("mail.smtp.starttls.enable", "true");
//        props.put("mail.smtp.host", host);
//        props.put("mail.smtp.port", "587");
//
//// Get the Session object
//        Session session = Session.getInstance(props, new javax.mail.Authenticator() {
//                protected PasswordAuthentication getPasswordAuthentication() {
//                return new PasswordAuthentication(username, password);
//            }
//        });
//
//        try {
//            // Create a default MimeMessage object
//            Message message = new MimeMessage(session);
//
//            message.setFrom(new InternetAddress(from));
//
//            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(to));
//
//            // Set Subject
//            message.setSubject("ALERT");
//
//            // Put the content of your message
//            message.setText("Hi there,we are just experimenting with JavaMail here");
//
//// Send message
//            Transport.send(message);
//
//           // System.out.println("Helooowwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww");
//
//        } catch (MessagingException e) {
//            throw new RuntimeException(e);
//        }
//    
//    
//}
