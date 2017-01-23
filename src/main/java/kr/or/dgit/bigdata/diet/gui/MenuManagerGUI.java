package kr.or.dgit.bigdata.diet.gui;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Dialog.ModalityType;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.sun.prism.paint.Color;

import kr.or.dgit.bigdata.diet.dto.Menu;
import kr.or.dgit.bigdata.diet.service.DataInputService;
import kr.or.dgit.bigdata.diet.service.MenuService;

import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;

import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import java.awt.Font;

public class MenuManagerGUI extends JDialog implements ActionListener {
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

	private JButton btnAdd;

	private JButton btnSub;

	DataInputService dataInputService = new DataInputService();

	public MenuManagerGUI() {
		setTitle("식단관리");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		contentPane = getContentPane();
		
		//크기조정불가
		setResizable(false);
		
		//현재 다이얼로그를 띄웠을 때 다른 프레임은 움직이지 못하도록 처리
		setModalityType(ModalityType.APPLICATION_MODAL);

		// 배경패널 추가
		NoteBg nb = new NoteBg();
		contentPane.add(nb, BorderLayout.CENTER);
		nb.setLayout(null);

		// 이미지아이콘
		ImageIcon iconAdd = new ImageIcon("src/main/resources/pictogram/small_add_list.png");
		ImageIcon iconTrash = new ImageIcon("src/main/resources/pictogram/small_trash.png");

		// 콤보박스, 텍스트필드
		// 식품군
		String[] grpList = { "고기", "생선&해산물", "음료", "과일", "야채", "빵&씨리얼" };
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

		btnAdd = new JButton("");
		btnAdd.setIcon(iconAdd);
		btnAdd.setOpaque(false);
		btnAdd.setBorder(null);
		btnAdd.setBorderPainted(false);
		btnAdd.setContentAreaFilled(false);
		btnAdd.setFocusable(false);
		btnAdd.addActionListener(this);

		btnAdd.setBounds(652, 400, 50, 50);
		nb.add(btnAdd);

		btnSub = new JButton("");
		btnSub.setIcon(iconTrash);
		btnSub.setOpaque(false);
		btnSub.setBorder(null);
		btnSub.setBorderPainted(false);
		btnSub.setContentAreaFilled(false);
		btnSub.setFocusable(false);
		btnSub.addActionListener(this);
		btnSub.setBounds(650, 451, 50, 50);
		nb.add(btnSub);

		setSize(800, 730);
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		if (e.getSource() == btnAdd) {
			menuService = MenuService.getInstance();

			// 값 유효성 검사 함수가 true일 때 실행
			if (!validCheck()) {

			} else {
				Menu menu = new Menu();

				menu.setGrp(boxGrp.getSelectedItem() + "");
				menu.setItem(tfItem.getText());
				menu.setCal(Integer.parseInt(tfCal.getText()));
				menu.setFat(Float.parseFloat(tfFat.getText()));
				menu.setCarbo(Float.parseFloat(tfCarbo.getText()));
				menu.setProtein(Float.parseFloat(tfProtein.getText()));
				menu.setCost(Integer.parseInt(tfCost.getText()));
				menu.setCon(tfCon.getText());

				int res = menuService.insertMenuAuto(menu);

				JOptionPane.showMessageDialog(null, "식단이 추가되었습니다.");
				// 텍스트필드 초기화 메소드 호출
				allTextFieldClear();
			}
		}

		if (e.getSource() == btnSub) {
			OutputMenuList oml = new OutputMenuList();
			oml.setLocationRelativeTo(null);
			oml.setVisible(true);
		}
	}

	private void allTextFieldClear() {
		dataInputService.allTextFieldClear(
				tfItem,
				tfCal,
				tfFat,
				tfCarbo,
				tfProtein,
				tfCost,
				tfCon);
	}

	// 값 유효성 검사
	private boolean validCheck() {

		try {
			dataInputService.isEmptyCheck(tfItem);
			dataInputService.isEmptyCheck(tfCal);
			dataInputService.isEmptyCheck(tfFat);
			dataInputService.isEmptyCheck(tfCarbo);
			dataInputService.isEmptyCheck(tfProtein);
			dataInputService.isEmptyCheck(tfCost);
			dataInputService.isEmptyCheck(tfCon);

			dataInputService.isValidCheck("[가-힣]{1,10}", tfItem, "항목은 1글자 이상 10글자 이하로 한글로 작성해주세요.");
			dataInputService.isValidCheck("^[0-9]{1,3}", tfCal, "칼로리는 999kcal이하로 작성해주세요.");
			dataInputService.isValidCheck("^[0-9]+(.[0-9]+)?{1,2}", tfFat, "지방은 99kcal이하로 작성해주세요.");
			dataInputService.isValidCheck("^[0-9]+(.[0-9]+)?{1,2}", tfCarbo, "탄수화물은 99kcal이하로 작성해주세요.");
			dataInputService.isValidCheck("^[0-9]+(.[0-9]+)?{1,2}", tfProtein, "단백질은 99kcal이하로 작성해주세요.");
			dataInputService.isValidCheck("^[0-9]+(.[0-9]+)?{1,2}", tfProtein, "단백질은 99kcal이하로 작성해주세요.");
			dataInputService.isValidCheck("[0-9]{2,4}", tfCost, "비용은 100~9999원 이하로 작성해주세요.");
			dataInputService.isValidCheck("^[0-9a-zA-Zㄱ-ㅎㅏ-ㅣ가-힣]{1,10}", tfCon, "조건은 10글자 이하로 작성해주세요.");

			return true;
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
			return false;
		}
	}
}
	// 배경 패널
class NoteBg extends JPanel{
	ImageIcon bgIcon = new ImageIcon("src/main/resources/images/note2.jpg");
	Image bgImg = bgIcon.getImage();
	
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		
		g.drawImage(bgImg, 0, 0, getWidth(), getHeight(), this);
	}
}
