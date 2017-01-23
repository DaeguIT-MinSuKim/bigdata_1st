package kr.or.dgit.bigdata.diet.service;

import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableColumnModel;

public abstract class AbstractTableCell {
	//셀 정렬
	public void tableCellAlignment(JTable table, int align,  int ...idx) {
		DefaultTableCellRenderer dtcr = new DefaultTableCellRenderer();
		dtcr.setHorizontalAlignment(align);
		
		TableColumnModel model = table.getColumnModel();
		
		for (int i = 0; i < idx.length; i++) {
			model.getColumn(idx[i]).setCellRenderer(dtcr);
		}
	}
	
	//셀 너비
	public void tableSetWidth(JTable table, int width, int ...column) {
		TableColumnModel model = table.getColumnModel();
		
		for (int i = 0; i < column.length; i++) {
			model.getColumn(column[i]).setPreferredWidth(width);
		}
	}
}
