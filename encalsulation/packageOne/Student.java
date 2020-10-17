package encalsulation.packageOne;

public class Student {
	private String name;
	private int roll;
	private int cls;
	public Student(){
		//as parameterized constructor present in order to initiate all
		// attributes by there default values we explicitly write this block
		//of code
		//other wise it will be considered that there is no default constructor
		//as parameterized constructor is already present
	}
	public Student(String name,int roll,int cls) {
		this.name=name;
		this.roll=roll;
		this.cls=cls;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getRoll() {
		return roll;
	}
	public void setRoll(int roll) {
		this.roll = roll;
	}
	public int getCls() {
		return cls;
	}
	public void setCls(int cls) {
		this.cls = cls;
	}
	public void getDetails() {
		System.out.println(this.name+" "+this.roll+" "+this.cls);
	}
}
