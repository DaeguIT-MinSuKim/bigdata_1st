package kr.or.dgit.bigdata.diet.gui;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import kr.or.dgit.bigdata.diet.dto.Member;
import kr.or.dgit.bigdata.diet.middle.MonthMenu;
import kr.or.dgit.bigdata.diet.service.MemberService;

public class MemberCheckGUI extends JDialog implements ActionListener{

	private JPanel contentPane;
	JTextField tf_no;
	JTextField tf_name;
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
	static HashMap<Integer, FoodListMakingGUI> tempMakingFoodList = new HashMap<>(); //회원번호와 추천식단 프레임 정보
	
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
		MemberCheckGUIPanel panelBg = new MemberCheckGUIPanel();
		panelBg.setBounds(0, 0, 300, 500);
		contentPane.add(panelBg);
		panelBg.setLayout(null);
		
		//	좌 우 버튼
		btnLeft = new JButton("");
		btnRight = new JButton("");
		btnLeft.setBackground(Color.WHITE);
		btnRight.setBackground(Color.WHITE);
		btnLeft.setBounds(25, 320, 33, 33);
		btnRight.setBounds(243, 320, 33, 33);
		btnLeft.setBorder(null);
		btnRight.setBorder(null);
		btnLeft.setOpaque(false);
		btnRight.setOpaque(false);
		btnLeft.setIcon(new ImageIcon(getClass().getClassLoader().getResource("images/btn_left.png")));
		btnRight.setIcon(new ImageIcon(getClass().getClassLoader().getResource("images/btn_right.png")));
		panelBg.add(btnLeft);
		panelBg.add(btnRight);
		//버튼 이벤트 호출
		btnLeft.addActionListener(this);
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
			
			//텍스트필드 세팅 메소드 호출
			setTextAboutMember(memberList);
			
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
		
		//화면에  member 출력
		panelNumber.lbl_number.setText((memberIndex+1)+"");
		
		//텍스트필드 세팅 메소드 호출
		setTextAboutMember(memberIndex);
	}
	

	//텍스트필드 세팅 메소드
	private <T> void setTextAboutMember(T t) {
		DecimalFormat df = new DecimalFormat("000");
		
		Member member = null;
		
		//memberList 0일 때 설정 됨
		if (t == memberList) {
			member = memberList.get(0);
		}else{
			member = memberList.get(memberIndex);
		}
		
		//FoodListMaking에 보내기 위한 변수.
		//tf_no가 ###형식이어서
		noForFoodList = member.getNo();
		
		tf_no.setText( df.format(member.getNo()) );
		tf_name.setText(member.getName());
		
		panelInfo.tf_gender.setText(member.getGender());
		panelInfo.tf_weight.setText(member.getWeight()+"");
		panelInfo.tf_age.setText(member.getAge()+"");
		panelInfo.tf_phone.setText(member.getPhone());
		panelInfo.tf_location.setText(member.getAddress());
		panelInfo.tf_budget.setText(member.getBudget()+"");
		
	}

}
