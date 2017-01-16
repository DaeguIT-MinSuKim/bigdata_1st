package kr.or.dgit.bigdata.diet.dto;

public class Calorie {

	private int minage;
	private int maxage;
	private int calMan;
	private int hMan;
	private float wMan;
	private int calWoman;
	private int hWoman;
	private float wWoman;
		
	public Calorie() {}
	
	public Calorie(int minage, int maxage, int cal_man, int h_man, float w_man, int cal_woman, int h_woman,
			float w_woman) {
	
		this.minage = minage;
		this.maxage = maxage;
		this.calMan = cal_man;
		this.hMan = h_man;
		this.wMan = w_man;
		this.calWoman = cal_woman;
		this.hWoman = h_woman;
		this.wWoman = w_woman;
	}
	public int getMinage() 		{return minage;	}
	public int getMaxage() 		{return maxage;	}
	public int getCal_man()		{return calMan;	}
	public int getH_man()  		{return hMan;	}
	public float getW_man()  		{return wMan;	}
	public int getCal_woman() 	{return calWoman;	}
	public int getH_woman()   	{return hWoman;	}
	public float getW_woman()   	{return wWoman;	}
	public void setMinage(int minage) 	{this.minage = minage;	}
	public void setMaxage(int maxage) 	{this.maxage = maxage;	}
	public void setCal_man(int cal_man) {this.calMan = cal_man;	}
	public void setH_man(int h_man) 	{this.hMan = h_man;}
	public void setW_man(int w_man) 	{this.wMan = w_man;	}
	public void setCal_woman(int cal_woman) {this.calWoman = cal_woman;	}
	public void setH_woman(int h_woman) {this.hWoman = h_woman;	}
	public void setW_woman(int w_woman) {this.wWoman = w_woman;}
	
	
	
	
	public void setW_man(float w_man) {
		this.wMan = w_man;
	}
	public void setW_woman(float w_woman) {
		this.wWoman = w_woman;
	}
	
	@Override
	public String toString() {
		return String.format(
				"Calorie [minage=%s, maxage=%s, cal_man=%s, h_man=%s, w_man=%s, cal_woman=%s, h_woman=%s, w_woman=%s]",
				minage, maxage, calMan, hMan, wMan, calWoman, hWoman, wWoman);
	}
	
	
	
}
