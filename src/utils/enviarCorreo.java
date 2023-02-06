package utils;

import java.io.IOException;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

public class enviarCorreo {

	public static void EnviarEmail(String correo, int codigo) throws Exception {

		final String to = "verifycodedaw@yahoo.com";
		final String from = "verifycodedaw@yahoo.com";

		String host = "smtp.mail.yahoo.com";
		Properties properties = System.getProperties();

		properties.put("mail.smtp.ssl.trust", "smtp.mail.yahoo.com");
		properties.put("mail.smtp.host", host);
		properties.put("mail.smtp.port", "587");
		properties.put("mail.smtp.starttls.enable", "true");
		properties.put("mail.smtp.auth", "true");

		Session session = Session.getInstance(properties, new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication("verifycodedaw", "lpqolwadhpemfvkt");
			}
		});

		session.setDebug(true);
		try {
			MimeMessage message = new MimeMessage(session);

			message.setFrom(new InternetAddress(from));
			message.addRecipient(Message.RecipientType.TO, new InternetAddress(correo));
			message.setSubject("CÓDIGO DE VERIFICACIÓN");
			message.setText("Para verificar tu cuenta, ingrese el siguiente código:  " + codigo);

			System.out.println("Enviando correo...");
			Transport.send(message);
			System.out.println("Correo enviado exitosamente.");
		} catch (MessagingException mex) {
			mex.printStackTrace();
		}

		/*
		 * 
		 * //authentication info final String username = "verifycodedaw@yahoo.com";
		 * final String password = "DAW456!"; String fromEmail =
		 * "verifycodedaw@yahoo.com"; String toEmail = correo;
		 * 
		 * Properties properties = new Properties(); properties.put("mail.smtp.auth",
		 * "true"); properties.put("mail.smtp.starttls.enable", "true");
		 * properties.put("mail.smtp.host", "smtp.mail.yahoo.com");
		 * properties.put("mail.smtp.port", "587");
		 * 
		 * Session session = Session.getInstance(properties, new
		 * javax.mail.Authenticator() { protected PasswordAuthentication
		 * getPasswordAuthentication() { return new
		 * PasswordAuthentication(username,password); } }); //Start our mail message
		 * MimeMessage msg = new MimeMessage(session); try { msg.setFrom(new
		 * InternetAddress(fromEmail)); msg.addRecipient(Message.RecipientType.TO, new
		 * InternetAddress(toEmail)); msg.setSubject("Subject Line");
		 * 
		 * Multipart emailContent = new MimeMultipart();
		 * 
		 * //Text body part MimeBodyPart textBodyPart = new MimeBodyPart();
		 * textBodyPart.setText("My multipart text");
		 * 
		 * //Attachment body part. MimeBodyPart pdfAttachment = new MimeBodyPart();
		 * pdfAttachment.attachFile("/home/parallels/Documents/docs/javamail.pdf");
		 * 
		 * //Attach body parts emailContent.addBodyPart(textBodyPart);
		 * emailContent.addBodyPart(pdfAttachment);
		 * 
		 * //Attach multipart to message msg.setContent(emailContent);
		 * 
		 * Transport.send(msg); System.out.println("Sent message"); } catch
		 * (MessagingException e) { e.printStackTrace(); } catch (IOException e) { //
		 * TODO Auto-generated catch block e.printStackTrace(); }
		 * 
		 */

	}

}
