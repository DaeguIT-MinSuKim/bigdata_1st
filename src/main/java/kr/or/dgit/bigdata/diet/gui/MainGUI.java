package kr.or.dgit.bigdata.diet.gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.FlowLayout;
import javax.swing.JTextField;
import javax.swing.JSeparator;

public class MainGUI extends JFrame {

	private JPanel contentPane;
	private JTextField tf_no;
	private JTextField tf_name;
	private JTextField tf_gender;
	private JTextField tf_weight;
	private JTextField tf_age;
	private JTextField tf_phone;
	private JTextField tf_location;
	private JTextField tf_budg;
	private JButton btnMenu;
	private JButton btnOneReg;
	private JButton btnGrpReg;
	private JButton btnLeft;
	private JButton btnRight;
	private JSeparator separator;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainGUI frame = new MainGUI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	public MainGUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 487);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JPanel p_display = new JPanel();
		contentPane.add(p_display, BorderLayout.CENTER);
		p_display.setLayout(null);
		
		JLabel label = new JLabel("회원번호");
		label.setBounds(108, 19, 48, 15);
		label.setHorizontalAlignment(SwingConstants.RIGHT);
		p_display.add(label);
		
		JLabel label_1 = new JLabel("이름");
		label_1.setBounds(132, 62, 24, 15);
		label_1.setHorizontalAlignment(SwingConstants.RIGHT);
		p_display.add(label_1);
		
		JLabel label_2 = new JLabel("성별");
		label_2.setBounds(132, 105, 24, 15);
		label_2.setHorizontalAlignment(SwingConstants.RIGHT);
		p_display.add(label_2);
		
		JLabel label_3 = new JLabel("몸무게");
		label_3.setBounds(120, 148, 36, 15);
		label_3.setHorizontalAlignment(SwingConstants.RIGHT);
		p_display.add(label_3);
		
		JLabel label_4 = new JLabel("나이");
		label_4.setBounds(132, 191, 24, 15);
		label_4.setHorizontalAlignment(SwingConstants.RIGHT);
		p_display.add(label_4);
		
		JLabel label_5 = new JLabel("휴대전화");
		label_5.setBounds(108, 234, 48, 15);
		label_5.setHorizontalAlignment(SwingConstants.RIGHT);
		p_display.add(label_5);
		
		JLabel label_6 = new JLabel("거주지");
		label_6.setBounds(120, 277, 36, 15);
		label_6.setHorizontalAlignment(SwingConstants.RIGHT);
		p_display.add(label_6);
		
		JLabel label_7 = new JLabel("월 예산");
		label_7.setBounds(116, 320, 40, 15);
		label_7.setHorizontalAlignment(SwingConstants.RIGHT);
		p_display.add(label_7);
		
		btnMenu = new JButton("다이어트식단");
		btnMenu.setBounds(40, 405, 111, 23);
		p_display.add(btnMenu);
		
		btnOneReg = new JButton("회원등록");
		btnOneReg.setBounds(163, 405, 97, 23);
		p_display.add(btnOneReg);
		
		btnGrpReg = new JButton("단체회원등록");
		btnGrpReg.setBounds(272, 405, 111, 23);
		p_display.add(btnGrpReg);
		
		btnLeft = new JButton("◀");
		btnLeft.setBounds(108, 367, 47, 23);
		p_display.add(btnLeft);
		
		btnRight = new JButton("▶");
		btnRight.setBounds(259, 367, 48, 23);
		p_display.add(btnRight);
		
		JLabel lblNewLabel = new JLabel("회원검색(N/M)");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(158, 371, 99, 15);
		p_display.add(lblNewLabel);
		
		tf_no = new JTextField();
		tf_no.setBounds(192, 16, 116, 21);
		p_display.add(tf_no);
		tf_no.setColumns(10);
		
		tf_name = new JTextField();
		tf_name.setBounds(192, 59, 116, 21);
		p_display.add(tf_name);
		tf_name.setColumns(10);
		
		tf_gender = new JTextField();
		tf_gender.setBounds(192, 102, 116, 21);
		p_display.add(tf_gender);
		tf_gender.setColumns(10);
		
		tf_weight = new JTextField();
		tf_weight.setBounds(192, 145, 116, 21);
		p_display.add(tf_weight);
		tf_weight.setColumns(10);
		
		tf_age = new JTextField();
		tf_age.setBounds(192, 188, 116, 21);
		p_display.add(tf_age);
		tf_age.setColumns(10);
		
		tf_phone = new JTextField();
		tf_phone.setBounds(192, 231, 116, 21);
		p_display.add(tf_phone);
		tf_phone.setColumns(10);
		
		tf_location = new JTextField();
		tf_location.setBounds(192, 274, 116, 21);
		p_display.add(tf_location);
		tf_location.setColumns(10);
		
		tf_budg = new JTextField();
		tf_budg.setBounds(192, 317, 116, 21);
		p_display.add(tf_budg);
		tf_budg.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("kg");
		lblNewLabel_1.setBounds(316, 145, 24, 15);
		p_display.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("세");
		lblNewLabel_2.setBounds(316, 191, 36, 15);
		p_display.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("원");
		lblNewLabel_3.setBounds(315, 320, 57, 15);
		p_display.add(lblNewLabel_3);
		
		separator = new JSeparator();
		separator.setBounds(0, 355, 424, 7);
		p_display.add(separator);
	}
}
