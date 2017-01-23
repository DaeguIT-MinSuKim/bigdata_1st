package kr.or.dgit.bigdata.diet.gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.plaf.basic.BasicScrollBarUI;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumnModel;

import com.ibm.icu.text.DecimalFormat;

import kr.or.dgit.bigdata.diet.dto.Menu;
import kr.or.dgit.bigdata.diet.middle.MonthMenu;
import kr.or.dgit.bigdata.diet.middle.OneDayMenu;
import kr.or.dgit.bigdata.diet.service.DecorateService;
import kr.or.dgit.bigdata.diet.service.TableCellService;

import java.awt.Font;
import java.awt.FlowLayout;

public class FoodListTable extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTable table;
	private MonthMenu monthMenu;
	private int day;
	int avgOneDayCost; //1일 평균 소비금액
	int monthCost; //월 총 경비
	DecorateService decorateService = new DecorateService();
	TableCellService tableCellSetting = new TableCellService();

	public FoodListTable(MonthMenu monthMenu, int day) {
		this.monthMenu = monthMenu;
		this.day = day;
		
		//현재 다이얼로그를 띄웠을 때 다른 프레임은 움직이지 못하도록 처리
		setModalityType(ModalityType.APPLICATION_MODAL);
		
		setBounds(100, 100, 700, 450);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(Color.WHITE);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		FlowLayout flowLayout = (FlowLayout) panel.getLayout();
		flowLayout.setVgap(20);
		panel.setBackground(Color.WHITE);
		contentPanel.add(panel, BorderLayout.NORTH);
		
		JLabel lblDayNum = new JLabel();
		lblDayNum.setFont(new Font("맑은 고딕", Font.PLAIN, 16));
		if (day == -1) {
			lblDayNum.setText("한달 식단");
		}else{
			lblDayNum.setText(day+"일자 식단");
		}
		
		panel.add(lblDayNum);
		
		JScrollPane scrollPane = new JScrollPane();
		contentPanel.add(scrollPane, BorderLayout.CENTER);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		//테이블 불러옴
		listTable(this.monthMenu, this.day);
		
		//		스크롤바 꾸미기 메소드 호출
		decorateService.decorateScrollPane(scrollPane);
		
		//		테이블 꾸미기 메소드 호출
		decorateService.decorateTable(table);
		
	}

	private void listTable(MonthMenu monthMenu, int day) {
		String[][] getRowDatas =  null;
		
		if (day == -1) {
			//한달치 테이블
			getRowDatas = monthRows(monthMenu);
		}else{
			//하루치 테이블
			getRowDatas = oneDayGetRows(monthMenu, day);
		}
		
		DefaultTableModel model = new DefaultTableModel(
				getRowDatas,
				new String[] { "번호", "일자", "식사", "항목", "메뉴", "칼로리", "지방", "탄수화물", "단백질", "비용" });
		
		table.setModel(model);
		
		//테이블 셀 너비 및 정렬 메소드 호출
		tableCellSetting.tableSetWidth(table, 120, 0, 1, 2);
		tableCellSetting.tableSetWidth(table, 240, 3, 4);
		tableCellSetting.tableSetWidth(table, 200, 5, 6, 7, 8, 9);
		tableCellSetting.tableCellAlignment(table, SwingConstants.CENTER, 0,1,2,3,4);
		tableCellSetting.tableCellAlignment(table, SwingConstants.RIGHT, 5,6,7,8,9);
	}
	
	//하루치 테이블
	private String[][] oneDayGetRows(MonthMenu monthMenu, int day) {
		//한달값 받아오기
		ArrayList<OneDayMenu> list = monthMenu.monthMenuList;

		String[][] rowDatas = new String[monthMenu.count][];
		
		System.out.println("한달리스트 사이즈 : " + list.size());
		
		int ttt = -1;
		
		int oneDayCost = 0; //하루 총 경비
		int oneDayCal = 0; //하루 총 칼로리
		int oneDayFat = 0; //하루 총 지방
		int oneDayCarbo = 0; //하루 총 탄수화물 
		int oneDayProtein = 0; //하루 총 단백질
		
		DecimalFormat df = new DecimalFormat("#,###");
		
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
							df.format(templistoneday.get(j).getCost())
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
					df.format(oneDayCal), 
					oneDayFat+"",
					oneDayCarbo+"", 
					oneDayProtein+"",
					df.format(oneDayCost), 
			};
		}
		System.out.println(ttt);
		return rowDatas;
	}
	
	//한달치 테이블
	public String[][] monthRows(MonthMenu monthMenu) {
		//한달값 받아오기
		ArrayList<OneDayMenu> list = monthMenu.monthMenuList;

		String[][] rowDatas = new String[monthMenu.count][];

		System.out.println("한달리스트 사이즈 : " + list.size());
		
		int ttt = -1;
		
		int monthCost = 0; //월 총 경비
		int monthCal = 0; //월 칼로리
		int monthFat = 0; //월 지방
		int monthCarbo = 0; //월 탄수화물 
		int monthProtein = 0; //월 단백질
		
		DecimalFormat df = new DecimalFormat("#,###");
		
		for (int i = 0; i < list.size(); i++) { // 30일분..

			// 하루치 가져오기
			ArrayList<Menu> templistoneday = list.get(i).menuList;

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
						df.format(templistoneday.get(j).getCost())
						};
				
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
		}
		
		//1일 평균 소비금액
		this.avgOneDayCost = Math.min((monthCost / 30),  30000);
		this.monthCost = monthCost;
		
		System.out.println(ttt);
		return rowDatas;
	}
	
}
