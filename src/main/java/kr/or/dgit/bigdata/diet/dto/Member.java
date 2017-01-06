package kr.or.dgit.bigdata.diet.dto;

public class Member {

	private int no;
	private String name;
	private String gender;
	private int weight;
	private int age;
	private String phone;
	private String address;
	private int budget;
	
	public int getNo() {
		return no;
	}
	public String getName() {
		return name;
	}
	public String getGender() {
		return gender;
	}
	public int getWeight() {
		return weight;
	}
	public int getAge() {
		return age;
	}
	public String getPhone() {
		return phone;
	}
	public String getAddress() {
		return address;
	}
	public int getBudget() {
		return budget;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public void setWeight(int weight) {
		this.weight = weight;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public void setBudget(int budget) {
		this.budget = budget;
	}
	@Override
	public String toString() {
		return String.format("Member [no=%s, name=%s, gender=%s, weight=%s, age=%s, phone=%s, address=%s, budget=%s]",
				no, name, gender, weight, age, phone, address, budget);
	}

	
	
	
}
