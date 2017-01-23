package kr.or.dgit.bigdata.diet.service;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.LineBorder;
import javax.swing.plaf.basic.BasicScrollBarUI;
import javax.swing.table.JTableHeader;

public abstract class AbstractDecorate {
	//스크롤페인 꾸미기
	public void decorateScrollPane(JScrollPane scrollPane){
		//		스크롤페인꾸미기
		scrollPane.getViewport().setBackground(Color.WHITE);
		scrollPane.getViewport().setBorder(null);
		scrollPane.setBorder(BorderFactory.createEmptyBorder());
		
		//		스크롤바 width사이즈를 13으로 설정
		scrollPane.getVerticalScrollBar().setPreferredSize(new Dimension(13,0));
		
		//		스크롤바의 ▲ ▼ 없앰
		scrollPane.getVerticalScrollBar().setUI(new BasicScrollBarUI(){

			@Override
			protected void configureScrollBarColors() {
				this.thumbDarkShadowColor = Color.PINK;
			}

			@Override
			protected JButton createDecreaseButton(int orientation) {
				return createZeroButton();
			}

			@Override
			protected JButton createIncreaseButton(int orientation) {
				return createZeroButton();
			}
			
			private JButton createZeroButton(){
				JButton button = new JButton();
				button.setPreferredSize(new Dimension(0, 0));
				button.setMinimumSize(new Dimension(0, 0));
				button.setMaximumSize(new Dimension(0, 0));
				return button;
			}
			
		});
	}
	
	//테이블 꾸미기
	public void decorateTable(JTable table){
		table.setGridColor(new Color(200,200,200)); //그리드 라인
		table.setOpaque(false);
		
		JTableHeader tableHeader = table.getTableHeader();
		tableHeader.setBackground(Color.PINK);
		tableHeader.setFont(new Font("맑은 고딕", Font.PLAIN, 14));
	}
	
	//버튼 꾸미기
	public void decorateButton(JButton ...button){
		for (JButton jButton : button) {
			jButton.setForeground(Color.WHITE);
			jButton.setFont(new Font("맑은 고딕", Font.BOLD, 13));
			jButton.setFocusPainted(false);
			jButton.setBorder(new LineBorder(new Color(102, 162, 212)));
			jButton.setBackground(new Color(44, 103, 156));
		}
		
	}
}
