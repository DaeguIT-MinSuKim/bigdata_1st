package kr.or.dgit.bigdata.diet.util;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Dialog.ModalityType;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.swing.JRViewer;

public class PrnMenu extends JDialog {

	private JPanel contentPane;
	private String[][] table;
	
	private String numberNo;
	private String name;
	private String cal;
	public void setNumberNo(String numberNo,String name, String cal) {
		this.numberNo = numberNo;
		this.name = name;
		this.cal = cal;
	}

	public PrnMenu(String[][] table,String numberNo,String name, String cal) {
		this.numberNo = numberNo;
		this.name = name;
		this.cal = cal;
		this.table = table;
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		ShowReport();
		revalidate();
		repaint();
		setSize(900, 800);
		
		//현재 다이얼로그를 띄웠을 때 다른 프레임은 움직이지 못하도록 처리
		setModalityType(ModalityType.APPLICATION_MODAL);
	}
	private void ShowReport(){
		try {
			//List<Person> list=PersonService.getInstance().selectAll();
			List<Map<String, ?>> dataSource=new ArrayList<>();
			
			for(int i=0 ; i< table.length ;i++ ){							 
				Map<String, Object> m=new HashMap<>();
				//m.put("no",	table[i][0]);
				m.put("day",	table[i][1]); //System.out.print(m.get("day")+", ");
				m.put("time",	table[i][2]); //System.out.print(m.get("time")+", ");
				m.put("grp",	table[i][3]); //System.out.print(m.get("grp")+", ");
				m.put("menu",	table[i][4]); //System.out.print(m.get("menu")+", ");
				m.put("cal",	table[i][5]); //System.out.print(m.get("cla")+", ");
				m.put("ing1",	table[i][6]); //System.out.print(m.get("ing1")+", ");
				m.put("ing2",	table[i][7]); //System.out.print(m.get("ing2")+", ");
				m.put("ing3",	table[i][8]); //System.out.print(m.get("ing3")+", ");
				m.put("cost",	table[i][9]); //System.out.println(m.get("cost"));
				m.put("number", numberNo);
				m.put("name", name);
				m.put("daycal", cal);
				//m.put("name",person.getName());
				//m.put("day", person.getDay());				
				dataSource.add(m);
			}
			JRDataSource jrDataSource=new JRBeanCollectionDataSource(dataSource);
			//String sourceName= getClass().getClassLoader().getResource("Silhouette.jrxml").toURI()+"";
			String sourceName="Silhouette.jrxml";
			
			JasperReport report=JasperCompileManager.compileReport(sourceName);
			JasperPrint filledReport=JasperFillManager.fillReport(report, null,jrDataSource);
			this.getContentPane().add(new JRViewer(filledReport));
			
//			new String = "번호      일자    식사     항목      메뉴       칼로리(cal)    지방          탄수화물          단백질         비용
			
		} catch (Exception e) {
			// TODO: handle exception
			JOptionPane.showMessageDialog(null, e.getMessage());
		}	
		
	}

}
