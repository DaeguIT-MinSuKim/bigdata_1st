package kr.or.dgit.bigdata.diet.dto;

public class Calorie {

	private int minage;
	private int maxage;
	private int cal_man;
	private int h_man;
	private float w_man;
	private int cal_woman;
	private int h_woman;
	private float w_woman;
		
	public Calorie() {}
	
	public Calorie(int minage, int maxage, int cal_man, int h_man, float w_man, int cal_woman, int h_woman,
			float w_woman) {
	
		this.minage = minage;
		this.maxage = maxage;
		this.cal_man = cal_man;
		this.h_man = h_man;
		this.w_man = w_man;
		this.cal_woman = cal_woman;
		this.h_woman = h_woman;
		this.w_woman = w_woman;
	}
	public int getMinage() 		{return minage;	}
	public int getMaxage() 		{return maxage;	}
	public int getCal_man()		{return cal_man;	}
	public int getH_man()  		{return h_man;	}
	public float getW_man()  		{return w_man;	}
	public int getCal_woman() 	{return cal_woman;	}
	public int getH_woman()   	{return h_woman;	}
	public float getW_woman()   	{return w_woman;	}
	public void setMinage(int minage) 	{this.minage = minage;	}
	public void setMaxage(int maxage) 	{this.maxage = maxage;	}
	public void setCal_man(int cal_man) {this.cal_man = cal_man;	}
	public void setH_man(int h_man) 	{this.h_man = h_man;}
	public void setW_man(int w_man) 	{this.w_man = w_man;	}
	public void setCal_woman(int cal_woman) {this.cal_woman = cal_woman;	}
	public void setH_woman(int h_woman) {this.h_woman = h_woman;	}
	public void setW_woman(int w_woman) {this.w_woman = w_woman;}
	
	
	
	
	public void setW_man(float w_man) {
		this.w_man = w_man;
	}
	public void setW_woman(float w_woman) {
		this.w_woman = w_woman;
	}
	
	@Override
	public String toString() {
		return String.format(
				"Calorie [minage=%s, maxage=%s, cal_man=%s, h_man=%s, w_man=%s, cal_woman=%s, h_woman=%s, w_woman=%s]",
				minage, maxage, cal_man, h_man, w_man, cal_woman, h_woman, w_woman);
	}
	
	
	
}
