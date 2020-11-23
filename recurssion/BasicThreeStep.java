package recurssion;

public class BasicThreeStep {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//https://www.youtube.com/watch?v=AqHoXqOgctU&list=PLKKfKV1b9e8ps6dD3QA5KFfHdiWj9cB1s&index=56
		
		//step 1: find the base condition (minimum i/p possible for that function)
		//step 2: find the relation between one step higher and one step lower problem
		//step 3: generalize the equation 
		
		System.out.println(factorial(5));
		System.out.println(pow(2,4));
		System.out.println(nNaturalNumberSum(10));
		System.out.println(pathFinderOne(5, 5));
		System.out.println(pathFinderTwo(1, 1, 5, 5));
		TOH('A','B','C',5);
		
	}
	public static long factorial(long n) {//O(N)
		if(n==1) return 1;
		else return n*factorial(n-1);
	}
	public static long pow(int a,int b) { //O(logN)
		if(b==0) return 1;
		else if(b%2==0) return pow(a*a,b/2);
		else return a*pow(a*a,(b-1)/2); //or a*pow(a,b-1);
	}
	public static long nNaturalNumberSum(int n) {//O(N)
		if(n==1) return 1;
		else return n+nNaturalNumberSum(n-1);
	}
	public static int pathFinderOne(int n,int m) { //smaller rectangle
		if(n==1 || m==1) return 1;
		else return pathFinderOne(n,m-1)+pathFinderOne(n-1,m);
	}
	public static int pathFinderTwo(int r,int c,int n,int m) {// starts from starting point
		if(r==n || c==m) return 1;
		else return pathFinderTwo(r+1, c, n, m)+pathFinderTwo(r, c+1, n, m);
	}
	public static void TOH(char a,char b,char c,int n) { //O(2^n-1)
		//(from,using,to,amount of disks)
		//when there is only one disk-> send it from source to destination
		//when there are n disk-> send n-1 disks from source to auxiliary using destination
		//then(1 disk left) send n th disk form source to destination
		//then resends n-1 disks from auxiliary to destination using source 
		if(n==1) {
			System.out.println("1 no disk form "+a+" to "+c);
			return;
		}
		TOH(a,c,b,n-1);
		System.out.println(n+" no disk form "+a+" to "+c);
		TOH(b,a,c,n-1);
	}
}
