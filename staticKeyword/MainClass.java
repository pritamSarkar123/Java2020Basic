package staticKeyword;

import staticKeyword.Other.A;
import staticKeyword.Other.B;

public class MainClass {
	static {
		System.out.println("Static means class related not obj related");
		System.out.println("Static block will be accessed first");
	}
	static {
		System.out.println("Then this block,according to static block order");
	}
	public static void main(String[] args) {
		Other obj1=new Other();
		B objB=obj1.new B(); //B non static inner class
		System.out.println("Obj of non static inner B created using obj of outer class");
		A objA=new Other.A(); //static inner class,
		System.out.println("Obj of static inner A is created using class name only");
		
		Other.fuckU(); //no need of object creation directly we can call the static methods
		System.out.println(Other.noOf_Objects());
	}

}
