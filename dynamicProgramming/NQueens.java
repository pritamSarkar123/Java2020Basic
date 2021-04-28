package dynamicProgramming;

import java.util.Arrays;

public class NQueens {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] board=new int[4][4];
//		nQueensOne(board,0);
		nQueensMultiple(board,0);
	}
	public static void nQueensMultiple(int[][] board,int row) {
		if(row==board.length) {
			System.out.println("final board--->");
			for(int[] a:board) System.out.println(Arrays.toString(a));
		}else {
			for(int col=0;col<board.length;col++) {
				if(isSafe(board, row, col)) {
					board[row][col]=1;
					nQueensMultiple(board,row+1);
					board[row][col]=0;
				}
			}
		}			
	}
	public static boolean isSafe(int[][] board,int p,int q) {
		int i;
		int j;
		//top right check
		i=p-1;j=q+1;
		while(i>=0 && j<board.length) {
			if(board[i][j]==1) return false;
			i--;j++;
		}
		//bottom right check
		i=p+1;j=q+1;
		while(i<board.length && j<board.length) {
			if(board[i][j]==1) return false;
			i++;j++;
		}
		//top left check
		i=p-1;j=q-1;
		while(i>=0 && j>=0) {
			if(board[i][j]==1) return false;
			i--;j--;
		}
		//bottom left check
		i=p+1;j=q-1;
		while(i<board.length && j>=0) {
			if(board[i][j]==1) return false;
			i++;j--;
		}
		// check top to bottom
		i=0;
		j=q;
		while(i<board.length) {
			if(i!=p && board[i][j]==1) return false;
			i++;
		}
		return true;
	}
	public static boolean nQueensOne(int[][] board,int row) {
		// T(n)=n*T(n-1)+O(n^2) ------>~~ O(n!)
		if(row==board.length) {
			for(int[] a:board) {
				System.out.println(Arrays.toString(a));
			}
			return true;
		}else {
			for(int col=0;col<board.length;col++) {
				if(isSafe(board,row,col)) {
					board[row][col]=1;
					if(nQueensOne(board,row+1)) {
						return true;
					}else {
						board[row][col]=0;
					}
				}
			}
			return false;
		}
	}
}
