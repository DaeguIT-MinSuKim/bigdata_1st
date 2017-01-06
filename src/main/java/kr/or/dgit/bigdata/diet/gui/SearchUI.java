package kr.or.dgit.bigdata.diet.gui;

import java.awt.BorderLayout;
import java.awt.Container;

import javax.swing.JFrame;

public class SearchUI extends JFrame {
	
	private Container contentPane;
	
	public SearchUI() {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = getContentPane();
		SignPanel signPanel = new SignPanel();
		contentPane.add(signPanel, BorderLayout.CENTER);
		signPanel.setLayout(null);
		setSize(500,700);
		
		
	}
	
	public static void main(String[] args) {
		SearchUI frame = new SearchUI();
		frame.setVisible(true);
	}
}
