package kr.or.dgit.bigdata.diet.gui;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.sun.prism.paint.Color;

import kr.or.dgit.bigdata.diet.dto.Menu;
import kr.or.dgit.bigdata.diet.service.MenuService;

import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTabbedPane;
import javax.swing.JTable;

public class MenuManagerGUI extends JFrame {
	private static MenuService menuService;
	
	Container contentPane;
	private JTextField tfGrp;
	private JTextField tfItem;
	private JTextField tfCal;
	private JTextField tfFat;
	private JTextField tfCarbo;
	private JTextField tfProtein;
	private JTextField tfCost;
	private JTextField tfCon;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MenuManagerGUI frame = new MenuManagerGUI();
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
		
		//텍스트필드
		tfGrp = new JTextField();
		tfGrp.setColumns(10);
		tfGrp.setOpaque(false);
		tfGrp.setBorder(null);
		tfGrp.setBounds(290, 141, 120, 30);
		tfGrp.setFocusable(true);
		nb.add(tfGrp);
		
		tfItem = new JTextField();
		tfItem.setColumns(10);
		tfItem.setOpaque(false);
		tfItem.setBorder(null);
		tfItem.setBounds(290, 188, 120, 30);
		nb.add(tfItem);
		
		tfCal = new JTextField();
		tfCal.setColumns(10);
		tfCal.setOpaque(false);
		tfCal.setBorder(null);
		tfCal.setBounds(290, 235, 120, 30);
		nb.add(tfCal);
		
		tfFat = new JTextField();
		tfFat.setColumns(10);
		tfFat.setOpaque(false);
		tfFat.setBorder(null);
		tfFat.setBounds(290, 281, 120, 30);
		nb.add(tfFat);
		
		tfCarbo = new JTextField();
		tfCarbo.setColumns(10);
		tfCarbo.setOpaque(false);
		tfCarbo.setBorder(null);
		tfCarbo.setBounds(290, 327, 120, 30);
		nb.add(tfCarbo);
		
		tfProtein = new JTextField();
		tfProtein.setColumns(10);
		tfProtein.setOpaque(false);
		tfProtein.setBorder(null);
		tfProtein.setBounds(290, 374, 120, 30);
		nb.add(tfProtein);
		
		tfCost = new JTextField();
		tfCost.setColumns(10);
		tfCost.setOpaque(false);
		tfCost.setBorder(null);
		tfCost.setBounds(290, 421, 120, 30);
		nb.add(tfCost);
		
		tfCon = new JTextField();
		tfCon.setColumns(10);
		tfCon.setOpaque(false);
		tfCon.setBorder(null);
		tfCon.setBounds(290, 467, 120, 30);
		nb.add(tfCon);
		
		//버튼
		JButton btnAdd = new JButton("추가");
		//메뉴 입력 이벤트
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				menuService = MenuService.getInstance();
				
				Menu menu = new Menu();
				menu.setGrp(tfGrp.getText());
				menu.setItem(tfItem.getText());
				menu.setCal(Integer.parseInt(tfCal.getText()));
				menu.setFat(Float.parseFloat(tfFat.getText()));
				menu.setCarbo(Float.parseFloat(tfCarbo.getText()));
				menu.setProtein(Float.parseFloat(tfProtein.getText()));
				menu.setCost(Integer.parseInt(tfCost.getText()));
				menu.setCon(tfCon.getText());
				
				int res = menuService.insertMenuAuto(menu);
			}
		});
		
		btnAdd.setBounds(621, 391, 80, 50);
		nb.add(btnAdd);
		
		JButton btnSub = new JButton("삭제");
		btnSub.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				OutputMenuList oml = new OutputMenuList();
				oml.setVisible(true);
				
			}
		});
		btnSub.setBounds(621, 451, 80, 50);
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
