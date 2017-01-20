package kr.or.dgit.bigdata.diet.gui;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Image;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import kr.or.dgit.bigdata.diet.dto.Menu;
import kr.or.dgit.bigdata.diet.service.MenuService;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class OutputMenuList extends JFrame {
	private static MenuService menuService;
	/* Container contentPane; */
	private ArrayList<Menu> menuList;
	private JComboBox jcb;
	private JTable table;
	private String[][] data;
	int result;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					OutputMenuList frame = new OutputMenuList();
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
	public OutputMenuList() {
		
		setSize(1024, 768);
		getContentPane().setLayout(null);
		NoteBg2 panel = new NoteBg2();
		panel.setBounds(0, 0, 1008, 729);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		//table panel 추가
		JPanel pnlForTable = new JPanel();
		pnlForTable.setBounds(90, 175, 840, 340);
		panel.add(pnlForTable);
		pnlForTable.setOpaque(false);
		pnlForTable.setLayout(new BorderLayout(0, 0));
		
		//스크롤페인 추가
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setOpaque(false);
		pnlForTable.add(scrollPane, BorderLayout.CENTER);
		
		//메뉴리스트 생성
	
			
		
		menuService = MenuService.getInstance();
		menuList = menuService.selectAllMenu();
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			menuRow(),
			new String[] {
				"항목", "메뉴", "칼로리", "지방", "탄수화물", "단백질", "비용", "조건"
			}
		));
		
		scrollPane.setViewportView(table);
		
		//콤보박스
		String[] menu = new String[menuList.size()];
		for(int i=0; i< menuList.size(); i++){
			menu[i] = menuList.get(i).getItem(); 
		}
		jcb = new JComboBox();
		for(int i=0;i<menuList.size(); i++){
			jcb.addItem(menu[i]);
		}
		
		jcb.setBounds(500, 590, 120, 20);
		panel.add(jcb);
		
		//메뉴 삭제 버튼
		JButton btnMenuDel = new JButton("삭제");
		
		//삭제 이벤트
		btnMenuDel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				result = JOptionPane.showConfirmDialog(
						null, "선택한 메뉴를 삭제하겠습니까?","메뉴삭제창",JOptionPane.WARNING_MESSAGE
						);
				
				if(result == 0){
					Menu menu = new Menu();
					menu.setItem(jcb.getSelectedItem()+"");
					
					
					menuService.deleteMenu(menu);
					JOptionPane.showMessageDialog(null,"야호");
					
					
					//메뉴리스트 Refresh
					menuService = MenuService.getInstance();
					menuList = menuService.selectAllMenu();
					
					table = new JTable();
					table.setModel(new DefaultTableModel(
						menuRow(),
						new String[] {
							"항목", "메뉴", "칼로리", "지방", "탄수화물", "단백질", "비용", "조건"
						}
					));
					
					scrollPane.setViewportView(table);
					
					
				}
				
				
			}
		});
		btnMenuDel.setBounds(632, 589, 100, 20);
		panel.add(btnMenuDel);
		
		
		
		//콤보박스
		/*String[] menu = new String[menuList.size()];
		for(int i=0; i< menuList.size(); i++){
			menu[i] = menuList.get(i).getItem(); 
		}
		jcb = new JComboBox();
		for(int i=0;i<menuList.size(); i++){
			jcb.addItem(menu[i]);
		}
		
		jcb.setBounds(100, 100, 100, 20);
		panel.add(jcb);*/
		
		
		
		/*
		 * model(); jt = new JTable(); jt.setBounds(150, 300, 1000, 400);
		 */

	}

	private String[][] menuRow() {
		data = new String[menuList.size()][];
		for(int i = 0; i < menuList.size(); i++){
			data[i] = new String[]{
					menuList.get(i).getGrp()
					,menuList.get(i).getItem()
					,menuList.get(i).getCal()+""       
					,menuList.get(i).getFat()+""
					,menuList.get(i).getCarbo()+""
					,menuList.get(i).getProtein()+""
					,menuList.get(i).getCost()+""
					,menuList.get(i).getCon()
					}; 
		}
		return data;
	}
}

class NoteBg2 extends JPanel {
	ImageIcon bgIcon2 = new ImageIcon("images/info.jpg");
	Image bgImg2 = bgIcon2.getImage();

	public void paintComponent(Graphics g) {
		super.paintComponent(g);

		g.drawImage(bgImg2, 0, 0, getWidth(), getHeight(), this);
	}
}
