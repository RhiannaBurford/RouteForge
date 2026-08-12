import java.util.Properties;

import jakarta.mail.Session;

public class TEsting {
    public static void main(String[] args) {
        Properties props = new Properties();
        props.put("mail.smtp.host", "smtp-mail.outlook.com");
        props.put("mail.smtp.port", "587");
        props.put("mail.smtp.auth", "true");

        Session session = Session.getDefaultInstance(props);
        System.out.println("Session created successfully: " + session);
    }
}