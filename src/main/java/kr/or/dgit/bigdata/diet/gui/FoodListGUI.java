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
import kr.or.dgit.bigdata.diet.service.MenuService;

public class FoodListGUI extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private int cal = 1500;
	private int height = 121;
	private float weight = 24.6f;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FoodListGUI frame = new FoodListGUI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public FoodListGUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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
		
		table.setModel(reload());
		
		scrollPane.setViewportView(table);
	}
	
	private DefaultTableModel reload(){
		DefaultTableModel model = new DefaultTableModel(getRows(), getCols());
		return model;
	}

	private String[][] getRows() {
		Calorie cal = new Calorie();
		cal.setCal_woman(2000);
		
		//월 총 경비 = 9500000
		//월 총 경비 = 월 에산 +- 100,000
		int monthSumCost = 0;
		
		//1일 평균 소비금액 = (월 총 경비 / 30) < 30000 
		int oneDayAvgCost = 950000/30 > 30000 ? 30000 : 950000/30;
		
		//1일 경비 = 1일 평균소비금액 += 10000
		int oneDayCost = 0;
		
		//1일 권장 칼로리 = 2100 
		//1일 권장 칼로리의 100cal를 초과 X
		int oneDayCal = 0;
		
		int gogiSum = 0; //고기항목을 일주일에 몇 번이나 먹었는 지 카운트(연일 배치 방지용)
		int gogiCnt = 0; //고기항목이 포함되었을 때 카운트 
		
		int seafoodCnt = 0; //생선항목이 포함되었을 때 카운트
		
		int juiceCal = 0; //음료의 총 칼로리
		
		Menu[] oneDaylist = new Menu[7]; 
		ArrayList<Menu[]> menulist = new ArrayList<Menu[]>();
		List<Menu> newList = new ArrayList<>();

		//1일식단 70개 만들기
		for (int i = 0; i <2; i++) {
			
			//1일 식단 짜기
			for(int j=0;j<7;j++){
				oneDaylist[j]=MenuService.getInstance().getMenu();
			}			
			
			//1일식단 70개 만들기
			menulist.add((Menu[])oneDaylist);
			for (Menu menu : oneDaylist) {
				newList.add(menu);
			}
			oneDaylist= new Menu[7];
		}		

		
		//menulist(1일분(7개메뉴) 50일치 포함)
		oneDayDrinkCheck(menulist);
		//1일 평균 소비 금액
		oneDayAvgCostCheck(menulist);
		//1일 권장 칼로리
		oneDayGoodCal(menulist);
		
		String[][] rowDatas = new String[newList.size()+1][];
		
		for (int i = 0; i < newList.size(); i++) {
			rowDatas[i] = newList.get(i).toArray();
		}			
		
		return rowDatas;	
		
	}
	
    private void oneDayGoodCal(ArrayList<Menu[]> menulist) {
    	ArrayList<Menu[]> temp = new ArrayList<>();
		for (Menu[] menus : menulist) {
			int sum = 0;
			for (int i = 0; i < menus.length; i++) {
				sum += menus[i].getCal();
				
			}
			if (sum > cal+100) {
				temp.add(menus);
			}
		}
		for (Menu[] menus : temp) {
			menulist.remove(menus);
		}
		System.out.println(menulist.size());
		for(int i=0;i<menulist.size();i++){
			for(int j=0;j<7;j++){
				System.out.println(menulist.get(i)[j].toString());
			}
		}
	}

	private boolean oneDayAvgCostCheck(ArrayList<Menu[]> menulist) {
    	System.out.println(menulist.size());
    	ArrayList<Menu[]> temp = new ArrayList<>();
    	for (Menu[] menus : menulist) {
    		int sum = 0;
			for (int i = 0; i < menus.length; i++) {
				sum += menus[i].getCost(); //총 경비
			}
			
			if (sum > 30000) {
				temp.add(menus);
			}
		}
    	for (Menu[] menus : temp) {
			menulist.remove(menus);
		}
    	System.out.println(menulist.size());
    	for(int i=0;i<menulist.size();i++){
			for(int j=0;j<7;j++){
				System.out.println(menulist.get(i)[j].toString());
			}
		}
		return false;
	}

	//여러날 식단을 입력하여 조건에 걸리는 1일식단 삭제
	private boolean oneDayDrinkCheck(ArrayList<Menu[]> menulist) {
		System.out.println(menulist.size());
		//1일식단뽑기
		ArrayList<Menu[]> temp = new ArrayList<>();
		for (Menu[] menus : menulist) {
			if(!oneDayDrinkDayCheck(menus))			
			temp.add(menus);
		}
		for (Menu[] menus : temp) {
			menulist.remove(menus);			
		}
		System.out.println(menulist.size());
		for(int i=0;i<menulist.size();i++){
			for(int j=0;j<7;j++){
				System.out.println(menulist.get(i)[j].toString());
			}
		}
		return false;
	}

	private boolean oneDayDrinkDayCheck(Menu[] menus) {
		int sum =0;
		
		for(int i=0;i<7;i++){
			if(menus[i].getGrp().equals("음료")){
				sum += menus[i].getCal();
			}			
		}
		if(sum > 500) {
			return false;
		}
		return true;
	}

	private String[] getCols() {
		return new String[]{"항목", "메뉴", "칼로리(cal)", "지방", "탄수화물", "단백질", "비용", "일자"};
	}

}
