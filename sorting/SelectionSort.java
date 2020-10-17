package sorting;

public class SelectionSort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr= {10,9,8,7,6,5,4,3,2,1};
		int swapCount=0;int compCount=0;
		int temp,minposition;
		for(int i=0;i<arr.length;i++) {
			minposition=i;
			for(int j=i;j<arr.length;j++) {
				compCount++;
				if(arr[minposition]>arr[j]) minposition=j;
			}
			if(minposition!=i) {
				swapCount++;
				temp=arr[i];
				arr[i]=arr[minposition];
				arr[minposition]=temp;
			}
		}
		System.out.println("comparisons= "+compCount+" swaps= "+swapCount);
		for(int x:arr) {
			System.out.print(x+" ");
		}
	}

}
