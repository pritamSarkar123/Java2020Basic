package cycleFinding;
import java.util.*;
public class InUndirectedGraph {
	static Set<Integer> white=new HashSet<>();
	static Set<Integer> gray=new HashSet<>();
	static Set<Integer> black=new HashSet<>();
	public static void main(String[] args) {
		// https://www.youtube.com/watch?v=rKQaZuoUR4M
		// worst case recurssion depth no of edges (E)
		// time O(EV) // E times recursion depth, and V time iteration in each step 
		//space O(V)
		
		/* 1--->2
		 * \   /
		 *  \ /
		 *   V
		 *   3
		 * */
//		int[][] graph= {
//				{0,1,1},{0,0,1},{0,0,0}
//		};
		int[][] graph= {
				{0,1,0},{0,0,1},{1,0,0}
		};
		System.out.println(haveCycles(graph));
	}
	public static boolean haveCycles(int[][] graph) {
		for(int i=0;i<graph.length;i++) {
			white.add(i);
		}
		int i=0;
		while(!white.isEmpty()) {
			if(white.contains(i)) {
				if(findCycle(graph,i)) return true;
			}
			i++;
		}
		return false;
	}
	public static boolean findCycle(int[][] graph,int n) {
		if(gray.contains(n)) return true;
		if(white.contains(n) && !black.contains(n)) {
			white.remove(n);
			gray.add(n);
			for(int j=0;j<graph.length;j++) {
				if(graph[n][j]!=0) {
					if(findCycle(graph,j)) return true;
				}
			}
			gray.remove(n);
			black.add(n);
		}
		return false;
	}
}
