package com.spring.study.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.spring.study.model.Board;

@Repository
public class BoardDao {
	@Autowired
	SqlSessionTemplate sqlSession;
	//SqlSessionFactory sqlSessionFactory;
	
	public List<Board> selectBoardList(Board board){
		//SqlSession sqlSession = sqlSessionFactory.openSession();
		return sqlSession.selectList("Board.selectBoardList", board);
	}
	
	public int insertBoard(Board board){
		//SqlSession sqlSession = sqlSessionFactory.openSession();
		return sqlSession.insert("Board.insertBoard", board);
	}
	
	public Board detailBoard(Board board){
		//SqlSession sqlSession = sqlSessionFactory.openSession();
		return sqlSession.selectOne("Board.detailBoard", board);
	}
	
	public int deleteBoard (Board board){
		//SqlSession sqlSession = sqlSessionFactory.openSession();
		return sqlSession.delete("Board.deleteBoard", board);
	}
	
	public int updateBoard (Board board){
		//SqlSession sqlSession = sqlSessionFactory.openSession();
		return sqlSession.update("Board.updateBoard", board);
	}
}
