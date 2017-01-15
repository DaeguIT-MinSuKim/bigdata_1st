package kr.or.dgit.bigdata.diet.gui;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JEditorPane;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.text.Document;
import javax.swing.text.html.HTMLEditorKit;
import javax.swing.text.html.StyleSheet;

import kr.or.dgit.bigdata.diet.dto.Calorie;
import kr.or.dgit.bigdata.diet.dto.Member;
import kr.or.dgit.bigdata.diet.service.CalorieService;
import kr.or.dgit.bigdata.diet.service.MemberService;

public class MenuListGUI extends JFrame {

	private Container contentPane;
	private JTextField tfNo;
	private JTextField tfAge;
	private JTextField tfGender;
	private JTextField tfCal;
	private JTextField tfAvgBudget;
	private JTextField tfTotalBudget;
	private JButton btnCVS;
	private JButton btnReturn;
	private JTextField tfName_1;
	
	
	//
	private String day;
	private String time;
	private String sort;
	private String menu;
	private String cal;
	private String fat;
	private String carb;
	private String protein;
	private String cost;
	private static Member member; //회원받아옴
/*
	*//**
	 * Launch the application.
	 *//*
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MenuListGUI frame = new MenuListGUI(member);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
*/
	/**
	 * Create the frame.
	 */
	public MenuListGUI(Member member) {
		setTitle("식단생성");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 1400, 800);
		contentPane = getContentPane();
		
		
		
		 // jeditorpane 만들긔
        JEditorPane jEditorPane = new JEditorPane();
        
        // read-only 만들긔
        jEditorPane.setEditable(false);
        
        // scrollpane 만들어서 jeditorpane 달긔
        JScrollPane scrollPane = new JScrollPane(jEditorPane);
        
        // html editor kit 추가시킴
        HTMLEditorKit kit = new HTMLEditorKit();
        jEditorPane.setEditorKit(kit);
        
        // css 적용
        StyleSheet styleSheet = kit.getStyleSheet();
        styleSheet.addRule("body {color:#000; font-family:나눔바른고딕 Light; margin: 4px; height: 400px;}");
        styleSheet.addRule("table {font-size: 12px; border: 0px; border-collapse: collapse;"
        				+ "width: 900px; text-align: center; border-spacing:0px;}");
        
        styleSheet.addRule("tr {border: 1px solid black; border-spacing:0px;}");
        styleSheet.addRule("td {border: 1px solid black; border-spacing:0px;}");
        
        // html 문장 만들긔
        String htmlString = "<html>\n"
                          + "<body>\n"
                          + "<table>\n"
                          
                          + "<tr>\n"
                          + "<td>일자</td>\n"
                          + "<td>식사시간</td>\n"
                          + "<td>항목</td>\n"
                          + "<td>메뉴</td>\n"
                          + "<td>칼로리(Cal)</td>\n"
                          + "<td>지방</td>\n"
                          + "<td>탄수화물</td>\n"
                          + "<td>단백질</td>\n"
                          + "<td>비용</td>\n"
                          + "</tr>\n"
                          
						  + "<tr>\n"
						  + "<td>ex)" + day + "+</td>\n"
						  + "<td>" + time + "</td>\n"
						  + "<td>" + sort + "</td>\n"
						  + "<td>" + menu + "</td>\n"
						  + "<td>" + cal + "</td>\n"
						  + "<td>" + fat + "</td>\n"
						  + "<td>" + carb + "</td>\n"
						  + "<td>" + protein + "</td>\n"
						  + "<td>" + cost + "</td>\n"
						  + "</tr>\n"
                          
						  + "</table>\n"
                          + "</body>\n";
        
        // create a document, set it on the jeditorpane, then add the html
        Document doc = kit.createDefaultDocument();
        getContentPane().setLayout(null);
        
        jEditorPane.setDocument(doc);
        jEditorPane.setText(htmlString);
        
        JPanel pnlTop = new JPanel();
        pnlTop.setBounds(0, 104, 1384, 31);
        getContentPane().add(pnlTop);
        
        JLabel lblNo = new JLabel("회원번호");
        pnlTop.add(lblNo);
        
        tfNo = new JTextField();
        tfNo.setText(member.getNo()+"");
        tfNo.setEnabled(false);
        pnlTop.add(tfNo);
        tfNo.setColumns(10);
        
        JLabel lblAge = new JLabel("나이");
        pnlTop.add(lblAge);
        
        tfAge = new JTextField(member.getAge());
        tfAge.setText(member.getAge()+"");
        tfAge.setEnabled(false);
        tfAge.setColumns(10);
        pnlTop.add(tfAge);
        
        JLabel lblGender = new JLabel("성별");
        pnlTop.add(lblGender);
        
        tfGender = new JTextField();
        tfGender.setText(member.getGender());
        tfGender.setEnabled(false);
        tfGender.setColumns(10);
        pnlTop.add(tfGender);
        
        JLabel lblCal = new JLabel("1일 권장칼로리");
        pnlTop.add(lblCal);
        
        //회원의 나이에 맞는 1일 권장 칼로리 가져오기
        tfCal = new JTextField();
        Calorie cal = CalorieService.getInstance().selectCalorieByAgeNo(member);
        tfCal.setText(member.getGender().equals("여자") ? cal.getCalWoman()+"" : cal.getCalMan()+"");
        tfCal.setEnabled(false);
        tfCal.setColumns(10);
        pnlTop.add(tfCal);
        
        
        
        
        //패널에 달긔
        JPanel pnlMiddle = new JPanel();
        pnlMiddle.setBounds(0, 231, 1384, 410);
        contentPane.add(pnlMiddle);
        pnlMiddle.add(scrollPane,BorderLayout.CENTER);
        
        JScrollBar scrollBar = new JScrollBar();
        scrollPane.setRowHeaderView(scrollBar);
        
        JPanel pnlBottom = new JPanel();
        pnlBottom.setBounds(0, 651, 1384, 31);
        getContentPane().add(pnlBottom);
        
        JLabel lblAvgBudget = new JLabel("1일 평균소비금액 : ");
        pnlBottom.add(lblAvgBudget);
        
        tfAvgBudget = new JTextField();
        pnlBottom.add(tfAvgBudget);
        tfAvgBudget.setColumns(10);
        
        JLabel lblTotalBudget = new JLabel("월 총 경비 : ");
        pnlBottom.add(lblTotalBudget);
        
        tfTotalBudget = new JTextField();
        tfTotalBudget.setColumns(10);
        pnlBottom.add(tfTotalBudget);
        
        btnCVS = new JButton("CVS 저장");
        btnCVS.setBounds(1166, 692, 97, 23);
        getContentPane().add(btnCVS);
        
        btnReturn = new JButton("돌아가기");
        btnReturn.setBounds(1275, 692, 97, 23);
        getContentPane().add(btnReturn);
        
        tfName_1 = new JTextField();
        tfName_1.setFont(new Font("나눔바른고딕", Font.PLAIN, 20));
        tfName_1.setHorizontalAlignment(SwingConstants.RIGHT);
        tfName_1.setText(member.getName());
        tfName_1.setBounds(505, 172, 100, 30);
        getContentPane().add(tfName_1);
        tfName_1.setColumns(10);
        
        JLabel lblMenu = new JLabel("회원의 추천 식단");
        lblMenu.setFont(new Font("나눔바른고딕", Font.PLAIN, 20));
        lblMenu.setBounds(617, 172, 150, 30);
        getContentPane().add(lblMenu);
	}
}
