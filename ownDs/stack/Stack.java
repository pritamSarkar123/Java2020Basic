package ownDs.stack;

public class Stack<E  extends Comparable<E>> {
	private LinkedList<E> ll;
	public Stack() {
		ll=new LinkedList<>();
	}
	public void push(E value) {
		ll.add(value);
	}
	public E pop() throws Exception{
		try {
			E v=ll.getValue(0);
			ll.remove(0);
			return v;
		}catch (Exception  e){
			throw new Exception("Stack empty");
		}
	}
	public E peek() throws Exception{
		try {
			E v=ll.getValue(0);
			return v;
		}catch(Exception e) {
			throw new Exception("Stack empty");
		}
	}
	public boolean isEmpty() {
		return ll.nodeCount==0;
	}
	public void shoWStack() {
		ll.showList();
	}
}
