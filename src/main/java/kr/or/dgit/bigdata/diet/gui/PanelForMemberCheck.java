package kr.or.dgit.bigdata.diet.gui;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

import kr.or.dgit.bigdata.diet.dto.Member;
import kr.or.dgit.bigdata.diet.service.MemberService;


public class PanelForMemberCheck extends JPanel {
	public PanelForMemberCheck() {
	}
	ImageIcon bgImgTemp = new ImageIcon("images/bg_membercheck.png");
	Image bgImg = bgImgTemp.getImage();
	
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(bgImg, 0, 0, 300, 500, this);
		
	}
}

//회원 수 보여주는 패널
class PanelBottomNumber extends JPanel{
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

//회원 정보 보여주는 패널
class PanelMemberInfo extends JPanel{
	JTextField tf_gender;
	JTextField tf_weight;
	JTextField tf_age;
	JTextField tf_phone;
	JTextField tf_location;
	JTextField tf_budget;
	private MemberService memberService;

	public PanelMemberInfo(ArrayList<Member> memberList) {
		setLayout(null);
		setOpaque(false);
		
		JLabel lbl_kg = new JLabel("kg");
		lbl_kg.setBounds(170, 44, 29, 14);
		add(lbl_kg);
		lbl_kg.setFont(new Font("굴림", Font.PLAIN, 11));
		
		JLabel lbl_won = new JLabel("원");
		lbl_won.setBounds(170, 175, 29, 14);
		add(lbl_won);
		lbl_won.setFont(new Font("굴림", Font.PLAIN, 11));
		
		JPanel panelText = new JPanel();
		panelText.setBounds(80, 0, 115, 200);
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

//버튼 패널
class PanelTopButton extends JPanel implements ActionListener{
	private JButton btnMakeList;
	private JButton btnCreateMember;
	private MemberCheckGUI memberCheckGUI;
	private FoodListMaking foodListMaking;
	
	public PanelTopButton(MemberCheckGUI memberCheckGUI) {
		this.memberCheckGUI = memberCheckGUI;
		
		setOpaque(false);
		setLayout(null);
		
		btnMakeList = new JButton("식단보기");
		btnMakeList.setFont(new Font("맑은 고딕", Font.BOLD, 13));
		btnMakeList.setBounds(28, 4, 72, 23);
		btnMakeList.setForeground(Color.WHITE);
		btnMakeList.setBackground(new Color(44,103,156));
		btnMakeList.setFocusPainted(false);
		btnMakeList.setBorder(new LineBorder(new Color(102, 162, 212)));
		add(btnMakeList);
		
		btnCreateMember = new JButton("회원등록");
		btnCreateMember.setForeground(Color.WHITE);
		btnCreateMember.setFont(new Font("맑은 고딕", Font.BOLD, 13));
		btnCreateMember.setFocusPainted(false);
		btnCreateMember.setBorder(new LineBorder(new Color(102, 162, 212)));
		btnCreateMember.setBackground(new Color(44, 103, 156));
		btnCreateMember.setBounds(200, 4, 72, 23);
		add(btnCreateMember);
		
		btnMakeList.addActionListener(this);
		btnCreateMember.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		//식단 보기 버튼
		if (e.getSource() == btnMakeList) {
			int no = memberCheckGUI.noForFoodList;
			
			if (MemberCheckGUI.tempMonthMenu.containsKey(no) == false) {
				JOptionPane.showMessageDialog(null, "식단을 생성해주세요.");
				
				foodListMaking = new FoodListMaking(memberCheckGUI);
				foodListMaking.setVisible(true);
			}else{
				foodListMaking = MemberCheckGUI.tempMakingFoodList.get(no);
				foodListMaking.setMember(no); //저장된 회원의 정보 가져옴
			}
			
		}
		
		//회원 등록 버튼
		if (e.getSource() == btnCreateMember) {
			memberCheckGUI.dispose();
			SignUpGUI signupUI = new SignUpGUI(memberCheckGUI);
			signupUI.setVisible(true);
		}
	}
}