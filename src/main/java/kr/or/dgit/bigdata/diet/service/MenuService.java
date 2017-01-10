package kr.or.dgit.bigdata.diet.service;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;

import kr.or.dgit.bigdata.diet.dto.Menu;
import kr.or.dgit.bigdata.diet.mappers.MenuMapper;
import kr.or.dgit.bigdata.diet.util.MyBatisSqlSessionFactory;

public class MenuService {

	private static final Logger logger = Logger.getLogger(MenuService.class);

	private static final MenuService instance = new MenuService();

	public static MenuService getInstance() {
		return instance;
	}
	public List<Menu> selectAllMenu() {
		if (logger.isDebugEnabled()) {
			logger.debug("selectAllMenu() - start"); 
		}
		SqlSession sqlSession = MyBatisSqlSessionFactory.openSession();
		try{
			MenuMapper menuMapper = sqlSession.getMapper(MenuMapper.class);
			ArrayList<Menu> menuList = menuMapper.selectAllMenu();
			return menuList;
		}finally{
			sqlSession.close();
		}
	}
}
