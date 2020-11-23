package mathCompitatuve;

public class Power {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(powerFindOldIterative(2,8));
		System.out.println(powerFindNewIterative(112,7));
		System.out.println(powerInModulo(112,7,Long.MAX_VALUE));
	}
	public static long powerFindOldIterative(int a,int b) {
		long result=1;
		while(b>=1) {
			result =result *a;
			b--;
		}
		return result;
	}
	public static long powerFindNewIterative(int a,int b) {
//		eg:
//			r	a	b
//			1	2	7
//		1*2=2	2	6
//			2	4	3
//		2*4=8	4	2
//			8	16	1
//		at last:- 8*16
		long result=1;
		while(b>0) {
			if((b & 1)!=0) {
				result*=a;
				b-=1; // optional as int/int alwayes int lower bounded
			}
			a*=a;
			b>>=1;
		}
		return result;
	}
	public static long powerInModulo(long a,long b,long n) {
//		(a+b)%n==(a%n + b%n)%n
//		(a-b)%n==(a%n - b%n)%n
//		(a*b)%n==(a%n * b%n)%n ..etc
		long result=1;
		while(b>0) {
			if((b & 1)!=0) {
				result=(result%n * a%n)%n;
				//result=(result * a%n)%n; same as result always <n 
				b-=1; // optional as int/int alwayes int lower bounded
			}
			a=(a%n * a%n)%n;
			b>>=1;
		}
		return result;
	}

}
