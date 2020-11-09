package compitativeJava;
import java.util.*;
//Problem:-https://www.youtube.com/watch?v=XDJKHtXJHBY&t=10s
public class SlidingWindow {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr= {4,3,1,2,5,3,4,7,1,9};
		int k=4;
		int[] result=slideMaxElement(arr,k);
		for(int x:result) {
			System.out.print(x+" ");
		}
	}
	public static int[] slideMaxElement(int[] arr,int k) {
		Deque<Integer> dq=new LinkedList<>(); //to store the indices, based on value order
		int len=arr.length;
		if(len==0) return arr;
		int[] result=new int[len-k+1];
		//for the starting window
		int i=0;
		for(;i<k;i++) {
			while(!dq.isEmpty() && arr[dq.peekLast()]<=arr[i]) {
				dq.pollLast();
			}
			dq.addLast(i);
		}
		//for remaining elements
		for(;i<len;i++) {
			result[i-k]=arr[dq.peekFirst()];
			//1st check left most element in range of window or not
			while(!dq.isEmpty() && dq.peekFirst()<=i-k) {
				dq.pollFirst();
			}
			while(!dq.isEmpty() && arr[dq.peekLast()]<=arr[i]) {
				dq.pollLast();
			}
			dq.addLast(i);
		}
		result[i-k]=arr[dq.peekFirst()]; //the last Slide max
		return result;
	}

}
