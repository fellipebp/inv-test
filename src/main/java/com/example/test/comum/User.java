package com.example.test.comum;

import java.util.Date;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import lombok.Data;

@Data
public class User {

	private Integer id;
	private String login;
	private String name;
	private String email;
	private boolean active;
	
	@CreatedDate
	private Date created;

	@LastModifiedDate
	private Date lastUpdate;
	    
}
