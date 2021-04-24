package staticKeyword;

import staticKeyword.Other.A;
import staticKeyword.Other.B;
/*
 * https://www.javatpoint.com/static-keyword-in-java
	Java(static)
	1. block [member,closure]
	2. method [member,closure]
	3. variable [member]
	4. class [member,closure]

1st: (non final )static member[block,method,variable,class] can not be declared within non static inner closure
	it should be in top most closure or
	it should be in static inner closure(static method / static inner class etc)
	or the static variable(variable only) become final(inner class non static)
	
2nd: static inner classes object can easily be created using outer classes name
3rd: static blocks get executed at the time of class loading
 */
public class MainClass {
	static int x=6; 
	static {
		System.out.println("Static means class related not obj related");
		System.out.println("Static block will be accessed first "+x);
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
//problem
class MyClass{
	class MyClassInnerOne{
//		static int v=5; <- non static inner type error
		public static final int v=5; // solution 1
	}
	static class MyClassInnerTwo{ //solution 2
		public static int x=89;
	}
}
