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

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class SignUpGUI extends JDialog {

	private JPanel contentPane;
	MemberCheckGUI memberCheckGUI;
	PanelInput panelInput;
	private PanelButton panelButton;
	
	public SignUpGUI() {
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
		PanelForSignUp panelBgImg = new PanelForSignUp();
		panelBgImg.setBounds(0, 0, 300, 500);
		contentPane.add(panelBgImg);
		panelBgImg.setLayout(null);
		
	}
	
	public SignUpGUI(MemberCheckGUI memberCheckGUI){
		this();
		
		this.memberCheckGUI = memberCheckGUI;
		
		panelButton = new PanelButton(memberCheckGUI, this);
		panelButton.setBounds(0, 145, 300, 30);
		contentPane.add(panelButton);
	}
	
}
