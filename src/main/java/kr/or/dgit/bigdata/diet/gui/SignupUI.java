package kr.or.dgit.bigdata.diet.gui;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.SystemColor;

public class SignupUI extends JFrame {

	private Container contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SignupUI frame = new SignupUI();
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
	public SignupUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = getContentPane();
		SignPanel signPanel = new SignPanel();
		contentPane.add(signPanel, BorderLayout.CENTER);
		signPanel.setLayout(null);
		
		
		//라벨
		JLabel lblSignUp = new JLabel("SIGN UP | 회원등록");
		lblSignUp.setHorizontalAlignment(SwingConstants.CENTER);
		lblSignUp.setFont(new Font("10X10 Bold", Font.PLAIN, 30));
		lblSignUp.setBounds(210, 62, 262, 71);
		signPanel.add(lblSignUp);
		
		JLabel label = new JLabel("회원번호");
		label.setHorizontalAlignment(SwingConstants.RIGHT);
		label.setFont(new Font("서울남산체 M", Font.PLAIN, 20));
		label.setBounds(154, 175, 76, 21);
		signPanel.add(label);
		
		JLabel label_1 = new JLabel("이름");
		label_1.setHorizontalAlignment(SwingConstants.RIGHT);
		label_1.setFont(new Font("서울남산체 M", Font.PLAIN, 20));
		label_1.setBounds(154, 217, 76, 21);
		signPanel.add(label_1);
		
		JLabel label_2 = new JLabel("성별");
		label_2.setHorizontalAlignment(SwingConstants.RIGHT);
		label_2.setFont(new Font("서울남산체 M", Font.PLAIN, 20));
		label_2.setBounds(154, 257, 76, 21);
		signPanel.add(label_2);
		
		JLabel label_3 = new JLabel("몸무게");
		label_3.setHorizontalAlignment(SwingConstants.RIGHT);
		label_3.setFont(new Font("서울남산체 M", Font.PLAIN, 20));
		label_3.setBounds(154, 298, 76, 21);
		signPanel.add(label_3);
		
		JLabel label_4 = new JLabel("나이");
		label_4.setHorizontalAlignment(SwingConstants.RIGHT);
		label_4.setFont(new Font("서울남산체 M", Font.PLAIN, 20));
		label_4.setBounds(154, 339, 76, 21);
		signPanel.add(label_4);
		
		JLabel label_5 = new JLabel("휴대전화");
		label_5.setHorizontalAlignment(SwingConstants.RIGHT);
		label_5.setFont(new Font("서울남산체 M", Font.PLAIN, 20));
		label_5.setBounds(154, 379, 76, 21);
		signPanel.add(label_5);
		
		JLabel label_6 = new JLabel("거주지");
		label_6.setHorizontalAlignment(SwingConstants.RIGHT);
		label_6.setFont(new Font("서울남산체 M", Font.PLAIN, 20));
		label_6.setBounds(154, 419, 76, 21);
		signPanel.add(label_6);
		
		JLabel label_7 = new JLabel("월 예산");
		label_7.setHorizontalAlignment(SwingConstants.RIGHT);
		label_7.setFont(new Font("서울남산체 M", Font.PLAIN, 20));
		label_7.setBounds(154, 456, 76, 21);
		signPanel.add(label_7);
		
		
		//텍스트필드
		textField = new JTextField();
		textField.setBounds(263, 176, 135, 21);
		signPanel.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(263, 218, 135, 21);
		signPanel.add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(263, 258, 135, 21);
		signPanel.add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(263, 299, 135, 21);
		signPanel.add(textField_3);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(263, 340, 135, 21);
		signPanel.add(textField_4);
		
		textField_5 = new JTextField();
		textField_5.setColumns(10);
		textField_5.setBounds(263, 380, 135, 21);
		signPanel.add(textField_5);
		
		textField_6 = new JTextField();
		textField_6.setColumns(10);
		textField_6.setBounds(263, 420, 135, 21);
		signPanel.add(textField_6);
		
		textField_7 = new JTextField();
		textField_7.setColumns(10);
		textField_7.setBounds(263, 458, 135, 21);
		signPanel.add(textField_7);
		
		//이미지 아이콘
		ImageIcon originSignup = new ImageIcon("pictogram/signup.png");
		Image originSignImg = originSignup.getImage();
		Image changeSignImg = originSignImg.getScaledInstance(100, 100, Image.SCALE_SMOOTH);
		ImageIcon changeSign = new ImageIcon(changeSignImg);
		
		ImageIcon originClear = new ImageIcon("pictogram/clear.png");
		Image originClearImg = originClear.getImage();
		Image changeClearImg = originClearImg.getScaledInstance(50, 50, Image.SCALE_SMOOTH);
		ImageIcon changeClear = new ImageIcon(changeClearImg);
		
		ImageIcon originCancel = new ImageIcon("pictogram/cancel.png");
		Image originCancelImg = originCancel.getImage();
		Image changeCancelImg = originCancelImg.getScaledInstance(50, 50, Image.SCALE_SMOOTH);
		ImageIcon changeCancel = new ImageIcon(changeCancelImg);

		
		
		//버튼
		JButton btnSign = new JButton("");
		btnSign.setFocusable(false);
		btnSign.setBorder(null);
		btnSign.setBackground(null);
		btnSign.setBounds(100, 530, 100, 100);
		btnSign.setBorderPainted(false);
		btnSign.setFocusPainted(false);
        btnSign.setContentAreaFilled(false);
		btnSign.setIcon(changeSign);
		signPanel.add(btnSign);
		
		JButton btnClear = new JButton("");
		btnClear.setFocusable(false);
		btnClear.setBorder(null);
		btnClear.setBackground(Color.WHITE);
		btnClear.setBounds(35, 563, 60, 60);
		btnClear.setBorderPainted(false);
        btnClear.setFocusPainted(false);
        btnClear.setContentAreaFilled(false);
		btnClear.setIcon(changeClear);
		signPanel.add(btnClear);
		
		JButton btnCancel = new JButton("");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
			}
		});
		
		btnCancel.setFocusable(false);
		btnCancel.setBorder(null);
		btnCancel.setBackground(Color.WHITE);
		btnCancel.setBounds(205, 570, 60, 60);
		btnCancel.setBorderPainted(false);
        btnCancel.setFocusPainted(false);
        btnCancel.setContentAreaFilled(false);
		btnCancel.setIcon(changeCancel);
		signPanel.add(btnCancel);
		
		setSize(500,700);
		setVisible(true);
	}
}

class SignPanel extends JPanel{
	ImageIcon SignBgIcon = new ImageIcon("images/signup_image.jpg");
	Image SignBgImg = SignBgIcon.getImage();
	
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		
		g.drawImage(SignBgImg, 0, 0, getWidth(), getHeight(), this);
	}
}
