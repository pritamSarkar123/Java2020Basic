package graphs;

import java.util.Deque;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.Set;
/*
6 7 0 1 1 2 0 2 5 0 5 3 3 4 4 5


6 6 0 1 1 2 0 2 5 0 5 3 3 4


6 7 0 1 1 2 0 2 5 0 5 3 3 4 5 4

*/
public class MyDirectedGraph {
	
	private LinkedList<Integer> []adjList;
	public MyDirectedGraph(int v) {
		adjList=new LinkedList[v];
		for(int i=0;i<v;i++) adjList[i]=new LinkedList<Integer>();
	}
	public void edgeEntry(int source,int destination) {
		adjList[source].add(destination); //as directed graph
	}
	public void findCycle() {
		Set<Integer> whiteSet=new HashSet<>();
		Set<Integer> graySet=new HashSet<>();
		Set<Integer> blackSet=new HashSet<>();
		//adding all vertices in set initially
		for(int i=0;i<adjList.length;i++) {
			whiteSet.add(i);
		}
		Deque<Integer> myStack=new LinkedList<>();
		while(!whiteSet.isEmpty()) { //better do it in recursion
			int current=whiteSet.iterator().next();
			whiteSet.remove(current);graySet.add(current);myStack.addLast(current);
			while(!myStack.isEmpty()) {
				current=myStack.peekLast();
				boolean added=false;
				for(int element:adjList[current]) {
					if(graySet.contains(element)) {
						System.out.println("Loop present");
						int start=graySet.iterator().next();
						for(int i:graySet) {
							System.out.print(i+" -> ");
						}
						System.out.println(start);
						return;
					}if(!blackSet.contains(element)) { //if already contained by black set don't add it
						whiteSet.remove(element);graySet.add(element);myStack.addLast(element);
						added=true;
					}
				}
				if(!added) {  //if no element added remove the top one
					int removdElement=myStack.removeLast();
					graySet.remove(removdElement);blackSet.add(removdElement);
				}
				
			}
		}
		System.out.println("Loop not present");
		
	}
	public void findCycleRec() {
		Set<Integer> whiteSet=new HashSet<>();
		Set<Integer> graySet=new HashSet<>();
		Set<Integer> blackSet=new HashSet<>();
		//adding all vertices in set initially
		for(int i=0;i<adjList.length;i++) {
			whiteSet.add(i);
		}
		while(!whiteSet.isEmpty()) {
			int current=whiteSet.iterator().next();
			whiteSet.remove(current);graySet.add(current);
			boolean looped=this.findCycleRec(whiteSet,graySet,blackSet,current);
			if(looped) {
				System.out.println("Loop present");
				int start=graySet.iterator().next();
				for(int i:graySet) {
					System.out.print(i+" -> ");
				}
				System.out.println(start);
				return;
			}
			graySet.remove(current);blackSet.add(current);
		}
		System.out.println("Loop not present");
	}
	private boolean findCycleRec(Set<Integer> whiteSet,Set<Integer> graySet,Set<Integer> blackSet,int current) {
		for(int element:adjList[current]) {
			if(graySet.contains(element)) return true;
			if(!blackSet.contains(element)) {
				whiteSet.remove(element);graySet.add(element);
				boolean looped=findCycleRec(whiteSet, graySet, blackSet, element);
				if(looped) return true;
				graySet.remove(element);blackSet.add(element);
			}
		}
		return false;
	}
	public void showTree() {
		for(int i=0;i<adjList.length;i++) {
			System.out.println(i+" -> "+adjList[i]);
		}System.out.println();
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc =new Scanner(System.in);
		int vertices=sc.nextInt();
		int edges=sc.nextInt();
		MyDirectedGraph dg=new MyDirectedGraph(vertices);
		for(int i=0;i<edges;i++) {
			int source=sc.nextInt();
			int destination=sc.nextInt();
			dg.edgeEntry(source, destination);
		}
		dg.showTree();
		dg.findCycle();
		dg.findCycleRec();
	}

}
