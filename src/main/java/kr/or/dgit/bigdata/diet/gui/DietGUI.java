package kr.or.dgit.bigdata.diet.gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import kr.or.dgit.bigdata.diet.dto.Member;
import kr.or.dgit.bigdata.diet.service.MemberService;

public class DietGUI extends JFrame implements ActionListener {

	private Container contentPane;
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
	private JLabel lblNewLabel;
	
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DietGUI frame = new DietGUI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	public DietGUI() {
		setTitle("식단생성");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 600, 800);
		contentPane = getContentPane();
		DietBackGroundPanel dbgp = new DietBackGroundPanel();
		contentPane.add(dbgp, BorderLayout.CENTER);
		dbgp.setLayout(null);
		
		JLabel lblPhone = new JLabel("Phone  |");
		lblPhone.setFont(new Font("맑은 고딕", Font.BOLD, 20));
		lblPhone.setHorizontalAlignment(SwingConstants.RIGHT);
		lblPhone.setBounds(72, 459, 150, 30);
		dbgp.add(lblPhone);
		
		JLabel lblAddr = new JLabel("Address  |");
		lblAddr.setFont(new Font("맑은 고딕", Font.BOLD, 20));
		lblAddr.setHorizontalAlignment(SwingConstants.RIGHT);
		lblAddr.setBounds(72, 509, 150, 30);
		dbgp.add(lblAddr);
		
		JLabel lblBudget = new JLabel("Budget  |");
		lblBudget.setFont(new Font("맑은 고딕", Font.BOLD, 20));
		lblBudget.setHorizontalAlignment(SwingConstants.RIGHT);
		lblBudget.setBounds(72, 563, 150, 30);
		dbgp.add(lblBudget);
		
		//이미지 아이콘
		ImageIcon originPrev = new ImageIcon("pictogram/prev.png");
		Image originPrevImg = originPrev.getImage();
		Image changePrevImg = originPrevImg.getScaledInstance(50, 50, Image.SCALE_SMOOTH);
		ImageIcon changePrev = new ImageIcon(changePrevImg);
		
		ImageIcon originNext = new ImageIcon("pictogram/Next.png");
		Image originNextImg = originNext.getImage();
		Image changeNextImg = originNextImg.getScaledInstance(50, 50, Image.SCALE_SMOOTH);
		ImageIcon changeNext = new ImageIcon(changeNextImg);
		
		//좌우 버튼
		btnLeft = new JButton("");
		btnLeft.addActionListener(this);
		btnLeft.setFocusable(false);
		btnLeft.setBorder(null);
		btnLeft.setBackground(null);
		btnLeft.setBounds(135, 620, 50, 50);
		btnLeft.setBorderPainted(false);
		btnLeft.setFocusPainted(false);
		btnLeft.setContentAreaFilled(false);
		btnLeft.setIcon(changePrev);
		dbgp.add(btnLeft);
		
		btnRight = new JButton("");
		btnRight.addActionListener(this);
		btnRight.setFocusable(false);
		btnRight.setBorder(null);
		btnRight.setBackground(null);
		btnRight.setBounds(255, 620, 50, 50);
		btnRight.setBorderPainted(false);
		btnRight.setFocusPainted(false);
		btnRight.setContentAreaFilled(false);
		btnRight.setIcon(changeNext);
		dbgp.add(btnRight);
		
		tf_no = new JTextField();
		tf_no.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		tf_no.setHorizontalAlignment(SwingConstants.CENTER);
		tf_no.setEnabled(false);
		tf_no.setEditable(false);
		tf_no.setBounds(72, 386, 60, 20);
		dbgp.add(tf_no);
		tf_no.setColumns(10);
		
		tf_name = new JTextField();
		tf_name.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		tf_name.setBorder(null);
		tf_name.setFocusable(false);
		tf_name.setBackground(Color.WHITE);
		tf_name.setHorizontalAlignment(SwingConstants.CENTER);
		tf_name.setText("");
		tf_name.setBounds(138, 376, 50, 30);
		dbgp.add(tf_name);
		
		tf_gender = new JTextField();
		tf_gender.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		tf_gender.setBorder(null);
		tf_gender.setFocusable(false);
		tf_gender.setBackground(Color.WHITE);
		tf_gender.setHorizontalAlignment(SwingConstants.CENTER);
		tf_gender.setText("");
		tf_gender.setBounds(200, 385, 33, 21);
		dbgp.add(tf_gender);
		
		tf_weight = new JTextField();
		tf_weight.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		tf_weight.setBorder(null);
		tf_weight.setFocusable(false);
		tf_weight.setBackground(Color.WHITE);
		tf_weight.setHorizontalAlignment(SwingConstants.CENTER);
		tf_weight.setText("");
		tf_weight.setBounds(245, 385, 33, 21);
		dbgp.add(tf_weight);
		
		tf_age = new JTextField();
		tf_age.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		tf_age.setBorder(null);
		tf_age.setFocusable(false);
		tf_age.setBackground(Color.WHITE);
		tf_age.setHorizontalAlignment(SwingConstants.CENTER);
		tf_age.setText("");
		tf_age.setBounds(316, 385, 33, 21);
		dbgp.add(tf_age);
		
		tf_phone = new JTextField();
		tf_phone.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		tf_phone.setBorder(null);
		tf_phone.setFocusable(false);
		tf_phone.setBackground(Color.WHITE);
		tf_phone.setBounds(240, 459, 120, 30);
		dbgp.add(tf_phone);
		
		tf_location = new JTextField();
		tf_location.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		tf_location.setBorder(null);
		tf_location.setFocusable(false);
		tf_location.setBackground(Color.WHITE);
		tf_location.setBounds(240, 509, 120, 30);
		dbgp.add(tf_location);
		
		tf_budg = new JTextField();
		tf_budg.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		tf_budg.setText("");
		tf_budg.setBorder(null);
		tf_budg.setFocusable(false);
		tf_budg.setBackground(Color.WHITE);
		tf_budg.setBounds(240, 563, 120, 30);
		dbgp.add(tf_budg);
		
		JLabel lblWeight = new JLabel("KG");
		lblWeight.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		lblWeight.setHorizontalAlignment(SwingConstants.CENTER);
		lblWeight.setBounds(284, 386, 20, 20);
		dbgp.add(lblWeight);
		
		JLabel lblAge = new JLabel("세");
		lblAge.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		lblAge.setHorizontalAlignment(SwingConstants.CENTER);
		lblAge.setBounds(350, 386, 20, 20);
		dbgp.add(lblAge);
		
		lbl_number = new JLabel("N");
		lbl_number.setForeground(Color.BLACK);
		lbl_number.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		lbl_number.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_number.setBounds(190, 632, 25, 25);
		dbgp.add(lbl_number);
		
		lbl_sum = new JLabel("N");
		lbl_sum.setForeground(Color.GRAY);
		lbl_sum.setFont(new Font("서울남산체 L", Font.PLAIN, 16));
		lbl_sum.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_sum.setBounds(230, 635, 20, 20);
		dbgp.add(lbl_sum);
		
		setVisible(true);
		
	// JFRAME 생성시에 member의 전체 racord 갯수를 가져와 화면에 출력
		memberService = MemberService.getInstance();
		sumNumber = memberService.selectMemberSum();
		lbl_sum.setText(sumNumber+"");
		
	// JFRAME 생성시에 member의 첫째 racord를 가져와 화면에 출력
		lbl_number.setText("0");
		
		lblNewLabel = new JLabel("/");
		lblNewLabel.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		lblNewLabel.setBounds(220, 635, 20, 20);
		dbgp.add(lblNewLabel);
		
		JButton btnNewButton = new JButton("식단만들기");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				(new MenuListGUI()).setVisible(true);
			}
		});
		btnNewButton.setBounds(430, 500, 100, 100);
		dbgp.add(btnNewButton);
		/*DietBgPanel dbp = new DietBgPanel();
		contentPane.add(dbp, BorderLayout.CENTER);
		dbp.setLayout(null);*/
		
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

class DietBackGroundPanel extends JPanel{
	ImageIcon dbgIcon = new ImageIcon("images/diet_bg_img.jpg");
	Image dbgImg = dbgIcon.getImage();
	
	
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		
		g.drawImage(dbgImg, 0, 0, getWidth(), getHeight(), this);
	}
}
