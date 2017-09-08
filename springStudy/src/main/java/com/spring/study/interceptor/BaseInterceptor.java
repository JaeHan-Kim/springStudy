package com.spring.study.interceptor;

import java.lang.reflect.Method;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.spring.study.annotation.LoginCheck;
import com.spring.study.controller.BaseController;
import com.spring.study.exception.BadRequestException;
import com.spring.study.model.Users;

public class BaseInterceptor extends HandlerInterceptorAdapter {

	private final Logger log = LoggerFactory.getLogger(this.getClass());
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		if (handler instanceof HandlerMethod) {
			log.debug("[BaseInterceptor]");
			log.debug("[Request URI]" + request.getRequestURI());
		}
		log.debug("시작");
		
		// 요청 method 획득
		Method method = ((HandlerMethod) handler).getMethod();
		
		// 현재 사용자 정보 처리
		
		BaseController b = (BaseController) ((HandlerMethod) handler).getBean();
		Users currUser = b.getCurrUser();
		request.setAttribute("currUser", currUser);
		
		LoginCheck loginCheck = method.getAnnotation(LoginCheck.class);
		
		if (loginCheck != null && currUser == null) {
			throw new BadRequestException();
		}
		
		
		//throw new BadRequestException();
		return super.preHandle(request, response, handler);
	}
	
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		super.postHandle(request, response, handler, modelAndView);
	}
}