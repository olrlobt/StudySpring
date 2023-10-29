package com.ssafy.test.model.mapper;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.ssafy.test.dto.Electronics;

@Mapper
public interface ElectronicsMapper {

	List<Electronics> list() throws SQLException;

	void regist(Electronics dto) throws SQLException;

	Electronics view(String electronicsCode) throws SQLException;

	void remove(String electornicsCode) throws SQLException;

}
