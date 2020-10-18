package interfaceJava8;

public class Student {
	private static String name;
	public static void setName(String n) {
		name=n;
	}
	public static void studentDetails() {
		System.out.println("This is "+name);
	}
}
