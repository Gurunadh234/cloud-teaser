package com.cloud.cloudteaser.service.impl;

import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.KeySpec;
import java.time.LocalDateTime;
import java.util.HexFormat;
import java.util.Optional;

import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;

import org.springframework.stereotype.Service;

import com.cloud.cloudteaser.dao.UserRequest;
import com.cloud.cloudteaser.dao.UserResponse;
import com.cloud.cloudteaser.entity.User;
import com.cloud.cloudteaser.exception.UnauthorizedException;
import com.cloud.cloudteaser.exception.UnexpectedException;
import com.cloud.cloudteaser.repository.UserRepository;
import com.cloud.cloudteaser.service.UserService;

import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.extern.log4j.Log4j2;

@Service
@RequiredArgsConstructor
@Getter
@Setter
@Log4j2
public class UserServiceImpl implements UserService {
	
	@NonNull
	private UserRepository userRepository;
	
	@Override
	public UserResponse register(UserRequest userReq) {
		Optional<User> userOpt = userRepository.findByUsername(userReq.getUsername());
		if(userOpt.isEmpty()) {
			log.info("Registering userA: {}", userReq.getFirstName());
			User user = new User();
			user.setPassword(userReq.getPassword());
			user.setUsername(userReq.getUsername());
			user.setCreatedAt(LocalDateTime.now());
			user.setUpdatedAt(LocalDateTime.now());
			user.setFirstName(userReq.getFirstName());
			user.setLastName(userReq.getLastName());
			
			User savedUser = userRepository.save(user);
			return mapUserResponse(savedUser);
		}
		else {
			log.info("User already exists");
			return mapUserResponse(userOpt.get());
		}
	}
	
	@Override
	public UserResponse login(UserRequest userReq) {
		Optional<User> userOpt = userRepository.findByUsernameAndPassword(userReq.getUsername(), userReq.getPassword());
		if(userOpt.isEmpty()) {
			throw new UnauthorizedException("Username or password is incorrect");
		}
		log.info("login user: {}", userOpt.get());
		return mapUserResponse(userOpt.get());
	}
	
	public String hashPassword(String password) {
		SecureRandom random = new SecureRandom();
		byte[] salt = new byte[16];
		random.nextBytes(salt);
		KeySpec spec = new PBEKeySpec(password.toCharArray(), salt, Short.MAX_VALUE, 512);
		SecretKeyFactory factory;
		try {
			factory = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA1");
			return HexFormat.of().formatHex(factory.generateSecret(spec).getEncoded());
		}
		catch (NoSuchAlgorithmException | InvalidKeySpecException e) {
			e.printStackTrace();
			throw new UnexpectedException(e.getLocalizedMessage());
		}
	}
	
	public UserResponse mapUserResponse(User user) {
		UserResponse res = new UserResponse();
		res.setFirstName(user.getFirstName());
		res.setLastName(user.getLastName());
		res.setUsername(user.getUsername());
		return res;
	}
	
}
