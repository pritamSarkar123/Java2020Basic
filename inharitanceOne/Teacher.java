package inharitanceOne;

import inharitanceOne.another.Person;

public class Teacher extends Person{

	public Teacher() {}
	public Teacher(String name) {
		super(name);
	}
	public void eat() {
		super.eat();
	}
	public void walk() {
		super.walk();
	}
	public void teach() {
		System.out.println(name+" is teaching");
	}
	public static void laugh() {
		System.out.println("Teacher is laughing");
	}
}
