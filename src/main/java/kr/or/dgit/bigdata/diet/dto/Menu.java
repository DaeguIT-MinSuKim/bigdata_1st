package kr.or.dgit.bigdata.diet.dto;

public class Menu {

	private int no;
	private String grp;
	private String item;
	private int cal;
	private int fat;
	private int carbo;
	private int protein;
	private int cost;
	private String con;
	private String mealTime;
	
	public Menu() {	}
	
	public Menu(int no, String grp, String item, int cal, int fat, int carbo, int protein, int cost, String con, String mealTime) {
		this.no = no;
		this.grp = grp;
		this.item = item;
		this.cal = cal;
		this.fat = fat;
		this.carbo = carbo;
		this.protein = protein;
		this.cost = cost;
		this.con = con;
		this.mealTime = mealTime;
	}
	public int getNo() {return no;	}
	public String getGrp() 	{return grp;	}
	public String getItem() {return item;	}
	public int getCal() 	{return cal;	}
	public int getFat() 	{return fat;	}
	public int getCarbo() 	{return carbo;	}
	public int getProtein() {return protein;	}
	public int getCost() 	{return cost;	}
	public String getCon() 	{return con;	}
	public void setNo(int no) {
		this.no = no;
	}
	public void setGrp(String grp) {
		this.grp = grp;
	}
	public void setItem(String item) {
		this.item = item;
	}
	public void setCal(int cal) {
		this.cal = cal;
	}
	public void setFat(int fat) {
		this.fat = fat;
	}
	public void setCarbo(int carbo) {
		this.carbo = carbo;
	}
	public void setProtein(int protein) {
		this.protein = protein;
	}
	public void setCost(int cost) {
		this.cost = cost;
	}
	public void setCon(String con) {
		this.con = con;
	}
	
	
	public String getMealTime() {
		return mealTime;
	}

	public void setMealTime(String mealTime) {
		this.mealTime = mealTime;
	}

	@Override
	public String toString() {
		return String.format("Menu [no=%s, grp=%s, item=%s, cal=%s, fat=%s, carbo=%s, protein=%s, cost=%s, con=%s]", no,
				grp, item, cal, fat, carbo, protein, cost, con);
	}
	
	public String[] toArray(){
		return new String[]{grp, item, cal+"", fat+"", carbo+"", protein+"", cost+""};
	}
	
	
	
	
	
}
