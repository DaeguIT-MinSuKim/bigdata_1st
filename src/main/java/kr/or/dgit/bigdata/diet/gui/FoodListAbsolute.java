package kr.or.dgit.bigdata.diet.gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.JButton;
import javax.swing.JEditorPane;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.plaf.basic.BasicScrollBarUI;
import javax.swing.text.Document;
import javax.swing.text.html.HTMLEditorKit;
import javax.swing.text.html.StyleSheet;

import org.w3c.dom.css.RGBColor;

import javafx.scene.layout.BorderWidths;
import kr.or.dgit.bigdata.diet.dto.Calorie;
import kr.or.dgit.bigdata.diet.dto.Member;
import kr.or.dgit.bigdata.diet.dto.Menu;
import kr.or.dgit.bigdata.diet.middle.MonthMenu;
import kr.or.dgit.bigdata.diet.service.CalorieService;
import kr.or.dgit.bigdata.diet.service.MemberService;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JRadioButton;
import javax.swing.JRootPane;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.SystemColor;
import java.awt.Window.Type;
import org.eclipse.wb.swing.FocusTraversalOnArray;
import java.awt.Component;

public class FoodListAbsolute extends JFrame implements ActionListener{
	public static JPanel contentPane;
	private JTable table;
	private JButton btnMakeFoodList;
	private JButton btnMonth;
	private JButton[] btnDays = new JButton[30];
	private JTextField tfName;
	private JTextField tfOneDayCal;
	public static JTextField tfOneDayCost;
	public static JTextField tfMonthCost;
	private JTextField tfGender;
	private JTextField tfAge;
	private JTextField tfNo;
	private JButton btnSaveCsv;
	private MonthMenu monthMenu;
	int no; //회원 번호
	
	private Member member;
	
	//MonthMenu에 보낼 필드 선언
	int dayCal;
	int monthCost;
	private FoodListDialog foodListDialog;
	
	public FoodListAbsolute(MemberCheckGUI memberCheckGUI) {
		//멤버 객체 받아오기
		this.no = memberCheckGUI.noForFoodList; //회원 번호
		member = MemberService.getInstance().selectMemberByNo(no);
		
		//회원의 나이애 따른 칼로리 받아와서 MonthMenu에 던질 수 있도록 함.
		Calorie calorie = CalorieService.getInstance().selectCalorieByAge(member.getAge());
		dayCal = member.getGender().equals("여") ? calorie.getCal_woman() : calorie.getCal_man();
		monthCost =  member.getBudget();
		
		setAutoRequestFocus(false);
		setBackground(Color.WHITE);
		setTitle("추천식단");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 500, 500);
		contentPane = new JPanel();
		contentPane.setForeground(Color.BLACK);
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		setContentPane(contentPane);
		
		JPanel panelTop = new JPanel();
		panelTop.setBounds(5, 5, 474, 146);
		panelTop.setBorder(null);
		panelTop.setBackground(Color.WHITE);
		panelTop.setLayout(null);
		contentPane.add(panelTop);
		
		JLabel lblNo = new JLabel("회원번호");
		lblNo.setFont(new Font("굴림", Font.PLAIN, 11));
		lblNo.setBounds(201, 0, 44, 33);
		panelTop.add(lblNo);
		
		tfNo = new JTextField();
		tfNo.setText(memberCheckGUI.tf_no.getText());
		tfNo.setFont(new Font("굴림", Font.PLAIN, 11));
		tfNo.setHorizontalAlignment(SwingConstants.CENTER);
		tfNo.setColumns(10);
		tfNo.setBounds(249, 5, 50, 21);
		panelTop.add(tfNo);
		
		JLabel lblAge = new JLabel("나이");
		lblAge.setFont(new Font("굴림", Font.PLAIN, 11));
		lblAge.setBounds(311, 0, 22, 33);
		panelTop.add(lblAge);
		
		tfAge = new JTextField();
		tfAge.setText(member.getAge()+"");
		tfAge.setFont(new Font("굴림", Font.PLAIN, 11));
		tfAge.setHorizontalAlignment(SwingConstants.CENTER);
		tfAge.setColumns(10);
		tfAge.setBounds(337, 5, 50, 21);
		panelTop.add(tfAge);
		
		JLabel lblGender = new JLabel("성별");
		lblGender.setFont(new Font("굴림", Font.PLAIN, 11));
		lblGender.setBounds(399, 0, 22, 33);
		panelTop.add(lblGender);
		
		tfGender = new JTextField();
		tfGender.setText(member.getGender());
		tfGender.setFont(new Font("굴림", Font.PLAIN, 11));
		tfGender.setHorizontalAlignment(SwingConstants.CENTER);
		tfGender.setBounds(424, 5, 50, 21);
		panelTop.add(tfGender);
		tfGender.setColumns(10);
		
		tfName = new JTextField();
		tfName.setText(member.getName());
		tfName.setHorizontalAlignment(SwingConstants.CENTER);
		tfName.setFont(new Font("맑은 고딕", Font.BOLD, 22));
		tfName.setBounds(114, 55, 89, 26);
		panelTop.add(tfName);
		tfName.setColumns(10);
		
		JLabel lblRecommand = new JLabel("회원의 추천식단");
		lblRecommand.setHorizontalAlignment(SwingConstants.CENTER);
		lblRecommand.setFont(new Font("맑은 고딕", Font.PLAIN, 20));
		lblRecommand.setBounds(206, 55, 159, 26);
		panelTop.add(lblRecommand);
		
		btnMakeFoodList = new JButton("식단 생성하기");
		btnMakeFoodList.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		btnMakeFoodList.setBounds(0, 112, 89, 30);
		btnMakeFoodList.setBackground(Color.PINK);
		btnMakeFoodList.setBorder(null);
		panelTop.add(btnMakeFoodList);
		btnMakeFoodList.addActionListener(this);
		
		btnMonth = new JButton("30일 식단 보기");
		btnMonth.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		btnMonth.setBorder(null);
		btnMonth.setBackground(Color.PINK);
		btnMonth.setBounds(94, 112, 89, 30);
		panelTop.add(btnMonth);
		btnMonth.addActionListener(this);
		
		JPanel panelSum = new JPanel();
		panelSum.setBounds(329, 153, 150, 303);
		panelSum.setBorder(new EmptyBorder(20, 20, 20, 20));
		panelSum.setBackground(SystemColor.text);
		contentPane.add(panelSum);
		panelSum.setLayout(null);
		
		JLabel lblOneDayCal = new JLabel("1일권장칼로리");
		lblOneDayCal.setFont(new Font("맑은 고딕", Font.PLAIN, 13));
		lblOneDayCal.setBounds(0, 0, 85, 33);
		panelSum.add(lblOneDayCal);
		
		//1일 평균 칼로리
		tfOneDayCal = new JTextField();
		tfOneDayCal.setEditable(false);
		tfOneDayCal.setHorizontalAlignment(SwingConstants.RIGHT);
		tfOneDayCal.setText(dayCal+"");
		tfOneDayCal.setBounds(51, 28, 57, 21);
		panelSum.add(tfOneDayCal);
		tfOneDayCal.setColumns(10);
		
		JLabel lblOneDayCost = new JLabel("1일 평균 소비금액");
		lblOneDayCost.setFont(new Font("맑은 고딕", Font.PLAIN, 13));
		lblOneDayCost.setBounds(0, 71, 108, 33);
		panelSum.add(lblOneDayCost);
		
		//1일 평균 소비금액
		tfOneDayCost = new JTextField();
		tfOneDayCost.setEditable(false);
		tfOneDayCost.setHorizontalAlignment(SwingConstants.RIGHT);
		tfOneDayCost.setText("");
		tfOneDayCost.setBounds(51, 102, 57, 21);
		panelSum.add(tfOneDayCost);
		tfOneDayCost.setColumns(10);
		
		JLabel lblMonthCost = new JLabel("월 총경비");
		lblMonthCost.setFont(new Font("맑은 고딕", Font.PLAIN, 13));
		lblMonthCost.setBounds(0, 145, 57, 33);
		panelSum.add(lblMonthCost);
		
		//월 총경비
		tfMonthCost = new JTextField();
		tfMonthCost.setEditable(false);
		tfMonthCost.setHorizontalAlignment(SwingConstants.RIGHT);
		tfMonthCost.setText("");
		tfMonthCost.setBounds(51, 176, 57, 21);
		panelSum.add(tfMonthCost);
		tfMonthCost.setColumns(10);
		
		
		btnSaveCsv = new JButton("CSV저장");
		btnSaveCsv.setBounds(0, 278, 150, 25);
		panelSum.add(btnSaveCsv);
		
		JPanel panelBtn = new JPanel();
		panelBtn.setBackground(Color.PINK);
		panelBtn.setBounds(5, 153, 320, 303);
		panelBtn.setBorder(new EmptyBorder(20, 20, 20, 20));
		panelBtn.setLayout(new GridLayout(0, 6, 10, 10));
		contentPane.add(panelBtn);
		
		for (int i = 0; i < btnDays.length; i++) {
			btnDays[i] = new JButton((i+1)+"일");
			btnDays[i].setBackground(Color.WHITE);
			btnDays[i].setBorder(null);
			panelBtn.add(btnDays[i]);
			
			btnDays[i].addActionListener(this);
		}
		
		/*scrollPane.getVerticalScrollBar().setUI(new BasicScrollBarUI(){
			
			@Override
			protected void configureScrollBarColors() {
				this.thumbDarkShadowColor = Color.BLACK;
			}

			@Override
			protected JButton createDecreaseButton(int orientation) {
				return createZeroButton();
			}

			@Override
			protected JButton createIncreaseButton(int orientation) {
				return createZeroButton();
			}
			
			private JButton createZeroButton(){
				JButton button = new JButton();
				button.setPreferredSize(new Dimension(0, 0));
				button.setMinimumSize(new Dimension(0, 0));
				button.setMaximumSize(new Dimension(0, 0));
				return button;
			}
		});*/
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		//식단 생성 버튼
		if (e.getSource() == btnMakeFoodList) {
			//식단이 아직 생성되어있지 않을 때 호출하도록
			if (MemberCheckGUI.tempMonthMenu.containsKey(no)) {
				return;
			}else{
				JOptionPane.showMessageDialog(null, "식단을 생성 중입니다");
				monthMenu = new MonthMenu(dayCal, monthCost);
				MemberCheckGUI.tempMonthMenu.put(no, monthMenu);
			}
		}
		
		//1일 ~ 30일 일자 버튼
		for (int i = 0; i < btnDays.length; i++) {
			if (e.getSource() == btnDays[i]) {
				monthMenu = MemberCheckGUI.tempMonthMenu.get(no);
				
				//1일~30일 버튼을 클릭했는데 식단이 없을 때
				if (monthMenu == null) {
					JOptionPane.showMessageDialog(null, "식단 생성을 먼저 진행해주세요.");
					return;
				}else{
					foodListDialog = new FoodListDialog(monthMenu, (i+1));
					foodListDialog.setVisible(true);
				}
			}
		}
		
		//30일치 한꺼번에 보기
		if (e.getSource() == btnMonth) {
			monthMenu = MemberCheckGUI.tempMonthMenu.get(no);
			
			if (monthMenu == null) {
				JOptionPane.showMessageDialog(null, "식단 생성을 먼저 진행해주세요.");
				return;
			}else{
				foodListDialog= new FoodListDialog(monthMenu, -1);
				foodListDialog.setVisible(true);
			}			
		}
	}
}
