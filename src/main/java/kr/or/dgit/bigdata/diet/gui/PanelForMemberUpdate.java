package kr.or.dgit.bigdata.diet.gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.EventObject;

import javax.swing.BorderFactory;
import javax.swing.DefaultCellEditor;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.LineBorder;
import javax.swing.event.CellEditorListener;

import kr.or.dgit.bigdata.diet.dto.Member;
import kr.or.dgit.bigdata.diet.service.MemberService;

import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellEditor;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumnModel;
import javax.swing.JCheckBox;
import javax.swing.JLabel;

public class PanelForMemberUpdate extends JPanel {
	ImageIcon bgImgTemp = new ImageIcon("images/bg_memberupdate.png");
	Image bgImg = bgImgTemp.getImage();
	
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(bgImg, 0, 0, 600, 400, this);
		
	}
	
	private JButton btnDelete;
	private JButton btnUpdate;
	private JScrollPane scrollPane;
	private JTable table;
	private ArrayList<Member> memberList;
	private MemberService memberService;
	private JCheckBox checkBox = new JCheckBox("보미");
	private JPanel panelTable;
	
	public PanelForMemberUpdate() {
		setLayout(null);
		
		//멤버 모두 불러오기
		memberService = MemberService.getInstance();
		memberList = memberService.selectAllMember();
		
		//button
		btnDelete = new JButton("삭제");
		btnUpdate = new JButton("수정");
		
		btnDelete.setBounds(25, 14, 72, 23);
		btnUpdate.setBounds(108, 14, 72, 23);
		
		btnDelete.setForeground(Color.WHITE);
		btnUpdate.setForeground(Color.WHITE);
		
		btnDelete.setFont(new Font("맑은 고딕", Font.BOLD, 13));
		btnUpdate.setFont(new Font("맑은 고딕", Font.BOLD, 13));
		
		btnDelete.setFocusPainted(false);
		btnUpdate.setFocusPainted(false);
		
		btnDelete.setBorder(new LineBorder(new Color(102, 162, 212)));
		btnUpdate.setBorder(new LineBorder(new Color(102, 162, 212)));
		
		btnDelete.setBackground(new Color(44, 103, 156));
		btnUpdate.setBackground(new Color(44, 103, 156));
		
		add(btnDelete);
		add(btnUpdate);
		
		panelTable = new JPanel();
		panelTable.setBounds(40, 123, 518, 240);
		panelTable.setLayout(new BorderLayout(0, 0));
		add(panelTable);
		
		scrollPane = new JScrollPane();
		table = new JTable();
		
		scrollPane.setViewportView(table);
		panelTable.add(scrollPane, BorderLayout.CENTER);
		
		//스크롤페인 꾸미기
		scrollPane.getViewport().setBackground(Color.WHITE);
		scrollPane.getViewport().setBorder(null);
		scrollPane.setBorder(BorderFactory.createEmptyBorder());
		
		//테이블 메소드 호출
		tableModel();
	}
	
	private void tableModel() {
		String[] colNames = new String[] {"번호", "이름", "성별", "몸무게", "나이", "휴대전화", "여부"};
		
		DefaultTableModel model = new DefaultTableModel(getRows(), colNames);
		table.setModel(model);
	}
	
	//행 데이터 메소드
	private Object[][] getRows() {
		Object[][] rowDatas = new String[memberList.size()][];
		for (int i = 0; i < memberList.size(); i++) {
			rowDatas[i] = new String[]{
					memberList.get(i).getNo()+"",
					memberList.get(i).getName(),
					memberList.get(i).getGender(),
					memberList.get(i).getWeight()+"",
					memberList.get(i).getAge()+"",
					memberList.get(i).getPhone(),
			};
		}
		return rowDatas;
	}
}
