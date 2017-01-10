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
		btnSignUp.setFocusable(false);
		btnSignUp.setBorder(null);
		btnSignUp.setBackground(Color.WHITE);
		btnSignUp.setBounds(150, 160, 120, 120);
		btnSignUp.setIcon(changeSignUp);
		panel.add(btnSignUp);
		setSize(800, 600);
		setVisible(true);
		
		JButton btnGroupSignUp = new JButton("");
		btnGroupSignUp.setFocusable(false);
		btnGroupSignUp.setBorder(null);
		btnGroupSignUp.setBackground(Color.WHITE);
		btnGroupSignUp.setBounds(280, 160, 120, 120);
		btnGroupSignUp.setIcon(changeGroupSignUp);
		panel.add(btnGroupSignUp);
		setSize(800, 600);
		setVisible(true);
		
		JButton btnSearch = new JButton("");
		btnSearch.setFocusable(false);
		btnSearch.setBorder(null);
		btnSearch.setBackground(Color.WHITE);
		btnSearch.setBounds(410, 160, 120, 120);
		btnSearch.setIcon(changeSearch);
		panel.add(btnSearch);
		setSize(800, 600);
		setVisible(true);
		
		JButton btnDiet = new JButton("");
		btnDiet.setFocusable(false);
		btnDiet.setBorder(null);
		btnDiet.setBackground(Color.WHITE);
		btnDiet.setBounds(540, 160, 120, 120);
		btnDiet.setIcon(changeDiet);
		panel.add(btnDiet);
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
