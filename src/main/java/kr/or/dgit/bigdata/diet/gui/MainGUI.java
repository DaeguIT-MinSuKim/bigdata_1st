package kr.or.dgit.bigdata.diet.gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.GridLayout;
import java.util.List;
import java.util.regex.Pattern;

import javax.swing.AbstractButton;
import javax.swing.ButtonGroup;
import javax.swing.ButtonModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import kr.or.dgit.bigdata.diet.dto.Member;
import kr.or.dgit.bigdata.diet.service.MemberService;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MainGUI extends JFrame {

	private JPanel contentPane;
	private JTextField tfNo;
	private JTextField tfName;
	private JTextField tfWeight;
	private JTextField tfAge;
	private JTextField tfPhone;
	private JTextField tfBudget;
	private JButton btnClear;
	private JButton btnCancel;
	private JButton btnOk;
	private ButtonGroup rdbtnGroup;
	private String[] habitat = {"서울", "대전", "대구", "부산", "울산", "세종", "제주", "광주", "순천", "포항", "제천", "양산", "김해"};
	private JRadioButton rdbtnMale;
	private JRadioButton rdbtnFemale;
	private JComboBox cmbHabitat;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainGUI frame = new MainGUI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public MainGUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(new GridLayout(0, 2, 10, 10));
		
		JLabel lblNo = new JLabel("회원번호 :");
		lblNo.setHorizontalAlignment(SwingConstants.RIGHT);
		panel.add(lblNo);
		
		tfNo = new JTextField();
		tfNo.setEditable(false);
		panel.add(tfNo);
		tfNo.setColumns(10);
		
		//"1"을 "001"로 나타나도록
		tfNo.setText(getNo());
		
		JLabel lblName = new JLabel("이름 :");
		lblName.setHorizontalAlignment(SwingConstants.RIGHT);
		panel.add(lblName);
		
		tfName = new JTextField();
		tfName.setColumns(10);
		panel.add(tfName);
		
		JLabel lblGender = new JLabel("성별 :");
		lblGender.setHorizontalAlignment(SwingConstants.RIGHT);
		panel.add(lblGender);
		
		JPanel panelGender = new JPanel();
		panel.add(panelGender);
		panelGender.setLayout(new GridLayout(0, 2, 0, 0));
		
		rdbtnMale = new JRadioButton("남");
		panelGender.add(rdbtnMale);
		
		rdbtnFemale = new JRadioButton("여");
		panelGender.add(rdbtnFemale);
		
		//라디오 버튼 그룹생성
		rdbtnGroup = new ButtonGroup();
		rdbtnGroup.add(rdbtnMale);
		rdbtnGroup.add(rdbtnFemale);		
		
		JLabel lblWeight = new JLabel("몸무게 :");
		lblWeight.setHorizontalAlignment(SwingConstants.RIGHT);
		panel.add(lblWeight);
		
		tfWeight = new JTextField();
		tfWeight.setColumns(10);
		panel.add(tfWeight);
		
		JLabel lblAge = new JLabel("나이 :");
		lblAge.setHorizontalAlignment(SwingConstants.RIGHT);
		panel.add(lblAge);
		
		tfAge = new JTextField();
		tfAge.setColumns(10);
		panel.add(tfAge);
		
		JLabel lblPhone = new JLabel("휴대전화 :");
		lblPhone.setHorizontalAlignment(SwingConstants.RIGHT);
		panel.add(lblPhone);
		
		tfPhone = new JTextField();
		tfPhone.setColumns(10);
		panel.add(tfPhone);
		
		JLabel lblHabitat = new JLabel("거주지 :");
		lblHabitat.setHorizontalAlignment(SwingConstants.RIGHT);
		panel.add(lblHabitat);
		
		cmbHabitat = new JComboBox();
		for (String s : habitat) {
			cmbHabitat.addItem(s);
		}
		panel.add(cmbHabitat);
		
		JLabel lblBudget = new JLabel("월 예산 :");
		lblBudget.setHorizontalAlignment(SwingConstants.RIGHT);
		panel.add(lblBudget);
		
		tfBudget = new JTextField();
		tfBudget.setColumns(10);
		panel.add(tfBudget);
		
		JPanel pannelBtn = new JPanel();
		contentPane.add(pannelBtn, BorderLayout.SOUTH);
		
		btnClear = new JButton("초기화");
		btnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				clearTf();
			}
		});
		pannelBtn.add(btnClear);
		
		btnOk = new JButton("등록완료");
		btnOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(!validCheck()){
					
				}
				//모든 항목이 제대로 입력되었을 때
				else{
					MemberService.getInstance().insertMember(getMembers());
					JOptionPane.showMessageDialog(null, "회원등록이 완료되었습니다.");
					clearTf();
					tfNo.setText(getNo()); //회원번호 증가
				}
			}

		});
		pannelBtn.add(btnOk);
		
		btnCancel = new JButton("등록취소");
		pannelBtn.add(btnCancel);
		
		revalidate();
	}

	//회원번호 자동 증가
	private String getNo() {
		List<Member> list = MemberService.getInstance().selectAllMembers();
		
		if (list.isEmpty()) {
			return "001";
		}else{
			return String.format("%03d", list.get(list.size()-1).getNo()+1);
		}
	}
	
	private boolean validCheck() {
		try {
			isEmptyCheck(tfName);
			isEmptyCheck(tfWeight);
			isEmptyCheck(tfAge);
			isEmptyCheck(tfPhone);
			isEmptyCheck(tfBudget);
			isValidCheck("[가-힣]{1,4}", tfName,  "이름을 4글자 이하, 한글로 작성해주세요.");
			isValidCheck("^[1-9][0-9]", tfWeight, "몸무게는 10~99kg이하로 작성해주세요.");
			isValidCheck("^[1-9][0-9]", tfAge, "나이는 10~99세 이하로 작성해주세요.");
			isValidCheck("^0[1-9]{1}[0-9]{1}-[0-9]{4}-[0-9]{4}$", tfPhone, "휴대전화 번호는 010-0000-0000형식으로 입력해주세요.");
			isValidCheck("", tfBudget, "월 예산은 0~100만원 사이로 입력해주세요.");
			
			if (rdbtnMale.isSelected()==false && rdbtnFemale.isSelected()==false){
				JOptionPane.showMessageDialog(null, "성별을 선택해주세요.");
				return false;
			}
			return true;
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
			return false;
		}
	}

	//공백여부검사
	private boolean isEmptyCheck(JTextField text) throws Exception {
		if(text.getText().trim().equals("")){
			text.requestFocus();
			throw new Exception("공백이 존재합니다.");
		}else{
			return true;
		}
	}
	
	//정규표현 검사
	private void isValidCheck(String pattern, JTextField text, String msg) throws Exception{
		if (text == tfBudget) {
			if (Integer.parseInt(text.getText().trim()) > 1000000 || Integer.parseInt(text.getText().trim()) < 0){
				text.setText("");
				text.requestFocus();
				throw new Exception(msg);
			}
		}else if (!Pattern.matches(pattern, text.getText().trim())) {
			text.setText("");
			text.requestFocus();
			throw new Exception(msg);
		}
	}
	//내용 초기화
	private void clearTf() {
		tfName.setText("");
		tfWeight.setText("");
		tfAge.setText("");
		tfPhone.setText("");
		cmbHabitat.setSelectedIndex(0);
		tfBudget.setText("");
	}
	
	private Member getMembers() {
		Member member = new Member();
		member.setNo(Integer.parseInt(tfNo.getText().trim()));
		member.setName(tfName.getText().trim());
		member.setGender(rdbtnMale.isSelected() ? rdbtnMale.getText() : rdbtnFemale.getText());
		member.setWeight(Integer.parseInt(tfWeight.getText().trim()));
		member.setAge(Integer.parseInt(tfAge.getText().trim()));
		member.setPhone(tfPhone.getText().trim());
		member.setAddress(cmbHabitat.getSelectedItem()+"");
		member.setBudget(Integer.parseInt(tfBudget.getText().trim()));
		
		return member;
	}
}
