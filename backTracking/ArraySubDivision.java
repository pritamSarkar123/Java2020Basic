package backTracking;

import java.util.ArrayList;
import java.util.List;

public class ArraySubDivision {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//Problem:- https://www.youtube.com/watch?v=S3rnLLHl0PM&t=139s
		int a[] = {2, 1, 2, 3, 4, 8};
		int sum=0;
		for(int element:a) {
			sum+=element;
		}
		if((sum & 1)!=0) {
			System.out.println("can not be partitioned");
		}else {
			List<Integer> al=new ArrayList<>();
			boolean possible=partition(a,sum/2,0,al);
			if(possible) {
				for(int x:al) {
					System.out.print(x+" ");
				}System.out.println();
			}else {
				System.out.println("can not be partitioned");
			}
		}
	}
	public static boolean partition(int []a,int sum,int i,List<Integer> al) {
		if(i>=a.length) return false;
		if(sum==0) return true;
		al.add(a[i]);
		boolean leftPossible=partition(a, sum-a[i], i+1, al);
		if(leftPossible) return true; //if left side possible then nothing to propagate
		al.remove(al.size()-1);
		return partition(a, sum, i+1, al);
	}

}
