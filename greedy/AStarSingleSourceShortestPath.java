package greedy;
import java.util.*;
class NodeOne{
	private int to;
	private int from;
	private int dist;
	private int huristicDistance;
	public NodeOne(int to,int from,int dist,int huristicDistance) {
		this.to=to;this.from=from;this.dist=dist;this.huristicDistance=huristicDistance;
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
	public int getHuristicDistance() {
		return huristicDistance;
	}
	public void setHuristicDistance(int huristicDistance) {
		this.huristicDistance = huristicDistance;
	}
}
public class AStarSingleSourceShortestPath {
	//https://www.youtube.com/watch?v=ySN5Wnu88nE
	public static void main(String[] args) {
		int[][] graph= {{0,4,3,-1,-1,-1,-1},
					    {-1,0,-1,-1,12,5,-1},
					    {-1,-1,0,7,10,-1,-1},
					    {-1,-1,-1,0,2,-1,-1},
					    {-1,-1,-1,-1,0,-1,5},
					    {-1,-1,-1,-1,-1,0,16},
					    {-1,-1,-1,-1,-1,-1,0}};
		//huristics must be perfectly estimated
		int[] huristicList=new int[]{17,17,14,7,5,16,0};
		int start=0;
		int end=6;
		aStarPathFinding(graph,huristicList,start,end);
	}
	public static void aStarPathFinding(int[][] graph,int[] huristicList,int start,int end) {
		PriorityQueue<NodeOne> pq=new PriorityQueue<>(Comparator.comparing(NodeOne::getHuristicDistance));
		Map<Integer,NodeOne> mp=new HashMap<>();
		for(int i=0;i<graph.length;i++) {
			NodeOne n;
			if(i!=start) n=new NodeOne(i,i,Integer.MAX_VALUE,Integer.MAX_VALUE);
			else n=new NodeOne(i,i,0,huristicList[i]);
			mp.put(i, n);
			pq.add(n);
		}
		boolean[] visited=new boolean[graph.length];
		int[] path=new int[graph.length];
		int[] distance=new int[graph.length];
		Arrays.fill(distance, Integer.MAX_VALUE); distance[start]=0;
		
		// time O(ElogV)// need to traverse through all edges(E), each time heap contains at most V elements
		//Space O(E+V)
		while(!pq.isEmpty()) {
			NodeOne n=pq.poll();
			if(n.getTo()==end) break;
			visited[n.getTo()]=true;
			for(int i=0;i<graph.length;i++) {
				if(graph[n.getTo()][i]!=-1 && !visited[i]) {
					if(distance[i] > n.getDist()+graph[n.getTo()][i]) {
						distance[i] = n.getDist()+graph[n.getTo()][i];
						path[i]=n.getTo();
						NodeOne updating=mp.get(i);
						pq.remove(updating);
						updating.setDist(distance[i]);
						//distance upto i node and the huristic of the i node
						updating.setHuristicDistance(distance[i]+huristicList[i]);
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
