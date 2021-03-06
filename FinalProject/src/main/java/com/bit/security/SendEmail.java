package com.bit.security;

import java.util.Random;

import javax.mail.Message.RecipientType;
import javax.mail.MessagingException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class SendEmail {

	private final JavaMailSender javaMailSender;
	
	public String getKey() {
		return keyGeneration();
	}
	
	private String keyGeneration() { // 난수 키값 생성
		Random random = new Random();
		StringBuffer stringBuffer = new StringBuffer();
		int num = 0;
		int size = 10;

		do {
			num = random.nextInt(75) + 48;
			if ((num >= 48 && num <= 57) || (num >= 65 && num <= 90) || (num >= 97 && num <= 122)) {
				stringBuffer.append((char) num);
			} else {
				continue;
			}

		} while (stringBuffer.length() < size);

		return stringBuffer.toString();
	}
	
	private void sendEmail (String email, String context)  {
		
		MimeMessage mimeMessage = javaMailSender.createMimeMessage();
		
		try {
			mimeMessage.setFrom("Bitbook");
			mimeMessage.setSubject("BitBook 회원인증 메일입니다.");
			mimeMessage.setText(context, "UTF-8", "html");
			mimeMessage.addRecipient(RecipientType.TO, new InternetAddress(email));
			
			javaMailSender.send(mimeMessage);
			
		} catch (MessagingException e) {
			// TODO: handle exception
		}		
	}
	
	public void joinEmail (String email, String name, String key) {
		String context = name + "님"
				+ "<p> 링크를 누르시면 가입이 완료됩니다. " 
				+ "<a href='http://localhost:80"
				+ "/join/email/" + email + "/" + key 
				+ "'>인증하기</a></p>"
				+ "<p>회원가입을 시도하지 않으셨다면 무시해주세요</p>";
		
		sendEmail(email, context);
	}
	
	public void forgotEmail (String email, String name, String key) {
		String context = name + "님의 임시 비밀번호는 " + key + " 입니다."
				+ "<p> 로그인후 비밀번호를 변경해주세요. </p> " ;
		
		sendEmail(email, context);
	}

}
