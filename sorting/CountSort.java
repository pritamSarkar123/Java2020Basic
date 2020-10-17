package sorting;

public class CountSort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// can not deal with negative numbers
		//need separate array for positive(from -ve)
		//Arrange it in descending order
		// concat it with main array
		// after again sign conversion
		int[] arr= {10,10,10,9,8,7,6,5,4,3,3,2,1};
		int max=findMax(arr);
		int[] count=new int[max+1];
		for(int i=0;i<count.length;i++) {
			count[i]=0;
		}
		for(int i=0;i<arr.length;i++) {
			count[arr[i]]++;
		}
		int i=0,j=0;
		while(j<count.length) {
			while(count[j]>0) {
				arr[i++]=j;
				count[j]--;
			}
			j++;
		}
		for(i=0;i<arr.length;i++) {
			System.out.print(arr[i]+" ");
		}
	}
	public static int findMax(int[] arr) {
		int max=arr[0];
		for(int i=1;i<arr.length;i++) {
			if(max<arr[i]) max=arr[i];
		}
		return max;
	}

}
