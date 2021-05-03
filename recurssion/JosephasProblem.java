package recurssion;

public class JosephasProblem {
	public static void main(String[] args) {
		//this is an advanced recurssion problem
		// available in youtube by Anuj kumar sharma
		System.out.println(findWiner(6,3));
	}
	public static int findWiner(int n,int k) {
		if(n==1) return 0;
		return (findWiner(n-1,k)+k)%n;
	}
}
