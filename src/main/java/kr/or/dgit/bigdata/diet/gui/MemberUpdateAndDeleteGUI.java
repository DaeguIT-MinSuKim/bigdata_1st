package kr.or.dgit.bigdata.diet.gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Dialog.ModalityType;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class MemberUpdateAndDeleteGUI extends JDialog {

	private JPanel contentPane;

	public MemberUpdateAndDeleteGUI() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 616, 438);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		//크기조정불가
		setResizable(false);
		
		//현재 다이얼로그를 띄웠을 때 다른 프레임은 움직이지 못하도록 처리
		setModalityType(ModalityType.APPLICATION_MODAL);
		
		MemberUpdateAndDeleteGUIPanel panel = new MemberUpdateAndDeleteGUIPanel();
		panel.setBounds(0, 0, 600, 400);
		contentPane.add(panel);
	}
}
