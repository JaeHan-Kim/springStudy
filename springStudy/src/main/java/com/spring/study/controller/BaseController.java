package com.spring.study.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.spring.study.model.Users;

@Controller
public class BaseController {
	
	public HttpServletRequest getRequest() {
		RequestAttributes requestAttributes = RequestContextHolder.currentRequestAttributes();
		return ((ServletRequestAttributes) requestAttributes).getRequest();
	}
	
	public Users getCurrUser() {
		return ((Users) this.getRequest().getSession().getAttribute("user"));
	}
	
	public void setSession(String key, Object value) {
		this.getRequest().getSession().setAttribute(key, value);
	}
	
	public void removeSession(String key) {
		this.getRequest().getSession().removeAttribute(key);
	}
}
