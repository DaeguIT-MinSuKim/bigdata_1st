package kr.or.dgit.bigdata.diet.gui;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Dialog.ModalityType;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JDialog;
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
import java.awt.Color;

public class OutputMenuList extends JDialog {
	private static MenuService menuService;
	/* Container contentPane; */
	private ArrayList<Menu> menuList;
	private JComboBox jcb;
	private JTable table;
	private String[][] data;
	int result;

	public OutputMenuList() {
		setSize(1024, 768);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		getContentPane().setLayout(null);
		
		NoteBg2 panel = new NoteBg2();
		panel.setBounds(0, 0, 1008, 729);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		//크기조정불가
		setResizable(false);
		
		//현재 다이얼로그를 띄웠을 때 다른 프레임은 움직이지 못하도록 처리
		setModalityType(ModalityType.APPLICATION_MODAL);
		
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
		jcb.setBackground(new Color(255, 255, 255));
		
		for(int i=0;i<menuList.size(); i++){
			jcb.addItem(menu[i]);
		}
		
		jcb.setBounds(500, 590, 120, 20);
		panel.add(jcb);
		
		//이미지아이콘
		ImageIcon iconAdd = new ImageIcon("src/main/resources/pictogram/small_add_list.png");
		ImageIcon iconTrash = new ImageIcon("src/main/resources/pictogram/small_trash.png");
		
		//메뉴 삭제 버튼
		JButton btnMenuDel = new JButton("");
		btnMenuDel.setIcon(iconTrash);
		btnMenuDel.setOpaque(false);
		btnMenuDel.setBorder(null);
		btnMenuDel.setBorderPainted(false);
		btnMenuDel.setContentAreaFilled(false);
		btnMenuDel.setFocusable(false);
		
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
					JOptionPane.showMessageDialog(null,jcb.getSelectedItem()+"를 삭제하였습니다.");
					
					
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
		btnMenuDel.setBounds(632, 565, 50, 50);
		panel.add(btnMenuDel);
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
	ImageIcon bgIcon2 = new ImageIcon("src/main/resources/images/info.jpg");
	Image bgImg2 = bgIcon2.getImage();

	public void paintComponent(Graphics g) {
		super.paintComponent(g);

		g.drawImage(bgImg2, 0, 0, getWidth(), getHeight(), this);
	}
}
