package kr.or.dgit.bigdata.diet.gui;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

public class PanelTopButton extends JPanel {
	//private JButton btnMakeList;
	/**
	 * Create the panel.
	 */
	public PanelTopButton() {
		setOpaque(false);
		setLayout(null);
		
		JButton btnMakeList = new JButton("다이어트식단");
		btnMakeList.setFont(new Font("맑은 고딕", Font.BOLD, 13));
		btnMakeList.setBounds(28, 4, 100, 23);
		btnMakeList.setForeground(Color.WHITE);
		btnMakeList.setBackground(new Color(44,103,156));
		btnMakeList.setFocusPainted(false);
		btnMakeList.setBorder(new LineBorder(new Color(102, 162, 212)));
		add(btnMakeList);
		
		JButton btnCreateMember = new JButton("회원등록");
		btnCreateMember.setForeground(Color.WHITE);
		btnCreateMember.setFont(new Font("맑은 고딕", Font.BOLD, 13));
		btnCreateMember.setFocusPainted(false);
		btnCreateMember.setBorder(new LineBorder(new Color(102, 162, 212)));
		btnCreateMember.setBackground(new Color(44, 103, 156));
		btnCreateMember.setBounds(200, 4, 72, 23);
		add(btnCreateMember);
	}

}
