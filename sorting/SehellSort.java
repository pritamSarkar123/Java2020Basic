package sorting;

import java.util.Arrays;

public class SehellSort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// gaph- each time /2 O(n log n) time
		// gaph- each time based on next prime (O(n^3/2))
		// as advanced form of insertion sort, it is adaptive,order holding,inplace, comparison based
		shellShortOne();
		shellShortPracOne();
	}
	static void swap(int[] arr,int i,int j) {
		arr[i]=arr[i]^arr[j];
		arr[j]=arr[i]^arr[j];
		arr[i]=arr[i]^arr[j];
	}
	public static void shellShortPracOne() {
		int[] arr= {10,10,10,9,8,7,6,5,4,3,3,2,1};
		int len=arr.length;
		int gaph=len/2;
		while(gaph>=1) {
			int start=0;
			int end=start+gaph;
			while(end<len) {
				if(arr[start]>arr[end]) swap(arr,start,end);
				int startBackward=start;
				int back=startBackward-gaph;
				while(back>=0 && arr[back]>arr[startBackward]) {
					swap(arr,back,startBackward);
					startBackward=back;
					back=back-gaph;
				}
				start++;
				end=start+gaph;
			}
		gaph/=2;
		}
		System.out.println(Arrays.toString(arr));
	}
	public static void shellShortOne() {
		// improved version of insertion sort
				// it assumes :- checking in gaps, leads to less no of swapping
				//time taken O(n log(n))
				int[] arr= {10,10,10,9,8,7,6,5,4,3,3,2,1};
				int i,j,temp;
				for(int gaph=arr.length/2;gaph>0;gaph/=2) { //log(n)
					i=gaph;
					while(i<arr.length) {//n
						j=i-gaph;
						temp=arr[i];
						while(j>=0 && arr[j]>temp) {
							arr[j+gaph]=arr[j];
							j-=gaph;
						}
						arr[j+gaph]=temp;
						i++;
					}
				}
				for(i=0;i<arr.length;i++) {
					System.out.print(arr[i]+" ");
				}System.out.println();
	}

}
