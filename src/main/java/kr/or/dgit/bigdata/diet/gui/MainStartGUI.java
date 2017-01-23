package kr.or.dgit.bigdata.diet.gui;

import java.awt.AWTException;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Cursor;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.MenuItem;
import java.awt.Point;
import java.awt.PopupMenu;
import java.awt.SystemTray;
import java.awt.Toolkit;
import java.awt.TrayIcon;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.UnknownHostException;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
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
	private JButton btnCreateList;
	private JButton btnCreateMenu;
	private MemberService memberService;		//db연결
	private ArrayList<Member> memberList;			//회원 명부
	private bgPanel panel;

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

	public MainStartGUI() {
		setTitle("다이어트식단프로그램");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		contentPane = getContentPane();
		panel = new bgPanel();
				
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		//이미지 아이콘
		ImageIcon[] origin = new ImageIcon[12];
		Image[] originImg = new Image[12];
		Image[] changeImg = new Image[12];
		ImageIcon[] change = new ImageIcon[12];
		
		//이미지 아이콘 생성 메소드
		createImages(origin, originImg, changeImg, change);
		
		btnSignup = new JButton("");
		btnSignupGroup = new JButton("");
		btnCreateList = new JButton("");
		btnCreateMenu = new JButton("");
		
		btnSignup.setBounds(150, 180, 120, 120);
		btnSignupGroup.setBounds(280, 180, 120, 120);
		btnCreateList.setBounds(410, 180, 120, 120);
		btnCreateMenu.setBounds(540, 180, 120, 120);
		
		btnSignup.setIcon(change[0]);
		btnSignup.setPressedIcon(change[1]);
		btnSignup.setRolloverIcon(change[2]);
		
		btnSignupGroup.setIcon(change[3]);
		btnSignupGroup.setPressedIcon(change[4]);
		btnSignupGroup.setRolloverIcon(change[5]);
		
		btnCreateList.setIcon(change[6]);
		btnCreateList.setPressedIcon(change[7]);
		btnCreateList.setRolloverIcon(change[8]);
		
		btnCreateMenu.setIcon(change[9]);
		btnCreateMenu.setPressedIcon(change[10]);
		btnCreateMenu.setRolloverIcon(change[11]);
		
		//공통 버튼 메소드 호출
		settingSameBtn(btnSignup, btnSignupGroup, btnCreateList, btnCreateMenu);
		
		//라벨
		JLabel lblSignup = new JLabel("회원등록");
		lblSignup.setHorizontalAlignment(SwingConstants.CENTER);
		lblSignup.setFont(new Font("맑은 고딕", Font.PLAIN, 20));
		lblSignup.setBounds(150, 310, 120, 20);
		panel.add(lblSignup);
		
		JLabel lblGroupSignup = new JLabel("단체회원등록");
		lblGroupSignup.setHorizontalAlignment(SwingConstants.CENTER);
		lblGroupSignup.setFont(new Font("맑은 고딕", Font.PLAIN, 20));
		lblGroupSignup.setBounds(281, 310, 120, 20);
		panel.add(lblGroupSignup);
		
		JLabel lblSearch = new JLabel("식단생성");
		lblSearch.setHorizontalAlignment(SwingConstants.CENTER);
		lblSearch.setFont(new Font("맑은 고딕", Font.PLAIN, 20));
		lblSearch.setBounds(410, 310, 120, 20);
		panel.add(lblSearch);
		
		JLabel lblDiet = new JLabel("메뉴추가");
		lblDiet.setHorizontalAlignment(SwingConstants.CENTER);
		lblDiet.setFont(new Font("맑은 고딕", Font.PLAIN, 20));
		lblDiet.setBounds(542, 310, 120, 20);
		panel.add(lblDiet);
		
		setResizable(false); //사이즈 조정 불가
		setSize(800, 600);
		setVisible(true);
		setLocationRelativeTo(null); //중앙 위치토록 함수 호출
		
///////////마우스 이벤트 처리 클래스
		 MouseEventListener mouseListener = new MouseEventListener(this);
		 addMouseListener(mouseListener);
		 addMouseMotionListener(mouseListener);
		 
///////////윈도우 최소화 경우 트레이 이벤트 처리 		 
		 addWindowListener(new WindowListener() {
			    public void windowOpened(WindowEvent e) {
			    }
			    public void windowClosing(WindowEvent e) {
			    }
			    public void windowClosed(WindowEvent e) {
			    }
			    public void windowIconified(WindowEvent e) {
			       setVisible(false);
			       displayTrayIcon();
			    }
			    private void displayTrayIcon() {
					
			    	final TrayIcon trayIcon;
			        if (SystemTray.isSupported()) {
			           final SystemTray tray = SystemTray.getSystemTray();
			           ImageIcon image = new ImageIcon(getClass().getClassLoader().getResource("images/info.png"));

			           MouseListener mouseListener = new MouseListener() {
			              public void mouseClicked(MouseEvent e) {
			                 System.out.println("Tray Icon - Mouse clicked!");
			                 
			              }
			              public void mouseReleased(MouseEvent e) {
			                 System.out.println("Tray Icon - Mouse released!");
			              }
			              public void mouseEntered(MouseEvent e) {
			                 System.out.println("Tray Icon - Mouse entered!");
			              }
			              public void mouseExited(MouseEvent e) {
			                 System.out.println("Tray Icon - Mouse exited!");
			              }
			              
			              public void mousePressed(MouseEvent e) {
			                 if (e.getClickCount() == 2) {
			                                   
			                    tray.remove(tray.getTrayIcons()[0]);
			                    setVisible(true);
			                    setExtendedState(JFrame.NORMAL);
			                    //setAlwaysOnTop(true);
			                 }else System.out.println("Tray Icon - Mouse Pressed!");
			                 
			              }            
			           };
			           
			           ActionListener exitListener = new ActionListener() {
			              public void actionPerformed(ActionEvent e) {
			                 //System.out.println("Exiting...");
			                 System.exit(0);
			              }
			           };
			           PopupMenu popup = new PopupMenu();
			           MenuItem defaultItem = new MenuItem("Exit");
			           defaultItem.addActionListener(exitListener);
			           popup.add(defaultItem);
			           trayIcon = new TrayIcon(image.getImage(), "Tray Demo", popup);
			           /*ActionListener actionListener = new ActionListener() {
			              public void actionPerformed(ActionEvent e) {
			                 trayIcon.displayMessage("Action Event", "An Action Event Has Been Peformed!",
			                       TrayIcon.MessageType.INFO);
			              }
			           };*/

			           trayIcon.setImageAutoSize(true);
			           //trayIcon.addActionListener(actionListener);
			           trayIcon.addMouseListener(mouseListener);

			           try {
			              tray.add(trayIcon);
			           } catch (AWTException e) {
			              System.err.println("TrayIcon could not be added.");
			           }
			        } else {
			           System.err.println("System tray is currently not supported.");
			        }

				}
				public void windowDeiconified(WindowEvent e) {
			    }
			    public void windowActivated(WindowEvent e) {
			       System.out.println("windowActivated");
			    }
			    public void windowDeactivated(WindowEvent e) {
			    }
			 });
	}

	//버튼에 넣을 이미지 아이콘 생성
	private void createImages(ImageIcon[] origin, Image[] originImg, Image[] changeImg, ImageIcon[] change) {
		String[] imgNames = new String[]{
				"pictogram/icon_userinput1.png","pictogram/icon_userinput2.png","pictogram/icon_userinput3.png",
				"pictogram/icon_alluserinput1.png","pictogram/icon_alluserinput2.png","pictogram/icon_alluserinput3.png",
				"pictogram/icon_listcreate1.png", "pictogram/icon_listcreate2.png", "pictogram/icon_listcreate3.png",
				"pictogram/icon_menuadd1.png", "pictogram/icon_menuadd2.png", "pictogram/icon_menuadd3.png",
		};
		//[0, 1, 2]	[3, 4, 5] [6, 7, 8] [9, 10, 11]
		for (int i = 0; i < 12; i++) {
			origin[i] = new ImageIcon(getClass().getClassLoader().getResource(imgNames[i]));
			originImg[i] = origin[i].getImage();
			changeImg[i] = originImg[i].getScaledInstance(120, 120, Image.SCALE_SMOOTH);
			change[i] = new ImageIcon(changeImg[i]);
		}
		//클릭하면 이미지가 조금 작아지도록
		changeImg[1] = originImg[1].getScaledInstance(110, 110, Image.SCALE_SMOOTH);
		changeImg[4] = originImg[4].getScaledInstance(110, 110, Image.SCALE_SMOOTH);
		changeImg[7] = originImg[7].getScaledInstance(110, 110, Image.SCALE_SMOOTH);
	}

	//버튼 세팅 메소드
	private void settingSameBtn(JButton ...button) {
		for (JButton jButton : button) {
			jButton.setFocusable(false);
			jButton.setBorder(null);
			jButton.setBackground(Color.WHITE);
			jButton.addActionListener(this);
			jButton.setBorderPainted(false);
			jButton.setFocusPainted(false);
			jButton.setContentAreaFilled(false);
			panel.add(jButton);
		}
	}
	
///////////////////////////////////////
/////////////이벤트 처리 ///////////////////
	
	

	@Override
	public void actionPerformed(ActionEvent e) {
		
//////////회원등록
		if(e.getSource() == btnSignup ){
			
			new SignUpAndUpdateGUI().setVisible(true);
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
		if(e.getSource() == btnCreateList ){
			//MemberService객체 얻어오기
			memberService = MemberService.getInstance();
			
			//모든 member객체 가져오기
			memberList = memberService.selectAllMember();
			
			//등록된 회원이 없으면 창 띄우지 못하게 함
			if (memberList.size() == 0) {
				JOptionPane.showMessageDialog(null,"등록된 회원이 없습니다.");
				return;
			}else{
				new MemberCheckGUI().setVisible(true);
			}
			
		}
		
//////////식단 짜기
		if(e.getSource() == btnCreateMenu ){
			MenuManagerGUI mmgui = new MenuManagerGUI();
			mmgui.setVisible(true);
		}
	}

}


////////그림 패널//////////////
class bgPanel extends JPanel{
	ImageIcon bgIcon = new ImageIcon(getClass().getClassLoader().getResource("images/healthy_food (7).jpg"));
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

