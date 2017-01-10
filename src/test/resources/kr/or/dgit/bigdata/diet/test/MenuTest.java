package kr.or.dgit.bigdata.diet.test;

import java.util.List;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import kr.or.dgit.bigdata.diet.dto.Menu;
import kr.or.dgit.bigdata.diet.service.MenuService;

public class MenuTest {

	private static MenuService menuService;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		menuService = MenuService.getInstance();
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		menuService=null;
	}

	@Test
	public void testSelectAllMenu() {
		List<Menu> menu = menuService.selectAllMenu();
		Assert.assertNotNull(menu);
		System.out.println("testSelectAllMenu()" + menu);
	}

}
