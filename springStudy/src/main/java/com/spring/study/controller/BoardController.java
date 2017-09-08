package com.spring.study.controller;

import java.text.DateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;

import com.spring.study.annotation.LoginCheck;
import com.spring.study.model.Board;
import com.spring.study.model.Users;
import com.spring.study.service.BoardService;
import com.spring.study.service.UsersService;

/**
 * Handles requests for the application home page.
 */
@Controller
public class BoardController extends BaseController {
	
	@Autowired
	private BoardService boardService;
	
	private static final Logger logger = LoggerFactory.getLogger(BoardController.class);
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model, Board board) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		List<Board> boards = boardService.getBoardList(board);
		
		logger.info("{}", boards.size());
		for (Board boarda : boards) {
			logger.debug("{}", boarda.getContent());
		}
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );

		return "home";
	}
}
