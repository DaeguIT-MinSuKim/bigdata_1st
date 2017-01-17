package kr.or.dgit.bigdata.diet.gui;

import java.awt.Color;
import java.awt.Font;
import java.awt.Dialog.ModalityType;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

import com.mysql.fabric.xmlrpc.base.Member;

public class PanelTopButton extends JPanel implements ActionListener {
	private JButton btnMakeList;
	private JButton btnCreateMember;
	private MemberCheckGUI memberCheckGUI;
	private FoodListAbsolute foodListAbsolute;

	//private JButton btnMakeList;
	/**
	 * Create the panel.
	 */
	public PanelTopButton(MemberCheckGUI memberCheckGUI) {
		this.memberCheckGUI = memberCheckGUI;
		
		setOpaque(false);
		setLayout(null);
		
		btnMakeList = new JButton("식단생성");
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
		//식단 생성 버튼
		if (e.getSource() == btnMakeList) {
			/*foodListAbsolute = new FoodListAbsolute(memberCheckGUI);
			foodListAbsolute.setVisible(true);
			new MemberCheckGUI().setEnabled(false);
			*/
			FoodListDialog foodListDialog = new FoodListDialog();
			foodListDialog.setVisible(true);
		}
		
		//회원 등록 버튼
		if (e.getSource() == btnCreateMember) {
			SignupUI signupUi = new SignupUI();
			signupUi.setVisible(true);
		}
	}

}
