package kr.or.dgit.bigdata.diet.mappers;

import java.util.ArrayList;

import kr.or.dgit.bigdata.diet.dto.Menu;

public interface MenuMapper {

	Menu getMenu(int no);

	ArrayList<Menu> selectAllMenu();

	public int insertMenuAuto(Menu menu);
	
	public int deleteMenu(Menu menu);

}
