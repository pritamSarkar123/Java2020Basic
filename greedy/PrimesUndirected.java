package greedy;
import java.util.*;
class Edge{
	private int start;
	private int end;
	private int dist;
	public Edge(int s,int e,int d) {
		start=s;end=e;dist=d;
	}
	public int getStart() {
		return start;
	}
	public void setStart(int start) {
		this.start = start;
	}
	public int getEnd() {
		return end;
	}
	public void setEnd(int end) {
		this.end = end;
	}
	public int getDist() {
		return dist;
	}
	public void setDist(int dist) {
		this.dist = dist;
	}
}
public class PrimesUndirected {
/* Let us create the following graph 
    2 3 
(0)--(1)--(2) 
| / \ | 
6| 8/ \5 |7 
| / \ | 
(3)-------(4) 
        9     */
// primes fails in case of disconnecte components
	public static void main(String[] args) {
		int[][] graph={ { 0, 2, 0, 6, 0 }, 
	                { 2, 0, 3, 8, 5 }, 
	                { 0, 3, 0, 0, 7 }, 
	                { 6, 8, 0, 0, 9 }, 
	                { 0, 5, 7, 9, 0 } };
		int start=0;
		primsUndirected(graph,start);
	}
	public static void primsUndirected(int[][] graph,int start) {
		boolean[][] heapified=new boolean[graph.length][graph[0].length];
		PriorityQueue<Edge> pq=new PriorityQueue<>(Comparator.comparing(Edge::getDist));
		List<Edge> edges=new ArrayList<>();
		Set<Integer> s=new HashSet<>();
		for(int i=0;i<graph.length;i++) {
			if(graph[start][i]!=0) {
				heapified[start][i]=heapified[i][start]=true;
				pq.add(new Edge(start,i,graph[start][i]));
			}
		}
		int noOfEdges=graph.length-1;
		//time O(V log E)
		while(noOfEdges>0) {
			Edge e=pq.poll();
			if(!s.contains(e.getStart()) || !s.contains(e.getEnd())) {
				edges.add(e);
				s.add(e.getStart());
				s.add(e.getEnd());
				for(int i=0;i<graph.length;i++) {
					if(graph[e.getStart()][i]!=0 && !heapified[e.getStart()][i]) {
						heapified[e.getStart()][i]=heapified[i][e.getStart()]=true;
						pq.add(new Edge(e.getStart(),i,graph[e.getStart()][i]));
					}
				}
				for(int i=0;i<graph.length;i++) {
					if(graph[e.getEnd()][i]!=0 && !heapified[e.getEnd()][i]) {
						heapified[e.getEnd()][i]=heapified[i][e.getEnd()]=true;
						pq.add(new Edge(e.getEnd(),i,graph[e.getEnd()][i]));
					}
				}
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
