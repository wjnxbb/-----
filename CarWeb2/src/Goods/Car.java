package Goods;

public class Car {
	private String name;
	private String year;
	//���ֳ�����
	private String text;
	private float price;
	private String grade;
	private String id;
	private int state=1;
	public int getState() {
		return state;
	}
	public void setState(int state) {
		this.state = state;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getId() {
		return id;
	}
	public Car() {
		
	}
	public String getGrade() {
		return grade;
	}
	public void setGrade(String grade) {
		this.grade = grade;
	}
	public Car(String grade,String name,String year,String text,float price){
		this.grade=grade;
		this.name = name;
		this.year=year;
		this.text=text;
		this.price=price;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getYear() {
		return year;
	}
	public void setYear(String year) {
		this.year = year;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	
}
