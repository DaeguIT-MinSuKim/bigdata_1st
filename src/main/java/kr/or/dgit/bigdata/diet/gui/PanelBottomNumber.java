package kr.or.dgit.bigdata.diet.gui;

import javax.swing.JPanel;

import kr.or.dgit.bigdata.diet.dto.Member;
import kr.or.dgit.bigdata.diet.service.MemberService;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Color;
import java.awt.Font;
import java.text.DecimalFormat;
import java.util.ArrayList;

public class PanelBottomNumber extends JPanel {
	JLabel lbl_sum;
	JLabel lbl_number;
	
	public PanelBottomNumber(ArrayList<Member> memberList) {
		setOpaque(false);
		setLayout(null);
		
		lbl_sum = new JLabel();
		lbl_sum.setBounds(154, 5, 17, 15);
		lbl_sum.setFont(new Font("굴림", Font.PLAIN, 12));
		add(lbl_sum);
		
		lbl_number = new JLabel();
		lbl_number.setBounds(124, 0, 20, 21);
		lbl_number.setFont(new Font("맑은 고딕", Font.BOLD, 15));
		add(lbl_number);
		lbl_number.setForeground(new Color(90,153,204));
		
		
		JLabel lblSeparator = new JLabel("/");
		lblSeparator.setBounds(143, 5, 6, 15);
		lblSeparator.setFont(new Font("굴림", Font.PLAIN, 12));
		add(lblSeparator);
	}

}
