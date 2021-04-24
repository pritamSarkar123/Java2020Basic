package inharitanceOne;

import inharitanceOne.another.Person;

public class Singer extends Person{
	public Singer(String name) {
		super(name);
	}
	public void eat() {
		super.eat();
	}
	public void walk() {
		super.walk();
	}
	public void sing() {
		System.out.println(name+" is singing");
	}
	public static void laugh() {
		System.out.println("Singer is laughing");
	}
}
