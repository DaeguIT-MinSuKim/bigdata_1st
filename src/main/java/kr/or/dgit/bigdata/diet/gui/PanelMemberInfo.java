package kr.or.dgit.bigdata.diet.gui;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Color;
import javax.swing.SwingConstants;

import kr.or.dgit.bigdata.diet.dto.Member;
import kr.or.dgit.bigdata.diet.service.MemberService;

import javax.swing.JTextField;
import java.awt.GridLayout;
import java.text.DecimalFormat;
import java.util.ArrayList;

public class PanelMemberInfo extends JPanel {
	JTextField tf_gender;
	JTextField tf_weight;
	JTextField tf_age;
	JTextField tf_phone;
	JTextField tf_location;
	JTextField tf_budget;

	/**
	 * Create the panel.
	 */
	public PanelMemberInfo(ArrayList<Member> memberList) {
		setLayout(null);
		setOpaque(false);
		
		JLabel lbl_kg = new JLabel("kg");
		lbl_kg.setBounds(165, 44, 29, 14);
		add(lbl_kg);
		lbl_kg.setFont(new Font("굴림", Font.PLAIN, 11));
		
		JLabel lbl_won = new JLabel("원");
		lbl_won.setBounds(165, 175, 29, 14);
		add(lbl_won);
		lbl_won.setFont(new Font("굴림", Font.PLAIN, 11));
		
		JPanel panelLabel = new JPanel();
		panelLabel.setBounds(0, 0, 73, 200);
		add(panelLabel);
		panelLabel.setLayout(new GridLayout(0, 1, 0, 0));
		panelLabel.setOpaque(false);
		
		JLabel lbl_gender = new JLabel("성별");
		lbl_gender.setHorizontalAlignment(SwingConstants.RIGHT);
		lbl_gender.setForeground(Color.DARK_GRAY);
		lbl_gender.setFont(new Font("맑은 고딕", Font.PLAIN, 15));
		panelLabel.add(lbl_gender);
		
		JLabel lbl_weight = new JLabel("몸무게");
		lbl_weight.setHorizontalAlignment(SwingConstants.RIGHT);
		lbl_weight.setForeground(Color.DARK_GRAY);
		lbl_weight.setFont(new Font("맑은 고딕", Font.PLAIN, 15));
		panelLabel.add(lbl_weight);
		
		JLabel lbl_age = new JLabel("나이");
		lbl_age.setHorizontalAlignment(SwingConstants.RIGHT);
		lbl_age.setForeground(Color.DARK_GRAY);
		lbl_age.setFont(new Font("맑은 고딕", Font.PLAIN, 15));
		panelLabel.add(lbl_age);
		
		JLabel lbl_phone = new JLabel("휴대전화");
		lbl_phone.setHorizontalAlignment(SwingConstants.RIGHT);
		lbl_phone.setForeground(Color.DARK_GRAY);
		lbl_phone.setFont(new Font("맑은 고딕", Font.PLAIN, 15));
		panelLabel.add(lbl_phone);
		
		JLabel lbl_location = new JLabel("거주지");
		lbl_location.setHorizontalAlignment(SwingConstants.RIGHT);
		lbl_location.setForeground(Color.DARK_GRAY);
		lbl_location.setFont(new Font("맑은 고딕", Font.PLAIN, 15));
		panelLabel.add(lbl_location);
		
		JLabel lbl_budget = new JLabel("월예산");
		lbl_budget.setHorizontalAlignment(SwingConstants.RIGHT);
		lbl_budget.setForeground(Color.DARK_GRAY);
		lbl_budget.setFont(new Font("맑은 고딕", Font.PLAIN, 15));
		panelLabel.add(lbl_budget);
		
		JPanel panelText = new JPanel();
		panelText.setBounds(80, 0, 91, 200);
		add(panelText);
		panelText.setLayout(new GridLayout(0, 1, 0, 0));
		panelText.setOpaque(false);
		
		tf_gender = new JTextField();
		tf_gender.setText("여");
		tf_gender.setOpaque(false);
		tf_gender.setHorizontalAlignment(SwingConstants.CENTER);
		tf_gender.setEditable(false);
		tf_gender.setColumns(10);
		tf_gender.setBorder(null);
		panelText.add(tf_gender);
		
		tf_weight = new JTextField();
		tf_weight.setText("45");
		tf_weight.setOpaque(false);
		tf_weight.setHorizontalAlignment(SwingConstants.CENTER);
		tf_weight.setEditable(false);
		tf_weight.setColumns(10);
		tf_weight.setBorder(null);
		panelText.add(tf_weight);
		
		tf_age = new JTextField();
		tf_age.setText("23");
		tf_age.setOpaque(false);
		tf_age.setHorizontalAlignment(SwingConstants.CENTER);
		tf_age.setEditable(false);
		tf_age.setColumns(10);
		tf_age.setBorder(null);
		panelText.add(tf_age);
		
		tf_phone = new JTextField();
		tf_phone.setText("010-5108-4160");
		tf_phone.setOpaque(false);
		tf_phone.setHorizontalAlignment(SwingConstants.CENTER);
		tf_phone.setEditable(false);
		tf_phone.setColumns(10);
		tf_phone.setBorder(null);
		panelText.add(tf_phone);
		
		tf_location = new JTextField();
		tf_location.setText("완주");
		tf_location.setOpaque(false);
		tf_location.setHorizontalAlignment(SwingConstants.CENTER);
		tf_location.setEditable(false);
		tf_location.setColumns(10);
		tf_location.setBorder(null);
		panelText.add(tf_location);
		
		tf_budget = new JTextField();
		tf_budget.setText("316000");
		tf_budget.setOpaque(false);
		tf_budget.setHorizontalAlignment(SwingConstants.CENTER);
		tf_budget.setEditable(false);
		tf_budget.setColumns(10);
		tf_budget.setBorder(null);
		panelText.add(tf_budget);
		

	}

}
