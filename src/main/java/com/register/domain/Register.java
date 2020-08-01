package com.register.domain;

import java.util.Date;

import lombok.Data;

@Data
public class Register {

	private Integer registerId;

	private String firstName;
	
	private String lastName;

	private String email;

	private String phNo;
	
	private String dob;
	
	private String gender;
	
	private Integer cityId;
	
	private Integer countryId;
	
	private Integer stateId;

	private String accountStatus;

	private String userPwd;
	
	private Date createdDate;
	
	private Date updatedDate;
}

