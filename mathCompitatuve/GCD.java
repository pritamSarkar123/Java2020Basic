package mathCompitatuve;

public class GCD {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(gcd(24,60));
		System.out.println(lcm(24,60));
	}
	public static int gcd(int a,int b) {
		return a%b==0?b:gcd(b,a%b);
	}
	public static int lcm(int a,int b) {
		return (a*b)/gcd(a,b);
	}
}
