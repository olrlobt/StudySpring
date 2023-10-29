package com.ssafy.test.controller;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.request;

import java.sql.SQLException;
import java.util.Map;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ssafy.test.dto.User;
import com.ssafy.test.model.service.UserService;

@RequestMapping("/user")
@Controller
public class UserController {
	UserService service;
	
	public UserController(UserService service) {
		super();
		this.service = service;
	}

	@GetMapping("/login")
	public String login() {
		return "user/login";
	}
	
	@PostMapping("/login")
	public String login(User user, @RequestParam(name = "remember", required = false) String remember, 
			HttpSession session, Model model, HttpServletRequest request, HttpServletResponse response) throws SQLException {
		User userInfo = service.login(user);
		if (userInfo != null) { // 로그인 성공
			// 세션, 쿠키
			if ("on".equals(remember)) {
				Cookie cookie = new Cookie("ssafy_id", userInfo.getId());
				cookie.setPath("/board");
				System.out.println(remember);
				cookie.setMaxAge(60*60*24*365*40);
				response.addCookie(cookie);
			} else {
				Cookie[] cookies = request.getCookies();
				for(Cookie cookie : cookies) {
					if(cookie.getName().equals("ssafy_id")) {
						cookie.setMaxAge(0);
						response.addCookie(cookie);
						break;
					}
				}
			}
			session.setAttribute("userInfo", userInfo);
			
			model.addAttribute("msg", "로그인 성공");
		} else { // 로그인 실패
			model.addAttribute("msg", "로그인 실패");
		}
		return "index";
	}
	
	@GetMapping("/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "index";
	}
}
