package com.spring.study.resolver;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.SimpleMappingExceptionResolver;
import org.springframework.web.servlet.view.InternalResourceView;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;

import com.spring.study.exception.BadRequestException;

public class ExceptionResolver extends SimpleMappingExceptionResolver implements HandlerExceptionResolver {

	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Override
	public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) {
		ModelAndView model	= super.resolveException(request, response, handler, ex);
		String requestURI	= request.getRequestURI();
		String queryString	= StringUtils.defaultIfEmpty(request.getQueryString(), "");
		String method		= StringUtils.defaultIfEmpty(request.getMethod(), "");
		String viewType		= "html";
		
		if(logger.isDebugEnabled()) {
			logger.debug("uriName : " + requestURI);
			logger.debug("method : " + method);
		}
		
		// exception에 대한 뷰타입을 판단함
		if(handler != null) {
			// request type을 판단함.
			if(StringUtils.contains(request.getHeader("Accept"), "application/json") || StringUtils.contains(requestURI, ".json")) {
				viewType = "json";
				model.setView(new MappingJackson2JsonView());
			} else if(StringUtils.contains(requestURI, ".excel")) {
				viewType = "html";
				model.setView(new InternalResourceView("/WEB-INF/jsp/" + model.getViewName() + ".jsp"));
			} else {
				viewType = "html";
			}
		}
		
		// 공통 Exception에 대한 처리
		model.getModelMap().remove("exception");
		
		model.addObject("message", ex.getMessage());
		model.addObject("exception", ex.getClass().getSimpleName());
		model.addObject("resultCode", "9999");
		
		
		// 각각의 Exception에 대한 처리
		if(ex instanceof BadRequestException){
			model.addObject("message", ex.getMessage());
			
			BadRequestException e = (BadRequestException) ex;
			model.addObject("messgaeList", e.getMessageList());
			model.addObject("dipsMode", e.getDispMode());
			
			if(StringUtils.isEmpty(e.getMessage()) && (e.getMessageList() == null || e.getMessageList().size() == 0)){
				model.addObject("message", "bad request");
			}
			
			if(!viewType.equals("json")){ model.setViewName("exception/badRequestException"); }
			
			if(((BadRequestException) ex).getResultCode() != 100){
				model.addObject("resultCode", ((BadRequestException) ex).getResultCode());
			}
		}
		
		// Exception 로그 기록
		logger.error(ex.getMessage(), ex);
		
		return model;
	}
}
