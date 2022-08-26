import java.util.*;
import javax.mail.*;
import javax.mail.internet.*;

import java.util.Properties;
public class Sendmail
{
	public static String getKey() {
		 String Capital_chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
	        String Small_chars = "abcdefghijklmnopqrstuvwxyz";
	        String numbers = "0123456789";
	             
	  
	  
	        String values = Capital_chars + Small_chars +
	                        numbers ;
	  
	        Random rndm_method = new Random();
	  
	        String password = "";
	  
	        for (int i = 0; i < 20; i++)
	        {
	        
	            password=password+values.charAt(rndm_method.nextInt(values.length()));
	  
	        }
	        return password.toString();
	}
	
	
	public static String getRandom() {
        Random rnd = new Random();
        int n1 = rnd.nextInt(9);
        int n2 = rnd.nextInt(9);
        int n3 = rnd.nextInt(9);
        int n4 = rnd.nextInt(9);
        int n5 = rnd.nextInt(9);
        int n6 = rnd.nextInt(9);
        String number=""+n1+n2+n3+n4+n5+n6;
        return number;
    }

public static boolean send(String rep,String ran)

{
	boolean test = false;
	
	try {
        Properties properties = System.getProperties();

        //Gmail SMTP server address
        properties.put("mail.smtp.host", "smtp.gmail.com");
        //Gmail SMTP port (TLS) and for SSL 465 
        properties.put("mail.smtp.port", "587");
        //Gmail SMTP TLS/SSL required: Yes .... it is for saying the end user support tls
        properties.put("mail.smtp.starttls.enable", "true");
        //if not specified it become false
        properties.put("mail.smtp.auth", "true");
       /*
     // Setup mail server
        properties.setProperty("mail.smtp.host", "smtp.gmail.com");
         
        // SSL Port
        properties.put("mail.smtp.port", "465");
         
        // enable authentication
        properties.put("mail.smtp.auth", "true");
         
        // SSL Factory
        properties.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory"); 
        */       
        
	    String user="esp32mailsys@gmail.com";
		String password="x"; 
	
	
		//it a key for session
		Authenticator auth = new Authenticator() {
		
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(user, password);
			}
		};
	    
	Session session = Session.getInstance(properties, auth);
	
	session.setDebug(true);
	
    Message mess = new MimeMessage(session);

    mess.setFrom(new InternetAddress(user));


    mess.setRecipient(Message.RecipientType.TO, new InternetAddress(rep));
	
	
    mess.setSubject("User Email Verification");
    
	
    mess.setText("Registered successfully.Please verify your account using this code: " +ran);
    
    //Multipart email = new MimeMultipart();
    
    //MimeBodyPart att = new MimeBodyPart();
    //att.attachFile("C:\\Users\\Lenova\\Downloads\\Cetificate\\Actalis Client Authentication CA G3");
		
    //mess.setContent(email);
    
	System.out.println(rep);
    Transport.send(mess);
    test=true;
    
} 
	catch (Exception e) {
    e.printStackTrace();
}

return test;
}


public static void sendlogin(String rep,String key)

{
	boolean test = false;
	
	try {
        Properties properties = System.getProperties();
        /*
        //Gmail SMTP server address
        properties.put("mail.smtp.host", "smtp.gmail.com");
        //Gmail SMTP port (TLS) amd for SSL 465 
        properties.put("mail.smtp.port", "587");
        //Gmail SMTP TLS/SSL required: Yes .... it is for saying the end user support tls
        properties.put("mail.smtp.starttls.enable", "true");
        //if not specified it become false
        properties.put("mail.smtp.auth", "true");
        */
    
        properties.setProperty("mail.smtp.host", "smtp.gmail.com");
         
        
        properties.put("mail.smtp.port", "465");
         
        
        properties.put("mail.smtp.auth", "true");
         
        
        properties.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory"); 
              
        
	    String user="esp32mailsys@gmail.com";
		String password="X"; 
	
	
		//it a key for session
		Authenticator auth = new Authenticator() {
		
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(user, password);
			}
		};
	    
	Session session = Session.getInstance(properties, auth);
	
	session.setDebug(true);
	
    //Message mess = new MimeMessage(session);

    //mess.setFrom(new InternetAddress(user));


    //mess.setRecipient(Message.RecipientType.TO, new InternetAddress(rep));
	
	
    //mess.setSubject(" Email secure link ");
    
	String path="http://localhost:8080/Sign_login_logout_json/Sec?key="+key+"";
    
    MimeBodyPart mbp = new MimeBodyPart(); 
    mbp.setContent(path, "text/html"); 
    MimeMultipart multipart = new MimeMultipart(); 
    multipart.addBodyPart(mbp); 
    MimeMessage message = new MimeMessage(session);
    message.setFrom(new InternetAddress(user));
    message.setContent(multipart);
    message.addRecipient(
            Message.RecipientType.TO,
            new InternetAddress(rep));
    message.setSubject("Secure link:");
    message.setText(path);
    //mess.setContent(path,"text/html");
    
    //Multipart email = new MimeMultipart();
    
    //MimeBodyPart att = new MimeBodyPart();
    //att.attachFile("C:\\Users\\Lenova\\Downloads\\Cetificate\\Actalis Client Authentication CA G3");
		
    //mess.setContent(email);
    
	System.out.println(rep);
    Transport.send(message);
    
    
} 
	catch (Exception e) {
    e.printStackTrace();
}
}
}

