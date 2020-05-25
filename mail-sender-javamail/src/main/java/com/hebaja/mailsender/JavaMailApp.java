package com.hebaja.mailsender;

import java.util.Properties;
import javax.mail.Session;
import javax.mail.Store;
import javax.mail.Address;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.NoSuchProviderException;
import javax.mail.PasswordAuthentication;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class JavaMailApp {

	public static void main(String[] args) throws MessagingException {
		Properties props = new Properties();
	    //** Parâmetros de conexão com servidor Gmail *
		
//		props.put("mail.smtp.host", "smtp.gmail.com");
//		props.put("mail.smtp.socketFactory.port", "465");
//		props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
//		props.put("mail.smtp.auth", "true");
//		props.put("mail.smtp.port", "465");
		
//		props.put("mail.imap.ssl.enable", "true");
//		props.put("mail.imap.auth.machanisms", "XOAUTH2");
		
		props.put("mail.imap.ssl.enable", "true"); // required for Gmail
		 props.put("mail.imap.sasl.enable", "true");
		 props.put("mail.imap.sasl.mechanisms", "XOAUTH2");
		 props.put("mail.imap.auth.login.disable", "true");
		 props.put("mail.imap.auth.plain.disable", "true");
		
		
//		Session session = Session.getDefaultInstance(props, 
//			new javax.mail.Authenticator() {
//				protected PasswordAuthentication getPasswordAuthentication() {
//					return new PasswordAuthentication("hebajabackup@gmail.com", "111712");
//			}
//		});
		
//		Session session = Session.getInstance(props);
//		Store store = session.getStore("imap");
//		store.connect("imap.gmail.com", "945534568573-946h11s9tnaso8qlele4s339i32b3aj4.apps.googleusercontent.com", "Z4Gokc7TbtLV7afUv-J9j2t1");
		
				
		Session session = Session.getInstance(props);

		 
	    /** Ativa Debug para sessão */
		
		try {
			//Remetente
			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress("hebaja@gmail.com"));
			
			//Destinatário(s)
			Address[] toUser = InternetAddress.parse("hebaja@yahoo.com.br, feanor_esc@hotmail.com");
			
			
			
			//Assunto
			message.setRecipients(Message.RecipientType.TO, toUser);
			message.setSubject("Enviando email com JavaMail");
			
			//Corpo email
			message.setText("Enviei este email utilizando o JavaMail com autenticação XOAUTH2!");
			
			
			Transport transport = session.getTransport("smpt");
			transport.connect("smtp.gmail.com", "hebaja@gmail.com", "Z4Gokc7TbtLV7afUv-J9j2t1");
			Transport.send(message, message.getAllRecipients());
			
//			Transport.send(message);
			
			System.out.println("Pronto");
			
		} catch (MessagingException e) {
			throw new RuntimeException(e);
		}
		
	}
}
