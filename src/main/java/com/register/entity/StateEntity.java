package com.register.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "STATE")
public class StateEntity {
	
	@GeneratedValue
	@Id
	@Column(name = "STATE_ID")
	private Integer stateId;
	
	@Column(name = "COUNTRY_ID")
	private Integer countryId;
	
	@Column(name = "STATE_NAME")
	private String stateName;

}
