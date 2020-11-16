package compitativeJava;
import java.util.*;
public class SubSetSumZero {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//Given an array find whether there exist a subset whose sum=0
		//O(n)
		//Problem: https://www.youtube.com/watch?v=PSpuM9cimxA&list=PLKKfKV1b9e8ps6dD3QA5KFfHdiWj9cB1s&index=49
		
		int[] arr= {3,4,-1,4,3,-6,-7,2};
		boolean found=false;
		int sum=0;
		Set<Integer> s=new HashSet<>();
		for(int element:arr) {
			sum+=element;
			if(sum==0 || s.contains(sum)) {
				found=true; break;
			}
			s.add(sum);
		}
		if(found) {
			System.out.println("yes the subset of sum of element = 0 is present");
		}else {
			System.out.println("yes the subset of sum of element = 0 is not present");
		}
	}

}
