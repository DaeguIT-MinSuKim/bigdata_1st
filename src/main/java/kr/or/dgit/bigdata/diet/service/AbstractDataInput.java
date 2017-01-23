package kr.or.dgit.bigdata.diet.service;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.regex.Pattern;

import javax.swing.JTextField;

public abstract class AbstractDataInput<T> {
	//공백여부
	public boolean isEmptyCheck(JTextField text) throws Exception {
		if(text.getText().trim().equals("")){
			text.requestFocus();
			throw new Exception("공백이 존재합니다.");
		}else{
			return true;
		}
	}
	
	//값 유효성 검사
	public void isValidCheck(String pattern, JTextField text, String msg) throws Exception{}
	
	//초기화 버튼 클릭
	public void allTextFieldClear(JTextField ...text){
		for (JTextField jTextField : text) {
			jTextField.setText("");
		}
	}
	
	//key이벤트 발생
	public KeyListener runKeyListener(JTextField key) {
		return null;
		
	}
}
