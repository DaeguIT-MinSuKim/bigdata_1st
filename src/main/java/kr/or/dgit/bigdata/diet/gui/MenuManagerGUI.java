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

public class MenuManagerGUI extends JFrame {

	Container contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MenuManagerGUI frame = new MenuManagerGUI();
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
	public MenuManagerGUI() {
		setTitle("식단관리");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		contentPane = getContentPane();
		
		NoteBg nb = new NoteBg();
		contentPane.add(nb, BorderLayout.CENTER);
		nb.setLayout(null);
		
		setSize(800, 730);
	}
}


//배경 패널
class NoteBg extends JPanel{
	ImageIcon bgIcon = new ImageIcon("images/note1.jpg");
	Image bgImg = bgIcon.getImage();
	
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		
		g.drawImage(bgImg, 0, 0, getWidth(), getHeight(), this);
	}
}
