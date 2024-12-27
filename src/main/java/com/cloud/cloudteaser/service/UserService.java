package com.cloud.cloudteaser.service;

import com.cloud.cloudteaser.dao.UserRequest;
import com.cloud.cloudteaser.dao.UserResponse;
import com.cloud.cloudteaser.entity.User;

public interface UserService {
	UserResponse register(UserRequest user);
	UserResponse login(UserRequest user);
}
