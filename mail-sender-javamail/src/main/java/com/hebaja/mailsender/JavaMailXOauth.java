package com.hebaja.mailsender;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.sql.Date;
import java.util.HashMap;
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

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JavaMailXOauth{

	public static void main(String[] args) throws MessagingException {
		
//		String TOKEN_URL = "https://www.googleapis.com/oauth2/v4/token";
		
		String TOKEN_URL = "https://accounts.google.com/o/oauth2/auth";
		
		String oauthClientId = "945534568573-946h11s9tnaso8qlele4s339i32b3aj4.apps.googleusercontent.com";
		String oauthSecret = "Z4Gokc7TbtLV7afUv-J9j2t1";
//		String refreshToken = "";
		String accessToken = "https://oauth2.googleapis.com/token";
		long tokenExpires = 1458168133864L;

		if (System.currentTimeMillis() > tokenExpires) {
		    try {
		        String request = "client_id=" + URLEncoder.encode(oauthClientId, "UTF-8")
		                + "&client_secret=" + URLEncoder.encode(oauthSecret, "UTF-8");
//		                + "&refresh_token=" + URLEncoder.encode(refreshToken, "UTF-8")
//		                + "&grant_type=refresh_token";
		        HttpURLConnection conn = (HttpURLConnection) new URL(TOKEN_URL).openConnection();
		        conn.setDoOutput(true);
		        conn.setRequestMethod("POST");
		        PrintWriter out = new PrintWriter(conn.getOutputStream());
		        out.print(request); // note: println causes error
		        out.flush();
		        out.close();
		        conn.connect();
		        try {
		            HashMap<String, Object> result;
		            result = new ObjectMapper().readValue(conn.getInputStream(), new TypeReference<HashMap<String, Object>>() {
		            });
		            accessToken = (String) result.get("access_token");
		            tokenExpires = System.currentTimeMillis() + (((Number) result.get("expires_in")).intValue() * 1000);
		        } catch (IOException e) {
		            String line;
		            BufferedReader in = new BufferedReader(new InputStreamReader(conn.getErrorStream()));
		            while ((line = in.readLine()) != null) {
		                System.out.println(line);
		            }
		            System.out.flush();
		        }
		    } catch (Exception e) {
		        e.printStackTrace();
		    }
		}
		
		
		
		Properties props = new Properties();
		
//		props.put("mail.imap.ssl.enable", "true"); // required for Gmail
//		props.put("mail.imap.sasl.enable", "true");
//		props.put("mail.imap.sasl.mechanisms", "XOAUTH2");
//		props.put("mail.imap.auth.login.disable", "true");
//		props.put("mail.imap.auth.plain.disable", "true");
		
		
//		props.put("mail.imap.ssl.enable", "true"); // required for Gmail
//		props.put("mail.imap.auth.mechanisms", "XOAUTH2");
		
//		 props.put("mail.smtp.ssl.enable", "true"); // required for Gmail
//		 props.put("mail.smtp.auth.mechanisms", "XOAUTH2");
		
		 
		 props.put("mail.smtp.ssl.enable", "true"); // required for Gmail
		 props.put("mail.smtp.sasl.enable", "true");
		 props.put("mail.smtp.sasl.mechanisms", "XOAUTH2");
		 props.put("mail.smtp.auth.login.disable", "true");
		 props.put("mail.smtp.auth.plain.disable", "true");
		 
		Session session = Session.getInstance(props);
				
		Message msg = new MimeMessage(session);
		msg.setFrom(new InternetAddress("hebaja"));
		msg.addRecipient(Message.RecipientType.TO, new InternetAddress("feanor_esc@hotmail.com"));

		msg.setSubject("JavaMail OAuth2 test");
		msg.setSentDate(new Date(tokenExpires));
		msg.setText("Hello, world with OAuth2!\n");
		msg.saveChanges();
		
//		Transport transport = session.getTransport("smpt");
//		transport.connect("smtp.gmail.com", "hebaja", accessToken);
//		Transport.send(msg, msg.getAllRecipients());
		
		Store store = session.getStore("imap");
		 store.connect("imap.gmail.com", "hebaja", accessToken);
		 
		
	}
}
