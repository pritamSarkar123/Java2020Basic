package dynamicProgramming;

import java.util.Arrays;

public class DimentionOfLargestSquareMatrixOfOnes {

	public static void main(String[] args) {
		
		int[][] outerMatrix= {
				{1,0,0,1,0,1},
				{0,1,1,1,1,0},
				{1,1,1,1,0,1},
				{0,1,1,1,0,1},
				{0,0,0,0,1,1},
				{0,0,1,0,1,1}
		};
		findLargestOnesSquareMatrix(outerMatrix);
	}
	public static void findLargestOnesSquareMatrix(int[][] outerMatrix) {
		int[][] auxilary=new int[outerMatrix.length][outerMatrix[0].length];
		int maxDim=0;
		for(int i=0;i<outerMatrix.length;i++) {
			for(int j=0;j<outerMatrix[0].length;j++) {
				if(i==0 || j==0 || outerMatrix[i][j]==0) {
					auxilary[i][j]=outerMatrix[i][j];
				}else{
					if(outerMatrix[i-1][j-1]==1 && outerMatrix[i-1][j]==1 && outerMatrix[i][j-1]==1)
						auxilary[i][j]=auxilary[i-1][j-1]+1;
					else auxilary[i][j]=outerMatrix[i][j];
				}
				if(maxDim<auxilary[i][j]) maxDim=auxilary[i][j];
			}
		}
		System.out.println(maxDim);
		for(int[] a:auxilary) {
			System.out.println(Arrays.toString(a));
		}
	}

}
