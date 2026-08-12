import java.io.File;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Properties;
import javax.mail.*;
import javax.mail.internet.*;
import javax.swing.JOptionPane;

public class EmailSender {

    public static void sendEmail(String recipientEmail, String subject, String body, 
    		File routePng, File VolumeInfoTxt) throws IOException {
 
        String smtpHost = "smtp.gmail.com"; //Gmail SMTP server
        int smtpPort = 587;  // TLS port
        final String senderEmail = System.getenv("ROUTEFORGE_EMAIL");
        final String senderPassword = System.getenv("ROUTEFORGE_EMAIL_PASSWORD");
        
        if (senderEmail == null || senderPassword == null) {
            throw new IOException("Email credentials are not configured.");
        }

        Properties properties = new Properties();
        properties.put("mail.smtp.host", smtpHost);
        properties.put("mail.smtp.port", smtpPort);  
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.starttls.enable", "true");  // enabling TLS encryption
        properties.put("mail.smtp.ssl.trust", smtpHost);

        Authenticator auth = new Authenticator() {//SMTP
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(senderEmail, senderPassword); 
            }
        };

        Session session = Session.getInstance(properties, auth); //creating email session
        session.setDebug(true); 

        try {
            // new email message
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(senderEmail));
            message.setRecipient(Message.RecipientType.TO, new InternetAddress(recipientEmail));
            message.setSubject(subject);

            Multipart multipart = new MimeMultipart(); //For both the body and attachments
            MimeBodyPart textPart = new MimeBodyPart();
            textPart.setText(body);
            multipart.addBodyPart(textPart);

            LinkedList<File> attachments = new LinkedList<>();
            attachments.add(routePng);
            attachments.add(VolumeInfoTxt);

            // Adding attachments
            for (int i =0;i<attachments.size();i++) {
            	File attachment = attachments.get(i);
                MimeBodyPart attachmentPart = new MimeBodyPart();
                attachmentPart.attachFile(attachment);
                multipart.addBodyPart(attachmentPart);
            }

            message.setContent(multipart);

            // Sending email
            Transport.send(message);
            JOptionPane.showMessageDialog(null, "Email sent successfully!", 
                    "Success", JOptionPane.INFORMATION_MESSAGE);
            
        } catch (MessagingException e) {
            e.printStackTrace();
            System.err.println("There was an error sending the email: " + e.getMessage());
        }
    }
}
