package com.example.ums.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.ums.model.User;
import com.example.ums.repository.UserRepo;

@Service
public class UserService {

	private UserRepo userRepo;
	
	public UserService(UserRepo userRepo) {
		super();
		this.userRepo = userRepo;
	}

	public User saveUser(User user) {
		return userRepo.save(user);
	}

	public List<User> findAllUser() {
		List<User> users = userRepo.findAll();
		return users;
	}

	public void updateUser(User user) {
		userRepo.save(user);
	}
	
	public void deleteUser(int userId) {
		 userRepo.deleteById(userId);
	}
	public User findUserById(int userId) {
		Optional<User> optional = userRepo.findById(userId);
		if(optional.isPresent())
		return optional.get();
		else
			return null;
	}

}
