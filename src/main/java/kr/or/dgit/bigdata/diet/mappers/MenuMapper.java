package kr.or.dgit.bigdata.diet.mappers;

import java.util.ArrayList;

import kr.or.dgit.bigdata.diet.dto.Menu;

public interface MenuMapper {
	Menu getMenu(int no);
	ArrayList<Menu> selectAllMenu();
	int insertMenuAuto(Menu menu);
	int deleteMenu(Menu menu);
}
