package com.spring.study.dao;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.spring.study.model.Users;

@Repository
public class UsersDao {
	@Autowired
	SqlSessionTemplate sqlSession;
	
	public Users detailUser(Users user){
		return sqlSession.selectOne("Users.selectUsersInfo", user);
	}
}
