package com.spring.study.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.study.dao.UsersDao;
import com.spring.study.model.Users;

@Service
public class UsersService {

	@Autowired
	UsersDao usersDao;
	
	public Users getUserDetail(Users user){
		return usersDao.detailUser(user);
	}
}
