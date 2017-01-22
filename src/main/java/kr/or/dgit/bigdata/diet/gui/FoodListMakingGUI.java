package kr.or.dgit.bigdata.diet.gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Dialog.ModalityType;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import kr.or.dgit.bigdata.diet.dto.Calorie;
import kr.or.dgit.bigdata.diet.dto.Member;
import kr.or.dgit.bigdata.diet.middle.MonthMenu;
import kr.or.dgit.bigdata.diet.service.CalorieService;
import kr.or.dgit.bigdata.diet.service.MemberService;
import kr.or.dgit.bigdata.diet.util.PrnMenu;

public class FoodListMakingGUI extends JDialog implements ActionListener {

	private BgImageForFoodMakingDialog bgImagePanel = new BgImageForFoodMakingDialog();
	private JButton[] btnDays = new JButton[30];
	private JButton btnSave;
	private JButton btnPrint;
	private JButton btnCreate;
	static JLabel lblOneDayCost;
	static JLabel lblMonthCost;
	private MonthMenu monthMenu;
	private Member member;
	
	int no;//회원 번호
	//Monthmenu에 보낼 필드 선언
	int dayCal;
	int monthCost;
	
	private FoodListTable foodListTable;
	private FoodListMakingGUI foodListMaking;
	private JLabel lblName;
	private JLabel lblNo;
	private JLabel lblAge;
	private JLabel lblGender;
	private JLabel lblOneDayCal;
	
	public FoodListMakingGUI(MemberCheckGUI memberCheckGUI) {
		//멤버 객체 받아오기
		this.no = memberCheckGUI.noForFoodList; //회원번호
		member = MemberService.getInstance().selectMemberByNo(this.no);
		
		//회원의 나이에 따른 칼로리를 받아와서 MonthMenu에 던질 수 있도록 함
		CalorieService calorieService = CalorieService.getInstance();
		Calorie calorie = calorieService.selectCalorieByAge(member.getAge());
		dayCal = member.getGender().equals("여") ? calorie.getCal_woman() : calorie.getCal_man();
		monthCost = member.getBudget();
		
		//현재 다이얼로그를 띄웠을 때 다른 프레임은 움직이지 못하도록 처리
		setModalityType(ModalityType.APPLICATION_MODAL);
		
		//크기조정불가
		setResizable(false);
		
		setBounds(865, 220, 900, 720);
		getContentPane().setLayout(new BorderLayout());
		bgImagePanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(bgImagePanel, BorderLayout.CENTER);
		bgImagePanel.setLayout(null);
		
		lblNo = new JLabel("001");
		lblNo.setText(memberCheckGUI.tf_no.getText());
		lblNo.setFont(new Font("굴림", Font.PLAIN, 12));
		lblNo.setBounds(159, 77, 48, 22);
		bgImagePanel.add(lblNo);
		
		lblAge = new JLabel("22");
		lblAge.setText(member.getAge()+"");
		lblAge.setFont(new Font("굴림", Font.PLAIN, 12));
		lblAge.setBounds(274, 77, 48, 22);
		bgImagePanel.add(lblAge);
		
		lblGender = new JLabel("여");
		lblGender.setText(member.getGender());
		lblGender.setFont(new Font("굴림", Font.PLAIN, 12));
		lblGender.setBounds(381, 77, 48, 22);
		bgImagePanel.add(lblGender);
		
		lblName = new JLabel("강보미");
		lblName.setText(member.getName());
		lblName.setHorizontalAlignment(SwingConstants.RIGHT);
		lblName.setFont(new Font("HY견고딕", Font.PLAIN, 36));
		lblName.setForeground(Color.BLACK);
		lblName.setBounds(206, 148, 172, 52);
		bgImagePanel.add(lblName);
		
		lblOneDayCal = new JLabel("2100");
		lblOneDayCal.setText(dayCal+"");
		lblOneDayCal.setHorizontalAlignment(SwingConstants.RIGHT);
		lblOneDayCal.setFont(new Font("맑은 고딕", Font.BOLD, 14));
		lblOneDayCal.setBounds(165, 578, 69, 22);
		bgImagePanel.add(lblOneDayCal);
		
		//1일 평균 소비금액 : 동적으로 받아옴
		lblOneDayCost = new JLabel();
		lblOneDayCost.setHorizontalAlignment(SwingConstants.RIGHT);
		lblOneDayCost.setFont(new Font("맑은 고딕", Font.BOLD, 14));
		lblOneDayCost.setBounds(385, 578, 69, 22);
		bgImagePanel.add(lblOneDayCost);
		
		//월 총경비 : 동적으로 받아옴
		lblMonthCost = new JLabel();
		lblMonthCost.setHorizontalAlignment(SwingConstants.RIGHT);
		lblMonthCost.setFont(new Font("맑은 고딕", Font.BOLD, 14));
		lblMonthCost.setBounds(535, 578, 95, 22);
		bgImagePanel.add(lblMonthCost);
		
		btnSave = new JButton("CSV저장");
		btnSave.setBounds(595, 615, 100, 30);
		btnSave.setForeground(Color.WHITE);
		btnSave.setFont(new Font("맑은 고딕", Font.BOLD, 14));
		btnSave.setFocusPainted(false);
		btnSave.setBorder(new LineBorder(new Color(102, 162, 212)));
		btnSave.setBackground(new Color(69, 126, 175));
		bgImagePanel.add(btnSave);
		btnSave.addActionListener(this);
		
		btnPrint = new JButton("식단출력");
		btnPrint.setBounds(700, 615, 100, 30);
		btnPrint.setForeground(Color.WHITE);
		btnPrint.setFont(new Font("맑은 고딕", Font.BOLD, 14));
		btnPrint.setFocusPainted(false);
		btnPrint.setBorder(new LineBorder(new Color(102, 162, 212)));
		btnPrint.setBackground(new Color(69, 126, 175));
		bgImagePanel.add(btnPrint);
		btnPrint.addActionListener(this);
		
		btnCreate = new JButton("식단생성");
		btnCreate.setForeground(Color.WHITE);
		btnCreate.setFont(new Font("맑은 고딕", Font.BOLD, 14));
		btnCreate.setFocusPainted(false);
		btnCreate.setBorder(new LineBorder(new Color(102, 162, 212)));
		btnCreate.setBackground(new Color(69, 126, 175));
		btnCreate.setBounds(700, 225, 100, 30);
		bgImagePanel.add(btnCreate);
		btnCreate.addActionListener(this);
		
		//btnDays를 담을 panel선언
		JPanel panelCenterButton = new JPanel();
		panelCenterButton.setBounds(93, 265, 705, 277);
		bgImagePanel.add(panelCenterButton);
		panelCenterButton.setLayout(new GridLayout(0, 6, 10, 15));
		panelCenterButton.setOpaque(false);
		
		for (int i = 0; i < btnDays.length; i++) {
			btnDays[i] = new JButton((i+1)+"일");
			btnDays[i].setBackground(Color.WHITE);
			btnDays[i].setForeground(new Color(69, 126, 175));
			btnDays[i].setFont(new Font("맑은 고딕", Font.BOLD, 14));
			btnDays[i].setBorder(null);
			btnDays[i].setOpaque(false);
			panelCenterButton.add(btnDays[i]);
			
			btnDays[i].addActionListener(this);
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		//식단 생성 버튼
		if (e.getSource() == btnCreate) {
			//식단이 아직 생성되어있지 않을 때 호출하도록
			if (MemberCheckGUI.tempMonthMenu.containsKey(no)) {
				JOptionPane.showMessageDialog(null, "식단이 존재합니다.");
				return;
			}else{
				JOptionPane.showMessageDialog(null, "식단을 생성합니다");
				
				monthMenu = new MonthMenu(dayCal, monthCost);
				foodListTable = new FoodListTable(monthMenu, -1);
				
				MemberCheckGUI.tempMonthMenu.put(no, monthMenu);
				MemberCheckGUI.tempFoodList.put(no, foodListTable);
				MemberCheckGUI.tempMakingFoodList.put(no, this);
				
				lblOneDayCost.setText(foodListTable.avgOneDayCost+"");
				lblMonthCost.setText(foodListTable.monthCost+"");
			}
			
		}
		
		//1일 ~ 30일 일자 버튼
		for (int i = 0; i < btnDays.length; i++) {
			if (e.getSource() == btnDays[i]) {
				monthMenu = MemberCheckGUI.tempMonthMenu.get(no);
				foodListTable = MemberCheckGUI.tempFoodList.get(no);
				foodListMaking = MemberCheckGUI.tempMakingFoodList.get(no);
				
				//1일~30일 버튼을 클릭했는데 식단이 없을 때
				if (monthMenu == null) {
					JOptionPane.showMessageDialog(null, "식단 생성을 먼저 진행해주세요.");
					return;
				}else{
					foodListTable = new FoodListTable(monthMenu, (i+1));
					foodListTable.setVisible(true);
				}
			}
		}
		
		//식단 출력버튼
		if (e.getSource() == btnPrint) {
			monthMenu = MemberCheckGUI.tempMonthMenu.get(no);
			foodListTable = MemberCheckGUI.tempFoodList.get(no);
			foodListMaking = MemberCheckGUI.tempMakingFoodList.get(no);
			
			//클릭했는데 식단이 없을 때
			if (monthMenu == null) {
				JOptionPane.showMessageDialog(null, "식단 생성을 먼저 진행해주세요.");
				return;
			}else{
				/////////////////////////////////////////////////////////////////
				int memberNo = no;
				String name = lblName.getText();
				int cal = dayCal;
				PrnMenu prnMenu = new PrnMenu(foodListTable.monthRows(monthMenu),no+"",name,cal+"");
				prnMenu.setVisible(true);
			}
		}
		
		//CSV저장 버튼
		if (e.getSource() == btnSave) {
			monthMenu = MemberCheckGUI.tempMonthMenu.get(no);
			foodListTable = MemberCheckGUI.tempFoodList.get(no);
			foodListMaking = MemberCheckGUI.tempMakingFoodList.get(no);
			
			//클릭했는데 식단이 없을 때
			if (monthMenu == null) {
				JOptionPane.showMessageDialog(null, "식단 생성을 먼저 진행해주세요.");
				return;
			}else{
				//실행될 코드
				File fileName = null;
				BufferedWriter out=null;
				JFileChooser chooser = new JFileChooser();				
				int returnVal = chooser.showSaveDialog(null);
							
					if(returnVal == JFileChooser.APPROVE_OPTION) {
						String s;
						fileName = chooser.getSelectedFile();
					}
					try {
						out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(fileName), "euc-kr"));
						String[][] temp = foodListTable.monthRows(monthMenu);
						for (String[] strings : temp) {
							out.write(strings[0]+","+strings[1]+","+strings[2]+","+strings[3]+","+strings[4]+"" + ","+strings[5]+","+strings[6]+","+strings[7]+","+strings[8]+","+strings[9]); 
							out.newLine();
						}
						out.close();
					} catch (IOException e1) {
						e1.printStackTrace();
					}			
			}
		}
	}

	public void setMember(int no) {
		this.no = no;
		member = MemberService.getInstance().selectMemberByNo(this.no);
		
		//회원의 나이에 따른 칼로리를 받아와서 MonthMenu에 던질 수 있도록 함
		Calorie calorie = CalorieService.getInstance().selectCalorieByAge(member.getAge());
		dayCal = member.getGender().equals("여") ? calorie.getCal_woman() : calorie.getCal_man();
		monthCost = member.getBudget();
		
		monthMenu = MemberCheckGUI.tempMonthMenu.get(no);
		foodListTable = MemberCheckGUI.tempFoodList.get(no);
		foodListMaking = MemberCheckGUI.tempMakingFoodList.get(no);
		lblNo.setText(no+"");
		lblAge.setText(member.getAge()+"");
		lblGender.setText(member.getGender());
		lblName.setText(member.getName());
		lblOneDayCal.setText(dayCal+"");
		lblOneDayCost.setText(foodListTable.avgOneDayCost+"");
		lblMonthCost.setText(foodListTable.monthCost+"");
		
		setVisible(true);
	}
}

class BgImageForFoodMakingDialog extends JPanel{
	ImageIcon bgImgTemp = new ImageIcon("images/bg_makingfoodlist.png");
	Image bgImg = bgImgTemp.getImage();
	
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(bgImg, 0, 0, 900, 700, this);
		
	}
}