package kr.or.dgit.bigdata.diet.gui;

import javax.swing.JPanel;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.regex.Pattern;

import javax.swing.JTextField;
import javax.swing.border.LineBorder;

import com.sun.org.apache.bcel.internal.generic.IF_ACMPEQ;
import com.sun.xml.internal.ws.api.streaming.XMLStreamReaderFactory.Default;

import kr.or.dgit.bigdata.diet.dto.Member;
import kr.or.dgit.bigdata.diet.service.MemberService;

import javax.swing.ButtonGroup;
import javax.swing.JButton;

import java.awt.Color;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JRadioButton;

public class PanelTextField extends JPanel {
	private JTextField tf_name;
	private JTextField tf_weight;
	private JTextField tf_age;
	private JTextField tf_phone;
	private JTextField tf_location;
	private JTextField tf_budget;
	private JTextField tf_no;

	public PanelTextField() {
		setLayout(null);
		setOpaque(false);
		
		
		//textfield 생성
		tf_no = new JTextField();
		tf_no.setEditable(false);
		tf_no.setBackground(Color.WHITE);
		tf_name = new JTextField();
		tf_weight = new JTextField();
		tf_age = new JTextField();
		tf_phone = new JTextField();
		tf_location = new JTextField();
		tf_budget = new JTextField();
		
		tf_no.setHorizontalAlignment(SwingConstants.CENTER);
		tf_name.setHorizontalAlignment(SwingConstants.CENTER);
		tf_weight.setHorizontalAlignment(SwingConstants.CENTER);
		tf_age.setHorizontalAlignment(SwingConstants.CENTER);
		tf_phone.setHorizontalAlignment(SwingConstants.CENTER);
		tf_location.setHorizontalAlignment(SwingConstants.LEFT);
		tf_budget.setHorizontalAlignment(SwingConstants.CENTER);
		
		tf_no.setFont(new Font("돋움", Font.PLAIN, 13));
		tf_name.setFont(new Font("돋움", Font.PLAIN, 13));
		tf_weight.setFont(new Font("돋움", Font.PLAIN, 13));
		tf_age.setFont(new Font("돋움", Font.PLAIN, 13));
		tf_phone.setFont(new Font("돋움", Font.PLAIN, 13));
		tf_location.setFont(new Font("돋움", Font.PLAIN, 13));
		tf_budget.setFont(new Font("돋움", Font.PLAIN, 13));
		
		tf_no.setColumns(10);
		tf_name.setColumns(10);
		tf_weight.setColumns(10);
		tf_age.setColumns(10);
		tf_phone.setColumns(10);
		tf_location.setColumns(10);
		tf_budget.setColumns(10);
		
		tf_no.setBounds(0, 0, 120, 20);
		tf_name.setBounds(0, 29, 120, 20);
		tf_weight.setBounds(0, 87, 120, 20);
		tf_age.setBounds(0, 116, 120, 20);
		tf_phone.setBounds(0, 145, 120, 20);
		tf_location.setBounds(0, 205, 120, 20);
		tf_budget.setBounds(0, 234, 120, 20);
		
		tf_no.setBorder(null);
		tf_name.setBorder(new LineBorder(new Color(204,204,204)));
		tf_weight.setBorder(new LineBorder(new Color(204,204,204)));
		tf_age.setBorder(new LineBorder(new Color(204,204,204)));
		tf_phone.setBorder(new LineBorder(new Color(204,204,204)));
		tf_location.setBorder(new LineBorder(new Color(204, 204, 204)));
		tf_budget.setBorder(new LineBorder(new Color(204,204,204)));
		
		add(tf_no);
		add(tf_name);
		add(tf_weight);
		add(tf_age);
		add(tf_phone);
		add(tf_location);
		add(tf_budget);
		
		//회원번호 자동 증가
		tf_no.setText(getNo());
		
		//textfield 키 이벤트 발생 부분
		tf_name.setName("tf_name");
		tf_weight.setName("tf_weight");
		tf_age.setName("tf_age");
		tf_phone.setName("tf_phone");
		tf_budget.setName("tf_budget");
		
		tf_name.addKeyListener(runKeyListener(tf_name));
		tf_weight.addKeyListener(runKeyListener(tf_weight));
		tf_age.addKeyListener(runKeyListener(tf_age));
		tf_phone.addKeyListener(runKeyListener(tf_phone));
		tf_budget.addKeyListener(runKeyListener(tf_budget));
		
		JButton btnLocation = new JButton("주소검색");
		btnLocation.setBounds(24, 175, 72, 23);
		add(btnLocation);
		btnLocation.setFont(new Font("굴림", Font.BOLD, 11));
		btnLocation.setForeground(new Color(44,103,156));
		btnLocation.setBackground(new Color(234,234,234));
		btnLocation.setFocusPainted(false);
		btnLocation.setBorder(null);
		
		//*****radio button 부분
		JRadioButton rdbtnMale = new JRadioButton("남자");
		JRadioButton rdbtnFemale = new JRadioButton("여자");
		rdbtnMale.setHorizontalAlignment(SwingConstants.CENTER);
		rdbtnFemale.setHorizontalAlignment(SwingConstants.CENTER);
		rdbtnMale.setFont(new Font("굴림", Font.PLAIN, 12));
		rdbtnFemale.setFont(new Font("굴림", Font.PLAIN, 12));
		rdbtnMale.setBounds(0, 58, 59, 20);
		rdbtnFemale.setBounds(60, 58, 59, 20);
		rdbtnMale.setOpaque(false);
		rdbtnFemale.setOpaque(false);
		add(rdbtnMale);
		add(rdbtnFemale);
	/*	
		//라디오버튼 그룹화를 위한 버튼그룹 설정
				ButtonGroup  group = new ButtonGroup(); 
				rdbtnMale = new JRadioButton("남성");
				rdbtnFemale = new JRadioButton("여성");
				rdbtnMale.setBackground(Color.white);
				rdbtnFemale.setBackground(Color.white);
				//같은 그룹끼리는 그룹중에 1개만 선택된다.
				//그룹에 그룹화시킬 버튼들을 추가
				group.add(rdbtnMale);  group.add(rdbtnFemale); 
				rdbtnMale.setBounds(275, 258, 54, 23);
				rdbtnFemale.setBounds(333, 258, 54, 23);
				 //라디오 버튼 frame에 추가
				signPanel.add(rdbtnMale);
				signPanel.add(rdbtnFemale);
				
				tf_location = new JTextField();
				tf_location.setHorizontalAlignment(SwingConstants.CENTER);
				tf_location.setBounds(263, 421, 76, 21);
				signPanel.add(tf_location);
				tf_location.setColumns(10);
				
				JButton btnLocation = new JButton("검색");
				btnLocation.setBackground(Color.WHITE);
				btnLocation.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						SearchPost searchPost = new SearchPost();
						searchPost.setVisible(true);
					}
				});
				btnLocation.setBounds(344, 420, 54, 23);
				btnLocation.setBorder(null);
				signPanel.add(btnLocation);*/
		
		
		
	}

	//키 이벤트 발생 메소드
	private KeyListener runKeyListener(JTextField key) {
		KeyAdapter keyAdapter = new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				//특수문자 배제시킴
				char t = e.getKeyChar();
				
				//공통 체크 부분
				boolean digitCheck = Character.isDigit(t);
				boolean backSpaceCheck = ( t == KeyEvent.VK_BACK_SPACE );
				boolean deleteCheck = ( t == KeyEvent.VK_DELETE );
				
				switch (key.getName()) {
				
				case "tf_name":
					if ( !(digitCheck || backSpaceCheck || deleteCheck || Character.isAlphabetic(t)) ) {
						getToolkit().beep();
						e.consume();
					}
					//한글 최대 8자까지 받음 
					if(!Pattern.matches("^[0-9a-zA-Zㄱ-ㅎㅏ-ㅣ가-힣]{1,8}", key.getText()+t)){
						e.consume();
						getToolkit().beep();
					}
					break;
					
				case "tf_weight":
				case "tf_age":
					if ( !(digitCheck || backSpaceCheck || deleteCheck) ) {
						getToolkit().beep();
						e.consume();
					}
					//최대 3자까지 받음 			
					if(!Pattern.matches("^[0-9]{1,3}", key.getText()+t)){
						e.consume();
						getToolkit().beep();
					}
					break;
					
				case "tf_budget":
					if ( !(digitCheck || backSpaceCheck || deleteCheck) ) {
						getToolkit().beep();
						e.consume();
					}
					//최대 8자까지 받음 			
					if(!Pattern.matches("^[0-9]{1,8}", key.getText()+t)){
						e.consume();
						getToolkit().beep();
					}
					break;
					
				case "tf_phone":
					if ( !(digitCheck || backSpaceCheck || deleteCheck || (t == KeyEvent.VK_MINUS)) ) {
						getToolkit().beep();
						e.consume();
					}
					//최대 15자까지 받음 			
					if(!Pattern.matches("^[0-9-]{1,15}", key.getText()+t)){
						e.consume();
						getToolkit().beep();
					}
					break;
				}
			}
		};
		return keyAdapter;
	}
	
	
	//회원번호 자동 증가
	private String getNo() {
		ArrayList<Member> list = MemberService.getInstance().selectAllMember();
		
		if (list.isEmpty()) {
			return "001";
		}else{
			return String.format("%03d", list.get(list.size()-1).getNo()+1);
		}
	}
	
}
