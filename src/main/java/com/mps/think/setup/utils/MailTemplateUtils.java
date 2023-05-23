package com.mps.think.setup.utils;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;
@Component
public class MailTemplateUtils {
	
	@Autowired
	private Environment env;
	
public void sendMailToCus(String emailFrom,String emailTo,String emailCC,String emailSubject,String emailContent) throws AddressException, MessagingException  {
		
		Properties props = new Properties();
		props.put("mail.smtp.host", env.getProperty("MAIL_SMTP_HOST"));
		Session session = Session.getDefaultInstance(props);
		
		MimeMessage message = new MimeMessage(session);
		message.setFrom(new InternetAddress(emailFrom.trim()));
		message.addRecipient(Message.RecipientType.TO, new InternetAddress(emailTo.trim()));
		if (!emailCC.trim().isEmpty()) {
			message.addRecipient(Message.RecipientType.CC, new InternetAddress(emailCC.trim()));
		}
		
		String subject = emailSubject;
		String content = emailContent;
//				"<p>Hello,</p>"
//						+ "This is your first time password.\n " + generatedPassword;
		
		message.setSubject(subject, "UTF-8");
		message.setContent(content, "text/html; charset=utf-8");
		Transport.send(message);
		
	}

}
