package com.example.ums.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.ums.model.User;

public interface UserRepo extends JpaRepository<User, Integer>{
	
}
