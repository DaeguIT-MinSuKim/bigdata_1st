package kr.or.dgit.bigdata.diet.gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import kr.or.dgit.bigdata.diet.dto.Member;
import kr.or.dgit.bigdata.diet.service.MemberService;

public class SearchUI extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JTextField tf_no;
	private JTextField tf_name;
	private JTextField tf_gender;
	private JTextField tf_weight;
	private JTextField tf_age;
	private JTextField tf_phone;
	private JTextField tf_location;
	private JTextField tf_budg;
	private JButton btnLeft;
	private JButton btnRight;
	private JSeparator separator;
	private static MemberService memberService;
	private ArrayList<Member> memberList;			//회원 명부
	private int sumNumber;                      //회원 총 갯수
	private int memberIndex=0;
	private JLabel lbl_sum;
	private JLabel lbl_number;
	
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SearchUI frame = new SearchUI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	public SearchUI() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 453);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JPanel p_display = new JPanel();
		contentPane.add(p_display, BorderLayout.CENTER);
		p_display.setLayout(null);
		
		JLabel label = new JLabel("회원번호");
		label.setBounds(78, 19, 78, 15);
		label.setHorizontalAlignment(SwingConstants.RIGHT);
		p_display.add(label);
		
		JLabel label_1 = new JLabel("이름");
		label_1.setBounds(78, 62, 78, 15);
		label_1.setHorizontalAlignment(SwingConstants.RIGHT);
		p_display.add(label_1);
		
		JLabel label_2 = new JLabel("성별");
		label_2.setBounds(78, 105, 78, 15);
		label_2.setHorizontalAlignment(SwingConstants.RIGHT);
		p_display.add(label_2);
		
		JLabel label_3 = new JLabel("몸무게");
		label_3.setBounds(78, 148, 78, 15);
		label_3.setHorizontalAlignment(SwingConstants.RIGHT);
		p_display.add(label_3);
		
		JLabel label_4 = new JLabel("나이");
		label_4.setBounds(78, 191, 78, 15);
		label_4.setHorizontalAlignment(SwingConstants.RIGHT);
		p_display.add(label_4);
		
		JLabel label_5 = new JLabel("휴대전화");
		label_5.setBounds(78, 234, 78, 15);
		label_5.setHorizontalAlignment(SwingConstants.RIGHT);
		p_display.add(label_5);
		
		JLabel label_6 = new JLabel("거주지");
		label_6.setBounds(78, 277, 78, 15);
		label_6.setHorizontalAlignment(SwingConstants.RIGHT);
		p_display.add(label_6);
		
		JLabel label_7 = new JLabel("월 예산");
		label_7.setBounds(78, 320, 78, 15);
		label_7.setHorizontalAlignment(SwingConstants.RIGHT);
		p_display.add(label_7);
		
		btnLeft = new JButton("◀");
		btnLeft.addActionListener(this);
		btnLeft.setBounds(108, 367, 47, 23);
		p_display.add(btnLeft);
		
		btnRight = new JButton("▶");
		btnRight.addActionListener(this);
		btnRight.setBounds(259, 367, 48, 23);
		p_display.add(btnRight);
		
		JLabel lblNewLabel = new JLabel("회원검색");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(158, 371, 57, 15);
		p_display.add(lblNewLabel);
		
		tf_no = new JTextField();
		tf_no.setHorizontalAlignment(SwingConstants.CENTER);
		tf_no.setEnabled(false);
		tf_no.setEditable(false);
		tf_no.setBounds(192, 16, 116, 21);
		p_display.add(tf_no);
		tf_no.setColumns(10);
		
		tf_name = new JTextField();
		tf_name.setHorizontalAlignment(SwingConstants.CENTER);
		tf_name.setEditable(false);
		tf_name.setBounds(192, 59, 116, 21);
		p_display.add(tf_name);
		tf_name.setColumns(10);
		
		tf_gender = new JTextField();
		tf_gender.setHorizontalAlignment(SwingConstants.CENTER);
		tf_gender.setEditable(false);
		tf_gender.setBounds(192, 102, 116, 21);
		p_display.add(tf_gender);
		tf_gender.setColumns(10);
		
		tf_weight = new JTextField();
		tf_weight.setHorizontalAlignment(SwingConstants.CENTER);
		tf_weight.setEditable(false);
		tf_weight.setBounds(192, 145, 116, 21);
		p_display.add(tf_weight);
		tf_weight.setColumns(10);
		
		tf_age = new JTextField();
		tf_age.setHorizontalAlignment(SwingConstants.CENTER);
		tf_age.setEditable(false);
		tf_age.setBounds(192, 188, 116, 21);
		p_display.add(tf_age);
		tf_age.setColumns(10);
		
		tf_phone = new JTextField();
		tf_phone.setHorizontalAlignment(SwingConstants.CENTER);
		tf_phone.setEditable(false);
		tf_phone.setBounds(192, 231, 116, 21);
		p_display.add(tf_phone);
		tf_phone.setColumns(10);
		
		tf_location = new JTextField();
		tf_location.setHorizontalAlignment(SwingConstants.CENTER);
		tf_location.setEditable(false);
		tf_location.setBounds(192, 274, 116, 21);
		p_display.add(tf_location);
		tf_location.setColumns(10);
		
		tf_budg = new JTextField();
		tf_budg.setHorizontalAlignment(SwingConstants.CENTER);
		tf_budg.setEditable(false);
		tf_budg.setBounds(192, 317, 116, 21);
		p_display.add(tf_budg);
		tf_budg.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("kg");
		lblNewLabel_1.setBounds(316, 145, 24, 15);
		p_display.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("세");
		lblNewLabel_2.setBounds(316, 191, 36, 15);
		p_display.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("원");
		lblNewLabel_3.setBounds(315, 320, 57, 15);
		p_display.add(lblNewLabel_3);
		
		separator = new JSeparator();
		separator.setBounds(0, 355, 424, 7);
		p_display.add(separator);
		
		lbl_number = new JLabel("N");
		lbl_number.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_number.setBounds(216, 371, 16, 15);
		p_display.add(lbl_number);
		
		lbl_sum = new JLabel("N");
		lbl_sum.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_sum.setBounds(239, 371, 16, 15);
		p_display.add(lbl_sum);
		
		JLabel label_9 = new JLabel("/");
		label_9.setHorizontalAlignment(SwingConstants.CENTER);
		label_9.setBounds(227, 371, 16, 15);
		p_display.add(label_9);
		
		setVisible(true);
		
	// JFRAME 생성시에 member의 전체 racord 갯수를 가져와 화면에 출력
		memberService = MemberService.getInstance();
		sumNumber = memberService.selectMemberSum();
		lbl_sum.setText(sumNumber+"");
		
	// JFRAME 생성시에 member의 첫째 racord를 가져와 화면에 출력
		lbl_number.setText("0");
		
		memberService = MemberService.getInstance();
		memberList = (ArrayList<Member>) memberService.selectAllMember();
		
		//데이터가 있으면 1로 시작
		if(memberList.size() != 0) {

			//화면에  member 출력
			lbl_number.setText("1");
			
			DecimalFormat df = new DecimalFormat("000");			
			tf_no.setText( df.format(memberList.get(0).getNo()) );
			tf_name.setText		(memberList.get(0).getName());
			tf_gender.setText	(memberList.get(0).getGender());
			tf_weight.setText	(memberList.get(0).getWeight()+"");
			tf_age.setText		(memberList.get(0).getAge()+"");
			tf_phone.setText	(memberList.get(0).getPhone());
			tf_location.setText	(memberList.get(0).getAddress());
			tf_budg.setText		(memberList.get(0).getBudget()+"");
		}else{
			JOptionPane.showMessageDialog(null,"등록된 사용자가 없습니다.");
			dispose();
		}
	}

	

	@Override
	public void actionPerformed(ActionEvent e) {

		//회원 조회 우측 버튼		
		if(e.getSource() == btnRight){
			
			tf_no.setEditable(false);
			tf_name.setEditable(false);
			tf_gender.setEditable(false);
			tf_weight.setEditable(false);
			tf_age.setEditable(false);
			tf_phone.setEditable(false);
			tf_location.setEditable(false);
			tf_budg.setEditable(false);
			
			//System.out.println(sumNumber);
			//System.out.println(memberIndex);
			if((sumNumber-1) != memberIndex){
				memberIndex++;
				lbl_number.setText((memberIndex+1)+"");
				Member temp = memberList.get(memberIndex);
				
				DecimalFormat df = new DecimalFormat("000");			
				tf_no.setText( df.format(temp.getNo()) );
				tf_name.setText(temp.getName());
				tf_gender.setText(temp.getGender());
				tf_weight.setText(temp.getWeight()+"");
				tf_age.setText(temp.getAge()+"");
				tf_phone.setText(temp.getPhone());
				tf_location.setText(temp.getAddress());
				tf_budg.setText(temp.getBudget()+"");				
			}			
		}
		
		//회원 조회 좌측 버튼 
		if(e.getSource() == btnLeft){
			
			tf_no.setEditable(false);
			tf_name.setEditable(false);
			tf_gender.setEditable(false);
			tf_weight.setEditable(false);
			tf_age.setEditable(false);
			tf_phone.setEditable(false);
			tf_location.setEditable(false);
			tf_budg.setEditable(false);			
			
			if(memberIndex != 0){
				memberIndex--;
				lbl_number.setText((memberIndex+1)+"");
				//System.out.println(memberIndex);
				Member temp = memberList.get(memberIndex);
				
				DecimalFormat df = new DecimalFormat("000");			
				tf_no.setText( df.format(temp.getNo()) );
								
				tf_name.setText(temp.getName());
				tf_gender.setText(temp.getGender());
				tf_weight.setText(temp.getWeight()+"");
				tf_age.setText(temp.getAge()+"");
				tf_phone.setText(temp.getPhone());
				tf_location.setText(temp.getAddress());
				tf_budg.setText(temp.getBudget()+"");
				
			}			
		}
		
	}
}
