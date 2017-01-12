package kr.or.dgit.bigdata.diet.gui;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.EventQueue;

import javax.swing.JEditorPane;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.text.Document;
import javax.swing.text.html.HTMLEditorKit;
import javax.swing.text.html.StyleSheet;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JScrollBar;

public class MenuListGUI extends JFrame {

	private Container contentPane;
	private JTextField tfName;
	private JTextField tfAge;
	private JTextField tfGender;
	private JTextField tfCal;
	private JTextField tfAvgBudget;
	private JTextField tfTotalBudget;
	private JButton btnCVS;
	private JButton btnReturn;
	private JTextField tfName_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MenuListGUI frame = new MenuListGUI();
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
	public MenuListGUI() {
		setTitle("식단생성");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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
        styleSheet.addRule("table {font-size: 12px; border: 1px solid black; border-collapse: collapse;"
        				+ "width: 900px; text-align: center;}");
        
        styleSheet.addRule("tr {border: 1px solid black;}");
        styleSheet.addRule("td {border: 1px solid black;}");
        
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
						  + "<td>ex)1</td>\n"
						  + "<td>아침</td>\n"
						  + "<td>고기</td>\n"
						  + "<td>돼지갈비</td>\n"
						  + "<td>395</td>\n"
						  + "<td>30.17</td>\n"
						  + "<td>0</td>\n"
						  + "<td>28.94</td>\n"
						  + "<td>1,500</td>\n"
						  + "</tr>\n"
                          
						  + "</table>\n"
                          + "</body>\n";
        
        // create a document, set it on the jeditorpane, then add the html
        Document doc = kit.createDefaultDocument();
        getContentPane().setLayout(null);
        
        JPanel pnlTop = new JPanel();
        pnlTop.setBounds(0, 104, 1384, 31);
        getContentPane().add(pnlTop);
        
        JLabel lblName = new JLabel("회원번호");
        pnlTop.add(lblName);
        
        tfName = new JTextField();
        pnlTop.add(tfName);
        tfName.setColumns(10);
        
        JLabel lblAge = new JLabel("나이");
        pnlTop.add(lblAge);
        
        tfAge = new JTextField();
        tfAge.setColumns(10);
        pnlTop.add(tfAge);
        
        JLabel lblGender = new JLabel("성별");
        pnlTop.add(lblGender);
        
        tfGender = new JTextField();
        tfGender.setColumns(10);
        pnlTop.add(tfGender);
        
        JLabel lblCal = new JLabel("1일 권장칼로리");
        pnlTop.add(lblCal);
        
        tfCal = new JTextField();
        tfCal.setColumns(10);
        pnlTop.add(tfCal);
        jEditorPane.setDocument(doc);
        jEditorPane.setText(htmlString);
        
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
        tfName_1.setText("ex)하악");
        tfName_1.setBounds(505, 172, 100, 30);
        getContentPane().add(tfName_1);
        tfName_1.setColumns(10);
        
        JLabel lblMenu = new JLabel("회원의 추천 식단");
        lblMenu.setFont(new Font("나눔바른고딕", Font.PLAIN, 20));
        lblMenu.setBounds(617, 172, 150, 30);
        getContentPane().add(lblMenu);
	}
}
