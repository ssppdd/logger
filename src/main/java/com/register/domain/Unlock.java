package com.register.domain;

import lombok.Data;

@Data
public class Unlock {
	private String email;
	
	private String temPwd;
	
	private String newPwd;
	
	private String cnfPwd;

}
