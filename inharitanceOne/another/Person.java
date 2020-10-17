package inharitanceOne.another;

public class Person {
	protected String name;
	protected Person() {}
	protected Person(String name) {
		this.name=name;
	}
	protected void walk() {
		System.out.println(name+ " is walking");
	}
	protected void eat() {
		System.out.println(name+" is eating");
	}
	public static void laugh() {
		System.out.println("Person is laughing");
	}
}
