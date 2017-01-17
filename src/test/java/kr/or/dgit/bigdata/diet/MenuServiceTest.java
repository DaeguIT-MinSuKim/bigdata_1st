package kr.or.dgit.bigdata.diet;

import static org.junit.Assert.*;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import kr.or.dgit.bigdata.diet.dto.Menu;
import kr.or.dgit.bigdata.diet.service.MenuService;

public class MenuServiceTest {

	private static MenuService menuService;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
			menuService = MenuService.getInstance();
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		menuService = null;
	}

	@Test
	public void testInsertMenuAuto() {
		Menu menu = new Menu();
		menu.setGrp("빵&씨리얼");
		menu.setItem("스페셜K");
		menu.setCal(330);
		menu.setFat(1);
		menu.setCarbo(80);
		menu.setProtein(14);
		menu.setCost(600);
		menu.setCon("100g당");
		
		int res = menuService.insertMenuAuto(menu);
	}

}
