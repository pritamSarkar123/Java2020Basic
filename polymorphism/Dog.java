package polymorphism;

public class Dog extends Pet{
	public void walk() {
		System.out.println("Dog is walking");
	}
	public void eat(String name) {
		System.out.println(name+" is eating");
	}
}
