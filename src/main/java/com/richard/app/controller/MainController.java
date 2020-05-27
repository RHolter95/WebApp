package com.richard.app.controller;

import com.richard.app.aws.AwsCreateIAM;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.richard.app.entity.Users;
import com.richard.app.repo.UserRepo;
import com.richard.app.security.javaemail.SendEmail;

@RestController
public class MainController {
	
	@Autowired
	private AwsCreateIAM awsCreateIAM;
	@Autowired
	private UserRepo userRepo;
	@Autowired
	private PasswordEncoder passwordEncoder;
	@Autowired
	SendEmail sendEmail;
	
	@RequestMapping("/")
	public ModelAndView Index() {
		ModelAndView mView = new ModelAndView("Index.html");
		return mView;
	}
	
	@RequestMapping("/email")
	public ModelAndView Email() {
		sendEmail.SendEmail("");
		ModelAndView mView = new ModelAndView("Index.html");
		return mView;
	}
	
	@RequestMapping("/adduser")
	public ModelAndView AddUser(Users user) {
		ModelAndView mView = new ModelAndView("Index.html");
		
		if(userRepo.findByName(user.getName()) == null && userRepo.findByEmail(user.getEmail()) == null) {
			user.setRole("ROLE_USER");
			user.setPassword(passwordEncoder.encode(user.getPassword()));
			
			try {
				awsCreateIAM.CreateAWSUser(user.getName(), user.getEmail(), user.getPassword());
			} catch (Exception e) {
				System.out.println(e);
				return mView;
			}
			
			userRepo.save(user);
			return mView;
		}else {
			System.out.println("Username or Email already in use!!");
			return mView;
		}
	}
	
	@RequestMapping("/hello")
	public String Hello() {
		return "HI";
	}
	
}
