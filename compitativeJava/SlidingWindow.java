package compitativeJava;
import java.util.*;
//Problem:-https://www.youtube.com/watch?v=XDJKHtXJHBY&t=10s
public class SlidingWindow {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr= {1,3,-1,-3,5,3,6,7};
		int k=3;
		int[] result=slideMaxElement(arr,k);
		for(int x:result) {
			System.out.print(x+" ");
		}
	}
	public static int[] slideMaxElement(int []arr,int k) {
		if(arr.length==0) return arr;
		Deque<Integer> indices=new LinkedList<>();
		int []result=new int[arr.length-k+1];
		int start=0;
		while(start<k) {
			while(!indices.isEmpty() && arr[indices.peekLast()]<=arr[start]) indices.pollLast();
			indices.addLast(start);
			start++;
		}
		int end=0;
		while(start<arr.length) {
			end=start-k+1;
			result[end-1]=arr[indices.peekFirst()];
			while(!indices.isEmpty() && indices.peekFirst()<end) indices.pollFirst();
			while(!indices.isEmpty() && arr[indices.peekLast()]<=arr[start]) indices.pollLast();
			indices.addLast(start);
			start++;
		}
		end=start-k+1;
		result[end-1]=arr[indices.peekFirst()];
		return result;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
//	public static int[] slideMaxElement(int[] arr,int k) {
//		Deque<Integer> dq=new LinkedList<>(); //to store the indices, based on value order
//		int len=arr.length;
//		if(len==0) return arr;
//		int[] result=new int[len-k+1];
//		//for the starting window
//		int i=0;
//		//for first slide i goes from start to end of the slide
//		for(;i<k;i++) {
//			while(!dq.isEmpty() && arr[dq.peekLast()]<=arr[i]) {
//				dq.pollLast();
//			}
//			dq.addLast(i);
//		}
//		//i remains at the end position of each slide
//		//for remaining elements
//		for(;i<len;i++) {
//			result[i-k]=arr[dq.peekFirst()];
//			//1st check left most element in range of window or not
//			while(!dq.isEmpty() && dq.peekFirst()<=i-k) {
//				dq.pollFirst();
//			}
//			while(!dq.isEmpty() && arr[dq.peekLast()]<=arr[i]) {
//				dq.pollLast();
//			}
//			dq.addLast(i);
//		}
//		result[i-k]=arr[dq.peekFirst()]; //the last Slide max
//		return result;
//	}

}
