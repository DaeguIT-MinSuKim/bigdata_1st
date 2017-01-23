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
import kr.or.dgit.bigdata.diet.service.DecorateService;
import kr.or.dgit.bigdata.diet.service.MemberService;


public class MemberCheckGUIPanel extends JPanel {
	ImageIcon bgImgTemp = new ImageIcon(getClass().getClassLoader().getResource("images/bg_membercheck.png"));
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
	private JPanel panelText;

	public PanelMemberInfo(ArrayList<Member> memberList) {
		setLayout(null);
		setOpaque(false);
		
		JLabel lbl_kg = new JLabel("kg");
		JLabel lbl_won = new JLabel("원");
		
		lbl_kg.setBounds(170, 44, 29, 14);
		lbl_won.setBounds(170, 175, 29, 14);
		
		lbl_kg.setFont(new Font("굴림", Font.PLAIN, 11));
		lbl_won.setFont(new Font("굴림", Font.PLAIN, 11));
		
		panelText = new JPanel();
		panelText.setBounds(80, 0, 115, 200);
		panelText.setLayout(new GridLayout(0, 1, 0, 0));
		panelText.setOpaque(false);
		
		add(lbl_kg);
		add(lbl_won);
		add(panelText);
		
		tf_gender = new JTextField();
		tf_weight = new JTextField();
		tf_age = new JTextField();
		tf_phone = new JTextField();
		tf_location = new JTextField();
		tf_budget = new JTextField();
		
		//JTextField 세팅
		textFieldSetting(tf_gender, tf_weight, tf_age, tf_phone, tf_location, tf_budget);
	}

	private void textFieldSetting(JTextField ...text) {
		for (JTextField jTextField : text) {
			jTextField.setOpaque(false);
			jTextField.setHorizontalAlignment(SwingConstants.CENTER);
			jTextField.setEditable(false);
			jTextField.setColumns(10);
			jTextField.setBorder(null);
			panelText.add(jTextField);
		}
	}
}

//버튼 패널
class PanelTopButton extends JPanel implements ActionListener{
	private JButton btnMakeList;
	private JButton btnCreateMember;
	private MemberCheckGUI memberCheckGUI;
	private FoodListMakingGUI foodListMaking;
	private JButton btnUpdateMember;
	DecorateService decorateService = new DecorateService();
	
	public PanelTopButton(MemberCheckGUI memberCheckGUI) {
		this.memberCheckGUI = memberCheckGUI;
		
		setOpaque(false);
		setLayout(null);
		
		btnMakeList = new JButton("식단보기");
		btnUpdateMember = new JButton("회원수정");
		btnCreateMember = new JButton("회원등록");
		
		btnMakeList.setBounds(28, 4, 72, 23);
		btnUpdateMember.setBounds(114, 4, 72, 23);
		btnCreateMember.setBounds(200, 4, 72, 23);
		
		add(btnMakeList);
		add(btnUpdateMember);
		add(btnCreateMember);
		
		//		버튼꾸미기 메소드 호출
		decorateService.decorateButton(btnMakeList, btnUpdateMember, btnCreateMember);
		
		btnMakeList.addActionListener(this);
		btnUpdateMember.addActionListener(this);
		btnCreateMember.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		//식단 보기 버튼
		if (e.getSource() == btnMakeList) {
			int no = memberCheckGUI.noForFoodList;
			
			if (MemberCheckGUI.tempMonthMenu.containsKey(no) == false) {
				JOptionPane.showMessageDialog(null, "식단을 생성해주세요.");
				
				foodListMaking = new FoodListMakingGUI(memberCheckGUI);
				foodListMaking.setVisible(true);
			}else{
				foodListMaking = MemberCheckGUI.tempMakingFoodList.get(no);
				foodListMaking.setMember(no); //저장된 회원의 정보 가져옴
			}
			
		}
		
		//회원 등록 버튼
		if (e.getSource() == btnCreateMember) {
			memberCheckGUI.dispose();
			SignUpAndUpdateGUI signupUI = new SignUpAndUpdateGUI(memberCheckGUI);
			signupUI.setVisible(true);
		}
		
		if (e.getSource() == btnUpdateMember) {
			memberCheckGUI.dispose();
			MemberUpdateAndDeleteGUI memberUpdate = new MemberUpdateAndDeleteGUI();
			memberUpdate.setVisible(true);
		}
	}
}