package basicMath;
import java.util.Scanner;
public class CatalanNumber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//Problem:-https://www.geeksforgeeks.org/program-nth-catalan-number/
		//Cn=sum(i=0 to n-1)Ci*Cn-1-i
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		long []mem=new long[n+2];
		System.out.println(catalanRec(n));
		System.out.println(catalanDynam(n,mem));
		System.out.println(catalanBinom(n));
		for(long x:mem) {
			System.out.print(x+" ");
		}System.out.println();
		sc.close();
	}
	public static long catalanRec(int n) {
		if(n<=1) return 1;
		long result=0;
		for(int i=0;i<n;i++) {
			
			result+=catalanRec(i)*catalanRec(n-1-i);
		}
		return result;
	}
	public static long catalanDynam(int n,long[] mem) {
		mem[0]=1;
		mem[1]=1;
		for(int i=2;i<=n;i++) {
			mem[i]=0;
			for(int j=0;j<i;j++) {
				mem[i]+=mem[j]*mem[i-j-1];
			}
		}
		return mem[n];
	}
	public static long catalanBinom(int n) {
		long result=binomialCoeff(2*n,n);
		return result/(n+1);
	}
	public static long binomialCoeff(int n,int k) {
		long result=1;
		if((k > n-k) && n-k >=0 ) {
			k=n-k;
		}
		for(int i=0;i<k;i++) {
			result*=(n-i); // 2n.....n (.n! <- not calculated)
			result/=(i+1); //1......n (.n! <- not calculated)
		}
		return result;
	}
}
