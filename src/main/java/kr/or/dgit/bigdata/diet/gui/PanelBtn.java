package kr.or.dgit.bigdata.diet.gui;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

public class PanelBtn extends JPanel {

	public PanelBtn() {
		setLayout(null);
		setOpaque(false);
		
		JButton btnSign = new JButton("회원등록");
		btnSign.setBounds(28, 4, 72, 23);
		add(btnSign);
		btnSign.setForeground(Color.WHITE);
		btnSign.setFont(new Font("맑은 고딕", Font.BOLD, 13));
		btnSign.setFocusPainted(false);
		btnSign.setBorder(new LineBorder(new Color(102, 162, 212)));
		btnSign.setBackground(new Color(44, 103, 156));
		
		JButton btnClear = new JButton("초기화");
		btnClear.setBounds(114, 4, 72, 23);
		add(btnClear);
		btnClear.setForeground(Color.WHITE);
		btnClear.setFont(new Font("맑은 고딕", Font.BOLD, 13));
		btnClear.setFocusPainted(false);
		btnClear.setBorder(new LineBorder(new Color(102, 162, 212)));
		btnClear.setBackground(new Color(44, 103, 156));
		
		JButton btnCancel = new JButton("돌아가기");
		btnCancel.setBounds(200, 4, 72, 23);
		add(btnCancel);
		btnCancel.setForeground(Color.WHITE);
		btnCancel.setFont(new Font("맑은 고딕", Font.BOLD, 13));
		btnCancel.setFocusPainted(false);
		btnCancel.setBorder(new LineBorder(new Color(102, 162, 212)));
		btnCancel.setBackground(new Color(44, 103, 156));
/*
		btnCreateMember = new JButton("회원등록");
		btnCreateMember.setForeground(Color.WHITE);
		btnCreateMember.setFont(new Font("맑은 고딕", Font.BOLD, 13));
		btnCreateMember.setFocusPainted(false);
		btnCreateMember.setBorder(new LineBorder(new Color(102, 162, 212)));
		btnCreateMember.setBackground(new Color(44, 103, 156));
		btnCreateMember.setBounds(200, 4, 72, 23);
		add(btnCreateMember);*/
		
		
	}

}
