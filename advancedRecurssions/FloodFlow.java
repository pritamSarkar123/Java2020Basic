package advancedRecurssions;

public class FloodFlow {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//https://www.youtube.com/watch?v=JMxl5rk7kGo
		int[][] arr= {
				{1,2,2,1},
				{1,3,2,2},
				{1,3,3,2},
				{2,3,2,2}
		};
		floodFlow(arr, 1, 1, 5, arr[1][1]);
		showArr(arr);

	}
	public static void floodFlow(int[][] arr,int r,int c,int color,int targetColor) {
		if(r<0 || r>=arr.length ||c<0 ||c>=arr[0].length) {
			return;
		}
		if(arr[r][c]!=targetColor) return;
		arr[r][c]=color;
		floodFlow(arr,r+1,c,color,targetColor);
		floodFlow(arr,r-1,c,color,targetColor);
		floodFlow(arr,r,c+1,color,targetColor);
		floodFlow(arr,r,c-1,color,targetColor);
	}
	public static void showArr(int[][] arr) {
		for(int[] a:arr) {
			for(int b:a) {
				System.out.print(b+" ");
			}
			System.out.println();
		}
	}
}
