/**
 * 
 */
package dao;


import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 * @author Mr.SAAD
 *
 */
public class SendMail {
	static Properties mailServerProperties;
	static Session getMailSession;
	static MimeMessage generateMailMessage;
 
	public static void generateAndSendEmail(String email,String token , String prenom) throws AddressException, MessagingException {
 
		// Step1
		mailServerProperties = System.getProperties();
		mailServerProperties.put("mail.smtp.port", "587");
		mailServerProperties.put("mail.smtp.auth", "true");
		mailServerProperties.put("mail.smtp.starttls.enable", "true");
 
		// Step2
		getMailSession = Session.getDefaultInstance(mailServerProperties, null);
		generateMailMessage = new MimeMessage(getMailSession);
		generateMailMessage.addRecipient(Message.RecipientType.TO, new InternetAddress(email));
		generateMailMessage.setSubject("activation de compte ");
		String url = "http://localhost:8082/atelier_2/Activate?token="+token;
		String emailBody = "<html><font >Bonjour Mr/MMe."+prenom+" </font><br><br>Veuillez cliquez sur ce lien pour valider votre compte : "+url+"<br><br><br>Cordialement"
				+ "</html>";				
		generateMailMessage.setContent(emailBody, "text/html");
 
		// Step3
		Transport transport = getMailSession.getTransport("smtp");
		transport.connect("smtp.gmail.com", "hostme.morocco", "marzakpfe");
		transport.sendMessage(generateMailMessage, generateMailMessage.getAllRecipients());
		transport.close();
	}
}
