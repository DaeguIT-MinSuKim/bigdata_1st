package kr.or.dgit.bigdata.diet.gui;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JPanel;


public class PanelBgImage extends JPanel {
	
	public PanelBgImage() {
		
	}
	
	@Override
	protected void paintComponent(Graphics g){
		ImageIcon tempImg = new ImageIcon("images/bg_membercheck.png");
		Image bgImg = tempImg.getImage();
		
		super.paintComponent(g);
		g.drawImage(bgImg, getWidth(), getHeight(), this);
	}

}
