package kr.or.dgit.bigdata.diet.gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Cursor;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Point;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JEditorPane;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.event.MouseInputListener;
import javax.swing.filechooser.FileNameExtensionFilter;

import kr.or.dgit.bigdata.diet.dto.Member;
import kr.or.dgit.bigdata.diet.service.MemberService;


public class MainStartGUI extends JFrame implements ActionListener {

	private Container contentPane;
	private JButton btnSignup;
	private JButton btnSignupGroup;
	private JButton btnSearch;
	private JButton btnMakePlan;
	private static MemberService memberService;		//db연결
	private ArrayList<Member> memberList;			//회원 명부


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainStartGUI frame = new MainStartGUI();
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
	public MainStartGUI() {
		setTitle("다이어트식단프로그램");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		contentPane = getContentPane();
		bgPanel panel = new bgPanel();
				
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		btnSignup = new JButton("회원등록");
		btnSignup.setBackground(SystemColor.info);
		btnSignup.addActionListener(this);
		btnSignup.setBounds(530, 196, 135, 31);
		panel.add(btnSignup);
		
		btnSignupGroup = new JButton("단체회원등록");
		btnSignupGroup.addActionListener(this);
		btnSignupGroup.setBackground(new Color(255, 127, 80));
		btnSignupGroup.setBounds(530, 229, 135, 31);
		panel.add(btnSignupGroup);
		
		btnSearch = new JButton("회원검색");
		btnSearch.addActionListener(this);
		btnSearch.setBackground(new Color(100, 149, 237));
		btnSearch.setBounds(530, 263, 135, 31);
		panel.add(btnSearch);
		
		btnMakePlan = new JButton("식단생성");
		btnMakePlan.addActionListener(this);
		btnMakePlan.setBackground(new Color(255, 215, 0));
		btnMakePlan.setBounds(530, 297, 135, 31);
		panel.add(btnMakePlan);
		setSize(800, 600);
		
///////////마우스 이벤트 처리 클래스
		 MouseEventListener mouseListener = new MouseEventListener(this);
		 addMouseListener(mouseListener);
		 addMouseMotionListener(mouseListener);
		
		//GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();  //풀 스크린
		//GraphicsDevice gd = ge.getDefaultScreenDevice();							   //풀 스크린
		//gd.setFullScreenWindow(this);
		
		//setUndecorated(true);        //상태줄 없애기
		setLocationRelativeTo(null); //중앙 위치토록 함수 호출
		setVisible(true);
	}

	
///////////////////////////////////////
/////////////이벤트 처리 ///////////////////
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
//////////회원등록
		if(e.getSource() == btnSignup ){
			
			(new SignupUI()).setVisible(true);;
		}
		
//////////그룹 등록
		if(e.getSource() == btnSignupGroup ){
			File fileName=null;
			JFileChooser chooser = new JFileChooser();
			
			FileNameExtensionFilter filter
			   = new FileNameExtensionFilter("회원리스트 엑셀 파일(csv)", "csv"); //description,......확장자					
			chooser.setFileFilter(filter);						//필터 셋팅
			int returnVal = chooser.showOpenDialog(null);
			
			if(returnVal == JFileChooser.APPROVE_OPTION) {
				String s;
				fileName = chooser.getSelectedFile();
				BufferedReader in;
				try {
					in = new BufferedReader(new FileReader(fileName));
					while ((s = in.readLine()) != null) {
						
						System.out.println(s);

						// db연결 및 member 리스트  저장
						String[] temp = s.split(",");
						Member mem = new Member(
								1,temp[1],temp[2],Integer.parseInt(temp[3]),
								Integer.parseInt(temp[4]),temp[5],temp[6],Integer.parseInt(temp[7]));
								
						memberService = MemberService.getInstance();
						memberService.insertMember(mem);	
						
					}
					in.close();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
				
			}	
		}
		
//////////회원찾기
		if(e.getSource() == btnSearch ){
	
			new SearchUI();
		}
		
//////////식단 짜기
		if(e.getSource() == btnMakePlan ){
			System.out.println("menuUI");
			JFrame temp =  new JFrame();
			JEditorPane edPane = new JEditorPane();
			edPane.setEditable(false);
			edPane.setContentType("text/html");
			edPane.setText("<html><p style='font-size: 36pt;'>보미씨 바보</P></html>");			
			temp.add(edPane);
			temp.setSize(300, 300);
			temp.setVisible(true);
		}
	}
}


//////////////////////
class bgPanel extends JPanel{
	ImageIcon bgIcon = new ImageIcon("images/healthy_food (7).jpg");
	Image bgImg = bgIcon.getImage();
	
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		
		g.drawImage(bgImg, 0, 0, getWidth(), getHeight(), this);
	}
}


//화면 이동 마우스 이벤트
//////////////////
class MouseEventListener implements MouseInputListener {
         
         Point origin;

         MainStartGUI frame;
         
         public MouseEventListener(MainStartGUI frame) {
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


