package kr.or.dgit.bigdata.diet.gui;

import java.awt.BorderLayout;
import java.awt.Cursor;
import java.awt.EventQueue;
import java.awt.Point;
import java.awt.Dialog.ModalityType;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionAdapter;
import java.awt.event.MouseMotionListener;
import java.text.DecimalFormat;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import kr.or.dgit.bigdata.diet.dto.Member;

public class SignUpAndUpdateGUI extends JDialog {

	private JPanel contentPane;
	MemberCheckGUI memberCheckGUI;
	PanelInput panelInput;
	private PanelButton panelButton;
	
	//메인 페이지에서 연결됨
	public SignUpAndUpdateGUI() {
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 306, 526);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		setContentPane(contentPane);
		
		//크기조정불가
		setResizable(false);
		//현재 다이얼로그를 띄웠을 때 다른 프레임은 움직이지 못하도록 처리
		setModalityType(ModalityType.APPLICATION_MODAL);
		
		panelButton = new PanelButton(this);
		panelButton.setBounds(0, 145, 300, 30);
		contentPane.add(panelButton);
		
		panelInput = new PanelInput();
		panelInput.setBounds(130, 205, 125, 261);
		contentPane.add(panelInput);
		
		//배경이미지
		SignUpAndUpdateGUIPanel panelBgImg = new SignUpAndUpdateGUIPanel();
		panelBgImg.setBounds(0, 0, 300, 500);
		contentPane.add(panelBgImg);
		panelBgImg.setLayout(null);
		
	}
	
	//회원 조회에서 연결됨
	public SignUpAndUpdateGUI(MemberCheckGUI memberCheckGUI){
		this();
		
		this.memberCheckGUI = memberCheckGUI;
		
		panelButton = new PanelButton(memberCheckGUI, this);
		panelButton.setBounds(0, 145, 300, 30);
		contentPane.add(panelButton);
	}
	
	//회원 수정에서 연결됨
	public SignUpAndUpdateGUI(Member member){
		this();
		
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
		
		panelButton.btnSign.setText("회원수정");
	}
}
