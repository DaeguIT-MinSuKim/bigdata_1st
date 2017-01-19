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
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.event.MouseInputListener;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;

import kr.or.dgit.bigdata.diet.dto.Member;
import kr.or.dgit.bigdata.diet.dto.Menu;
import kr.or.dgit.bigdata.diet.middle.MonthMenu;
import kr.or.dgit.bigdata.diet.middle.OneDayMenu;
import kr.or.dgit.bigdata.diet.service.MemberService;
import kr.or.dgit.bigdata.diet.util.PrnMenu;


public class MainStartGUI extends JFrame implements ActionListener {

	private Container contentPane;
	private JButton btnSignup;
	private JButton btnSignupGroup;
	private JButton btnSearch;
	private JButton btnMakePlan;
	private JButton btnprn;
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
		
		//이미지 아이콘
		ImageIcon originSignUp = new ImageIcon("pictogram/signup.png");
		Image originSignUpImg = originSignUp.getImage();
		Image changeSignUpImg = originSignUpImg.getScaledInstance(100, 100, Image.SCALE_SMOOTH);
		ImageIcon changeSignUp = new ImageIcon(changeSignUpImg);
		ImageIcon originSignUp2 = new ImageIcon("pictogram/signup2.png");
		Image originSignUpImg2 = originSignUp2.getImage();
		Image changeSignUpImg2 = originSignUpImg2.getScaledInstance(90, 90, Image.SCALE_SMOOTH);
		ImageIcon changeSignUp2 = new ImageIcon(changeSignUpImg2);
		ImageIcon originSignUp3 = new ImageIcon("pictogram/signup3.png");
		Image originSignUpImg3 = originSignUp3.getImage();
		Image changeSignUpImg3 = originSignUpImg3.getScaledInstance(100, 100, Image.SCALE_SMOOTH);
		ImageIcon changeSignUp3 = new ImageIcon(changeSignUpImg3);
		
		ImageIcon originGroupSignUp = new ImageIcon("pictogram/group.png");
		Image originGroupSignUpImg = originGroupSignUp.getImage();
		Image changeGroupSignUpImg = originGroupSignUpImg.getScaledInstance(100, 100, Image.SCALE_SMOOTH);
		ImageIcon changeGroupSignUp = new ImageIcon(changeGroupSignUpImg);
		ImageIcon originGroupSignUp2 = new ImageIcon("pictogram/group2.png");
		Image originGroupSignUpImg2 = originGroupSignUp2.getImage();
		Image changeGroupSignUpImg2 = originGroupSignUpImg2.getScaledInstance(90, 90, Image.SCALE_SMOOTH);
		ImageIcon changeGroupSignUp2 = new ImageIcon(changeGroupSignUpImg2);
		ImageIcon originGroupSignUp3 = new ImageIcon("pictogram/group3.png");
		Image originGroupSignUpImg3 = originGroupSignUp3.getImage();
		Image changeGroupSignUpImg3 = originGroupSignUpImg3.getScaledInstance(100, 100, Image.SCALE_SMOOTH);
		ImageIcon changeGroupSignUp3 = new ImageIcon(changeGroupSignUpImg3);
		
		ImageIcon originSearch = new ImageIcon("pictogram/search.png");
		Image originSearchImg = originSearch.getImage();
		Image changeSearchImg = originSearchImg.getScaledInstance(100, 100, Image.SCALE_SMOOTH);
		ImageIcon changeSearch = new ImageIcon(changeSearchImg);
		ImageIcon originSearch2 = new ImageIcon("pictogram/search2.png");
		Image originSearchImg2 = originSearch2.getImage();
		Image changeSearchImg2 = originSearchImg2.getScaledInstance(90, 90, Image.SCALE_SMOOTH);
		ImageIcon changeSearch2 = new ImageIcon(changeSearchImg2);
		ImageIcon originSearch3 = new ImageIcon("pictogram/search3.png");
		Image originSearchImg3 = originSearch3.getImage();
		Image changeSearchImg3 = originSearchImg3.getScaledInstance(100, 100, Image.SCALE_SMOOTH);
		ImageIcon changeSearch3 = new ImageIcon(changeSearchImg3);
		
		ImageIcon originDiet = new ImageIcon("pictogram/diet.png");
		Image originDietImg = originDiet.getImage();
		Image changeDietImg = originDietImg.getScaledInstance(100, 100, Image.SCALE_SMOOTH);
		ImageIcon changeDiet = new ImageIcon(changeDietImg);		
		ImageIcon originDiet2 = new ImageIcon("pictogram/diet2.png");
		Image originDietImg2 = originDiet2.getImage();
		Image changeDietImg2 = originDietImg2.getScaledInstance(90, 90, Image.SCALE_SMOOTH);
		ImageIcon changeDiet2 = new ImageIcon(changeDietImg2);
		ImageIcon originDiet3 = new ImageIcon("pictogram/diet3.png");
		Image originDietImg3 = originDiet3.getImage();
		Image changeDietImg3 = originDietImg3.getScaledInstance(100, 100, Image.SCALE_SMOOTH);
		ImageIcon changeDiet3 = new ImageIcon(changeDietImg3);
		
		
		
		btnSignup = new JButton("");
		btnSignup.setFocusable(false);
		btnSignup.setBorder(null);
		btnSignup.setBackground(Color.WHITE);
		btnSignup.addActionListener(this);
		btnSignup.setBounds(150, 180, 120, 120);
		btnSignup.setBorderPainted(false);
        btnSignup.setFocusPainted(false);
        btnSignup.setContentAreaFilled(false);
		btnSignup.setIcon(changeSignUp);
		btnSignup.setPressedIcon(changeSignUp2);
		btnSignup.setRolloverIcon(changeSignUp3);
		panel.add(btnSignup);
		
		btnSignupGroup = new JButton("");
		btnSignupGroup.addActionListener(this);
		btnSignupGroup.setFocusable(false);
		btnSignupGroup.setBorder(null);
		btnSignupGroup.setBackground(Color.WHITE);
		btnSignupGroup.setBounds(280, 180, 120, 120);
		btnSignupGroup.setBorderPainted(false);
        btnSignupGroup.setFocusPainted(false);
        btnSignupGroup.setContentAreaFilled(false);
		btnSignupGroup.setIcon(changeGroupSignUp);
		btnSignupGroup.setPressedIcon(changeGroupSignUp2);
		btnSignupGroup.setRolloverIcon(changeGroupSignUp3);
		panel.add(btnSignupGroup);
		
		btnSearch = new JButton("");
		btnSearch.addActionListener(this);
		btnSearch.setFocusable(false);
		btnSearch.setBorder(null);
		btnSearch.setBackground(Color.WHITE);
		btnSearch.setBounds(410, 180, 120, 120);
		btnSearch.setBorderPainted(false);
        btnSearch.setFocusPainted(false);
        btnSearch.setContentAreaFilled(false);
		btnSearch.setIcon(changeSearch);
		btnSearch.setPressedIcon(changeSearch2);
		btnSearch.setRolloverIcon(changeSearch3);
		panel.add(btnSearch);
		
		btnMakePlan = new JButton("");
		btnMakePlan.addActionListener(this);
		btnMakePlan.setFocusable(false);
		btnMakePlan.setBorder(null);
		btnMakePlan.setBackground(Color.WHITE);
		btnMakePlan.setBounds(540, 180, 120, 120);
		btnMakePlan.setBorderPainted(false);
        btnMakePlan.setFocusPainted(false);
        btnMakePlan.setContentAreaFilled(false);
		btnMakePlan.setIcon(changeDiet);
		btnMakePlan.setPressedIcon(changeDiet2);
		btnMakePlan.setRolloverIcon(changeDiet3);
		panel.add(btnMakePlan);
		
		//라벨
		
		JLabel lblSignup = new JLabel("회원등록");
		lblSignup.setHorizontalAlignment(SwingConstants.CENTER);
		lblSignup.setFont(new Font("10X10", Font.PLAIN, 20));
		lblSignup.setBounds(150, 310, 120, 20);
		panel.add(lblSignup);
		
		JLabel lblGroupSignup = new JLabel("단체회원등록");
		lblGroupSignup.setHorizontalAlignment(SwingConstants.CENTER);
		lblGroupSignup.setFont(new Font("10X10", Font.PLAIN, 20));
		lblGroupSignup.setBounds(280, 310, 120, 20);
		panel.add(lblGroupSignup);
		
		JLabel lblSearch = new JLabel("회원검색");
		lblSearch.setHorizontalAlignment(SwingConstants.CENTER);
		lblSearch.setFont(new Font("10X10", Font.PLAIN, 20));
		lblSearch.setBounds(410, 310, 120, 20);
		panel.add(lblSearch);
		
		JLabel lblDiet = new JLabel("식단추가");
		lblDiet.setHorizontalAlignment(SwingConstants.CENTER);
		lblDiet.setFont(new Font("10X10", Font.PLAIN, 20));
		lblDiet.setBounds(535, 310, 120, 20);
		panel.add(lblDiet);
		
		btnprn = new JButton("출력");
		btnprn.addActionListener(this);
		btnprn.setBounds(614, 374, 97, 23);
		panel.add(btnprn);
		
		setResizable(false);
		setSize(800, 600);
		setVisible(true);
		
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
			
			new SignupUI();
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
	
			new MemberCheckGUI().setVisible(true);
		}
		
//////////식단 짜기
		if(e.getSource() == btnMakePlan ){
			
			MenuManagerGUI mmgui = new MenuManagerGUI();
			mmgui.setVisible(true);
			
		}
		
/////////////////////jasper report 띄우기 //////////////////////////////////////////////////////////////////////		
		if(e.getSource() == btnprn ){
			//PrnMenu test = new PrnMenu(getRows());
			
			
		}
		
	}

	private String[][] getRows() {
		MonthMenu monthMenu = new MonthMenu(2100, 950000);    ///new MonthMenu(2000, 760000);
		ArrayList<OneDayMenu> list = monthMenu.monthMenuList;
		
		String[][] rowDatas = new String[monthMenu.count][];
		//ArrayList<String[]> temp = new ArrayList<>();
		//rowDatas[i] = temp.get(i).toArray();
		
		//System.out.println("한달리스트 사이즈 : " + list.size());
		int ttt=-1;
		for (int i = 0; i < list.size(); i++) {     //30일분..
			
			//하루치 가져오기
			ArrayList<Menu> templistoneday = list.get(i).menuList;

			for(int j=0;j<templistoneday.size();j++){
				int quo = templistoneday.size() / 3; // (하루치 메뉴 개수 / 아침,점심,저녁)
				int rem = templistoneday.size() % 3; // (하루치 메뉴 개수 / 아침,점심,저녁)의
														// 나머지 개수
				String str = ""; // 아침 점심 저녁을 저장할 변수

				/*
				 * 6만약 메뉴 개수가 7개일 때 몫 = 2, 나머지 =1 
				 * 아침 2개, 점심 3개, 저녁 2개 
				 * 아침 = 1, 2
				 * 점심 = 2, 3, 4 
				 * 저녁 = 5, 6 
				 */
				if (j < quo) {
					str = "아침";
				} else if (j < (quo + quo + rem)) {
					str = "점심";
				} else if (j < (quo + quo + quo + rem)) {
					str = "저녁";
				}

				ttt++;
				
				   //"번호","일자","식사","항목", "메뉴", "칼로리(cal)", "지방", "탄수화물", "단백질", "비용"
				rowDatas[ttt] = new String[]{
						(ttt+1)+"",
						(i+1)+"",
						str,
						templistoneday.get(j).getGrp()+ "",
						templistoneday.get(j).getItem()+ "",
						templistoneday.get(j).getCal()+ "",
						templistoneday.get(j).getFat()+ "",
						templistoneday.get(j).getCarbo() +"",
						templistoneday.get(j).getProtein() +"",
						templistoneday.get(j).getCost() +""};
				//
				//rowDatas[ttt] = templistoneday.get(j).toArray();
					
			}
		}
		//System.out.println(ttt);
		return rowDatas;

	}
}


////////그림 패널//////////////
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
