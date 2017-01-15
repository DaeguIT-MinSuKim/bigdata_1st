package kr.or.dgit.bigdata.diet.service;

import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;

import kr.or.dgit.bigdata.diet.dto.Calorie;
import kr.or.dgit.bigdata.diet.dto.Member;
import kr.or.dgit.bigdata.diet.mappers.CalorieMapper;
import kr.or.dgit.bigdata.diet.util.MyBatisSqlSessionFactory;


public class CalorieService {

	private static final Logger logger = Logger.getLogger(CalorieService.class);

	private static final CalorieService instance = new CalorieService();

	public static CalorieService getInstance() {
		return instance;
	}
	
	public Calorie selectCalorieByAge(int age){
		if (logger.isDebugEnabled()) {
			logger.debug("selectCalorieByAge(age) - start"); 
		}
		SqlSession sqlSession = MyBatisSqlSessionFactory.openSession();
		try{
			CalorieMapper CalorieMapper = sqlSession.getMapper(CalorieMapper.class);
			Calorie res = CalorieMapper.selectCalorieByAge(age);
			return res;
		}finally{
			sqlSession.close();
		}
	}
	
	public Calorie selectCalorieByAgeNo(Member member){
		if (logger.isDebugEnabled()) {
			logger.debug("selectCalorieByAgeNo(Member) - start");
		}
		SqlSession sqlSession = MyBatisSqlSessionFactory.openSession();
		try {
			CalorieMapper calorieMapper = sqlSession.getMapper(CalorieMapper.class);
			Calorie calorie = calorieMapper.selectCalorieByAgeNo(member);
			return calorie;
		} finally {
			sqlSession.close();
		}
	}
}
