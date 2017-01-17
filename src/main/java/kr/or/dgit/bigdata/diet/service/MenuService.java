package kr.or.dgit.bigdata.diet.service;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;

import kr.or.dgit.bigdata.diet.dto.Member;
import kr.or.dgit.bigdata.diet.dto.Menu;
import kr.or.dgit.bigdata.diet.mappers.MemberMapper;
import kr.or.dgit.bigdata.diet.mappers.MenuMapper;
import kr.or.dgit.bigdata.diet.util.MyBatisSqlSessionFactory;

public class MenuService {

	private static final Logger logger = Logger.getLogger(MenuService.class);

	private static final MenuService instance = new MenuService();

	public static MenuService getInstance() {
		return instance;
	}
	public Menu getMenu(int no) {
		if (logger.isDebugEnabled()) {
			logger.debug("getMenu(int) - start"); 
		}
		SqlSession sqlSession = MyBatisSqlSessionFactory.openSession();
		try{
			MenuMapper menuMapper = sqlSession.getMapper(MenuMapper.class);
			Menu menu = menuMapper.getMenu(no);
			System.out.println(menu+"service 확인");
			return menu;
		}finally{
			sqlSession.close();
		}
	}
	public ArrayList<Menu> selectAllMenu() {
		if (logger.isDebugEnabled()) {
			logger.debug("selectAllMenu() - start"); 
		}
		SqlSession sqlSession = MyBatisSqlSessionFactory.openSession();
		try{
			MenuMapper menuMapper = sqlSession.getMapper(MenuMapper.class);
			ArrayList<Menu> menu = menuMapper.selectAllMenu();
			return menu;
		}finally{
			sqlSession.close();
		}		
	}
	
	public int insertMenuAuto(Menu menu){
		logger.debug("insertMenuAuto(menu) - start");
		SqlSession sqlSession = MyBatisSqlSessionFactory.openSession();
		try {
			MenuMapper menuMapper = sqlSession.getMapper(MenuMapper.class);
			int res = menuMapper.insertMenuAuto(menu);
			sqlSession.commit();
			return res;
		}catch(Exception e){
			sqlSession.rollback();
			e.printStackTrace();
			throw new RuntimeException(e.getCause());
		}finally{
			sqlSession.close();
		}
	}
	
	public int deleteMenu(int no){
		logger.debug("deleteMenu(no) - start");
		SqlSession sqlSession = MyBatisSqlSessionFactory.openSession();
		try {
			MenuMapper menuMapper = sqlSession.getMapper(MenuMapper.class);
			int res = menuMapper.deleteMenu(no);
			sqlSession.commit();
			return res;
		}catch(Exception e){
			sqlSession.rollback();
			e.printStackTrace();
			throw new RuntimeException(e.getCause());
		}finally{
			sqlSession.close();
		}
	}
}
