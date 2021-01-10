package com.dibas;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class SendEmailUsingGMailSMTP {

	public static void main(String[] args) {

		Properties props = new Properties();

		// To use TLS
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.host", Constants.HOST);

		// To use SSL
		props.put("mail.smtp.socketFactory.port", Constants.PORT);
		props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
		props.put("mail.smtp.port", Constants.PORT);
		props.put("mail.transport.protocol", Constants.PROTOCOL);

		// Remove incase any isssue 
		//props.put("mail.debug", "true");
		
		// Get the Session object.

		Session session = Session.getInstance(props, new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(Constants.USERNAME, Constants.SECRET_CODE);
			}
		});

		try {
			// Create a default MimeMessage object.
			Message message = new MimeMessage(session);

			// Set From: header field of the header.
			message.setFrom(new InternetAddress(Constants.FROM_MAILID));

			// Set To: header field of the header.
			message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(Constants.TO_MAILID));

			// Set Subject: header field
			message.setSubject("Testing Subject");

			// Now set the actual message

			message.setText("Hello, this is sample for to check send email using JavaMailAPI.");

			// Send message
			Transport.send(message);
			System.out.println("Sent message successfully....");

		} catch (MessagingException e) {
			throw new RuntimeException(e);
		}

	}

}
