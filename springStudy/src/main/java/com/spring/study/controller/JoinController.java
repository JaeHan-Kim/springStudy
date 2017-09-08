package com.spring.study.controller;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;

import com.spring.study.annotation.LoginCheck;
import com.spring.study.model.Users;
import com.spring.study.service.UsersService;

@Service
public class JoinController extends BaseController {
	
	@Autowired
	private UsersService userService;
	
	private static final Logger logger = LoggerFactory.getLogger(BoardController.class);
	
	@RequestMapping(value="/join/loginForm", method = RequestMethod.GET)
	public ModelAndView loginForm(ModelMap model) {
		return  new ModelAndView("/join/loginForm");
	}
	
	@RequestMapping(value="/join/login", method = RequestMethod.POST)
	public View login(ModelMap model, Users users, HttpServletRequest request) {
		logger.debug("{}", users.getEmail());
		Users loginUser = this.userService.getUserDetail(users);
		model.addAttribute("resultCode", -1000);
		if (users.getPw().equals(loginUser.getPw())) {
			super.setSession("user", loginUser);
			model.addAttribute("resultCode", 1);
		}
		
		return  new MappingJackson2JsonView();
	}
	
	@LoginCheck
	@RequestMapping(value="/join/loginComplete", method = RequestMethod.GET)
	public ModelAndView loginComplete(ModelMap model , HttpServletRequest request) {
		Users user = (Users) super.getCurrUser();
		logger.info("email {}, pw {}", user.getEmail(), user.getPw());
		return  new ModelAndView("/join/loginComplete");
	}
	
}
