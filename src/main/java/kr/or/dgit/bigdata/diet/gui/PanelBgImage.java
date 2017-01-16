package kr.or.dgit.bigdata.diet.gui;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JPanel;


public class PanelBgImage extends JPanel {
	ImageIcon bgImgTemp = new ImageIcon("images/bg_membercheck.png");
	Image bgImg = bgImgTemp.getImage();
	
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(bgImg, 0, 0, 300, 500, this);
		
	}
}
