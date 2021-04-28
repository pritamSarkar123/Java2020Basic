package greedy;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

class Node{
	private int to,from,dist;
	public Node(int to,int dist) {
		this.to=to;this.from=to;this.dist=dist;
	}
	public Node(int to) {
		this.to=to;this.from=to;this.dist=Integer.MAX_VALUE;
	}
	public int getTo() {
		return to;
	}
	public void setTo(int to) {
		this.to = to;
	}
	public int getFrom() {
		return from;
	}
	public void setFrom(int from) {
		this.from = from;
	}
	public int getDist() {
		return dist;
	}
	public void setDist(int dist) {
		this.dist = dist;
	}
}
public class DijkstraSingleSourceShortestPath {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//grap at:-https://www.geeksforgeeks.org/dijkstras-shortest-path-algorithm-greedy-algo-7/
		// may or may not work for negative weighted edges
		// it moves towards the current shortest
//		//https://www.youtube.com/watch?v=XB4MIexjvY0
		int[][] graph={ { 0, 4, 0, 0, 0, 0, 0, 8, 0 },
		                { 4, 0, 8, 0, 0, 0, 0, 11, 0 },
		                { 0, 8, 0, 7, 0, 4, 0, 0, 2 },
		                { 0, 0, 7, 0, 9, 14, 0, 0, 0 },
		                { 0, 0, 0, 9, 0, 10, 0, 0, 0 },
		                { 0, 0, 4, 14, 10, 0, 2, 0, 0 },
		                { 0, 0, 0, 0, 0, 2, 0, 1, 6 },
		                { 8, 11, 0, 0, 0, 0, 1, 0, 7 },
		                { 0, 0, 2, 0, 0, 0, 6, 7, 0 } };
		int start=0;
		findDistanceAndPath(graph,start);
	}
	public static void findDistanceAndPath(int[][] graph,int start) {
		PriorityQueue<Node> pq=new PriorityQueue<>(Comparator.comparing(Node::getDist));
		Map<Integer,Node> mp=new HashMap<>();
		// initializing all the nodes with inf except starting node
		for(int i=0;i<graph.length;i++) {
			Node n;
			if(i!=start) n=new Node(i);
			else n=new Node(i,0);
			mp.put(i,n);
			pq.add(n);
		}
		boolean[] visited=new boolean[graph.length];
		int[] path=new int[graph.length];
		int[] distance=new int[graph.length];
		Arrays.fill(distance, Integer.MAX_VALUE); distance[start]=0;
		
		// time O(ElogV)// need to traverse through all edges(E), each time heap contains at most V elements
		//Space O(E+V)
		while(!pq.isEmpty()) {
			Node n=pq.poll();
			visited[n.getTo()]=true;
			for(int i=0;i<graph.length;i++) {
				if(graph[n.getTo()][i]!=0 && !visited[i]) {
					if(distance[i] > n.getDist()+graph[n.getTo()][i]) {
						distance[i] = n.getDist()+graph[n.getTo()][i];
						path[i]=n.getTo();
						Node updating=mp.get(i);
						// without removing you can not update the priority queue
						// remove-> update element->insert again
						pq.remove(updating);
						updating.setDist(distance[i]);
						updating.setFrom(n.getTo());
						pq.add(updating);
					}
				}
			}
		}
		System.out.println(Arrays.toString(path));
		System.out.println(Arrays.toString(distance));
		
	}
	
}