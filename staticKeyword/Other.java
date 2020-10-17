package staticKeyword;

public class Other {
	static class A{
		
	}
	class B{
		
	}
	private static int noOfObjects=0;
	Other(){
		noOfObjects++;
	}
	
	public static void fuckU() {
		System.out.println("Fuck you!");
	}
	
	public static int noOf_Objects() {
		return noOfObjects;
	}
	
}
