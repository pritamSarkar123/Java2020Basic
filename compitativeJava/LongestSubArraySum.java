package compitativeJava;

public class LongestSubArraySum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//contiguous + ordered -> sub array
		//non contiguous + un ordered -> sub sequence
		
		brutForce();
		brutForceSegmentArray();
		kadane_s();
	}
	public static void brutForce() { //O(n^3)
		int []arr= {-1,4,-2,4,-1,3,5,-6};
		int n=arr.length;
		int max_l = 0,max_h=0;
		int maxSum=Integer.MIN_VALUE;
		for(int d=1;d<=n;d++) {
			int m=0;
			for(int k=n-d+1;k>=1;k--) {
				int sum=0;
				for(int j=m;j<m+d;j++) {
					sum+=arr[j];
				}
				if(sum>maxSum) {
					maxSum=sum;
					max_l=m;max_h=m+d;
				}
				m++;
			}
		}
		for(int i=max_l;i<max_h;i++) {
			System.out.print(arr[i]+" ");
		}System.out.println();
		
		System.out.println("Maximum sum = "+maxSum);
	}
	public static void brutForceSegmentArray() {
		int []arr= {-1,4,-2,4,-1,3,5,-6};
		int n=arr.length;
		int []segmentArray=new int[arr.length];
		segmentArray[0]=arr[0];
		for(int i=1;i<n;i++) {
			segmentArray[i]=segmentArray[i-1]+arr[i]; //s[i]=s[i-1]+a[i]
		}
		int max_l = 0,max_h=0;
		int maxSum=Integer.MIN_VALUE;
		for(int d=1;d<=n;d++) {
			int m=0;
			for(int k=n-d+1;k>=1;k--) {
				int sum=segmentArray[m+d-1]-segmentArray[m]+arr[m]; //sum=s[j]-s[i]+a[i]
				if(sum>maxSum) {
					maxSum=sum;
					max_l=m;max_h=m+d;
				}
				m++;
			}
		}
		for(int i=max_l;i<max_h;i++) {
			System.out.print(arr[i]+" ");
		}System.out.println();
		
		System.out.println("Maximum sum = "+maxSum);
	}
	public static void kadane_s() {
		//https://www.geeksforgeeks.org/largest-sum-contiguous-subarray/
		int []arr= {-1,4,-2,4,-1,3,5,-6};
		int n=arr.length;
		int start=0;
		int end=0;
		int maxSum=Integer.MIN_VALUE;
		int currentSum=0;
		for(int i=0;i<n;i++) {
			currentSum+=arr[i];
			if(currentSum > maxSum && currentSum>0) { 
				maxSum=currentSum;
				end=i;
			}
			else if(currentSum<0) {
				currentSum=0; // discarding the prev sub array , as it leading to less value
				start=i+1;
			}
		}
		if(start<arr.length) {
			for(int i=start;i<=end;i++) {
				System.out.print(arr[i]+"->");
			}System.out.println();
		}
		System.out.println("Maximum Sum = "+maxSum);
	}
}
