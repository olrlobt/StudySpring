package com.ssafy.test.model.service;

import java.sql.SQLException;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.ssafy.test.dto.Electronics;
import com.ssafy.test.model.mapper.ElectronicsMapper;

@Service
public class ElectronicsServiceImpl implements ElectronicsService{
	private ElectronicsMapper mapper;

	public ElectronicsServiceImpl(ElectronicsMapper dao) {
		this.mapper = dao;
	}

	@Override
	public List<Electronics> list() throws SQLException {
		return mapper.list();
	}

	@Override
	public void regist(Electronics dto) throws SQLException {
		mapper.regist(dto);
	}

	@Override
	public Electronics view(String electronicsCode) throws SQLException {
		return mapper.view(electronicsCode);
	}

	@Override
	public void remove(String electornicsCode) throws SQLException {
		mapper.remove(electornicsCode);
	}
	
}
