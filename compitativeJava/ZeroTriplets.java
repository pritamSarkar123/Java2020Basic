package compitativeJava;
import java.util.Arrays;
public class ZeroTriplets {

	public static void main(String[] args) {
		//Problem:-https://practice.geeksforgeeks.org/problems/find-triplets-with-zero-sum/1
		//{9,21,64,50,82 ,31, 42 ,-33, 62, 24, 19, -30, 28, -2, 73, 23, 94, -45, 84, 7 ,1, 25, 20, 77, 9 ,-6 ,56, 2, 3, 3, 64 ,83, 28 ,-24, 59, -37, 55, 43, 77 ,-22 ,24};
	    
	    //{97 ,-27 ,2 ,-34 ,61,-39};
		int[] array= {9,21,64,50,82 ,31, 42 ,-33, 62, 24, 19, -30, 28, -2, 73, 23, 94, -45, 84, 7 ,1, 25, 20, 77, 9 ,-6 ,56, 2, 3, 3, 64 ,83, 28 ,-24, 59, -37, 55, 43, 77 ,-22 ,24};
	    
		System.out.println(findTriplets(array));
		
	}
	public static boolean findTriplets(int[] array) {
		Arrays.sort(array);
		boolean match=false;
		for(int i=0;i<array.length;i++) {
			if(findMatch(i,array)) {
				match=true;
			}
		}
		if(match)return true;
		return false;
	}
	public static boolean findMatch(int index,int[] array) {
		int p=0,q=array.length-1,value=-array[index],num;
		while(p<q) {
			if(index==p) p++;
			else if(index==q) q--;
			else {
				num=array[p]+array[q];
				//System.out.println(num+" "+value);
				if(num>value) q--; //decreasing highest value
				else if(num<value) p++; //increasing lowest value
				else {
					System.out.println(array[p]+" "+array[q]+" "+(-value));
					return true;
				}
			}
		}
		return false;
	}
}
