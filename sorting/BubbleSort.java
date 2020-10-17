package sorting;

public class BubbleSort {

	public static void main(String[] args) {
		int[] arr= {10,9,8,7,6,5,4,3,2,1};
		int swapCount=0;int compCount=0;
		int temp;
		boolean sorted;
		for(int i=0;i<arr.length;i++) {
			sorted=true;
			for(int j=0;j<arr.length-i-1;j++) {
				compCount++;
				if(arr[j]>arr[j+1]) {
					sorted=false;
					temp=arr[j];
					arr[j]=arr[j+1];
					arr[j+1]=temp;
					swapCount++;
				}
			}
			if(sorted) break;
		}
		System.out.println("comparisons= "+compCount+" swaps= "+swapCount);
		for(int x:arr) {
			System.out.print(x+" ");
		}
	}

}
