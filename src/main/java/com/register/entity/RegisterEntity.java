package com.register.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import lombok.Data;

@Data
@Entity
@Table(name = "REGISTERENTITY")
public class RegisterEntity {

	@GeneratedValue
	@Id
	@Column(name = "REGISTER_ID")
	private Integer registerId;

	@Column(length = 20, name = "FIRST_NAME")
	private String firstName;
	
	@Column(length = 20, name = "LAST_NAME")
	private String lastName;

	@Column(length = 50, name = "EMAIL")
	private String email;

	@Column(length = 50, name = "NUMBER")
	private String phNo;
	
	@Column(length = 20, name = "DOB")
	private String dob;
	
	@Column(length = 20, name = "GENDER")
	private String gender;
	
	@Column(name = "CITY_ID")
	private Integer cityId;
	
	@Column(name = "COUNTRY_ID")
	private Integer countryId;
	
	@Column(name = "STATE_ID")
	private Integer stateId;

	@Column(name = "ACC_STATUS")
	private String accountStatus;

	@Column(name = "USER_PWD")
	private String userPwd;
	
	@CreationTimestamp
	@Temporal(TemporalType.DATE)
	@Column(name="CREATED_DATE",updatable=false)
	private Date createdDate;
	
	@UpdateTimestamp
	@Temporal(TemporalType.DATE)
	@Column(name="UPDATED_DATE",insertable=false)
	private Date updatedDate;
}

