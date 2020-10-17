package compitativeJava;

import java.util.Scanner;
import java.util.Arrays;
public class CandyDistribution {

	public static void main(String[] args) {
		long sum=minNoOfCandiesRequired();
		System.out.println(sum);
	}
	public static long minNoOfCandiesRequired() {
		// TODO Auto-generated method stub
		//Problem:-https://www.hackerrank.com/challenges/candies/problem
		//https://www.youtube.com/watch?v=F_ISHYJ5GZs
		Scanner sc=new Scanner(System.in);
		int numOfStudents=sc.nextInt();
		int[] candies=new int[numOfStudents];
		int[] rancks=new int[numOfStudents];
		Arrays.fill(candies,1);
		for(int i=0;i<numOfStudents;i++) {
			rancks[i]=sc.nextInt();
		}
		//left to right
		for(int i=1;i<numOfStudents;i++) {
			if(rancks[i]>rancks[i-1])
				candies[i]=candies[i-1]+1;
		}
		// right to left
		for(int i=numOfStudents-1;i>0;i--) {
			if(rancks[i-1]>rancks[i]) {
				candies[i-1]=Math.max(candies[i]+1, candies[i-1]);
			}
		}	
		long sum=0;
		for(int i=0;i<numOfStudents;i++) {
			sum+=(long)candies[i];
		}
		sc.close();
		return sum;
	}

}
