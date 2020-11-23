package backTracking;

public class MyMazeProblem {
	static int maxValue;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//Problem:-https://www.youtube.com/watch?v=S3rnLLHl0PM&t=139s
		int [][]a= {
				{ 1, 1, 1, 1, 1, 0, 0, 1, 1, 1 },
				{ 0, 1, 1, 1, 1, 1, 0, 1, 0, 1 },
				{ 0, 0, 1, 0, 1, 1, 1, 0, 0, 1 },
				{ 1, 0, 1, 1, 1, 0, 1, 1, 0, 1 },
				{ 0, 0, 0, 1, 0, 0, 0, 1, 0, 1 },
				{ 1, 0, 1, 1, 1, 0, 0, 1, 1, 0 },
				{ 0, 0, 0, 0, 1, 0, 0, 1, 0, 1 },
				{ 0, 1, 1, 1, 1, 1, 1, 1, 0, 0 },
				{ 1, 1, 1, 1, 1, 0, 0, 1, 1, 1 },
				{ 0, 0, 1, 0, 0, 1, 1, 0, 0, 1 },
		};
		maxValue=0;
		for(int i=0;i<a.length*a[0].length;i++) {
				maxValue++;
		}
		maxValue+=10;
		int pathValue=findSortestPath(a, 0, 0, 8, 0);
		if(pathValue>=maxValue) {
			System.out.println("Path not Possible");
		}else {
			System.out.println(pathValue);
		}
	}
	public static int findSortestPath(int [][]a,int i,int j,int x,int y) {
		int rows=a.length;
		int cols=a[0].length;
		boolean [][]v=new boolean[rows][cols]; //by default false
		return findSortestPath(a, i, j, x, y, v);
	}
	public static boolean isPossible(int [][]a,int i,int j,boolean [][]v) {
		return i>=0 && j>=0 && i<a.length && j<a[0].length && a[i][j]!=0 && !v[i][j];
	}
	public static int findSortestPath(int [][]a,int i,int j,int x,int y,boolean [][]v) {
		if(!isPossible(a, i, j, v)) return maxValue;
		if(i==x && j==y) return 0;
		v[i][j]=true;
		int leftPath=findSortestPath(a, i, j-1, x, y, v);
		int rightPath=findSortestPath(a, i, j+1, x, y, v);
		int topPath=findSortestPath(a, i-1, j, x, y, v);
		int bottomPath=findSortestPath(a, i+1, j, x, y, v);
		//1 <- for the current node value
		int finalPath=1+Math.min(Math.min(leftPath,rightPath),Math.min(topPath,bottomPath));
		v[i][j]=false;
		return finalPath;
	}
}
