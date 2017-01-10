package kr.or.dgit.bigdata.diet.gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;

import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Graphics;

import java.awt.Image;

import java.awt.Color;
import java.awt.Container;

import javax.swing.JButton;

public class DietGUI extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Container contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DietGUI frame = new DietGUI();
					frame.setTitle("Your Diet Planning");
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
	public DietGUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 930, 600);
		contentPane = getContentPane();
		dietBgPanel dbp = new dietBgPanel();
		contentPane.add(dbp, BorderLayout.CENTER);
		dbp.setLayout(null);

		// 이미지 아이콘
		ImageIcon originDay = new ImageIcon("pictogram/day.png");
		Image originDayImg = originDay.getImage();
		Image changeDayImg = originDayImg.getScaledInstance(100, 100, Image.SCALE_SMOOTH);
		ImageIcon changeDay = new ImageIcon(changeDayImg);

		// 메인타이틀
		JLabel lblTitle = new JLabel("DIET PLANNING FOR 1MONTH");
		lblTitle.setBounds(10, 30, 419, 45);
		lblTitle.setFont(new Font("Fugaz One", Font.PLAIN, 30));
		dbp.add(lblTitle);

		// 버튼
		JButton btnDay1 = new JButton("");
		btnDay1.setFocusable(false);
		btnDay1.setBorder(null);
		btnDay1.setBackground(Color.WHITE);
		btnDay1.setBounds(20, 85, 100, 100);
		btnDay1.setBorderPainted(false);
		btnDay1.setFocusPainted(false);
        btnDay1.setContentAreaFilled(false);
		btnDay1.setIcon(changeDay);
		dbp.add(btnDay1);

		JButton btnDay2 = new JButton("");
		btnDay2.setFocusable(false);
		btnDay2.setBorder(null);
		btnDay2.setBackground(Color.WHITE);
		btnDay2.setBounds(150, 85, 100, 100);
		btnDay2.setFocusPainted(false);
        btnDay2.setContentAreaFilled(false);
		btnDay2.setIcon(changeDay);
		btnDay2.setIcon(changeDay);
		dbp.add(btnDay2);

		JButton btnDay3 = new JButton("");
		btnDay3.setFocusable(false);
		btnDay3.setBorder(null);
		btnDay3.setBackground(Color.WHITE);
		btnDay3.setBounds(280, 85, 100, 100);
		btnDay3.setFocusPainted(false);
        btnDay3.setContentAreaFilled(false);
		btnDay3.setIcon(changeDay);
		btnDay3.setIcon(changeDay);
		dbp.add(btnDay3);

		JButton btnDay4 = new JButton("");
		btnDay4.setFocusable(false);
		btnDay4.setBorder(null);
		btnDay4.setBackground(Color.WHITE);
		btnDay4.setBounds(410, 85, 100,100);
		btnDay4.setFocusPainted(false);
        btnDay4.setContentAreaFilled(false);
		btnDay4.setIcon(changeDay);
		btnDay4.setIcon(changeDay);
		dbp.add(btnDay4);

		JButton btnDay5 = new JButton("");
		btnDay5.setFocusable(false);
		btnDay5.setBorder(null);
		btnDay5.setBackground(Color.WHITE);
		btnDay5.setBounds(540, 85, 100, 100);
		btnDay5.setFocusPainted(false);
        btnDay5.setContentAreaFilled(false);
		btnDay5.setIcon(changeDay);
		btnDay5.setIcon(changeDay);
		dbp.add(btnDay5);

		JButton btnDay6 = new JButton("");
		btnDay6.setFocusable(false);
		btnDay6.setBorder(null);
		btnDay6.setBackground(Color.WHITE);
		btnDay6.setBounds(670, 85, 100, 100);
		btnDay6.setFocusPainted(false);
        btnDay6.setContentAreaFilled(false);
		btnDay6.setIcon(changeDay);
		btnDay6.setIcon(changeDay);
		dbp.add(btnDay6);

		JButton btnDay7 = new JButton("");
		btnDay7.setFocusable(false);
		btnDay7.setBorder(null);
		btnDay7.setBackground(Color.WHITE);
		btnDay7.setBounds(800, 85, 100, 100);
		btnDay7.setFocusPainted(false);
        btnDay7.setContentAreaFilled(false);
		btnDay7.setIcon(changeDay);
		btnDay7.setIcon(changeDay);
		dbp.add(btnDay7);

	}
}

class dietBgPanel extends JPanel{

	private static final long serialVersionUID = 1L;
	ImageIcon DietBgIcon = new ImageIcon("images/healthy_food (6).jpg");
	Image DietBgImg = DietBgIcon.getImage();
	
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		
		g.drawImage(DietBgImg, 0, 0, getWidth(), getHeight(), this);
	}
}
