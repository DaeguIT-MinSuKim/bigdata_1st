package kr.or.dgit.bigdata.diet.gui;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class DietGUI extends JFrame {

	Container contentPane;
	private JTextField tfName;
	private JTextField tfGender;
	private JTextField tfWeight;
	private JTextField tfAge;
	private JTextField tfPhone;
	private JTextField tfAddr;
	private JTextField tfBudget;
	private JTextField tfNowNum;
	private JTextField thWholeNum;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DietGUI frame = new DietGUI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public DietGUI() {
		setTitle("식단생성");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 500, 700);
		contentPane = getContentPane();
		DietBgPanel dbp = new DietBgPanel();
		contentPane.add(dbp, BorderLayout.CENTER);
		dbp.setLayout(null);
		
		tfName = new JTextField();
		tfName.setText("ex)임정학");
		tfName.setBounds(37, 193, 70, 21);
		dbp.add(tfName);
		tfName.setColumns(10);
		
		tfGender = new JTextField();
		tfGender.setText("남");
		tfGender.setBounds(113, 193, 33, 21);
		dbp.add(tfGender);
		tfGender.setColumns(10);
		
		tfWeight = new JTextField();
		tfWeight.setText("60");
		tfWeight.setBounds(37, 224, 33, 21);
		dbp.add(tfWeight);
		tfWeight.setColumns(10);
		
		tfAge = new JTextField();
		tfAge.setText("28");
		tfAge.setColumns(10);
		tfAge.setBounds(94, 224, 33, 21);
		dbp.add(tfAge);
		
		tfPhone = new JTextField();
		tfPhone.setText("01012341234");
		tfPhone.setBounds(78, 306, 187, 21);
		dbp.add(tfPhone);
		tfPhone.setColumns(10);
		
		tfAddr = new JTextField();
		tfAddr.setText("대구광역시");
		tfAddr.setColumns(10);
		tfAddr.setBounds(78, 356, 187, 21);
		dbp.add(tfAddr);
		
		tfBudget = new JTextField();
		tfBudget.setText("1,000,000");
		tfBudget.setColumns(10);
		tfBudget.setBounds(78, 410, 187, 21);
		dbp.add(tfBudget);
		
		tfNowNum = new JTextField();
		tfNowNum.setText("1");
		tfNowNum.setBounds(331, 30, 42, 40);
		dbp.add(tfNowNum);
		tfNowNum.setColumns(10);
		
		thWholeNum = new JTextField();
		thWholeNum.setText("20");
		thWholeNum.setColumns(10);
		thWholeNum.setBounds(331, 87, 42, 40);
		dbp.add(thWholeNum);
		
		JButton btnPrev = new JButton("Prev");
		btnPrev.setBounds(96, 507, 97, 23);
		dbp.add(btnPrev);
		
		JButton btnNext = new JButton("Next");
		btnNext.setBounds(289, 507, 97, 23);
		dbp.add(btnNext);
		
		JButton btnPlanA = new JButton("plan A");
		btnPlanA.setBounds(37, 579, 64, 61);
		dbp.add(btnPlanA);
		
		JButton btnPlanB = new JButton("plan B");
		btnPlanB.setBounds(113, 579, 64, 61);
		dbp.add(btnPlanB);
		
		JButton btnPlanC = new JButton("plan C");
		btnPlanC.setBounds(201, 579, 64, 61);
		dbp.add(btnPlanC);
		
		JLabel lblWeight = new JLabel("KG");
		lblWeight.setBounds(70, 227, 57, 15);
		dbp.add(lblWeight);
		
		JLabel lblAge = new JLabel("세");
		lblAge.setBounds(127, 225, 19, 18);
		dbp.add(lblAge);
		
		JLabel lblPhone = new JLabel("Phone");
		lblPhone.setHorizontalAlignment(SwingConstants.RIGHT);
		lblPhone.setBounds(13, 309, 57, 15);
		dbp.add(lblPhone);
		
		JLabel lblAddr = new JLabel("Address");
		lblAddr.setHorizontalAlignment(SwingConstants.RIGHT);
		lblAddr.setBounds(13, 359, 57, 15);
		dbp.add(lblAddr);
		
		JLabel lblBudget = new JLabel("Budget");
		lblBudget.setHorizontalAlignment(SwingConstants.RIGHT);
		lblBudget.setBounds(13, 413, 57, 15);
		dbp.add(lblBudget);
	}
}

class DietBgPanel extends JPanel{
	ImageIcon dbgIcon = new ImageIcon("images/signup_image_origin.jpg");
	Image dbgImg = dbgIcon.getImage();
	
	
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		
		g.drawImage(dbgImg, 0, 0, getWidth(), getHeight(), this);
	}
}
