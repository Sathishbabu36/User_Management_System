package com.example.ums.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.ums.model.User;
import com.example.ums.service.UserService;

@Controller
public class UserController {
	
	private UserService userService;

	public UserController(UserService userService) {
		super();
		this.userService = userService;
	}

	@GetMapping("/register-view")
	public String registerView(Model model) {
		model.addAttribute("user",new User());
		return "register";
	}
	
	@PostMapping("/register")
	public String registerUser(User user) {
		System.out.println(user.getUserName()+" "+user.getEmail()+" "+user.getPassword());
		userService.saveUser(user);
		return "redirect:/";
	}
	
	@GetMapping("/findAll-user-view")
	public String findAllUser(Model model) {
		List<User> users = userService.findAllUser();
		model.addAttribute("users", users);
		return "showtable";
	}
	
	@GetMapping("/update-user-view")
	public String updateView(@RequestParam(value="user_id") int userId, Model model) {
		User user = userService.findUserById(userId);
		model.addAttribute("user",user);
		return "update_view";
	}
	
	@PostMapping("/update-user")
	public String updateUser(User user) {
		userService.updateUser(user);
		return "redirect:/findAll-user-view";
	}
	
	@GetMapping("/delete-user")
	public String deleteUser(@RequestParam(value = "user_id") int userId,Model model) {
		userService.deleteUser(userId);
		return "redirect:/findAll-user-view";
	}
}
