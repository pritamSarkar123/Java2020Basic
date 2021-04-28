package greedy;
import java.util.*;
//Edge present in PrimesUndrected
public class KruskalsUndirected {
	/* Let us create the following graph 
    2 3 
(0)--(1)--(2) 
| / \ | 
6| 8/ \5 |7 
| / \ | 
(3)-------(4) 
        9     */

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//O(V log E) time
		int[][] graph={ { 0, 2, 0, 6, 0 }, 
                { 2, 0, 3, 8, 5 }, 
                { 0, 3, 0, 0, 7 }, 
                { 6, 8, 0, 0, 9 }, 
                { 0, 5, 7, 9, 0 } };
		kruskalsUndirected(graph);
	}
	public static void kruskalsUndirected(int[][] graph) {
		boolean[][] heapified=new boolean[graph.length][graph[0].length];
		PriorityQueue<Edge> pq=new PriorityQueue<>(Comparator.comparing(Edge::getDist));
		List<Edge> edges=new ArrayList<>();
		Set<Integer> s=new HashSet<>();
		for(int i=0;i<graph.length;i++) {
			for(int j=i;j<graph[i].length;j++) {
				if(graph[i][j]!=0 && !heapified[i][j]) {
					heapified[i][j]=heapified[j][i]=true;
					pq.add(new Edge(i,j,graph[i][j]));
				}
			}
		}
		int noOfEdges=graph.length-1;
		while(noOfEdges>0) {
			Edge e=pq.poll();
			if(!s.contains(e.getStart()) || !s.contains(e.getEnd())) {
				edges.add(e);
				s.add(e.getStart());
				s.add(e.getEnd());
			}
			noOfEdges--;
		}
		Iterator<Edge> it=edges.iterator();
		while(it.hasNext()) {
			Edge e=it.next();
			System.out.println(e.getStart()+"->"+e.getEnd()+"="+e.getDist());
		}
	}

}
