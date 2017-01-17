package kr.or.dgit.bigdata.diet.gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

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
import kr.or.dgit.bigdata.diet.dto.Menu;
import kr.or.dgit.bigdata.diet.middle.MonthMenu;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.SystemColor;
import java.awt.Window.Type;
import org.eclipse.wb.swing.FocusTraversalOnArray;
import java.awt.Component;

public class FoodListAbsolute extends JFrame implements ActionListener{
	private JPanel contentPane;
	private JTable table;
	private JButton btnMakeFoodList;
	private JButton btnMonth;
	private JButton[] btnDays = new JButton[30];
	private JTextField tfName;
	private JTextField tfOneDayCal;
	private JTextField tfOneDayCost;
	private JTextField tfMonthCost;
	private JTextField tfGender;
	private JTextField tfAge;
	private JTextField tfNo;
	private JButton btnBack;
	private JButton btnSaveCsv;
	private MonthMenu monthMenu;
	private FoodListGUI foodListGui;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FoodListAbsolute frame = new FoodListAbsolute(null);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public FoodListAbsolute(MemberCheckGUI memberCheckGUI) {
		setAutoRequestFocus(false);
		setBackground(Color.WHITE);
		setTitle("추천식단");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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
		tfNo.setFont(new Font("굴림", Font.PLAIN, 11));
		tfNo.setText("001");
		tfNo.setHorizontalAlignment(SwingConstants.CENTER);
		tfNo.setColumns(10);
		tfNo.setBounds(249, 5, 50, 21);
		panelTop.add(tfNo);
		
		JLabel lblAge = new JLabel("나이");
		lblAge.setFont(new Font("굴림", Font.PLAIN, 11));
		lblAge.setBounds(311, 0, 22, 33);
		panelTop.add(lblAge);
		
		tfAge = new JTextField();
		tfAge.setFont(new Font("굴림", Font.PLAIN, 11));
		tfAge.setText("22");
		tfAge.setHorizontalAlignment(SwingConstants.CENTER);
		tfAge.setColumns(10);
		tfAge.setBounds(337, 5, 50, 21);
		panelTop.add(tfAge);
		
		JLabel lblGender = new JLabel("성별");
		lblGender.setFont(new Font("굴림", Font.PLAIN, 11));
		lblGender.setBounds(399, 0, 22, 33);
		panelTop.add(lblGender);
		
		tfGender = new JTextField();
		tfGender.setFont(new Font("굴림", Font.PLAIN, 11));
		tfGender.setHorizontalAlignment(SwingConstants.CENTER);
		tfGender.setText("여");
		tfGender.setBounds(424, 5, 50, 21);
		panelTop.add(tfGender);
		tfGender.setColumns(10);
		
		tfName = new JTextField();
		tfName.setHorizontalAlignment(SwingConstants.CENTER);
		tfName.setText("강보미");
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
		
		tfOneDayCal = new JTextField();
		tfOneDayCal.setEditable(false);
		tfOneDayCal.setHorizontalAlignment(SwingConstants.RIGHT);
		tfOneDayCal.setText("2100");
		tfOneDayCal.setBounds(51, 28, 57, 21);
		panelSum.add(tfOneDayCal);
		tfOneDayCal.setColumns(10);
		
		JLabel lblOneDayCost = new JLabel("1일 평균 소비금액");
		lblOneDayCost.setFont(new Font("맑은 고딕", Font.PLAIN, 13));
		lblOneDayCost.setBounds(0, 71, 108, 33);
		panelSum.add(lblOneDayCost);
		
		tfOneDayCost = new JTextField();
		tfOneDayCost.setEditable(false);
		tfOneDayCost.setHorizontalAlignment(SwingConstants.RIGHT);
		tfOneDayCost.setText("30000");
		tfOneDayCost.setBounds(51, 102, 57, 21);
		panelSum.add(tfOneDayCost);
		tfOneDayCost.setColumns(10);
		
		JLabel lblMonthCost = new JLabel("월 총경비");
		lblMonthCost.setFont(new Font("맑은 고딕", Font.PLAIN, 13));
		lblMonthCost.setBounds(0, 145, 57, 33);
		panelSum.add(lblMonthCost);
		
		tfMonthCost = new JTextField();
		tfMonthCost.setEditable(false);
		tfMonthCost.setHorizontalAlignment(SwingConstants.RIGHT);
		tfMonthCost.setText("950000");
		tfMonthCost.setBounds(51, 176, 57, 21);
		panelSum.add(tfMonthCost);
		tfMonthCost.setColumns(10);
		
		
		btnSaveCsv = new JButton("CSV저장");
		btnSaveCsv.setBounds(0, 251, 150, 25);
		panelSum.add(btnSaveCsv);
		
		btnBack = new JButton("돌아가기");
		btnBack.setBounds(0, 278, 150, 25);
		panelSum.add(btnBack);
		
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
		if (e.getSource() == btnMakeFoodList) {
			if (monthMenu == null) {
				monthMenu= new MonthMenu(2100, 950000);
			}else{
				return;
			}
		}
		for (int i = 0; i < btnDays.length; i++) {
			if (e.getSource() == btnDays[i]) {
				if (monthMenu == null) {
					JOptionPane.showMessageDialog(null, "식단 생성을 먼저 진행해주세요.");
					return;
				}else{
					foodListGui = new FoodListGUI(monthMenu, (i+1));
					foodListGui.setVisible(true);
				}
			}
		}
		if (e.getSource() == btnMonth) {
			foodListGui = new FoodListGUI(monthMenu, -1);
			foodListGui.setVisible(true);
		}
	}
}
