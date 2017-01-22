package kr.or.dgit.bigdata.diet.gui;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.regex.Pattern;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

import kr.or.dgit.bigdata.diet.dto.Member;
import kr.or.dgit.bigdata.diet.service.MemberService;

public class SignUpAndUpdateGUIPanel extends JPanel {
	ImageIcon bgImgTemp = new ImageIcon("images/bg_signup.png");
	Image bgImg = bgImgTemp.getImage();
	
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(bgImg, 0, 0, 300, 500, this);
		
	}
}

class PanelButton extends JPanel implements ActionListener {

	JButton btnSign;
	JButton btnClear;
	JButton btnCancel;
	private MemberService memberService;
	private static SignUpAndUpdateGUI signUpAndUpdateGUI;
	private static MemberCheckGUI memberCheckGUI;
	
	public PanelButton(SignUpAndUpdateGUI signUpGUI) {
		this.signUpAndUpdateGUI = signUpGUI;
		
		setLayout(null);
		setOpaque(false);
		
		btnSign = new JButton("회원등록");
		btnClear = new JButton("초기화");
		btnCancel = new JButton("돌아가기");
		
		btnSign.setBounds(28, 4, 72, 23);
		btnClear.setBounds(114, 4, 72, 23);
		btnCancel.setBounds(200, 4, 72, 23);
		
		btnSign.setForeground(Color.WHITE);
		btnClear.setForeground(Color.WHITE);
		btnCancel.setForeground(Color.WHITE);
		
		btnSign.setFont(new Font("맑은 고딕", Font.BOLD, 13));
		btnClear.setFont(new Font("맑은 고딕", Font.BOLD, 13));
		btnCancel.setFont(new Font("맑은 고딕", Font.BOLD, 13));
		
		btnSign.setFocusPainted(false);
		btnClear.setFocusPainted(false);
		btnCancel.setFocusPainted(false);
		
		btnSign.setBorder(new LineBorder(new Color(102, 162, 212)));
		btnClear.setBorder(new LineBorder(new Color(102, 162, 212)));
		btnCancel.setBorder(new LineBorder(new Color(102, 162, 212)));
	
		btnSign.setBackground(new Color(44, 103, 156));
		btnClear.setBackground(new Color(44, 103, 156));
		btnCancel.setBackground(new Color(44, 103, 156));
		
		add(btnSign);
		add(btnClear);
		add(btnCancel);
		
		btnSign.addActionListener(this);
		btnClear.addActionListener(this);
		btnCancel.addActionListener(this);

	}

	public PanelButton(MemberCheckGUI memberCheckGUI, SignUpAndUpdateGUI signUpGUI) {
		this(signUpGUI);
		this.memberCheckGUI = memberCheckGUI;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		//회원 등록
		if (e.getSource() == btnSign) {
			memberService = MemberService.getInstance();
			
			//값 유효성 검사 함수가 true일 때 실행
			if( !validCheck() ){
				
			}else{
				//라디오버튼 값 가져오기
				String gender ="";
				
				if (signUpAndUpdateGUI.panelInput.rdbtnMale.isSelected() == true) gender ="남";
				if (signUpAndUpdateGUI.panelInput.rdbtnFemale.isSelected() == true) gender ="여";
				
				//주소 값 가져오기
				String location = signUpAndUpdateGUI.panelInput.tf_location.getText();
				
				Member member = new Member(
						1,
						signUpAndUpdateGUI.panelInput.tf_name.getText(),
						gender,
						Integer.parseInt(signUpAndUpdateGUI.panelInput.tf_weight.getText()),
						Integer.parseInt(signUpAndUpdateGUI.panelInput.tf_age.getText()),
						signUpAndUpdateGUI.panelInput.tf_phone.getText(),
						location,
						Integer.parseInt(signUpAndUpdateGUI.panelInput.tf_budget.getText()));
				
				int rs = 0;
				
				if (btnSign.getText().equals("회원수정")) {
					member.setNo(Integer.parseInt((signUpAndUpdateGUI.panelInput.tf_no.getText())));
					rs = memberService.updateMember(member);
					JOptionPane.showMessageDialog(null, "정상적으로 수정되었습니다.");
					return;
				}else{
					rs = memberService.insertMember(member);
				}
				
				if (rs != 0) {
					JOptionPane.showMessageDialog(null, "정상적으로 가입되었습니다.");
					signUpAndUpdateGUI.panelInput.tf_no.setText(signUpAndUpdateGUI.panelInput.getNo()); //회원번호 초기화
					
					if (memberCheckGUI != null) {
						signUpAndUpdateGUI.dispose();
						new MemberCheckGUI().setVisible(true);
					}
				}
				else{
					JOptionPane.showMessageDialog(null, "입력오류가 발생했습니다.(데이터베이스 오류)");
				}

				//텍스트필드 초기화 메소드 호출
				allTextFieldClear(); 
			}					
		}
		
		//초기화
		if (e.getSource() == btnClear) {
			//텍스트필드 초기화 메소드 호출
			allTextFieldClear();
		}
		
		//돌아가기
		if (e.getSource() == btnCancel) {
			if (btnSign.getText().equals("회원수정")) {
				signUpAndUpdateGUI.dispose();
			}else{
				if (this.memberCheckGUI != null) {
					signUpAndUpdateGUI.dispose();
					new MemberCheckGUI().setVisible(true);
				}else{
					signUpAndUpdateGUI.dispose();
				}
			}
		}
	}

	//초기화 메소드
	private void allTextFieldClear() {
		signUpAndUpdateGUI.panelInput.tf_name.setText("");
		signUpAndUpdateGUI.panelInput.tf_weight.setText("");
		signUpAndUpdateGUI.panelInput.tf_age.setText("");
		signUpAndUpdateGUI.panelInput.tf_phone.setText("");
		signUpAndUpdateGUI.panelInput.tf_location.setText("");
		signUpAndUpdateGUI.panelInput.tf_budget.setText("");
	}

	//값 유효성 검사
	private boolean validCheck() {
		try {
			
			isEmptyCheck(signUpAndUpdateGUI.panelInput.tf_name);
			isEmptyCheck(signUpAndUpdateGUI.panelInput.tf_weight);
			isEmptyCheck(signUpAndUpdateGUI.panelInput.tf_age);
			isEmptyCheck(signUpAndUpdateGUI.panelInput.tf_phone);
			isEmptyCheck(signUpAndUpdateGUI.panelInput.tf_budget);
			isValidCheck("[가-힣]{1,4}", signUpAndUpdateGUI.panelInput.tf_name,  "이름을 4글자 이하, 한글로 작성해주세요.");
			isValidCheck("^[1-9][0-9]", signUpAndUpdateGUI.panelInput.tf_weight, "몸무게는 10~99kg이하로 작성해주세요.");
			isValidCheck("^[1-9][0-9]", signUpAndUpdateGUI.panelInput.tf_age, "나이는 10~99세 이하로 작성해주세요.");
			isValidCheck("^0[1-9]{1}[0-9]{1}-[0-9]{4}-[0-9]{4}$", signUpAndUpdateGUI.panelInput.tf_phone, "휴대전화 번호는 010-0000-0000형식으로 입력해주세요.");
			isValidCheck("", signUpAndUpdateGUI.panelInput.tf_budget, "월 예산은 0~100만원 사이로 입력해주세요.");
			
			if (signUpAndUpdateGUI.panelInput.rdbtnMale.isSelected()==false 
					&& signUpAndUpdateGUI.panelInput.rdbtnFemale.isSelected()==false){
				JOptionPane.showMessageDialog(null, "성별을 선택해주세요.");
				return false;
			}
			
			return true;
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
			return false;
		}
	}
	
	//공백여부검사
	private boolean isEmptyCheck(JTextField text) throws Exception {
		if(text.getText().trim().equals("")){
			text.requestFocus();
			throw new Exception("공백이 존재합니다.");
		}else{
			return true;
		}
	}
	
	// 정규표현 검사
	private void isValidCheck(String pattern, JTextField text, String msg) throws Exception {
		if (text == signUpAndUpdateGUI.panelInput.tf_budget) {
			if (Integer.parseInt(text.getText().trim()) > 1000000 
					|| Integer.parseInt(text.getText().trim()) < 0) {
				text.setText("");
				text.requestFocus();
				throw new Exception(msg);
			}
		} else if (!Pattern.matches(pattern, text.getText().trim())) {
			text.setText("");
			text.requestFocus();
			throw new Exception(msg);
		}
	}
}


class PanelInput extends JPanel{
	JTextField tf_name;
	JTextField tf_weight;
	JTextField tf_age;
	JTextField tf_phone;
	JTextField tf_location;
	JTextField tf_budget;
	JTextField tf_no;
	JRadioButton rdbtnMale;
	JRadioButton rdbtnFemale;
	private ButtonGroup rdbtnGroup;
	private JButton btnLocation;
	private PanelInput panelTextField;

	public PanelInput() {
		this.panelTextField = this;
		
		setLayout(null);
		setOpaque(false);
		
		//textfield 생성
		tf_no = new JTextField();
		tf_name = new JTextField();
		tf_weight = new JTextField();
		tf_age = new JTextField();
		tf_phone = new JTextField();
		tf_location = new JTextField();
		tf_budget = new JTextField();
		
		tf_no.setEditable(false);
		tf_location.setEditable(false);
		
		tf_no.setBackground(Color.WHITE);
		tf_location.setBackground(Color.WHITE);
		
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
		
		btnLocation = new JButton("주소검색");
		btnLocation.setBounds(24, 175, 72, 23);
		add(btnLocation);
		btnLocation.setFont(new Font("굴림", Font.BOLD, 11));
		btnLocation.setForeground(new Color(44,103,156));
		btnLocation.setBackground(new Color(234,234,234));
		btnLocation.setFocusPainted(false);
		btnLocation.setBorder(null);
		btnLocation.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new SearchPost(panelTextField).setVisible(true);
			}
		});
		
		//radio button , radio button group
		rdbtnMale = new JRadioButton("남자");
		rdbtnFemale = new JRadioButton("여자");
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
		
		rdbtnGroup = new ButtonGroup();
		rdbtnGroup.add(rdbtnMale);
		rdbtnGroup.add(rdbtnFemale);
		
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
	public String getNo() {
		ArrayList<Member> list = MemberService.getInstance().selectAllMember();
		
		if (list.isEmpty()) {
			return "001";
		}else{
			return String.format("%03d", list.get(list.size()-1).getNo()+1);
		}
	}
	
}