package graphs;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Graph {

	private LinkedList<Integer> []adjList;
	public Graph(int v) {
		adjList=new LinkedList[v];
//		Arrays.fill(adjList, new LinkedList<Integer>()); <- all array got same ref -_-
		for(int i=0;i<v;i++) {
			adjList[i]=new LinkedList<Integer>();
		}
	}
	public void addEdge(int start,int end) {
		adjList[start].add(end);
		adjList[end].add(start);// for bidirectional graph
	}
	public void showGraph() {
		for(int i=0;i<adjList.length;i++) {
			System.out.println(i+" -> "+adjList[i]);
		}
	}
	public int getMinPathUsingBfs(int source,int destination) {
		boolean []enqueued=new boolean[adjList.length];
		int []parent=new int[adjList.length];
		Queue<Integer> q=new LinkedList<>();
		parent[source]=-1;
		q.add(source);
		enqueued[source]=true;
		while(!q.isEmpty()) {
			int current=q.poll();
			if(current==destination) break;
			for(int neighbour:adjList[current]) {
				if(!enqueued[neighbour]) {
					q.add(neighbour);
					parent[neighbour]=current;
					enqueued[neighbour]=true;
				}
			}
		}
		
		int distance=0;
		while(destination!=source) {
			distance++;
			destination=parent[destination];
		}
		return distance;
	}
	public boolean dfsRec(int source,int destination) {
		boolean[] visited=new boolean[adjList.length];
		return this.dfsRec(source, destination,visited);
	}
	private boolean dfsRec(int source,int destination,boolean[] visited) {
		visited[source]=true;
		if(source==destination) return true;
		for(int neighbour:adjList[source]) {
			if(!visited[neighbour]) {
				boolean reachable=dfsRec(neighbour, destination, visited);
				if(reachable) return true;
			}
		}
		return false;
	}
	public boolean dfsStack(int source,int destination) {
		boolean []visited=new boolean[adjList.length];visited[source]=true;
		Deque<Integer> stack=new LinkedList<>();
		stack.addLast(source);
		while(!stack.isEmpty()) {
			int current=stack.pollLast();
			if(current==destination) return true;
			for(int neighbour:adjList[current]) {
				if(!visited[neighbour]) {
					visited[neighbour]=true;
					stack.addLast(neighbour);
				}
			}
		}
		return false;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter number of vertices and edges");
		int v=sc.nextInt();
		int e=sc.nextInt();
		Graph g=new Graph(v);
		System.out.println("Now enter "+e+" edges");
		for(int i=0;i<e;i++) {
			int start=sc.nextInt();
			int end=sc.nextInt();
			g.addEdge(start, end);
		}
		g.showGraph();
		System.out.println("distance beween "+0+" and "+2+" is "+g.getMinPathUsingBfs(0, 2));
		
		System.out.println(0+" to "+2+" is reachable "+g.dfsRec(0, 2));
		System.out.println(0+" to "+2+" is reachable "+g.dfsStack(0, 2));
		sc.close();
	}

}
