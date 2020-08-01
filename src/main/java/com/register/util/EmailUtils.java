package com.register.util;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

import com.register.domain.Register;

@Component
public class EmailUtils {
	
	@Autowired
	JavaMailSender javaMailSender;
	
	public boolean sendEmailNew(Register reg) {
		try {

			MimeMessage mimeMsg = javaMailSender.createMimeMessage();
			MimeMessageHelper helper = new MimeMessageHelper(mimeMsg);

			helper.setTo(reg.getEmail());
			helper.setSubject("Unlock your account");
			helper.setText(getUnlockAccEmailBody(reg), true);
			
			javaMailSender.send(mimeMsg);

			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	public String getUnlockAccEmailBody(Register reg) throws IOException {
		StringBuffer sb = new StringBuffer("");
		FileReader fr = new FileReader("UNLOCK-ACC-EMAIL-BODY-TEMPLATE.txt");
		BufferedReader br = new BufferedReader(fr);
		String line = br.readLine();

		while (line != null) {
			sb.append(line);
			line = br.readLine();
		}
		
		br.close();

		// format mail body
		String mailBody = sb.toString();
		mailBody = mailBody.replace("{FNAME}", reg.getFirstName());
		mailBody = mailBody.replace("{LNAME}", reg.getLastName());
		mailBody = mailBody.replace("{TEMP-PWD}", reg.getUserPwd());
		mailBody = mailBody.replace("{EMAIL}", reg.getEmail());

		return mailBody;
	}

}
