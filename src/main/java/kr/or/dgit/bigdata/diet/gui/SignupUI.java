package kr.or.dgit.bigdata.diet.gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Cursor;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.util.regex.Pattern;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.event.MouseInputListener;

import kr.or.dgit.bigdata.diet.dto.Member;
import kr.or.dgit.bigdata.diet.service.MemberService;
import javax.swing.JRadioButton;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;

public class SignupUI extends JDialog {

	private Container contentPane;
	private JTextField tf_no;
	private JTextField tf_name;
	private JTextField tf_weight;
	private JTextField tf_age;
	private JTextField tf_phone;
	private JTextField tf_budg;
	private String[] habitat = {"서울", "대전", "대구", "부산", "울산", "세종", "제주", "광주", "순천", "포항", "제천", "양산", "김해"};
	private static MemberService memberService; // db 서비스 인스턴스
	private JRadioButton rdbtnMale;
	private JRadioButton rdbtnFemale;
	private JComboBox cmbHabitat;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SignupUI frame = new SignupUI();
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
	public SignupUI() {
		setModal(true);
		setResizable(false);
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = getContentPane();
		SignPanel signPanel = new SignPanel();
		contentPane.add(signPanel, BorderLayout.CENTER);
		signPanel.setLayout(null);

		JLabel lblSignUp = new JLabel("SIGN UP | 회원등록");
		lblSignUp.setHorizontalAlignment(SwingConstants.CENTER);
		lblSignUp.setFont(new Font("10X10 Bold", Font.PLAIN, 30));
		lblSignUp.setBounds(210, 62, 262, 71);
		signPanel.add(lblSignUp);

		JLabel label_1 = new JLabel("이름");
		label_1.setHorizontalAlignment(SwingConstants.RIGHT);
		label_1.setFont(new Font("서울남산체 M", Font.PLAIN, 20));
		label_1.setBounds(154, 217, 76, 21);
		signPanel.add(label_1);

		JLabel label_2 = new JLabel("성별");
		label_2.setHorizontalAlignment(SwingConstants.RIGHT);
		label_2.setFont(new Font("서울남산체 M", Font.PLAIN, 20));
		label_2.setBounds(154, 257, 76, 21);
		signPanel.add(label_2);

		JLabel label_3 = new JLabel("몸무게");
		label_3.setHorizontalAlignment(SwingConstants.RIGHT);
		label_3.setFont(new Font("서울남산체 M", Font.PLAIN, 20));
		label_3.setBounds(154, 298, 76, 21);
		signPanel.add(label_3);

		JLabel label_4 = new JLabel("나이");
		label_4.setHorizontalAlignment(SwingConstants.RIGHT);
		label_4.setFont(new Font("서울남산체 M", Font.PLAIN, 20));
		label_4.setBounds(154, 339, 76, 21);
		signPanel.add(label_4);

		JLabel label_5 = new JLabel("휴대전화");
		label_5.setHorizontalAlignment(SwingConstants.RIGHT);
		label_5.setFont(new Font("서울남산체 M", Font.PLAIN, 20));
		label_5.setBounds(154, 379, 76, 21);
		signPanel.add(label_5);

		JLabel label_6 = new JLabel("거주지");
		label_6.setHorizontalAlignment(SwingConstants.RIGHT);
		label_6.setFont(new Font("서울남산체 M", Font.PLAIN, 20));
		label_6.setBounds(154, 419, 76, 21);
		signPanel.add(label_6);

		JLabel label_7 = new JLabel("월 예산");
		label_7.setHorizontalAlignment(SwingConstants.RIGHT);
		label_7.setFont(new Font("서울남산체 M", Font.PLAIN, 20));
		label_7.setBounds(154, 456, 76, 21);
		signPanel.add(label_7);

		tf_no = new JTextField();
		tf_no.setEditable(true);
		tf_no.setEnabled(false);
		tf_no.setBorder(null);
					
		tf_no.setBounds(263, 176, 135, 21);
		signPanel.add(tf_no);
		tf_no.setColumns(10);

		tf_name = new JTextField();
		tf_name.setHorizontalAlignment(SwingConstants.CENTER);
		tf_name.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				//특수문자 배제시킴
				char t = e.getKeyChar();
				if (! (   ( Character.isDigit(t))
						||(Character.isAlphabetic(t))
						||(t == KeyEvent.VK_BACK_SPACE) 
						||(t == KeyEvent.VK_DELETE) ) ) {
					getToolkit().beep();
					e.consume();
				}
				//한글 최대 8자까지 받음 			
				if(!Pattern.matches("^[0-9a-zA-Zㄱ-ㅎㅏ-ㅣ가-힣]{1,8}",tf_name.getText()+t)){
					e.consume();
					getToolkit().beep();
				}
			}
		});
		tf_name.setColumns(10);
		tf_name.setBounds(263, 218, 135, 21);
		signPanel.add(tf_name);

		tf_weight = new JTextField();
		tf_weight.setHorizontalAlignment(SwingConstants.CENTER);
		tf_weight.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				//특수문자와 알파벳 배제시킴
				char t = e.getKeyChar();
				if (! ( (Character.isDigit(t))
						||(t == KeyEvent.VK_BACK_SPACE) 
						||(t == KeyEvent.VK_DELETE) ) ) {
					getToolkit().beep();
					e.consume();
				}
				//최대 8자까지 받음 			
				if(!Pattern.matches("^[0-9]{1,3}",tf_weight.getText()+t)){
					e.consume();
					getToolkit().beep();
				}
			}
		});
		tf_weight.setColumns(10);
		tf_weight.setBounds(263, 299, 135, 21);
		signPanel.add(tf_weight);

		tf_age = new JTextField();
		tf_age.setHorizontalAlignment(SwingConstants.CENTER);
		tf_age.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				//백스페이스 및 숫자만 받음
				char t = e.getKeyChar();
				if (! ( (Character.isDigit(t))
						||(t == KeyEvent.VK_BACK_SPACE) 
						||(t == KeyEvent.VK_DELETE) ) ) {
					getToolkit().beep();
					e.consume();
				}
				//최대 3자까지 받음 			
				if(!Pattern.matches("^[0-9]{1,3}",tf_age.getText()+t)){
					e.consume();
					getToolkit().beep();
				}
			}
		});
		tf_age.setColumns(10);
		tf_age.setBounds(263, 340, 135, 21);
		signPanel.add(tf_age);

		tf_phone = new JTextField();
		tf_phone.setHorizontalAlignment(SwingConstants.CENTER);
		tf_phone.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				//백스페이스 및 숫자만 받음				
				char t = e.getKeyChar();
				if (! ( (Character.isDigit(t))
						||(t == KeyEvent.VK_BACK_SPACE) 
						||(t == KeyEvent.VK_DELETE) ) ) {
					getToolkit().beep();
					e.consume();
				}
				//최대 15자까지 받음 			
				if(!Pattern.matches("^[0-9]{1,15}",tf_phone.getText()+t)){
					e.consume();
					getToolkit().beep();
				}
			}
		});
		tf_phone.setColumns(10);
		tf_phone.setBounds(263, 380, 135, 21);
		signPanel.add(tf_phone);

		tf_budg = new JTextField();
		tf_budg.setHorizontalAlignment(SwingConstants.CENTER);
		tf_budg.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				//백스페이스 및 숫자만 받음
				char t = e.getKeyChar();
				if (! ( (Character.isDigit(t))
						||(t == KeyEvent.VK_BACK_SPACE) 
						||(t == KeyEvent.VK_DELETE) ) ) {
					getToolkit().beep();
					e.consume();
				}
				//최대 8자까지 받음 			
				if(!Pattern.matches("^[0-9]{1,8}",tf_budg.getText()+t)){
					e.consume();
					getToolkit().beep();
				}
			}
		});
		tf_budg.setColumns(10);
		tf_budg.setBounds(263, 458, 135, 21);
		signPanel.add(tf_budg);
		
		//이미지 아이콘
		ImageIcon originSignup = new ImageIcon("pictogram/signup.png");
		Image originSignImg = originSignup.getImage();
		Image changeSignImg = originSignImg.getScaledInstance(100, 100, Image.SCALE_SMOOTH);
		ImageIcon changeSign = new ImageIcon(changeSignImg);
				
		ImageIcon originClear = new ImageIcon("pictogram/clear.png");
		Image originClearImg = originClear.getImage();
		Image changeClearImg = originClearImg.getScaledInstance(50, 50, Image.SCALE_SMOOTH);
		ImageIcon changeClear = new ImageIcon(changeClearImg);
				
		ImageIcon originCancel = new ImageIcon("pictogram/cancel.png");
		Image originCancelImg = originCancel.getImage();
		Image changeCancelImg = originCancelImg.getScaledInstance(50, 50, Image.SCALE_SMOOTH);
		ImageIcon changeCancel = new ImageIcon(changeCancelImg);
		
		
		//버튼
		JButton btnSign = new JButton("");
		btnSign.setFocusable(false);
		btnSign.setBorder(null);
		btnSign.setBackground(null);
		btnSign.setBounds(100, 530, 100, 100);
		btnSign.setBorderPainted(false);
		btnSign.setFocusPainted(false);
		btnSign.setContentAreaFilled(false);
		btnSign.setIcon(changeSign);
		signPanel.add(btnSign);
		btnSign.setToolTipText("등록하기");
		//btnSign.setToolTipText(
		//		"<html><body style='background-color:white;'>"
		//		+ "<center><h4>등록하기</h4></center></body></html>");
	
		
		JButton btnClear = new JButton("");
		btnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				tf_no.setText("");
				tf_name.setText("");
				tf_weight.setText("");
				tf_age.setText("");
				tf_phone.setText("");
				tf_budg.setText("");
			}
		});
		btnClear.setFocusable(false);
		btnClear.setBorder(null);
		btnClear.setBackground(Color.WHITE);
		btnClear.setBounds(35, 563, 60, 60);
		btnClear.setBorderPainted(false);
        btnClear.setFocusPainted(false);
        btnClear.setContentAreaFilled(false);
		btnClear.setIcon(changeClear);
		signPanel.add(btnClear);
		
		JButton btnCancel = new JButton("");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnCancel.setFocusable(false);
		btnCancel.setBorder(null);
		btnCancel.setBackground(Color.WHITE);
		btnCancel.setBounds(205, 570, 60, 60);
		btnCancel.setBorderPainted(false);
       	btnCancel.setFocusPainted(false);
      	btnCancel.setContentAreaFilled(false);
		btnCancel.setIcon(changeCancel);
		signPanel.add(btnCancel);
		
		//입력 버튼 이벤트
		btnSign.addActionListener(new ActionListener() {
			
			//입력 버튼 이벤트
			public void actionPerformed(ActionEvent arg0) {
				
				memberService = MemberService.getInstance();
				
				if(!validCheck()){
					
				}else{
					//라디오버튼 값 가져오기
					String gender ="";
					if (rdbtnMale.isSelected()==true){gender ="남";}
					if (rdbtnFemale.isSelected()==true){gender ="여";}
					
					//콤보박스 값 가져오기
					String location = (String)cmbHabitat.getSelectedItem();
					
					Member mem 
					  = new Member(1  , 
							  tf_name.getText(), 
							  gender,
						  	  Integer.parseInt(tf_weight.getText()), 
						  	  Integer.parseInt(tf_age.getText()), 
						  	  tf_phone.getText(),
							  location, 
							  Integer.parseInt(tf_budg.getText()));
					
					int rs = memberService.insertMember(mem);
					// 
					if (rs != 0)
						JOptionPane.showMessageDialog(null, "정상적으로 가입되었습니다.");
					else{JOptionPane.showMessageDialog(null, "입력오류가 발생했습니다.(데이터베이스 오류)");}

					tf_no.setText("");
					tf_name.setText("");
					tf_weight.setText("");
					tf_age.setText("");
					tf_phone.setText("");
					tf_budg.setText("");
				}								
			}
		});
		
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
		
		cmbHabitat = new JComboBox();
		for (String s : habitat) {
			cmbHabitat.addItem(s);
		}
		cmbHabitat.setBounds(263, 421, 135, 21);
		cmbHabitat.setBackground(Color.white);
		signPanel.add(cmbHabitat);
		setSize(500, 700);

		// 마우스 이벤트 처리 클래스
		MouseEventListener2 mouseListener = new MouseEventListener2(this);
		addMouseListener(mouseListener);
		addMouseMotionListener(mouseListener);

		// setUndecorated(true); //상태줄 없애기
		setLocationRelativeTo(null); // 중앙 위치토록 함수 호출
		setVisible(true);
	} // constructor end

	//값 유효성 검사 함수
	private boolean validCheck() {
		try {
			isEmptyCheck(tf_name);
			isEmptyCheck(tf_weight);
			isEmptyCheck(tf_age);
			isEmptyCheck(tf_phone);
			isEmptyCheck(tf_budg);
			isValidCheck("[가-힣]{1,4}", tf_name,  "이름을 4글자 이하, 한글로 작성해주세요.");
			isValidCheck("^[1-9][0-9]", tf_weight, "몸무게는 10~99kg이하로 작성해주세요.");
			isValidCheck("^[1-9][0-9]", tf_age, "나이는 10~99세 이하로 작성해주세요.");
			isValidCheck("^0[1-9]{1}[0-9]{1}-[0-9]{4}-[0-9]{4}$", tf_phone, "휴대전화 번호는 010-0000-0000형식으로 입력해주세요.");
			isValidCheck("", tf_budg, "월 예산은 0~100만원 사이로 입력해주세요.");
			
			if (rdbtnMale.isSelected()==false && rdbtnFemale.isSelected()==false){
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
		if (text == tf_budg) {
			if (Integer.parseInt(text.getText().trim()) > 1000000 || Integer.parseInt(text.getText().trim()) < 0) {
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
} // jframe end

class SignPanel extends JPanel {
	ImageIcon SignBgIcon = new ImageIcon("images/signup_image.jpg");
	Image SignBgImg = SignBgIcon.getImage();

	public void paintComponent(Graphics g) {
		super.paintComponent(g);

		g.drawImage(SignBgImg, 0, 0, getWidth(), getHeight(), this);
	}
}

class MouseEventListener2 implements MouseInputListener {

	Point origin;

	SignupUI frame;

	public MouseEventListener2(SignupUI frame) {
		this.frame = frame;
		origin = new Point();
	}

	@Override
	public void mouseClicked(MouseEvent e) {
	}

	/**
	 * 기록 마우스 눌렀을 때 시
	 */
	@Override
	public void mousePressed(MouseEvent e) {
		origin.x = e.getX();
		origin.y = e.getY();
	}

	@Override
	public void mouseReleased(MouseEvent e) {
	}

	/**
	 * 마우스 移进 제목 표시줄 때 마우스 아이콘 위해 이동 아이콘 설정
	 */
	@Override
	public void mouseEntered(MouseEvent e) {
		this.frame.setCursor(Cursor.getPredefinedCursor(Cursor.MOVE_CURSOR));
	}

	/**
	 * 제목 표시줄에 마우스를 위로 지나갈 때 마우스 포인터가 아이콘 기본값으로 설정
	 */
	@Override
	public void mouseExited(MouseEvent e) {
		this.frame.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
	}

	/**
	 * 마우스 캡션 표시줄 拖拽 때 설정 창 좌표 위치 창 새 좌표 위치 = 전에 좌표 이동 위치 + (마우스 포인터 현재 좌표 -
	 * 마우스를 누르고 때 커서 위치)
	 */
	@Override
	public void mouseDragged(MouseEvent e) {
		Point p = this.frame.getLocation();
		this.frame.setLocation(p.x + (e.getX() - origin.x), p.y + (e.getY() - origin.y));
	}

	@Override
	public void mouseMoved(MouseEvent e) {
	}

}
