package com.koatchy.configGenerator.tools;

import java.io.IOException;
import java.util.Date;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

import com.koatchy.configGenerator.model.EmailTemplate;

/**
 * @author alfredo.barrios
 *
 */
public class EmailHelper {
	public void sendmail(EmailTemplate email) throws AddressException, MessagingException, IOException {
		   Properties props = new Properties();
		   props.put("mail.smtp.auth", "true");
		   props.put("mail.smtp.starttls.enable", "true");
		   props.put("mail.smtp.host", "smtp.gmail.com");
		   props.put("mail.smtp.port", "587");
		   
		   /* HERE GOES THE PASSWORD */
		   Session session = Session.getInstance(props, new javax.mail.Authenticator() {
		      protected PasswordAuthentication getPasswordAuthentication() {
		         return new PasswordAuthentication("abarrios7007@gmail.com", "3i7W@x*uYp");
		      }
		   });
		   Message msg = new MimeMessage(session);
		   //msg.setFrom(new InternetAddress("tutorialspoint@gmail.com", false));
		   msg.setFrom(new InternetAddress(email.getFrom(), false));

		   //msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse("tutorialspoint@gmail.com"));
		   //msg.setSubject("Tutorials point email");
		   //msg.setContent("Tutorials point email", "text/html");
		   msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse(email.getTo()));
		   msg.setSubject(email.getSubject());
		   msg.setContent(email.getMessage(), "text/html");
		   msg.setSentDate(new Date());

		   MimeBodyPart messageBodyPart = new MimeBodyPart();
		   messageBodyPart.setContent(email.getMessage(), "text/html");

		   Multipart multipart = new MimeMultipart();
		   multipart.addBodyPart(messageBodyPart);
		   MimeBodyPart attachPart = new MimeBodyPart();

		   //attachPart.attachFile("/var/tmp/image19.png");
		   //multipart.addBodyPart(attachPart);
		   msg.setContent(multipart);
		   Transport.send(msg);   
		}
}
