package finalKeyWord;

public final class FinalClass extends NonFInalClass {
	//global final variables must be initialized
	//global static and non static final variables
	//they are blanks now
	final static int a;
	final static int b;
	final int c;
	final int d;
	final int e;
	final int f;
	//initializing non static global final variables
	{
		c=10;d=20;
	}
	//initializing static global final variables
	static {
		a=15;b=25;
	}
	public FinalClass() { //initializing nonstatic global final variables using constructor
		e=30;f=40;
	}
	public static void methOne() {
		final int x;
		//but local finals can remain uninitialized
		//will not generates errors until we use it 
		System.out.println("local final variable remains un initialized");
	}
	//v-- below case leads to error as , final method can not be overridden
//	public static void methTwo() {
//		System.out.println("Trying to overload");
//	}
}
