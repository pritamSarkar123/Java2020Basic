package exceptionhandling;

public class MainClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// throws:- the function is going to throw an Exception
		// try:- if Exception been thrown into it, it redirects it to catch block
		// catch:- handles the exception, and continue code execution
		// finally:- must be executed, exception thrown or not
		System.out.println("This is main function");
		func1();

	}
	public static void func1() {
		try {
			func2();
		}catch(ArithmeticException e) {
			System.out.println(e.getMessage());
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		finally {
			System.out.println("This is essential info");
		}
	}
	public static void func2() throws Exception {
		int a=5;int b=0;
		int c=a/b;
		System.out.println(c);
		
//		Thread.sleep(3000);
		// Thread sleep must be in a try block or a throws function
	}

}
