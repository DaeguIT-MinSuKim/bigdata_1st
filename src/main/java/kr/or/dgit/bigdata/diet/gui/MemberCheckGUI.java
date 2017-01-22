package kr.or.dgit.bigdata.diet.gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import kr.or.dgit.bigdata.diet.dto.Member;
import kr.or.dgit.bigdata.diet.middle.MonthMenu;
import kr.or.dgit.bigdata.diet.service.MemberService;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.Dialog.ModalityType;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.ImageIcon;
import javax.swing.border.LineBorder;

public class MemberCheckGUI extends JDialog implements ActionListener{

	private JPanel contentPane;
	JTextField tf_no;
	private JTextField tf_name;
	private JButton btnLeft;
	private JButton btnRight;
	
	private static MemberService memberService;
	private int sumNumber; //회원 총 수
	private int memberIndex = 0;
	private ArrayList<Member> memberList;
	PanelBottomNumber panelNumber; //panel 현재 회원 / 전체 회원
	private PanelMemberInfo panelInfo; //panel label, texfield
	static HashMap<Integer, MonthMenu> tempMonthMenu = new HashMap<>(); //회원번호와 식단정보 저장
	static HashMap<Integer, FoodListTable> tempFoodList = new HashMap<>(); //회원번호와 식단정보에 따른 테이블 정보 
	static HashMap<Integer, FoodListMaking> tempMakingFoodList = new HashMap<>(); //회원번호와 추천식단 프레임 정보
	
	int noForFoodList; //식단 테이블에 던져주기 위한 번호
	

	public MemberCheckGUI() {
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 300, 526);
		contentPane = new JPanel();
		contentPane.setBorder(null);
		setContentPane(contentPane);
		contentPane.setLayout(null);

		//크기조정불가
		setResizable(false);
		
		//현재 다이얼로그를 띄웠을 때 다른 프레임은 움직이지 못하도록 처리
		setModalityType(ModalityType.APPLICATION_MODAL);
		
		JLabel lblNo = new JLabel("No.");
		lblNo.setBounds(35, 198, 20, 17);
		contentPane.add(lblNo);
		lblNo.setFont(new Font("맑은 고딕", Font.BOLD, 12));
				
		tf_no = new JTextField();
		tf_no.setBounds(60, 201, 35, 14);
		contentPane.add(tf_no);
		tf_no.setFont(new Font("굴림", Font.PLAIN, 11));
		tf_no.setEditable(false);
		tf_no.setText("");
		tf_no.setColumns(10);
		tf_no.setOpaque(false);
		tf_no.setBorder(null);
		
		tf_name = new JTextField();
		tf_name.setBounds(50, 215, 200, 36);
		contentPane.add(tf_name);
		tf_name.setEditable(false);
		tf_name.setHorizontalAlignment(SwingConstants.CENTER);
		tf_name.setFont(new Font("맑은 고딕", Font.BOLD, 22));
		tf_name.setText("강보미");
		tf_name.setColumns(10);
		tf_name.setBorder(null);
		tf_name.setOpaque(false);
		
		//panel label, textfield
		panelInfo = new PanelMemberInfo(memberList);
		panelInfo.setBounds(44, 252, 225, 227);
		contentPane.add(panelInfo);
		
		//panel bottom
		panelNumber = new PanelBottomNumber(memberList);
		panelNumber.setBounds(0, 449, 300, 30);
		contentPane.add(panelNumber);
		panelNumber.lbl_number.setText("0"); 		//member의 첫째 record를 가져와 화면에 출력
		panelNumber.lbl_sum.setText(sumNumber+"");  //member의 전체 record 갯수를 가져와 화면에 출력
		
		//	panel button
		PanelTopButton panelButton = new PanelTopButton(this);
		panelButton.setBounds(0, 145, 300, 30);
		contentPane.add(panelButton);
		
		//	panel 배경화면 이미지
		PanelForMemberCheck panelBg = new PanelForMemberCheck();
		panelBg.setBounds(0, 0, 300, 500);
		contentPane.add(panelBg);
		panelBg.setLayout(null);
		
		btnLeft = new JButton("");
		btnLeft.setBackground(Color.WHITE);
		btnLeft.setBounds(25, 320, 33, 33);
		btnLeft.setBorder(null);
		btnLeft.setOpaque(false);
		btnLeft.setIcon(new ImageIcon("D:\\workspace\\workspace_mybatis\\dietfoodmanager\\images\\btn_left.png"));
		panelBg.add(btnLeft);
		btnLeft.addActionListener(this);
		
		
		btnRight = new JButton("");
		btnRight.setBackground(Color.WHITE);
		btnRight.setBounds(243, 320, 33, 33);
		btnRight.setBorder(null);
		btnRight.setOpaque(false);
		btnRight.setIcon(new ImageIcon("D:\\workspace\\workspace_mybatis\\dietfoodmanager\\images\\btn_right.png"));
		panelBg.add(btnRight);
		btnRight.addActionListener(this);
		
		//MemberService객체 얻어오기
		memberService = MemberService.getInstance();
		//모든 member객체 가져오기
		memberList = memberService.selectAllMember();
		
		//JFRAME 생성시
		sumNumber = memberService.selectMemberSum();
		panelNumber.lbl_sum.setText(sumNumber+"");
		
		//데이터가 있으면 1로 시작
		if(memberList.size() != 0) {

			//화면에  member 출력
			panelNumber.lbl_number.setText("1"); //member의 첫째 record를 가져와 화면에 출력
			
			DecimalFormat df = new DecimalFormat("000");
			
			//FoodListMaking에 보내기 위한 변수.
			//tf_no가 ###형식이어서
			noForFoodList = memberList.get(0).getNo();
			
			tf_no.setText( df.format(memberList.get(0).getNo()) );
			tf_name.setText(memberList.get(0).getName());
			
			panelInfo.tf_gender.setText(memberList.get(0).getGender());
			panelInfo.tf_weight.setText(memberList.get(0).getWeight()+"");
			panelInfo.tf_age.setText(memberList.get(0).getAge()+"");
			panelInfo.tf_phone.setText(memberList.get(0).getPhone());
			panelInfo.tf_location.setText(memberList.get(0).getAddress());
			panelInfo.tf_budget.setText(memberList.get(0).getBudget()+"");
		}else{
			JOptionPane.showMessageDialog(null,"등록된 사용자가 없습니다.");
			dispose();
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		//우측 버튼 클릭
		if (e.getSource() == btnRight) {
			if((sumNumber-1) != memberIndex){
				memberIndex++; //인덱스 증가
			}		
		}
		
		//좌측 버튼 클릭
		if (e.getSource() == btnLeft) {
			if(memberIndex != 0){
				memberIndex--; //인덱스 감소
			}
		}
		
		panelNumber.lbl_number.setText((memberIndex+1)+"");
		Member temp = memberList.get(memberIndex);
		
		//FoodListMaking에 보내기 위한 변수.
		//tf_no가 ###형식이어서
		noForFoodList = temp.getNo(); 
		
		DecimalFormat df = new DecimalFormat("000");
		
		tf_no.setText( df.format(temp.getNo()) );
		tf_name.setText(temp.getName());
		
		panelInfo.tf_gender.setText(temp.getGender());
		panelInfo.tf_weight.setText(temp.getWeight()+"");
		panelInfo.tf_age.setText(temp.getAge()+"");
		panelInfo.tf_phone.setText(temp.getPhone());
		panelInfo.tf_location.setText(temp.getAddress());
		panelInfo.tf_budget.setText(temp.getBudget()+"");
	}
}
