package com.jobkuri.Service;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.mail.SimpleMailMessage;
// import org.springframework.mail.javamail.JavaMailSender;

import org.springframework.stereotype.Service;

import com.jobkuri.DTO.EmailRequestDTO;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class EmailService {

//	@Autowired
//	private JavaMailSender mailSender;
	
	
//	public void sendEmail1(EmailRequestDTO dto) {
		
//		SimpleMailMessage message = new SimpleMailMessage();
//		message.setTo(dto.getTo());
//		message.setSubject(dto.getSubject());
//		message.setText(dto.getBody());
		
//		mailSender.send(message);
		
//	}
	
	
	
	public void sendEmail(EmailRequestDTO dto) {
		
		final String fromEmail= "thenpandi2775@gmail.com";
		final String password = "rtxjgakwcecsamkt";
		
		
		
		Properties props = new Properties();
		
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.port", "587");
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		
		
		
		Session session = Session.getInstance(props, new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				
				return new PasswordAuthentication(fromEmail,password);
			}
			
		});
		
		try {
			
			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress(fromEmail));
			message.setRecipients(Message.RecipientType.TO,InternetAddress.parse(dto.getTo()) );
			message.setSubject(dto.getSubject());
			message.setText(dto.getBody());
			
			Transport.send(message);
			System.out.println("Email sent to"+dto.getTo());
			
			} 
		catch (MessagingException e) {
			throw new RuntimeException("Failed to send Email" , e);
				
		}
	}
}


