package com.example.demo.service;

import com.example.demo.entites.Users;
public interface UserService {
	String addUsers(Users user);
	boolean emailExists(String email);
	boolean validateUser(String email, String password);
	String getRole(String email);
	public Users getUser(String email);
	public void updateUser(Users u);
}
