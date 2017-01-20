package kr.or.dgit.bigdata.diet.gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import kr.or.dgit.bigdata.diet.dto.Calorie;
import kr.or.dgit.bigdata.diet.dto.Menu;
import kr.or.dgit.bigdata.diet.middle.MonthMenu;
import kr.or.dgit.bigdata.diet.middle.OneDayMenu;
import kr.or.dgit.bigdata.diet.service.MenuService;

public class FoodListGUI extends JFrame {
	private JPanel contentPane;
	private JTable table;
	private int cal = 1500;
	private int height = 121;
	private float weight = 24.6f;
	private int day;
	int avgOneDayCost; //1일 평균 소비금액
	
	public FoodListGUI(MonthMenu monthMenu, int day) {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 575, 327);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		JLabel lblListName = new JLabel("추천식단");
		contentPane.add(lblListName, BorderLayout.NORTH);

		JScrollPane scrollPane = new JScrollPane();
		contentPane.add(scrollPane, BorderLayout.CENTER);

		table = new JTable();

		table.setModel(reload(monthMenu, day));

		scrollPane.setViewportView(table);
	}

	
	private DefaultTableModel reload(MonthMenu monthMenu, int day) {
		String[][] getRowDatas =  null;
		
		if (day == -1) {
			getRowDatas = monthRows(monthMenu);
		}else{
			getRowDatas = oneDayGetRows(monthMenu, day);
		}
		
		DefaultTableModel model = new DefaultTableModel(getRowDatas,
				new String[] { "번호", "일자", "식사", "항목", "메뉴", "칼로리(cal)", "지방", "탄수화물", "단백질", "비용" });
		return model;
	}

	//각각 일자에 대해 뿌리기
	private String[][] oneDayGetRows(MonthMenu monthMenu, int day) {
		//한달값 받아오기
		ArrayList<OneDayMenu> list = monthMenu.monthMenuList;

		String[][] rowDatas = new String[monthMenu.count][];
		
		int oneDayCost = 0; //하루 총 경비
		int oneDayCal = 0; //하루 총 칼로리
		int oneDayFat = 0; //하루 총 지방
		int oneDayCarbo = 0; //하루 총 탄수화물 
		int oneDayProtein = 0; //하루 총 단백질

		System.out.println("한달리스트 사이즈 : " + list.size());
		
		int ttt = -1;
		
		for (int i = 0; i < day; i++) {

			// 하루치 가져오기
			ArrayList<Menu> templistoneday = list.get(i).menuList;
			
			rowDatas = new String[templistoneday.size()+2][];
			
			//i가 0부터 시작하기 때문에
			if (i == day-1) {
				for (int j = 0; j < templistoneday.size(); j++) {
					int quo = templistoneday.size() / 3; // (하루치 메뉴 개수 / 아침,점심,저녁)
					int rem = templistoneday.size() % 3; // (하루치 메뉴 개수 / 아침,점심,저녁)의
															// 나머지 개수
					String str = ""; // 아침 점심 저녁을 저장할 변수

					/*
					 * 6만약 메뉴 개수가 7개일 때 몫 = 2, 나머지 =1 
					 * 아침 2개, 점심 3개, 저녁 2개 
					 * 아침 = 1, 2
					 * 점심 = 2, 3, 4 
					 * 저녁 = 5, 6
					 */
					if (j < quo) {
						str = "아침";
					} else if (j < (quo + quo + rem)) {
						str = "점심";
					} else if (j < (quo + quo + quo + rem)) {
						str = "저녁";
					}

					ttt++;

					// "번호","일자","식사","항목", "메뉴", "칼로리(cal)", "지방", "탄수화물", "단백질", "비용"
					rowDatas[ttt] = new String[] { 
							(ttt + 1) + "",
							(i + 1) + "", 
							str, 
							templistoneday.get(j).getGrp() + "",
							templistoneday.get(j).getItem() + "", 
							templistoneday.get(j).getCal() + "",
							templistoneday.get(j).getFat() + "", 
							templistoneday.get(j).getCarbo() + "",
							templistoneday.get(j).getProtein() + "", 
							templistoneday.get(j).getCost() + "" 
					};

					oneDayCost += templistoneday.get(j).getCost();
					oneDayCal += templistoneday.get(j).getCal();
					oneDayFat += templistoneday.get(j).getFat();
					oneDayCarbo += templistoneday.get(j).getCarbo();
					oneDayProtein += templistoneday.get(j).getProtein();
				}
			}else if(i > day+2){
				break;
			}
			
			rowDatas[templistoneday.size()+1] = new String[]{
					"", 
					"", 
					"합계",
					"", 
					"",
					oneDayCal+"", 
					oneDayFat+"",
					oneDayCarbo+"", 
					oneDayProtein+"",
					oneDayCost+"", 
			};
		}
		System.out.println(ttt);
		return rowDatas;
	}

	//30일치 한 번에 뿌리기
	private String[][] monthRows(MonthMenu monthMenu) {
		ArrayList<OneDayMenu> list = monthMenu.monthMenuList;

		String[][] rowDatas = new String[monthMenu.count+2][];
		// ArrayList<String[]> temp = new ArrayList<>();
		// rowDatas[i] = temp.get(i).toArray();

		int monthCost = 0; //월 총 경비
		int monthCal = 0; //월 칼로리
		int monthFat = 0; //월 지방
		int monthCarbo = 0; //월 탄수화물 
		int monthProtein = 0; //월 단백질
		
		System.out.println("한달리스트 사이즈 : " + list.size());
		int ttt = -1;
		for (int i = 0; i < list.size(); i++) { // 30일분..

			// 하루치 가져오기
			ArrayList<Menu> templistoneday = list.get(i).menuList;

			for (int j = 0; j < templistoneday.size(); j++) {
				int quo = templistoneday.size() / 3; // (하루치 메뉴 개수 / 아침,점심,저녁)
				int rem = templistoneday.size() % 3; // (하루치 메뉴 개수 / 아침,점심,저녁)의
														// 나머지 개수
				String str = ""; // 아침 점심 저녁을 저장할 변수

				/*
				 * 6만약 메뉴 개수가 7개일 때 몫 = 2, 나머지 =1 아침 2개, 점심 3개, 저녁 2개 아침 = 1, 2
				 * 점심 = 2, 3, 4 저녁 = 5, 6
				 */
				if (j < quo) {
					str = "아침";
				} else if (j < (quo + quo + rem)) {
					str = "점심";
				} else if (j < (quo + quo + quo + rem)) {
					str = "저녁";
				}

				ttt++;

				// "번호","일자","식사","항목", "메뉴", "칼로리(cal)", "지방", "탄수화물", "단백질", "비용"
				rowDatas[ttt] = new String[] { (ttt + 1) + "", 
						(i + 1) + "", 
						str, 
						templistoneday.get(j).getGrp() + "",
						templistoneday.get(j).getItem() + "", 
						templistoneday.get(j).getCal() + "",
						templistoneday.get(j).getFat() + "", 
						templistoneday.get(j).getCarbo() + "",
						templistoneday.get(j).getProtein() + "", 
						templistoneday.get(j).getCost() + "" };
				
				//월 총경비
				monthCost += templistoneday.get(j).getCost();
				//월 칼로리
				monthCal += templistoneday.get(j).getCal();
				//월 지방
				monthFat += templistoneday.get(j).getFat();
				//월 탄수화물
				monthCarbo += templistoneday.get(j).getCarbo();
				//월 지방
				monthProtein += templistoneday.get(j).getProtein();
			}
			rowDatas[monthMenu.count+1] = new String[]{
					"", 
					"", 
					"합계",
					"", 
					"",
					monthCal+"", 
					monthFat+"",
					monthCarbo+"", 
					monthProtein+"",
					monthCost+"", 
			};
		}
		
		//1일 평균 소비금액
		avgOneDayCost = Math.min((monthCost / 30),  30000);
		FoodListAbsolute.tfOneDayCost.setText(avgOneDayCost+"");
		FoodListAbsolute.tfMonthCost.setText(monthCost+"");
		
		System.out.println(ttt);
		return rowDatas;
	}
}