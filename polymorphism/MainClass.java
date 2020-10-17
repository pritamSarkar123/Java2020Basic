package polymorphism;

public class MainClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Dog d=new Dog();
		Pet p=d; //upcasting
		Animal a=p;//or Animal a = d;//upcasting
		
		System.out.println("Checking run time poly morphism");
		//slower as linker need to check and link runtime
		d.walk();
		p.walk();
		//a.walk();<- this gives compile time error as no method named "walk()" is present
		//Animal class which can be overridden by Dog class'es method "walk()"
		
		System.out.println("Checking compile time poly morphism");
		//faster as methods are linked in prior in compile time by compiler
		//linker overheads are reduced
		//like method overloading
		d.eat("Pumba");
		p.eat();
		
		//conclusion
		//method overloading needed for compile time polymorphism
		//method overridding needed for run time polymorphism
	}

}
