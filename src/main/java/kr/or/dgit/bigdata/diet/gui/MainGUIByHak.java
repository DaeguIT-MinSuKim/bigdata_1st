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
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.SystemColor;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;

public class MainGUIByHak extends JFrame {

	Container contentPane;
	private JButton btnSignup;
	private JButton btnSignupGroup;
	private JButton btnSearch;
	private JButton btnMakePlan;
	

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
		
		btnSignup = new JButton("회원등록");
		btnSignup.setBackground(SystemColor.info);
		btnSignup.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnSignup.setBounds(530, 196, 135, 31);
		panel.add(btnSignup);
		
		btnSignupGroup = new JButton("단체회원등록");
		btnSignupGroup.setBackground(new Color(255, 127, 80));
		btnSignupGroup.setBounds(530, 229, 135, 31);
		panel.add(btnSignupGroup);
		
		btnSearch = new JButton("회원검색");
		btnSearch.setBackground(new Color(100, 149, 237));
		btnSearch.setBounds(530, 263, 135, 31);
		panel.add(btnSearch);
		
		btnMakePlan = new JButton("식단생성");
		btnMakePlan.setBackground(new Color(255, 215, 0));
		btnMakePlan.setBounds(530, 297, 135, 31);
		panel.add(btnMakePlan);
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
