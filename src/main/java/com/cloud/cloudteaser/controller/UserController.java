package com.cloud.cloudteaser.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cloud.cloudteaser.dao.UserRequest;
import com.cloud.cloudteaser.dao.UserResponse;
import com.cloud.cloudteaser.service.UserService;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Controller
@RequestMapping("/cloud")
@Log4j2
@RequiredArgsConstructor
public class UserController {
	
	@NonNull
	private UserService userService;
	
	@PostMapping("/register")
	public ResponseEntity<UserResponse> registerUser(@RequestBody UserRequest userReq) {
		UserResponse res = userService.register(userReq);
		return new ResponseEntity<>(res, HttpStatus.ACCEPTED);
	}
	
	@PostMapping("/login")
	public ResponseEntity<UserResponse> login(@RequestBody UserRequest userReq) {
		UserResponse res = userService.login(userReq);
		return new ResponseEntity<>(res, HttpStatus.OK);
	}
}
