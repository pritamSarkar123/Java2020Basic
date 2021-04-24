package heapPractice;

import java.util.Comparator;
import java.util.PriorityQueue;
//import javafx.util.Pair; <- not available in eclipse now -_- so making custom pair
class Pair<K,V>{
	private K key;
	private V value;
	public Pair(K key,V value) {
		this.key=key;this.value=value;
	}
	public K getKey() {
		return key;
	}
	public V getValue() {
		return value;
	}
}

/*
 * making custom comparator class in case of generic custom class is too much time consuming
 * rather use Comparator.comparing .thenComparing .reverse() <- these type of methods
 */
public class HeapPracClass {

	public static void main(String[] args) {
		maxHeapPair();
		minHeapPair();
	}
	public static void minHeapPair() {
		// 1st key wise asc then val wise asc
		PriorityQueue<Pair<Integer,Integer>> pq=new 
				PriorityQueue<>(Comparator.comparing(Pair<Integer,Integer>::getKey)
						.thenComparing(Pair<Integer,Integer>::getValue));
		pq.add(new Pair<Integer,Integer>(1,2));pq.add(new Pair<Integer,Integer>(5,2));
		pq.add(new Pair<Integer,Integer>(2,3));pq.add(new Pair<Integer,Integer>(2,5));
		while(!pq.isEmpty()) {
			System.out.print("( "+pq.peek().getKey()+" , "+pq.peek().getValue()+" ) ");
			pq.poll();
		}System.out.println();
	}
	public static void maxHeapPair() {
		// 1st key wise desc then value wise desc
		PriorityQueue<Pair<Integer,Integer>> pq=new 
				PriorityQueue<>(Comparator.comparing(Pair<Integer,Integer>::getKey)
						.thenComparing(Pair<Integer,Integer>::getValue).reversed());
		pq.add(new Pair<Integer,Integer>(1,2));pq.add(new Pair<Integer,Integer>(5,2));
		pq.add(new Pair<Integer,Integer>(2,3));pq.add(new Pair<Integer,Integer>(2,5));
		while(!pq.isEmpty()) {
			System.out.print("( "+pq.peek().getKey()+" , "+pq.peek().getValue()+" ) ");
			pq.poll();
		}System.out.println();
	}

}
