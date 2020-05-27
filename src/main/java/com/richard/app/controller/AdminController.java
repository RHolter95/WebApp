package com.richard.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.richard.app.entity.Users;
import com.richard.app.repo.UserRepo;

@RestController
public class AdminController {
	
	@Autowired
	private UserRepo userRepo;
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@RequestMapping("/admin")
	public ModelAndView adminPanel() {		
		ModelAndView mView = new ModelAndView("AdminPanel.html");
		return mView;
	}
	
	@GetMapping("/admin/showusers")
	@ResponseBody
	public Iterable<Users> ShowUsers() {
		return userRepo.findAll();
	}

	@RequestMapping("/addadmin")
	public ModelAndView AddAdmin(Users user) {
		ModelAndView mView = new ModelAndView("AdminPanel.html");
		
		if(userRepo.findByName(user.getName()) == null && userRepo.findByEmail(user.getEmail()) == null) {
			user.setRole("ROLE_ADMIN");
			user.setPassword(passwordEncoder.encode(user.getPassword()));
			userRepo.save(user);	
			return mView;
		}else {
			System.out.println("Username or Email already in use!");
			return mView;
		}
	}
	
	@RequestMapping("/removeadmin")
	public ModelAndView RemoveAdmin(Users user) {
		Users tempUser = null;
		ModelAndView mView = new ModelAndView("AdminPanel.html");
		tempUser = userRepo.findByName(user.getName());
		userRepo.delete(tempUser);
		return mView;
	}
	
	@RequestMapping("/removeuser")
	public ModelAndView RemoveUser(Users user) {
		Users tempUser = null;
		ModelAndView mView = new ModelAndView("AdminPanel.html");
		tempUser = userRepo.findByName(user.getName());
		userRepo.delete(tempUser);
		return mView;
	}
}
