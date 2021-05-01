package sorting;

import java.util.Arrays;

public class MergeSortIterative {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//time O(n log n) log n passes ,in each passes n merges
		//space O(n) only auxilary space no recurssive space -.-
		mergeSortIter();
	}
	public static void merge(int[] arr,int[] aux,int i,int m,int j) {
		int a=i;
		int b=m;
		int k=i;
		while(a<=m-1 && b<=j) {
			if(arr[a]<=arr[b]) aux[k++]=arr[a++];
			else aux[k++]=arr[b++];
		}
		while(a<=m-1) aux[k++]=arr[a++];
		while(b<=j) aux[k++]=arr[b++];
		for(k=i;k<=j;k++) arr[k]=aux[k];
//		System.out.println("from "+i+" to "+m+" then "+j);
//		for(int p=i;p<=j;p++) {
//			System.out.print(arr[p]+" ");
//		}System.out.println();
	}
	public static void mergeSortIter() {
		int[] arr= {10,10,10,9,8,7,6,5,4,3,3,2,1};
		int len=arr.length;
		int[] aux=new int[len];
		int d=2;
		while(d<=len) {
			int i=0;
			int j=i+d-1;
			while(j<len) {
				merge(arr,aux,i,i+d/2,j);
//				System.out.println(arr.length+" "+i+" "+j+" "+d/2);
				i+=d; //i=j+1;
				j=i+d-1;
			}
			if(i<len && j>=len) {
				merge(arr,aux,i-d,i,len-1);
			}
			d*=2;
		}
		System.out.println(Arrays.toString(arr));
	}

}
