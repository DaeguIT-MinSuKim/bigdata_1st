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

public class OutputMenuList extends JFrame {

	Container contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					OutputMenuList frame = new OutputMenuList();
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
	public OutputMenuList() {
		setTitle("식단정보");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		contentPane = getContentPane();
		
		//배경패널 추가
		NoteBg2 nb2 = new NoteBg2();
		contentPane.add(nb2, BorderLayout.CENTER);
		nb2.setLayout(null);
		
		setSize(1024, 768);
	}

}

//배경 패널
class NoteBg2 extends JPanel{
	ImageIcon bgIcon2 = new ImageIcon("images/note3.jpg");
	Image bgImg2 = bgIcon2.getImage();
	
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		
		g.drawImage(bgImg2, 0, 0, getWidth(), getHeight(), this);
	}
}

