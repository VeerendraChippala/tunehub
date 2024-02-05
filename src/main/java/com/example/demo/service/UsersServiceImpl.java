package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.entites.Users;
import com.example.demo.repository.UserRepository;
@Service
public class UsersServiceImpl implements UserService  {
	@Autowired
	UserRepository repo;
	@Override
	public String addUsers(Users user) {
		 repo.save(user);
		 return "User added successfully";
	}
	@Override
	public boolean emailExists(String email) {
		if(repo.findByEmail(email)==null) {
			return false;
		}else {
			return true;
		}
	}
	@Override
	public boolean validateUser(String email, String password) {
		Users user=repo.findByEmail(email);
		if(password.equals(user.getPassword())) {
			return true;
		}else {
		return false;
		}
	}
	@Override
	public String getRole(String email) {
		Users user=repo.findByEmail(email);
		return user.getRole();
	}
	@Override
	public Users getUser(String email) {
		return repo.findByEmail(email);
	}
	@Override
	public void updateUser(Users u) {
		repo.save(u);
	}

}
