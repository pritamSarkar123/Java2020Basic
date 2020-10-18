package methodOverridding;

public class MainClass {

	public static void main(String[] args) {
		ChildClass c=new ChildClass();
		ParentClass p=c;
		
		System.out.println("ParentClass variable ChildClass obj reference(upcasting)");
		// those method which belongs from parent class can be accessed
		p.methOne(); //runtime poly
		p.methTwo(); //runtime poly
		p.methFive();
		System.out.println("Child class object");
		// all methods (overridden+inharited) of child class can be accessed
		c.methOne();
		c.methTwo();
		c.methThree();
		c.methFour();
		c.methFive();
	}

}
