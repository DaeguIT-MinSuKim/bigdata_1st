package kr.or.dgit.bigdata.diet.gui;

import java.awt.Container;
import java.awt.EventQueue;

import javax.swing.JEditorPane;
import javax.swing.JFrame;
import javax.swing.text.Document;
import javax.swing.text.html.HTMLEditorKit;
import javax.swing.text.html.StyleSheet;

public class MenuListGUI2 extends JFrame {

	private Container contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MenuListGUI2 frame = new MenuListGUI2();
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
	public MenuListGUI2() {
		setTitle("식단생성");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1200, 616);
		contentPane = getContentPane();

		 // html editor kit 추가시킴
        HTMLEditorKit kit = new HTMLEditorKit();
        
        // css 적용
        StyleSheet styleSheet = kit.getStyleSheet();
        styleSheet.addRule("#container{width: 1200px; height: 616px; border: 1px solid black; background: url('images/healthy_food (9).jpg') no-repeat ;}");
        styleSheet.addRule("#member{text-align: center;height: 15%;padding-top: 30px;}");
        styleSheet.addRule("#member label{margin: 10px;}");
        styleSheet.addRule("#member input{margin: 10px;width: 100px;background-color: transparent;border-bottom: 1px solid black;border-left: none;border-top: none;border-right: none;}");
        styleSheet.addRule("#menu{height: 60%;padding: 10px;}");
        styleSheet.addRule("table{border-collapse: collapse;width: 100%;text-align: center;}");
        styleSheet.addRule("#line1{border-bottom : 1px solid black;background-color: #FFE08C;}");
        styleSheet.addRule("#cost{height: 25%;text-align: center;}");
        styleSheet.addRule("");
        styleSheet.addRule("");
        // html 문장 만들긔
        String htmlString =
        "<html>\n"
        + "<body>\n"
        + "<div id='container'>\n"
        + "<div id='member'>\n" //member section 시작
        + "<label>\n" //label input 시작
        + "</label>\n"
        + "<input type='text'>	\n"
        + "<label>\n"
        + "</label>\n"
        + "<input type='text'>	\n"
        + "<label>\n"
        + "</label>\n"
        + "<input type='text'>	\n"
        + "<label>\n"
        + "</label>\n"
        + "<input type='text'>	\n"
        + "<br>\n"
        + "<input type='text'>\n"
        + "<a>회원의 추천식단</a>\n"
        + "</div>\n"
        + "<div id='menu'>\n" //menu section 시작
        + "<table>\n" //테이블 시작
        + "<tr id='line1'>\n" //row1
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
        + "<tr>\n" //row2
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
        + "</table>\n"
        + "</div>\n"
        + "\n"
        + "</body>\n";
        
        // create a document, set it on the jeditorpane, then add the html
        Document doc = kit.createDefaultDocument();
        getContentPane().setLayout(null);
        
        // jeditorpane 만들긔
        JEditorPane jEditorPane = new JEditorPane();
        jEditorPane.setLocation(0, 0);
        jEditorPane.setSize(1200, 616);
        contentPane.add(jEditorPane);
        
        // read-only 만들긔
        jEditorPane.setEditable(false);
        jEditorPane.setEditorKit(kit);
        jEditorPane.setDocument(doc);
        jEditorPane.setText(htmlString);
	}

}