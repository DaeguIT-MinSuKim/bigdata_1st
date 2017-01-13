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

public class MenuPlanGUI extends JFrame {

	
	
	private Container contentPane;

	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MenuPlanGUI frame = new MenuPlanGUI();
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
	public MenuPlanGUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1200, 819);
		contentPane = getContentPane();
		MenuPlanBgPanel mpbp = new MenuPlanBgPanel();
		contentPane.add(mpbp, BorderLayout.CENTER);
		mpbp.setLayout(null);

		// 이미지 아이콘
		ImageIcon originDay = new ImageIcon("pictogram/day.png");
		Image originDayImg = originDay.getImage();
		Image changeDayImg = originDayImg.getScaledInstance(100, 100, Image.SCALE_SMOOTH);
		ImageIcon changeDay = new ImageIcon(changeDayImg);

		// 메인타이틀
		JLabel lblTitle = new JLabel("DIET PLANNING FOR 1MONTH");
		lblTitle.setBounds(10, 30, 419, 45);
		lblTitle.setFont(new Font("Fugaz One", Font.PLAIN, 30));
		mpbp.add(lblTitle);

		// 버튼 row1
		JButton btnDay1 = new JButton("");
		btnDay1.setFocusable(false);
		btnDay1.setBorder(null);
		btnDay1.setBackground(Color.WHITE);
		btnDay1.setBounds(50, 85, 100, 100);
		btnDay1.setBorderPainted(false);
		btnDay1.setFocusPainted(false);
        btnDay1.setContentAreaFilled(false);
		btnDay1.setIcon(changeDay);
		mpbp.add(btnDay1);

		JButton btnDay2 = new JButton("");
		btnDay2.setFocusable(false);
		btnDay2.setBorder(null);
		btnDay2.setBackground(Color.WHITE);
		btnDay2.setBounds(180, 85, 100, 100);
		btnDay2.setFocusPainted(false);
        btnDay2.setContentAreaFilled(false);
		btnDay2.setIcon(changeDay);
		mpbp.add(btnDay2);

		JButton btnDay3 = new JButton("");
		btnDay3.setFocusable(false);
		btnDay3.setBorder(null);
		btnDay3.setBackground(Color.WHITE);
		btnDay3.setBounds(310, 85, 100, 100);
		btnDay3.setFocusPainted(false);
        btnDay3.setContentAreaFilled(false);
		btnDay3.setIcon(changeDay);
		btnDay3.setIcon(changeDay);
		mpbp.add(btnDay3);

		JButton btnDay4 = new JButton("");
		btnDay4.setFocusable(false);
		btnDay4.setBorder(null);
		btnDay4.setBackground(Color.WHITE);
		btnDay4.setBounds(440, 85, 100,100);
		btnDay4.setFocusPainted(false);
        btnDay4.setContentAreaFilled(false);
		btnDay4.setIcon(changeDay);
		btnDay4.setIcon(changeDay);
		mpbp.add(btnDay4);

		JButton btnDay5 = new JButton("");
		btnDay5.setFocusable(false);
		btnDay5.setBorder(null);
		btnDay5.setBackground(Color.WHITE);
		btnDay5.setBounds(570, 85, 100, 100);
		btnDay5.setFocusPainted(false);
        btnDay5.setContentAreaFilled(false);
		btnDay5.setIcon(changeDay);
		btnDay5.setIcon(changeDay);
		mpbp.add(btnDay5);

		JButton btnDay6 = new JButton("");
		btnDay6.setFocusable(false);
		btnDay6.setBorder(null);
		btnDay6.setBackground(Color.WHITE);
		btnDay6.setBounds(700, 85, 100, 100);
		btnDay6.setFocusPainted(false);
        btnDay6.setContentAreaFilled(false);
		btnDay6.setIcon(changeDay);
		btnDay6.setIcon(changeDay);
		mpbp.add(btnDay6);
		
		// 버튼 row2
		
		JButton btnDay7 = new JButton("");
		btnDay7.setFocusable(false);
		btnDay7.setBorder(null);
		btnDay7.setBackground(Color.WHITE);
		btnDay7.setBounds(50, 200, 100, 100);
		btnDay7.setBorderPainted(false);
		btnDay7.setFocusPainted(false);
        btnDay7.setContentAreaFilled(false);
		btnDay7.setIcon(changeDay);
		mpbp.add(btnDay7);

		JButton btnDay8 = new JButton("");
		btnDay8.setFocusable(false);
		btnDay8.setBorder(null);
		btnDay8.setBackground(Color.WHITE);
		btnDay8.setBounds(180, 200, 100, 100);
		btnDay8.setFocusPainted(false);
        btnDay8.setContentAreaFilled(false);
		btnDay8.setIcon(changeDay);
		btnDay8.setIcon(changeDay);
		mpbp.add(btnDay8);

		JButton btnDay9 = new JButton("");
		btnDay9.setFocusable(false);
		btnDay9.setBorder(null);
		btnDay9.setBackground(Color.WHITE);
		btnDay9.setBounds(310, 200, 100, 100);
		btnDay9.setFocusPainted(false);
        btnDay9.setContentAreaFilled(false);
		btnDay9.setIcon(changeDay);
		btnDay9.setIcon(changeDay);
		mpbp.add(btnDay9);

		JButton btnDay10 = new JButton("");
		btnDay10.setFocusable(false);
		btnDay10.setBorder(null);
		btnDay10.setBackground(Color.WHITE);
		btnDay10.setBounds(440, 200, 100,100);
		btnDay10.setFocusPainted(false);
        btnDay10.setContentAreaFilled(false);
		btnDay10.setIcon(changeDay);
		btnDay10.setIcon(changeDay);
		mpbp.add(btnDay10);

		JButton btnDay11 = new JButton("");
		btnDay11.setFocusable(false);
		btnDay11.setBorder(null);
		btnDay11.setBackground(Color.WHITE);
		btnDay11.setBounds(570, 200, 100, 100);
		btnDay11.setFocusPainted(false);
        btnDay11.setContentAreaFilled(false);
		btnDay11.setIcon(changeDay);
		btnDay11.setIcon(changeDay);
		mpbp.add(btnDay11);

		JButton btnDay12 = new JButton("");
		btnDay12.setFocusable(false);
		btnDay12.setBorder(null);
		btnDay12.setBackground(Color.WHITE);
		btnDay12.setBounds(700, 200, 100, 100);
		btnDay12.setFocusPainted(false);
        btnDay12.setContentAreaFilled(false);
		btnDay12.setIcon(changeDay);
		btnDay12.setIcon(changeDay);
		mpbp.add(btnDay12);
		
		//버튼 row3
		
		JButton btnDay13 = new JButton("");
		btnDay13.setFocusable(false);
		btnDay13.setBorder(null);
		btnDay13.setBackground(Color.WHITE);
		btnDay13.setBounds(50, 315, 100, 100);
		btnDay13.setBorderPainted(false);
		btnDay13.setFocusPainted(false);
        btnDay13.setContentAreaFilled(false);
		btnDay13.setIcon(changeDay);
		mpbp.add(btnDay13);

		JButton btnDay14 = new JButton("");
		btnDay14.setFocusable(false);
		btnDay14.setBorder(null);
		btnDay14.setBackground(Color.WHITE);
		btnDay14.setBounds(180, 315, 100, 100);
		btnDay14.setFocusPainted(false);
        btnDay14.setContentAreaFilled(false);
		btnDay14.setIcon(changeDay);
		btnDay14.setIcon(changeDay);
		mpbp.add(btnDay14);

		JButton btnDay15 = new JButton("");
		btnDay15.setFocusable(false);
		btnDay15.setBorder(null);
		btnDay15.setBackground(Color.WHITE);
		btnDay15.setBounds(310, 315, 100, 100);
		btnDay15.setFocusPainted(false);
        btnDay15.setContentAreaFilled(false);
		btnDay15.setIcon(changeDay);
		btnDay15.setIcon(changeDay);
		mpbp.add(btnDay15);

		JButton btnDay16 = new JButton("");
		btnDay16.setFocusable(false);
		btnDay16.setBorder(null);
		btnDay16.setBackground(Color.WHITE);
		btnDay16.setBounds(440, 315, 100,100);
		btnDay16.setFocusPainted(false);
        btnDay16.setContentAreaFilled(false);
		btnDay16.setIcon(changeDay);
		btnDay16.setIcon(changeDay);
		mpbp.add(btnDay16);

		JButton btnDay17 = new JButton("");
		btnDay17.setFocusable(false);
		btnDay17.setBorder(null);
		btnDay17.setBackground(Color.WHITE);
		btnDay17.setBounds(570, 315, 100, 100);
		btnDay17.setFocusPainted(false);
        btnDay17.setContentAreaFilled(false);
		btnDay17.setIcon(changeDay);
		btnDay17.setIcon(changeDay);
		mpbp.add(btnDay17);

		JButton btnDay18 = new JButton("");
		btnDay18.setFocusable(false);
		btnDay18.setBorder(null);
		btnDay18.setBackground(Color.WHITE);
		btnDay18.setBounds(700, 315, 100, 100);
		btnDay18.setFocusPainted(false);
        btnDay18.setContentAreaFilled(false);
		btnDay18.setIcon(changeDay);
		btnDay18.setIcon(changeDay);
		mpbp.add(btnDay18);

	}
}

class MenuPlanBgPanel extends JPanel{


	ImageIcon MenuBgIcon = new ImageIcon("images/healthy_food.jpg");
	Image MenuBgImg = MenuBgIcon.getImage();
	
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		
		g.drawImage(MenuBgImg, 0, 0, getWidth(), getHeight(), this);
	}
}
