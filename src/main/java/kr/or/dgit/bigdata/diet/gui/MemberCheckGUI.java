package kr.or.dgit.bigdata.diet.gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.Shape;
import java.awt.image.ImageObserver;
import java.text.AttributedCharacterIterator;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import java.awt.GridLayout;
import java.awt.SystemColor;
import javax.swing.JButton;

public class MemberCheckGUI extends JFrame {

	private JPanel contentPane;
	private JLabel lblBgImage;
	private JTextField tf_name;
	private JLabel lbl_no;
	private JTextField tf_no;
	private JLabel lbl_gender;
	private JLabel lbl_weight;
	private JLabel lbl_age;
	private JLabel lbl_phone;
	private JLabel lbl_location;
	private JLabel lbl_budget;
	private JPanel panelLabel;
	private JPanel panelText;
	private JTextField tf_budget;
	private JTextField tf_location;
	private JTextField tf_phone;
	private JTextField tf_age;
	private JTextField tf_weight;
	private JTextField tf_gender;
	private JLabel lbl_kg;
	private JLabel lbl_won;
	private JLabel lbl_number;
	private JLabel lbl_seperator;
	private JLabel lbl_sum;
	private JPanel panelNumber;
	private JButton btnRight;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MemberCheckGUI frame = new MemberCheckGUI();
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
	public MemberCheckGUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 316, 538);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lbl_no = new JLabel("No.");
		lbl_no.setFont(new Font("굴림", Font.PLAIN, 12));
		lbl_no.setBounds(31, 196, 20, 15);
		contentPane.add(lbl_no);
		
		tf_no = new JTextField();
		tf_no.setEditable(false);
		tf_no.setFont(new Font("굴림", Font.PLAIN, 12));
		tf_no.setText("001");
		tf_no.setBounds(53, 196, 40, 15);
		contentPane.add(tf_no);
		tf_no.setColumns(10);
		tf_no.setBorder(null);
		tf_no.setBackground(Color.WHITE);
		
		tf_name = new JTextField();
		tf_name.setEditable(false);
		tf_name.setHorizontalAlignment(SwingConstants.CENTER);
		tf_name.setFont(new Font("맑은 고딕", Font.BOLD, 22));
		tf_name.setText("강보미");
		tf_name.setBounds(75, 211, 150, 30);
		contentPane.add(tf_name);
		tf_name.setColumns(10);
		tf_name.setBorder(null);
		tf_name.setBackground(Color.WHITE);
		
		panelLabel = new JPanel();
		panelLabel.setBounds(67, 251, 65, 200);
		contentPane.add(panelLabel);
		panelLabel.setLayout(new GridLayout(0, 1, 0, 0));
		panelLabel.setBackground(new Color(255,0,0,0));
		
		lbl_gender = new JLabel("성별");
		lbl_gender.setForeground(Color.DARK_GRAY);
		lbl_gender.setHorizontalAlignment(SwingConstants.RIGHT);
		panelLabel.add(lbl_gender);
		lbl_gender.setFont(new Font("맑은 고딕", Font.PLAIN, 15));
		
		lbl_weight = new JLabel("몸무게");
		lbl_weight.setForeground(Color.DARK_GRAY);
		lbl_weight.setHorizontalAlignment(SwingConstants.RIGHT);
		lbl_weight.setFont(new Font("맑은 고딕", Font.PLAIN, 15));
		panelLabel.add(lbl_weight);
		
		lbl_age = new JLabel("나이");
		lbl_age.setForeground(Color.DARK_GRAY);
		lbl_age.setHorizontalAlignment(SwingConstants.RIGHT);
		lbl_age.setFont(new Font("맑은 고딕", Font.PLAIN, 15));
		panelLabel.add(lbl_age);
		
		lbl_phone = new JLabel("휴대전화");
		lbl_phone.setForeground(Color.DARK_GRAY);
		lbl_phone.setHorizontalAlignment(SwingConstants.RIGHT);
		lbl_phone.setFont(new Font("맑은 고딕", Font.PLAIN, 15));
		panelLabel.add(lbl_phone);
		
		lbl_location = new JLabel("거주지");
		lbl_location.setForeground(Color.DARK_GRAY);
		lbl_location.setHorizontalAlignment(SwingConstants.RIGHT);
		lbl_location.setFont(new Font("맑은 고딕", Font.PLAIN, 15));
		panelLabel.add(lbl_location);
		
		lbl_budget = new JLabel("월예산");
		lbl_budget.setForeground(Color.DARK_GRAY);
		lbl_budget.setHorizontalAlignment(SwingConstants.RIGHT);
		lbl_budget.setFont(new Font("맑은 고딕", Font.PLAIN, 15));
		panelLabel.add(lbl_budget);
		
		panelText = new JPanel();
		panelText.setBackground(new Color(255, 0, 0, 0));
		panelText.setBounds(132, 251, 100, 200);
		contentPane.add(panelText);
		panelText.setLayout(new GridLayout(0, 1, 0, 0));
		panelText.setBackground(new Color(255,0,0,0));
		
		tf_gender = new JTextField();
		tf_gender.setHorizontalAlignment(SwingConstants.CENTER);
		tf_gender.setText("여");
		tf_gender.setFont(new Font("굴림", Font.PLAIN, 12));
		tf_gender.setEditable(false);
		tf_gender.setColumns(10);
		tf_gender.setBorder(null);
		tf_gender.setBackground(new Color(255, 0, 0, 0));
		panelText.add(tf_gender);
		
		tf_weight = new JTextField();
		tf_weight.setEditable(false);
		tf_weight.setHorizontalAlignment(SwingConstants.CENTER);
		tf_weight.setText("45");
		tf_weight.setFont(new Font("굴림", Font.PLAIN, 12));
		tf_weight.setColumns(10);
		tf_weight.setBorder(null);
		tf_weight.setBackground(new Color(255, 0, 0, 0));
		panelText.add(tf_weight);
		
		tf_age = new JTextField();
		tf_age.setHorizontalAlignment(SwingConstants.CENTER);
		tf_age.setText("23");
		tf_age.setFont(new Font("굴림", Font.PLAIN, 12));
		tf_age.setEditable(false);
		tf_age.setColumns(10);
		tf_age.setBorder(null);
		tf_age.setBackground(new Color(255, 0, 0, 0));
		panelText.add(tf_age);
		
		tf_phone = new JTextField();
		tf_phone.setHorizontalAlignment(SwingConstants.CENTER);
		tf_phone.setText("010-5108-4160");
		tf_phone.setFont(new Font("굴림", Font.PLAIN, 12));
		tf_phone.setEditable(false);
		tf_phone.setColumns(10);
		tf_phone.setBorder(null);
		tf_phone.setBackground(new Color(255, 0, 0, 0));
		panelText.add(tf_phone);
		
		tf_location = new JTextField();
		tf_location.setHorizontalAlignment(SwingConstants.CENTER);
		tf_location.setText("대구");
		tf_location.setFont(new Font("굴림", Font.PLAIN, 12));
		tf_location.setEditable(false);
		tf_location.setColumns(10);
		tf_location.setBorder(null);
		tf_location.setBackground(new Color(255, 0, 0, 0));
		panelText.add(tf_location);
		
		tf_budget = new JTextField();
		tf_budget.setHorizontalAlignment(SwingConstants.CENTER);
		tf_budget.setText("316000");
		tf_budget.setFont(new Font("굴림", Font.PLAIN, 12));
		tf_budget.setEditable(false);
		tf_budget.setColumns(10);
		tf_budget.setBorder(null);
		tf_budget.setBackground(new Color(255, 0, 0, 0));
		panelText.add(tf_budget);
		
		lbl_kg = new JLabel("kg");
		lbl_kg.setFont(new Font("굴림", Font.PLAIN, 11));
		lbl_kg.setBounds(229, 297, 25, 15);
		contentPane.add(lbl_kg);
		
		lbl_won = new JLabel("원");
		lbl_won.setFont(new Font("굴림", Font.PLAIN, 11));
		lbl_won.setBounds(229, 428, 25, 15);
		contentPane.add(lbl_won);
		
		JButton btnLeft = new JButton("");
		btnLeft.setIcon(new ImageIcon("D:\\workspace\\workspace_mybatis\\dietfoodmanager\\images\\btn_left.png"));
		btnLeft.setBounds(10, 320, 65, 41);
		contentPane.add(btnLeft);
		btnLeft.setBackground(new Color(255,0,0,0));
		btnLeft.setBorder(null);
		
		btnRight = new JButton("");
		btnRight.setIcon(new ImageIcon("D:\\workspace\\workspace_mybatis\\dietfoodmanager\\images\\btn_right.png"));
		btnRight.setBounds(223, 322, 65, 41);
		contentPane.add(btnRight);
		btnRight.setBackground(new Color(255,0,0,0));
		btnRight.setBorder(null);
		
		panelNumber = new JPanel();
		panelNumber.setBounds(125, 450, 50, 31);
		contentPane.add(panelNumber);
		panelNumber.setBackground(new Color(255,0,0,0));
		
		lbl_number = new JLabel("1");
		panelNumber.add(lbl_number);
		lbl_number.setFont(new Font("Dialog", Font.BOLD, 14));
		lbl_number.setForeground(new Color(102, 153, 204));
		
		lbl_seperator = new JLabel("/");
		panelNumber.add(lbl_seperator);
		lbl_seperator.setFont(new Font("Dialog", Font.PLAIN, 12));
		
		lbl_sum = new JLabel("4");
		panelNumber.add(lbl_sum);
		lbl_sum.setFont(new Font("Dialog", Font.PLAIN, 12));
		
		
//배경화면 이미지 부분
		lblBgImage = new JLabel("");
		lblBgImage.setIcon(new ImageIcon("D:\\workspace\\workspace_mybatis\\dietfoodmanager\\images\\bg_membercheck.png"));
		lblBgImage.setBounds(0, 0, 300, 500);
		contentPane.add(lblBgImage);
	}
}
