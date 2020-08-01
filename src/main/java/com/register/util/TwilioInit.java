package com.register.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import com.twilio.Twilio;

@Configuration
public class TwilioInit {
	private final TwilioConfig twilioConfig;
	
	@Autowired
	public TwilioInit(TwilioConfig twilioConfig) {
		this.twilioConfig = twilioConfig;
		Twilio.init(
			twilioConfig.getAccountSid(),
			twilioConfig.getAuthToken()
		);
	}
	
	
	

}
