package recurssion;

import java.util.Scanner;
public class Permuttion {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		char[] str =sc.nextLine().toCharArray();
		char[] R=new char[str.length];
		int[] Available=new int[str.length];
		System.out.println("One---------------------");
		permuteOne(str,R,Available,0);
		System.out.println("Two---------------------");
		permuteTwo(str, 0, str.length-1);
		sc.close();
	}
	public static void permuteOne(char[] str,char[] R,int[] available,int k) {
		if(k==str.length) {
			for(char c:R) {
				System.out.print(c);
			}
			System.out.println();
			return;
		}
		for(int i=0;i<str.length;i++) {
			if(available[i]==0) {
				available[i]=1;
				R[k]=str[i];
				permuteOne(str,R,available,k+1);
				available[i]=0;
			}
		}
	}
	public static void permuteTwo(char[] str,int l,int h) {
		if(l==h) {
			for(char c:str) {
				System.out.print(c);
			}
			System.out.println();
			return;
		}
		for(int i=l;i<=h;i++) {
			swap(str,i,l);
			permuteTwo(str, l+1, h);
			swap(str,i,l);
		}
	}
	public static void swap(char[] str,int i,int j) {
		char temp=str[i];
		str[i]=str[j];
		str[j]=temp;
	}
	
}
