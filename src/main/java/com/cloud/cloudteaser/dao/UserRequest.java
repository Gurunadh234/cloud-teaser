package com.cloud.cloudteaser.dao;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserRequest {
	private String username;
	private String password;
	private String firstName;
	private String lastName;
}