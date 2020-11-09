package compitativeJava;
import java.util.PriorityQueue;
import java.util.Scanner;
public class KLargestElements {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//Problem:-https://practice.geeksforgeeks.org/problems/k-largest-elements3736/1#
		//Problem:-https://www.youtube.com/watch?v=FdObb76AmzM&t=24s
		//time:-O(NlogK)
		//space:-O(K)
		Scanner sc=new Scanner(System.in);
		int N,K,value;
		N=sc.nextInt();
		K=sc.nextInt();
		PriorityQueue<Integer> pq=new PriorityQueue<>();
		for(int i=0;i<N;i++) {
			value=sc.nextInt();
			if(i<K) {
				pq.add(value);
			}else {
				if(pq.peek()<value) {
					pq.remove();
					pq.add(value);
				}
			}
		}
		int[] arr=new int[K];
		for(int i=K-1;i>=0;i--) {
			arr[i]=pq.remove();
		}
		for(int i=0;i<K;i++) {
			System.out.print(arr[i]+" ");
		}
		System.out.println();
		sc.close();
	}

}
