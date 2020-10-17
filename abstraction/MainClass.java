package abstraction;

public class MainClass {

	public static void breeding(Animal a ) {
		System.out.println("it is a base class variable,derived class object");
		a.eating();
		a.walking();
	}
	public static void main(String[] args) {
		breeding(new Dog());
		breeding(new Cat());
	}
}
