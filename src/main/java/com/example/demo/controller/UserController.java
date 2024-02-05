package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.entites.Users;
import com.example.demo.service.UserService;

import jakarta.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UserController {
	@Autowired
	UserService service;
	@PostMapping("/register")
	public String addUsers(@ModelAttribute Users user) {
		if(service.emailExists(user.getEmail())==false) {
			service.addUsers(user);
			System.out.println("User added");
		}else {
			System.out.println("Email already exits");
		}
		return "home";
	}
	@PostMapping("/validate")
	public String validateUser(@RequestParam("email") String email,
			@RequestParam("password")String password,
			HttpSession session) {
		if(service.validateUser(email,password)) {
			String role=service.getRole(email);
			session.setAttribute("email", email);
			if(role.equals("admin")) {
				return "adminHome";
			}
			else {
				return "customerHome";
			}
		}else {
			return "login";
		}
	}
	@GetMapping("/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "login";
	}
	
	
	
}
