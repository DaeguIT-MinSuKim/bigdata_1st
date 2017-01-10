package kr.or.dgit.bigdata.diet.gui;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import com.sun.nio.file.SensitivityWatchEventModifier;

import kr.or.dgit.bigdata.diet.service.CalorieService;
import kr.or.dgit.bigdata.diet.service.MenuService;

public class MenuUI extends JFrame {

	private JFrame frame;
	private JTextField textField;
	private static CalorieService calorieService;
	private static MenuService menuService;
	//private ArrayList<Member> memberList;			//회원 명부
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MenuUI window = new MenuUI();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public MenuUI() {
		initialize();
		
		
		
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNo = new JLabel("");
		lblNo.setBounds(118, 128, 57, 15);
		frame.getContentPane().add(lblNo);
		
		JLabel lblName = new JLabel("");
		lblName.setBounds(271, 128, 57, 15);
		frame.getContentPane().add(lblName);
		
		textField = new JTextField();
		textField.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		textField.setBounds(185, 39, 116, 21);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("회원찾기");
		lblNewLabel_2.setBounds(95, 42, 57, 15);
		frame.getContentPane().add(lblNewLabel_2);
		
		JLabel lblPrev = new JLabel("이전");
		lblPrev.setBounds(154, 163, 57, 15);
		frame.getContentPane().add(lblPrev);
		
		JLabel lblNext = new JLabel("다음");
		lblNext.setBounds(223, 163, 57, 15);
		frame.getContentPane().add(lblNext);
		
		setVisible(true);
		
	}
}
