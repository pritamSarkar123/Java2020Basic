package mathCompitatuve;

import java.util.Arrays;

public class SieveOfEratrosthenes {
	//Problem:-https://www.youtube.com/watch?v=nDPo9hsDNvU&list=PLfqMhTWNBTe0b2nM6JHVCnAkhQRGiZMSJ&index=36
	public static void main(String[] args) {
		
		noOfPrimesInRange(50);
		primeFactor(46);
	}
	public static void noOfPrimesInRange(int n) {
		//general method takes O(n * n^(1/2))=>O(n^(3/2)) time
		//sieve method takes O(n^(1/2) * n^(1/2)) => 
		int primes[]=new int[n+1];
		Arrays.fill(primes,0);
		for(int i=2;i*i<=n;i++) {
			if(primes[i]==0) {
				for(int j=i*i;j<=n;j+=i) {
					if(primes[j]==0) primes[j]=1;
				}
			}
		}
		for(int i=2;i<=n;i++) {
			if(primes[i]==0)
				System.out.print(i+" ");
		}System.out.println();
	}
	public static void primeFactor(int n) {
		int spf[]=new int[n+1];
		for(int i=1;i<=n;i++) spf[i]=i;
		
		for(int i=2;i*i<=n;i++) {
			if(spf[i]==i) {
				for(int j=i*i;j<=n;j+=i) {
					if(spf[j]==j) spf[j]=i;
				}
			}
		}
		while(n>1) {
			System.out.print(spf[n]+" ");
			n=n/spf[n];
		}System.out.println(1);
	}

}
