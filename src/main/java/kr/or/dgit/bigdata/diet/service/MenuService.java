package kr.or.dgit.bigdata.diet.service;

import org.apache.log4j.Logger;

public class MenuService {

	private static final Logger logger = Logger.getLogger(MenuService.class);

	private static final MenuService instance = new MenuService();

	public static MenuService getInstance() {
		return instance;
	}
	
}
