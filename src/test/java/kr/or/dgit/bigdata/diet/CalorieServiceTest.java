package kr.or.dgit.bigdata.diet;

import static org.junit.Assert.*;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import kr.or.dgit.bigdata.diet.dto.Calorie;
import kr.or.dgit.bigdata.diet.dto.Member;
import kr.or.dgit.bigdata.diet.service.CalorieService;
import kr.or.dgit.bigdata.diet.service.MemberService;

public class CalorieServiceTest {
	
	private static CalorieService calorieService;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		calorieService = CalorieService.getInstance();
		
	}
		
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		calorieService = null;
	}

	@Test
	public void testSelectCalorieByAgeNo() {
		Member member = MemberService.getInstance().selectMemberByNo(3);
		
		Calorie cal = calorieService.selectCalorieByAgeNo(member);
		
		Assert.assertNotNull(cal);
	}
	
	@Test
	public void testSelectCalorieByAge(){
		Calorie cal = calorieService.selectCalorieByAge(25);
		Assert.assertNotNull(cal);
		System.out.println(cal.getMinage());
		System.out.println(cal.getMaxage());
		System.out.println(cal.getCalWoman());
		System.out.println(cal.getCalMan());
		System.out.println(cal.getwMan());
		System.out.println(cal.getwWoman());
	}

}
