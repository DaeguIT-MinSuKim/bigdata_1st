package kr.or.dgit.bigdata.diet.test;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import kr.or.dgit.bigdata.diet.dto.Calorie;
import kr.or.dgit.bigdata.diet.service.CalorieService;

public class CalorieTest {

	private static CalorieService calorieService;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		calorieService = CalorieService.getInstance();
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		calorieService=null;
	}

	@Test
	public void testSelectCalorieByAge() {
		Calorie calorie = calorieService.selectCalorieByAge(7);
		Assert.assertNotNull(calorie);
		System.out.println("testSelectCalorieByAge()" + calorie);
	}

}
