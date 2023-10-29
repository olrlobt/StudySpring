package com.ssafy.test.model.mapper;

import java.sql.SQLException;

import org.apache.ibatis.annotations.Mapper;

import com.ssafy.test.dto.User;

@Mapper
public interface UserMapper {
	User login(User user) throws SQLException;
}
