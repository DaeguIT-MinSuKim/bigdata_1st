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
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.event.MouseInputListener;

import kr.or.dgit.bigdata.diet.dto.Member;
import kr.or.dgit.bigdata.diet.service.MemberService;

public class SignupUI extends JFrame {

	private Container contentPane;
	private JTextField tf_no;
	private JTextField tf_name;
	private JTextField tf_gender;
	private JTextField tf_weight;
	private JTextField tf_age;
	private JTextField tf_phone;
	private JTextField tf_location;
	private JTextField tf_budg;

	private static MemberService memberService;  //db 서비스 인스턴스

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
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
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
		
		JLabel label = new JLabel("회원번호");
		label.setHorizontalAlignment(SwingConstants.RIGHT);
		label.setFont(new Font("서울남산체 M", Font.PLAIN, 20));
		label.setBounds(154, 175, 76, 21);
		signPanel.add(label);
		
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
		tf_no.setEditable(false);
		tf_no.setEnabled(false);
		tf_no.setBounds(263, 176, 135, 21);
		signPanel.add(tf_no);
		tf_no.setColumns(10);
		
		tf_name = new JTextField();
		tf_name.setColumns(10);
		tf_name.setBounds(263, 218, 135, 21);
		signPanel.add(tf_name);
		
		tf_gender = new JTextField();
		tf_gender.setColumns(10);
		tf_gender.setBounds(263, 258, 135, 21);
		signPanel.add(tf_gender);
		
		tf_weight = new JTextField();
		tf_weight.setColumns(10);
		tf_weight.setBounds(263, 299, 135, 21);
		signPanel.add(tf_weight);
		
		tf_age = new JTextField();
		tf_age.setColumns(10);
		tf_age.setBounds(263, 340, 135, 21);
		signPanel.add(tf_age);
		
		tf_phone = new JTextField();
		tf_phone.setColumns(10);
		tf_phone.setBounds(263, 380, 135, 21);
		signPanel.add(tf_phone);
		
		tf_location = new JTextField();
		tf_location.setColumns(10);
		tf_location.setBounds(263, 420, 135, 21);
		signPanel.add(tf_location);
		
		tf_budg = new JTextField();
		tf_budg.setColumns(10);
		tf_budg.setBounds(263, 458, 135, 21);
		signPanel.add(tf_budg);
		
		JButton btnNewButton = new JButton("");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				Member mem = new Member(1,tf_name.getText(),tf_gender.getText(),
						Integer.parseInt(tf_weight.getText()),Integer.parseInt(tf_age.getText()),
						tf_phone.getText(),tf_location.getText(),Integer.parseInt(tf_budg.getText())				
						);
				memberService = MemberService.getInstance();
				int rs = memberService.insertMember(mem);	
				//???
				if(rs != 0)	JOptionPane.showMessageDialog(null, "정상적으로 가입되었습니다.");
				
				tf_no.setText("");
				tf_name.setText("");
				tf_gender.setText("");
				tf_weight.setText("");
				tf_age.setText("");
				tf_phone.setText("");
				tf_location.setText("");
				tf_budg.setText("");
				
			}
		});
		btnNewButton.setBackground(Color.WHITE);
		btnNewButton.setFont(new Font("나눔바른고딕", Font.BOLD, 16));
		btnNewButton.setForeground(Color.BLACK);
		btnNewButton.setIcon(new ImageIcon("images\\signup.png"));
		btnNewButton.setBounds(122, 535, 108, 116);
		btnNewButton.setBorder(null);
		signPanel.add(btnNewButton);
		setSize(500,700);
		
		//마우스 이벤트 처리 클래스
		MouseEventListener2 mouseListener = new MouseEventListener2(this);
		addMouseListener(mouseListener);
		addMouseMotionListener(mouseListener);
		
		
		//setUndecorated(true);        //상태줄 없애기
		setLocationRelativeTo(null); //중앙 위치토록 함수 호출
		
		setLocationRelativeTo(null); //중앙 위치토록 함수 호출
		setVisible(true);
	}
}

class SignPanel extends JPanel{
	ImageIcon SignBgIcon = new ImageIcon("images/signup_image.jpg");
	Image SignBgImg = SignBgIcon.getImage();
	
	public void paintComponent(Graphics g){
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
  public void mouseClicked(MouseEvent e) {}

    /**
     * 기록 마우스 눌렀을 때 시
     */
    @Override
    public void mousePressed(MouseEvent e) {
         origin.x = e.getX();  
         origin.y = e.getY();
    }

    @Override
    public void mouseReleased(MouseEvent e) {}

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
     * 마우스 캡션 표시줄 拖拽 때 설정 창 좌표 위치
     * 창 새 좌표 위치 = 전에 좌표 이동 위치 + (마우스 포인터 현재 좌표 - 마우스를 누르고 때 커서 위치)
    */
    @Override
    public void mouseDragged(MouseEvent e) {
        Point p = this.frame.getLocation();
        this.frame.setLocation(
            p.x + (e.getX() - origin.x), 
            p.y + (e.getY() - origin.y));  
    }

    @Override
    public void mouseMoved(MouseEvent e) {}
    
}
