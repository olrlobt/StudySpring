package com.ssafy.test.model.service;

import java.sql.SQLException;
import java.util.List;

import org.springframework.stereotype.Service;

import com.ssafy.test.dto.Electronics;


public interface ElectronicsService {

	List<Electronics> list() throws SQLException;

	void regist(Electronics dto) throws SQLException;

	Electronics view(String electronicsCode) throws SQLException;

	void remove(String electornicsCode) throws SQLException;

}
