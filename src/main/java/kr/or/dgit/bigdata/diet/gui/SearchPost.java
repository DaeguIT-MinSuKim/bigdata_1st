package kr.or.dgit.bigdata.diet.gui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Dialog.ModalityType;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

import kr.or.dgit.bigdata.diet.dto.Post;
import kr.or.dgit.bigdata.diet.service.PostService;

import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JTable;

public class SearchPost extends JDialog {

	private final JPanel panelTop = new JPanel();
	private JTextField tfDoro;
	private JTable table;
	private JComboBox cmbSido;

	public SearchPost() {
		setTitle("주소 검색");
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		panelTop.setLayout(new FlowLayout());
		panelTop.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(panelTop, BorderLayout.NORTH);
		JLabel lblSido = new JLabel("시도");
		panelTop.add(lblSido);
		
		//현재 다이얼로그를 띄웠을 때 다른 프레임은 움직이지 못하도록 처리
		setModalityType(ModalityType.APPLICATION_MODAL);

		cmbSido = new JComboBox();
		List<Post> sidoList = PostService.getInstance().selectSido();
		for (int i = 0; i < sidoList.size(); i++) {
			cmbSido.addItem(sidoList.get(i));
		}
		panelTop.add(cmbSido);

		JLabel lblDoro = new JLabel("도로명");
		panelTop.add(lblDoro);

		tfDoro = new JTextField();
		tfDoro.setColumns(10);
		panelTop.add(tfDoro);

		JButton btnSearch = new JButton("검색");
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (tfDoro.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "도로명을 입력해주세요.");
					tfDoro.requestFocus();
				}else{
					//테이블 띄우는 메소드
					reload();
				}
			}
		});
		panelTop.add(btnSearch);

		JScrollPane scrollPane = new JScrollPane();
		getContentPane().add(scrollPane, BorderLayout.CENTER);

		table = new JTable();
		scrollPane.setViewportView(table);
	}
	
	private void reload(){
		DefaultTableModel model = new DefaultTableModel(getRowData(), getColName());
		if (getRowData() == null) {
			JOptionPane.showMessageDialog(null, "도로명을 정확히 입력해주세요.");
			revalidate();
		}else{
			table.setModel(model);
			tableCellAlignment(SwingConstants.CENTER, 0);
			tableCellAlignment(SwingConstants.LEFT, 1);
			tableSetWidth(120, 500);
			
			table.addMouseListener(new MouseAdapter() {

				@Override
				public void mouseClicked(MouseEvent e) {
					int res = JOptionPane.showConfirmDialog(null, "\""+model.getValueAt(table.getSelectedRow(), 1)+"\" 이 주소가 정확합니까?");
					
					if (res == 0) {
						setVisible(false);
						SignupUI.tf_location.setText(model.getValueAt(table.getSelectedRow(), 1)+""); //선택된 주소 전달
					}
				}
				
			});
		}
	}

	private String[][] getRowData() {
		List<Post> rowDatas = PostService.getInstance().searchDoro(getPost());
		
		String[][] arRowDatas = new String[rowDatas.size()][];
		for (int i = 0; i < rowDatas.size(); i++) {
			arRowDatas[i] = rowDatas.get(i).toArray();
		}
		
		if (rowDatas.isEmpty()) {
			return null;
		}else{
			return arRowDatas;
		}
		
	}
	
	private String[] getColName() {
		return new String[]{"우편번호", "주소"};
	}


	private void tableCellAlignment(int align, int ...idx) {
		DefaultTableCellRenderer dtcr = new DefaultTableCellRenderer();
		dtcr.setHorizontalAlignment(align);
		
		TableColumnModel model = table.getColumnModel();
		for (int i = 0; i < idx.length; i++) {
			model.getColumn(idx[i]).setCellRenderer(dtcr);
		}
		
	}
	
	public void tableSetWidth(int ...width){
		TableColumnModel cModel = table.getColumnModel();
		
		for (int i = 0; i < width.length; i++) {
			cModel.getColumn(i).setPreferredWidth(width[i]);
		}
	}

	private Post getPost() {
		String sido = cmbSido.getSelectedItem()+"";
		String doro = tfDoro.getText().trim();
		return new Post(sido, doro);
	}
}
