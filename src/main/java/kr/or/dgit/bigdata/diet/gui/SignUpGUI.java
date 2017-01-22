package kr.or.dgit.bigdata.diet.gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class SignUpGUI extends JFrame {

	private JPanel contentPane;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SignUpGUI frame = new SignUpGUI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public SignUpGUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 306, 526);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		//크기조정불가
		setResizable(false);
		contentPane.setLayout(null);
		
		PanelBtn panelButtons = new PanelBtn();
		panelButtons.setBounds(0, 145, 300, 30);
		contentPane.add(panelButtons);
		
		PanelTextField panelTextField = new PanelTextField();
		panelTextField.setBounds(130, 205, 125, 261);
		contentPane.add(panelTextField);
		
		//배경이미지
		PanelForSignUp panelBgImg = new PanelForSignUp();
		panelBgImg.setBounds(0, 0, 300, 500);
		contentPane.add(panelBgImg);
		panelBgImg.setLayout(null);
	}
}
