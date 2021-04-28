package dynamicProgramming;

import java.util.Arrays;

public class SudokuSolver {

	public static void main(String[] args) {
		/*For every unassigned index, there are 9 possible 
		 * options so the time complexity is O(9^(n*n))
		 */
		int[][] board= {{3, 0, 6, 5, 0, 8, 4, 0, 0 },
					    { 5, 2, 0, 0, 0, 0, 0, 0, 0 },
					    { 0, 8, 7, 0, 0, 0, 0, 3, 1 },
					    { 0, 0, 3, 0, 1, 0, 0, 8, 0 },
					    { 9, 0, 0, 8, 6, 3, 0, 0, 5 },
					    { 0, 5, 0, 0, 9, 0, 6, 0, 0 },
					    { 1, 3, 0, 0, 0, 0, 2, 5, 0 },
					    { 0, 0, 0, 0, 0, 0, 0, 7, 4 },
					    { 0, 0, 5, 2, 0, 6, 3, 0, 0 } };
		solveSudoku(board);
	}
	public static boolean isSafe(int[][] board,int p,int q,int val) {
		// checking inside the box
		int rowMultiple=p/3;
		int colMultiple=q/3;
		for(int i=rowMultiple*3;i<(rowMultiple+1)*3;i++) {
			for(int j=colMultiple*3;j<(colMultiple+1)*3;j++) {
				if(board[i][j]==val) return false;
			}
		}
		//checking the column
		for(int i=0;i<board.length;i++) {
			if(board[i][q]==val) return false;
		}
		//checking the row
		for(int i=0;i<board[0].length;i++) {
			if(board[p][i]==val) return false;
		}
		return true;
	}
	public static boolean solveSudoku(int[][] board) {
		boolean isFull=true;
		int i=-1,j=-1;
		//check for blank slot
		for(i=0;i<board.length;i++) {
			for(j=0;j<board[0].length;j++) {
				if(board[i][j]==0) {
					isFull=false;
					break;
				}
			}
			if(!isFull) break;
		}
		if(isFull) { // if all the slots are filled
			for(int[] a:board) {
				System.out.println(Arrays.toString(a));
			}
			return true;
		}
		// i j is the current blank slot
		for(int val=1;val<=9;val++) {
			if(isSafe(board,i,j,val)) {
				board[i][j]=val;
				if(solveSudoku(board)) return true;
				board[i][j]=0;
			}
		}// if no values from 1 to 9 can be assigned in this call then return false
		return false;
	}

}
