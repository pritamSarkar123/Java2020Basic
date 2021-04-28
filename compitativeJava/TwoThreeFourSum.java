package compitativeJava;

import java.util.Arrays;

public class TwoThreeFourSum {

	public static void main(String[] args) {
		int[] a=new int[]{1,2,4,5,3,4,2,1};
		twoSum(a,8);
		threeSum(a,6);
		fourSum(a,10);
	}
	public static void fourSum(int[] arr,int target) {
		Arrays.sort(arr);
		for(int i=0;i<arr.length;i++) {
			for(int j=i+1;j<arr.length;j++) {
				int p=j+1;
				int q=arr.length-1;
				while(p<q) {
					int sum=arr[p]+arr[q]+arr[i]+arr[j];
					if(sum==target) {
						System.out.println(arr[i]+" "+arr[j]+" "+arr[p]+" "+arr[q]);
						p++;q--;
					}else if(sum<target) p++;
					else q--;
				}
			}
		}
	}
	public static void threeSum(int[] arr,int target) {
		Arrays.sort(arr);
		for(int i=0;i<arr.length;i++) {
			int p=i+1;
			int q=arr.length-1;
			while(p<q) {
				int sum=arr[p]+arr[q]+arr[i];
				if(sum==target) {
					System.out.println(arr[i]+" "+arr[p]+" "+arr[q]);
					p++;q--;
				}else if(sum<target) p++;
				else q--;
			}
		}
	}
	public static void twoSum(int[] arr,int target) {
		Arrays.sort(arr);
		int p=0;
		int q=arr.length-1;
		while(p<q) {
			int sum=arr[p]+arr[q];
			if(sum==target) {
				System.out.println(arr[p]+" "+arr[q]);
				p++;q--;
			}
			else if(sum<target) p++;
			else q--;
		}
	}

}
