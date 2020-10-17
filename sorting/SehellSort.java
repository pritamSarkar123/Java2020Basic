package sorting;

public class SehellSort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
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
		}
	}

}
