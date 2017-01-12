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
		MonthMenu monthMenu = new MonthMenu(2100, 950000);
		ArrayList<OneDayMenu> list = monthMenu.monthMenuList;
		

		String[][] rowDatas = new String[monthMenu.count][];
		//ArrayList<String[]> temp = new ArrayList<>();
		//rowDatas[i] = temp.get(i).toArray();
		
		System.out.println("한달리스트 사이즈 : " + list.size());
		int ttt=-1;
		for (int i = 0; i < list.size(); i++) {
			
			ArrayList<Menu> templistoneday = list.get(i).menuList;

			for(int j=0;j<templistoneday.size();j++){
				ttt++;
				//rowD.add(templistoneday.get(j).toArray());
				rowDatas[ttt] = templistoneday.get(j).toArray();
			}
		}
		System.out.println(ttt);
		return rowDatas;	
		
	}
	

	private String[] getCols() {
		return new String[]{"항목", "메뉴", "칼로리(cal)", "지방", "탄수화물", "단백질", "비용", "일자"};
	}
}
