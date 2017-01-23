package kr.or.dgit.bigdata.diet.gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import javax.swing.event.CellEditorListener;

import kr.or.dgit.bigdata.diet.dto.Member;
import kr.or.dgit.bigdata.diet.service.DecorateService;
import kr.or.dgit.bigdata.diet.service.MemberService;
import kr.or.dgit.bigdata.diet.service.TableCellService;

import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellEditor;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumnModel;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class MemberUpdateAndDeleteGUIPanel extends JPanel implements ActionListener{
	ImageIcon bgImgTemp = new ImageIcon(getClass().getClassLoader().getResource("images/bg_memberupdate.png"));
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

	private MemberService memberService;
	private JCheckBox checkBox = new JCheckBox("보미");
	private JPanel panelTable;
	DecorateService decorateService = new DecorateService();
	TableCellService tableCellSetting = new TableCellService();
	
	public MemberUpdateAndDeleteGUIPanel() {
		setLayout(null);
		
		//멤버 모두 불러오기
		memberService = MemberService.getInstance();
		
		//button
		btnDelete = new JButton("삭제");
		btnUpdate = new JButton("수정");
		
		btnDelete.setBounds(25, 14, 72, 23);
		btnUpdate.setBounds(108, 14, 72, 23);
		
		add(btnDelete);
		add(btnUpdate);
		
		btnDelete.addActionListener(this);
		btnUpdate.addActionListener(this);
		
		panelTable = new JPanel();
		panelTable.setBounds(40, 123, 518, 240);
		panelTable.setLayout(new BorderLayout(0, 0));
		add(panelTable);
		
		scrollPane = new JScrollPane();
		table = new JTable();
		
		scrollPane.setViewportView(table);
		panelTable.add(scrollPane, BorderLayout.CENTER);
		
		//		버튼꾸미기 메소드 호출
		decorateService.decorateButton(btnDelete, btnUpdate);
		
		//		스크롤페인 꾸미기 메소드 호출
		decorateService.decorateScrollPane(scrollPane);
		
		//		테이블 꾸미기 메소드 호출
		decorateService.decorateTable(table);
		
		//테이블 메소드 호출
		tableModel();
	}
	
	//테이블 메소드
	private void tableModel() {
		String[] colNames = new String[] {"회원 번호", "이름", "성별", "몸무게", "나이", "휴대전화"};
		
		DefaultTableModel model = new DefaultTableModel(getRows(), colNames);
		table.setModel(model);
		
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.out.println(table.getValueAt(table.getSelectedRow(), table.getSelectedColumn()));
			}
		});
		
		//테이블 셀 너비 및 정렬 메소드 호출
		tableCellSetting.tableCellAlignment(table, SwingConstants.CENTER, 0,1,2,3,4,5);
		tableCellSetting.tableSetWidth(table, 50, 0, 2, 3, 4);
		tableCellSetting.tableSetWidth(table, 70, 1);
		tableCellSetting.tableSetWidth(table, 150, 5);
	}
	
	//행 데이터 메소드
	private Object[][] getRows() {
		ArrayList<Member> memberList = memberService.selectAllMember();
		
		Object[][] rowDatas = new String[memberList.size()][];
		
		for (int i = 0; i < memberList.size(); i++) {
			rowDatas[i] = memberList.get(i).toArray();
		}
		return rowDatas;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		//회원 삭제
		if (e.getSource() == btnDelete) {
			//선택된 회원이 없으면 return;
			if (table.isRowSelected(table.getSelectedRow()) == false) {
				JOptionPane.showMessageDialog(null, "회원을 선택해주세요.");
				return;
			}
			
			String no = table.getValueAt(table.getSelectedRow(), 0)+"";
			String name = table.getValueAt(table.getSelectedRow(), 1)+"";
			
			int res = JOptionPane.showConfirmDialog(null, no + " 번 " + name + " 회원을 삭제하시겠습니까?");
			
			//확인을 누르면 삭제
			if (res == 0) {
				memberService.deleteMember(Integer.parseInt(no));
				JOptionPane.showMessageDialog(null, name + "회원이 삭제되었습니다.");
				tableModel(); //테이블 다시 load
			}
		}
		//회원 수정
		if (e.getSource() == btnUpdate) {
			//선택된 회원이 없으면 return;
			if (table.isRowSelected(table.getSelectedRow()) == false) {
				JOptionPane.showMessageDialog(null, "회원을 선택해주세요.");
				return;
			}
			
			String no = table.getValueAt(table.getSelectedRow(), 0)+"";
			
			Member member = memberService.selectMemberByNo(Integer.parseInt(no));
			
			new SignUpAndUpdateGUI(member).setVisible(true);
			
			tableModel(); //테이블 다시 load
		}
	}
}
