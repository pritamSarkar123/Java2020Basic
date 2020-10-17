package inharitanceOne;

import inharitanceOne.another.Person;
public class MainClass {

	public static void main(String[] args) {
		Teacher t1=new Teacher("Pritam");
		System.out.println(t1 instanceof Teacher);
		System.out.println(t1 instanceof Person);
		Teacher.laugh();
		t1.eat();
		t1.walk();
		t1.teach();
		
		System.out.println("Upcasting");
		Person p1=t1;
		System.out.println(p1 instanceof Teacher);
		System.out.println(p1 instanceof Person);
		System.out.println("Down casting");
		Teacher t2=(Teacher)p1;
		System.out.println(t2 instanceof Teacher);
		System.out.println(t2 instanceof Person);
		
//		Person p2=new Person();
//		p2.name="isjf";
//		p2.eat();
//		p2.walk();
//		Person.laugh();
		
//above can not be done as , the fields in Person are protected and in another package
	}

}
