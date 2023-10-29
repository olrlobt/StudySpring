package com.ssafy.test.model.service;

import java.sql.SQLException;

import org.springframework.stereotype.Service;

import com.ssafy.test.dto.User;
import com.ssafy.test.model.mapper.UserMapper;

@Service
public class UserServiceImpl implements UserService {

	private UserMapper userMapper;
	
	public UserServiceImpl(UserMapper userMapper) {
		super();
		this.userMapper = userMapper;
	}

	@Override
	public User login(User user) throws SQLException {
		User userr = userMapper.login(user);
		System.out.println(userr);
		return userr;
	}

}
