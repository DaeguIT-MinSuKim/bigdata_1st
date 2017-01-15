package kr.or.dgit.bigdata.diet.dto;

public class Calorie {

	private int minage;
	private int maxage;
	private int calWoman;
	private int hWoman;
	private float wWoman;
	private int calMan;
	private int hMan;
	private float wMan;
	
	
		
	public Calorie() {}
	
	public Calorie(int minage, int maxage, int calWoman, int hWoman, float wWoman, int calMan, int hMan, float wMan) {
		super();
		this.minage = minage;
		this.maxage = maxage;
		this.calWoman = calWoman;
		this.hWoman = hWoman;
		this.wWoman = wWoman;
		this.calMan = calMan;
		this.hMan = hMan;
		this.wMan = wMan;
	}
	
	public int getMinage() {
		return minage;
	}


	public void setMinage(int minage) {
		this.minage = minage;
	}


	public int getMaxage() {
		return maxage;
	}


	public void setMaxage(int maxage) {
		this.maxage = maxage;
	}
	
	public int getCalWoman() {
		return calWoman;
	}

	public void setCalWoman(int calWoman) {
		this.calWoman = calWoman;
	}

	public int gethWoman() {
		return hWoman;
	}

	public void sethWoman(int hWoman) {
		this.hWoman = hWoman;
	}

	public float getwWoman() {
		return wWoman;
	}

	public void setwWoman(float wWoman) {
		this.wWoman = wWoman;
	}

	public int getCalMan() {
		return calMan;
	}

	public void setCalMan(int calMan) {
		this.calMan = calMan;
	}

	public int gethMan() {
		return hMan;
	}

	public void sethMan(int hMan) {
		this.hMan = hMan;
	}

	public float getwMan() {
		return wMan;
	}

	public void setwMan(float wMan) {
		this.wMan = wMan;
	}

	@Override
	public String toString() {
		return String.format(
				"Calorie [minage=%s, maxage=%s, calWoman=%s, hWoman=%s, wWoman=%s, calMan=%s, hMan=%s, wMan=%s]",
				minage, maxage, calWoman, hWoman, wWoman, calMan, hMan, wMan);
	}
	
}
