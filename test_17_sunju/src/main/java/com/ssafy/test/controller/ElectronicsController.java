package com.ssafy.test.controller;

import java.sql.SQLException;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ssafy.test.dto.Electronics;
import com.ssafy.test.dto.User;
import com.ssafy.test.model.service.ElectronicsService;

@Controller
@RequestMapping("/electronics")
public class ElectronicsController {
	
	private ElectronicsService service;
	
	public ElectronicsController(ElectronicsService service) {
		this.service = service;
	}

	@GetMapping("/list")
	public String list(Model model) throws SQLException {
		List<Electronics> listDto = service.list();
		model.addAttribute("listDto", listDto);
		return "electronics/listElectronics";
	}
	
	@GetMapping("/regist")
	public String regist(HttpSession session) {
		User user = (User) session.getAttribute("userInfo");
		if (user == null) return "index";
		return "electronics/registElectronics";
	}
	
	@PostMapping("/regist")
	public String regist(Electronics dto) throws SQLException {
		service.regist(dto);
		return "redirect:/electronics/list";
		
	}
	
	@GetMapping("/view/{electronicsCode}")
	public String view(@PathVariable("electronicsCode") String electronicsCode, Model model) throws SQLException {
		Electronics dto = service.view(electronicsCode);
		model.addAttribute("dto", dto);
		return "electronics/detailElectronics";
	}
	
	
	@GetMapping("/remove/{electronicsCode}")
	public String remove(@PathVariable String electronicsCode) throws SQLException {
		service.remove(electronicsCode);
		return "redirect:/electronics/list";
	}

}
