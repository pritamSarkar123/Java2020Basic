package ownDs.queue;

public class Queue<E extends Comparable<E>> {
	private LinkedList<E> ll;
	public Queue() {
		ll=new LinkedList<>();
	}
	public void enqueue(E value) {
		ll.add(value);
	}
	public E dequeue() {
		try {
			E val=ll.getValue(ll.nodeCount-1);
			ll.remove(ll.nodeCount-1);
			return val;
		}catch(Exception e) {
			return null;
		}
	}
	public E peek() {
		try {
			E val=ll.getValue(ll.nodeCount-1);
			return val;
		}catch(Exception e) {
			return null;
		}
	}
	public boolean isEmpty() {
		return ll.nodeCount==0;
	}
	public void showQueue() {
		ll.showList();
	}
}
