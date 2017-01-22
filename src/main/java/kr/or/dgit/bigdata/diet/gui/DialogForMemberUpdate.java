package kr.or.dgit.bigdata.diet.gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Dialog.ModalityType;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import kr.or.dgit.bigdata.diet.dto.Member;

public class DialogForMemberUpdate extends JFrame {

	private JPanel contentPane;
	PanelInput panelInput;
	private Member member;
	private PanelForSignUp panelBgImg;
	private PanelButton panelButton;

	public DialogForMemberUpdate(Member member) {
		this.member = member;
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 306, 526);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		//크기조정불가
		setResizable(false);
		//현재 다이얼로그를 띄웠을 때 다른 프레임은 움직이지 못하도록 처리
		//setModalityType(ModalityType.APPLICATION_MODAL);

		panelInput = new PanelInput();
		panelInput.setBounds(130, 205, 125, 261);
		panelInput.tf_no.setText(member.getNo()+"");
		panelInput.tf_name.setText(member.getName());
		panelInput.tf_weight.setText(member.getWeight()+"");
		panelInput.tf_age.setText(member.getAge()+"");
		panelInput.tf_phone.setText(member.getPhone());
		panelInput.tf_location.setText(member.getAddress());
		panelInput.tf_budget.setText(member.getBudget()+"");
		if (member.getGender().equals("여")) {
			panelInput.rdbtnFemale.setSelected(true);
		}else{
			panelInput.rdbtnMale.setSelected(true);
		}
		contentPane.add(panelInput);
		
		panelButton = new PanelButton(new SignUpAndUpdateGUI());
		panelButton.setBounds(0, 145, 300, 30);
		panelButton.btnSign.setText("회원수정");
		contentPane.add(panelButton);
		
		
		//배경화면
		panelBgImg = new PanelForSignUp();
		panelBgImg.setBounds(0, 0, 300, 500);
		contentPane.add(panelBgImg);
	}

}
