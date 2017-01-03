package kr.or.dgit.bigdata.diet.service;

import org.apache.log4j.Logger;


public class CalorieService {

	private static final Logger logger = Logger.getLogger(CalorieService.class);

	private static final CalorieService instance = new CalorieService();

	public static CalorieService getInstance() {
		return instance;
	}
	
}
