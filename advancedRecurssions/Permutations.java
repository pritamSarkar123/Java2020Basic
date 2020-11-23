package advancedRecurssions;

import java.util.HashSet;
import java.util.Set;
import java.util.Scanner;
public class Permutations {
	public static Set<String> set=new HashSet<>();
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//https://www.youtube.com/watch?v=JMxl5rk7kGo
		Scanner sc=new Scanner(System.in);
		char[] str=sc.nextLine().toCharArray();
		uniquePermutations(str, 0, str.length-1);
		sc.close();
	}
	public static void uniquePermutations(char[] str,int l,int h) {
		if(l==h) {
			String s=String.valueOf(str);
			if(set.contains(s)) return;
			set.add(s);
			System.out.println(s);
			return;
		}
		for(int i=l;i<=h;i++) {
			swap(str,l,i);
			uniquePermutations(str, l+1, h);
			swap(str,l,i);
		}
	}
	public static void swap(char[] str,int i,int j) {
		char temp=str[i];
		str[i]=str[j];
		str[j]=temp;
	}

}
