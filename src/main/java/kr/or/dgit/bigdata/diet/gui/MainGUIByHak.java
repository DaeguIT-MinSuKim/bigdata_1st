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

import sun.awt.image.PixelConverter.Rgba;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.SystemColor;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;

public class MainGUIByHak extends JFrame {

	Container contentPane;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainGUIByHak frame = new MainGUIByHak();
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
	public MainGUIByHak() {
		setTitle("다이어트식단프로그램");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		contentPane = getContentPane();
		bgPanel panel = new bgPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		//이미지 아이콘
		ImageIcon originSignUp = new ImageIcon("pictogram/signup.png");
		Image originSignUpImg = originSignUp.getImage();
		Image changeSignUpImg = originSignUpImg.getScaledInstance(100, 100, Image.SCALE_SMOOTH);
		ImageIcon changeSignUp = new ImageIcon(changeSignUpImg);
		
		ImageIcon originGroupSignUp = new ImageIcon("pictogram/group.png");
		Image originGroupSignUpImg = originGroupSignUp.getImage();
		Image changeGroupSignUpImg = originGroupSignUpImg.getScaledInstance(100, 100, Image.SCALE_SMOOTH);
		ImageIcon changeGroupSignUp = new ImageIcon(changeGroupSignUpImg);
		
		ImageIcon originSearch = new ImageIcon("pictogram/search.png");
		Image originSearchImg = originSearch.getImage();
		Image changeSearchImg = originSearchImg.getScaledInstance(100, 100, Image.SCALE_SMOOTH);
		ImageIcon changeSearch = new ImageIcon(changeSearchImg);
		
		ImageIcon originDiet = new ImageIcon("pictogram/diet.png");
		Image originDietImg = originDiet.getImage();
		Image changeDietImg = originDietImg.getScaledInstance(100, 100, Image.SCALE_SMOOTH);
		ImageIcon changeDiet = new ImageIcon(changeDietImg);
		
		//버튼
		JButton btnSignUp = new JButton("");
		btnSignUp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SignupUI su = new SignupUI();
			}
		});
		btnSignUp.setFocusable(false);
		btnSignUp.setBorder(null);
		btnSignUp.setBackground(Color.WHITE);
		btnSignUp.setBounds(150, 180, 120, 120);
		btnSignUp.setBorderPainted(false);
        btnSignUp.setFocusPainted(false);
        btnSignUp.setContentAreaFilled(false);
		btnSignUp.setIcon(changeSignUp);
		panel.add(btnSignUp);
		
		JButton btnGroupSignUp = new JButton("");
		btnGroupSignUp.setFocusable(false);
		btnGroupSignUp.setBorder(null);
		btnGroupSignUp.setBackground(Color.WHITE);
		btnGroupSignUp.setBounds(280, 180, 120, 120);
		btnGroupSignUp.setBorderPainted(false);
        btnGroupSignUp.setFocusPainted(false);
        btnGroupSignUp.setContentAreaFilled(false);
		btnGroupSignUp.setIcon(changeGroupSignUp);
		panel.add(btnGroupSignUp);
		
		JButton btnSearch = new JButton("");
		btnSearch.setFocusable(false);
		btnSearch.setBorder(null);
		btnSearch.setBackground(Color.WHITE);
		btnSearch.setBounds(410, 180, 120, 120);
		btnSearch.setBorderPainted(false);
        btnSearch.setFocusPainted(false);
        btnSearch.setContentAreaFilled(false);
		btnSearch.setIcon(changeSearch);
		panel.add(btnSearch);
		
		JButton btnDiet = new JButton("");
		btnDiet.setFocusable(false);
		btnDiet.setBorder(null);
		btnDiet.setBackground(Color.WHITE);
		btnDiet.setBounds(540, 180, 120, 120);
		btnDiet.setBorderPainted(false);
        btnDiet.setFocusPainted(false);
        btnDiet.setContentAreaFilled(false);
		btnDiet.setIcon(changeDiet);
		panel.add(btnDiet);
		
		//라벨
		
		JLabel lblSignup = new JLabel("회원등록");
		lblSignup.setHorizontalAlignment(SwingConstants.CENTER);
		lblSignup.setFont(new Font("10X10", Font.PLAIN, 20));
		lblSignup.setBounds(150, 310, 120, 20);
		panel.add(lblSignup);
		
		JLabel lblGroupSignup = new JLabel("단체회원등록");
		lblGroupSignup.setHorizontalAlignment(SwingConstants.CENTER);
		lblGroupSignup.setFont(new Font("10X10", Font.PLAIN, 20));
		lblGroupSignup.setBounds(280, 310, 120, 20);
		panel.add(lblGroupSignup);
		
		JLabel lblSearch = new JLabel("회원검색");
		lblSearch.setHorizontalAlignment(SwingConstants.CENTER);
		lblSearch.setFont(new Font("10X10", Font.PLAIN, 20));
		lblSearch.setBounds(410, 310, 120, 20);
		panel.add(lblSearch);
		
		JLabel lblDiet = new JLabel("식단생성");
		lblDiet.setHorizontalAlignment(SwingConstants.CENTER);
		lblDiet.setFont(new Font("10X10", Font.PLAIN, 20));
		lblDiet.setBounds(540, 310, 120, 20);
		panel.add(lblDiet);
		//창 중앙정렬<--
		setResizable(false);
		setSize(800, 600);
		setVisible(true);
		

		
	}
}

class bgPanel extends JPanel{
	ImageIcon bgIcon = new ImageIcon("images/healthy_food (7).jpg");
	Image bgImg = bgIcon.getImage();
	
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		
		g.drawImage(bgImg, 0, 0, getWidth(), getHeight(), this);
	}
}
