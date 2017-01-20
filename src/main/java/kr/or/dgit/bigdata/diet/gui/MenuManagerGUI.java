package kr.or.dgit.bigdata.diet.gui;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.sun.prism.paint.Color;

import kr.or.dgit.bigdata.diet.dto.Menu;
import kr.or.dgit.bigdata.diet.service.MenuService;

import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JComboBox;

import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import java.awt.Font;

public class MenuManagerGUI extends JFrame {
	private static MenuService menuService;
	
	Container contentPane;
	private JTextField tfGrp;
	private JComboBox boxGrp;
	private JTextField tfItem;
	private JTextField tfCal;
	private JTextField tfFat;
	private JTextField tfCarbo;
	private JTextField tfProtein;
	private JTextField tfCost;
	private JTextField tfCon;
	
	private ArrayList<Menu> menuList;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MenuManagerGUI frame = new MenuManagerGUI();
					frame.setLocationRelativeTo(null);
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
	public MenuManagerGUI() {
		setTitle("식단관리");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		contentPane = getContentPane();
		
		//배경패널 추가
		NoteBg nb = new NoteBg();
		contentPane.add(nb, BorderLayout.CENTER);
		nb.setLayout(null);
		
		//이미지아이콘
		ImageIcon iconAdd = new ImageIcon("pictogram/small_add_list.png");
		ImageIcon iconTrash = new ImageIcon("pictogram/small_trash.png");
		
		//콤보박스, 텍스트필드
		String[] grpList = {"고기","생선&해산물","음료","과일","야채","빵&씨리얼"};
		boxGrp = new JComboBox(grpList);
		boxGrp.setBackground(new java.awt.Color(255, 255, 255));
		boxGrp.setForeground(new java.awt.Color(220, 20, 60));
		boxGrp.setFont(new Font("나눔바른펜", Font.BOLD, 16));
		boxGrp.setBounds(290, 141, 120, 30);
		boxGrp.setBorder(null);
		nb.add(boxGrp);
		
		tfItem = new JTextField();
		tfItem.setForeground(new java.awt.Color(220, 20, 60));
		tfItem.setFont(new Font("나눔바른펜", Font.BOLD, 20));
		tfItem.setColumns(10);
		tfItem.setOpaque(false);
		tfItem.setBorder(null);
		tfItem.setBounds(290, 188, 120, 30);
		nb.add(tfItem);
		
		tfCal = new JTextField();
		tfCal.setForeground(new java.awt.Color(220, 20, 60));
		tfCal.setFont(new Font("나눔바른펜", Font.BOLD, 20));
		tfCal.setColumns(10);
		tfCal.setOpaque(false);
		tfCal.setBorder(null);
		tfCal.setBounds(290, 235, 120, 30);
		nb.add(tfCal);
		
		tfFat = new JTextField();
		tfFat.setForeground(new java.awt.Color(220, 20, 60));
		tfFat.setFont(new Font("나눔바른펜", Font.BOLD, 20));
		tfFat.setColumns(10);
		tfFat.setOpaque(false);
		tfFat.setBorder(null);
		tfFat.setBounds(290, 281, 120, 30);
		nb.add(tfFat);
		
		tfCarbo = new JTextField();
		tfCarbo.setForeground(new java.awt.Color(220, 20, 60));
		tfCarbo.setFont(new Font("나눔바른펜", Font.BOLD, 20));
		tfCarbo.setColumns(10);
		tfCarbo.setOpaque(false);
		tfCarbo.setBorder(null);
		tfCarbo.setBounds(290, 327, 120, 30);
		nb.add(tfCarbo);
		
		tfProtein = new JTextField();
		tfProtein.setForeground(new java.awt.Color(220, 20, 60));
		tfProtein.setFont(new Font("나눔바른펜", Font.BOLD, 20));
		tfProtein.setColumns(10);
		tfProtein.setOpaque(false);
		tfProtein.setBorder(null);
		tfProtein.setBounds(290, 374, 120, 30);
		nb.add(tfProtein);
		
		tfCost = new JTextField();
		tfCost.setForeground(new java.awt.Color(220, 20, 60));
		tfCost.setFont(new Font("나눔바른펜", Font.BOLD, 20));
		tfCost.setColumns(10);
		tfCost.setOpaque(false);
		tfCost.setBorder(null);
		tfCost.setBounds(290, 421, 120, 30);
		nb.add(tfCost);
		
		tfCon = new JTextField();
		tfCon.setForeground(new java.awt.Color(220, 20, 60));
		tfCon.setFont(new Font("나눔바른펜", Font.BOLD, 20));
		tfCon.setColumns(10);
		tfCon.setOpaque(false);
		tfCon.setBorder(null);
		tfCon.setBounds(290, 467, 120, 30);
		nb.add(tfCon);
		
		//추가버튼
		JButton btnAdd = new JButton("");
		btnAdd.setIcon(iconAdd);
		btnAdd.setOpaque(false);
		btnAdd.setBorder(null);
		btnAdd.setBorderPainted(false);
		btnAdd.setContentAreaFilled(false);
		btnAdd.setFocusable(false);
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				menuService = MenuService.getInstance();
				
				Menu menu = new Menu();
				menu.setGrp((String) boxGrp.getSelectedItem());
				menu.setItem(tfItem.getText());
				menu.setCal(Integer.parseInt(tfCal.getText()));
				menu.setFat(Float.parseFloat(tfFat.getText()));
				menu.setCarbo(Float.parseFloat(tfCarbo.getText()));
				menu.setProtein(Float.parseFloat(tfProtein.getText()));
				menu.setCost(Integer.parseInt(tfCost.getText()));
				menu.setCon(tfCon.getText());
				
				int res = menuService.insertMenuAuto(menu);
				
				JOptionPane.showMessageDialog(null, "식단이 추가되었습니다.");
				
			}
		});
		
		btnAdd.setBounds(652, 400, 50, 50);
		nb.add(btnAdd);
		
		//삭제버튼
		JButton btnSub = new JButton("");
		btnSub.setIcon(iconTrash);
		btnSub.setOpaque(false);
		btnSub.setBorder(null);
		btnSub.setBorderPainted(false);
		btnSub.setContentAreaFilled(false);
		btnSub.setFocusable(false);
		btnSub.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				OutputMenuList oml = new OutputMenuList();
				oml.setLocationRelativeTo(null);
				oml.setVisible(true);
				
			}
		});
		btnSub.setBounds(650, 451, 50, 50);
		nb.add(btnSub);
		
		setSize(800, 730);
	}
}


//배경 패널
class NoteBg extends JPanel{
	ImageIcon bgIcon = new ImageIcon("images/note2.jpg");
	Image bgImg = bgIcon.getImage();
	
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		
		g.drawImage(bgImg, 0, 0, getWidth(), getHeight(), this);
	}
}
