package ownDs.queue;

public class MyQueue {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Queue<Integer> q=new Queue<>();
		q.enqueue(5);
		q.enqueue(10);
		q.enqueue(15);
		q.enqueue(20);
		q.showQueue();
		System.out.println(q.peek());
		System.out.println(q.dequeue());
		q.showQueue();
	}

}
