package kr.or.dgit.bigdata.diet.service;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.regex.Pattern;

import javax.swing.JTextField;

public class DataInputService<T> extends AbstractDataInput{
	//공백여부검사
	@Override
	public boolean isEmptyCheck(JTextField text) throws Exception {
		return super.isEmptyCheck(text);
	}
	
	//정규표현검사
	@Override
	public void isValidCheck(String pattern, JTextField text, String msg) throws Exception {
		if (text.getName() == "tf_budget") {
			if (Integer.parseInt(text.getText().trim()) > 1000000 
					|| Integer.parseInt(text.getText().trim()) < 0) {
				text.setText("");
				text.requestFocus();
				throw new Exception(msg);
			}
		} else if (!Pattern.matches(pattern, text.getText().trim())) {
			text.setText("");
			text.requestFocus();
			throw new Exception(msg);
		}
	}

	//텍스트필드 초기화
	@Override
	public void allTextFieldClear(JTextField ...text) {
		super.allTextFieldClear(text);
	}

	//key이벤트발생
	@Override
	public KeyListener runKeyListener(JTextField key) {
		KeyAdapter keyAdapter = new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				//특수문자 배제시킴
				char t = e.getKeyChar();
				
				//공통 체크 부분
				boolean digitCheck = Character.isDigit(t);
				boolean backSpaceCheck = ( t == KeyEvent.VK_BACK_SPACE );
				boolean deleteCheck = ( t == KeyEvent.VK_DELETE );
				
				switch (key.getName()) {
				
				case "tf_name":
					if ( !(digitCheck || backSpaceCheck || deleteCheck || Character.isAlphabetic(t)) ) {
						e.consume();
					}
					//한글 최대 8자까지 받음 
					if(!Pattern.matches("^[0-9a-zA-Zㄱ-ㅎㅏ-ㅣ가-힣]{1,8}", key.getText()+t)){
						e.consume();
					}
					break;
					
				case "tf_weight":
				case "tf_age":
					if ( !(digitCheck || backSpaceCheck || deleteCheck) ) {
						e.consume();
					}
					//최대 3자까지 받음 			
					if(!Pattern.matches("^[0-9]{1,3}", key.getText()+t)){
						e.consume();
					}
					break;
					
				case "tf_budget":
					if ( !(digitCheck || backSpaceCheck || deleteCheck) ) {
						e.consume();
					}
					//최대 8자까지 받음 			
					if(!Pattern.matches("^[0-9]{1,8}", key.getText()+t)){
						e.consume();
					}
					break;
					
				case "tf_phone":
					if ( !(digitCheck || backSpaceCheck || deleteCheck || (t == KeyEvent.VK_MINUS)) ) {
						e.consume();
					}
					//최대 15자까지 받음 			
					if(!Pattern.matches("^[0-9-]{1,15}", key.getText()+t)){
						e.consume();
					}
					break;
				}
			}
		};
		return keyAdapter;
	}

	
}
