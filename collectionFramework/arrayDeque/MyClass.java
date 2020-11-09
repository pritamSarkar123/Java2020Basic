package collectionFramework.arrayDeque;

import java.util.ArrayDeque;

public class MyClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		doubleEndedQueueWithException();
//		doubleEndedQueueWithOutException();
//		queueWithException();
		queueWithOutException();
		stack();
	}
	public static void doubleEndedQueueWithException() {
		ArrayDeque<Integer> ad=new ArrayDeque<>();
		ad.addLast(10);
		ad.addFirst(5);
		ad.addFirst(20);
		ad.addLast(25);
		System.out.println(ad.removeLast());
		System.out.println(ad.removeFirst());
		System.out.println(ad.getFirst());
		System.out.println(ad.getLast());
		System.out.println("above exception based deque "+ad.getClass().getName());
	}
	public static void doubleEndedQueueWithOutException() {
		ArrayDeque<Integer> ad=new ArrayDeque<>();
		ad.offerFirst(10);
		ad.offerLast(5);
		ad.offerFirst(20);
		ad.offerLast(25);
		System.out.println(ad.pollLast());
		System.out.println(ad.pollFirst());
		System.out.println(ad.peekFirst());
		System.out.println(ad.peekLast());
		System.out.println("above exception less deque "+ad.getClass().getName());
	}
	public static void queueWithOutException() {
		ArrayDeque<Integer> ad=new ArrayDeque<>();
		ad.offer(10);
		ad.offer(5);
		ad.offer(20);
		ad.offer(25);
		System.out.println(ad);
		System.out.println(ad.poll());
		System.out.println(ad.poll());
		System.out.println(ad.peek());
		System.out.println(ad);
		System.out.println("above exception less queue "+ad.getClass().getName());
	}
	public static void queueWithException() {
		ArrayDeque<Integer> ad=new ArrayDeque<>();
		ad.add(10);
		ad.add(5);
		ad.add(20);
		ad.add(25);
		System.out.println(ad.remove());
		System.out.println(ad.remove());
		System.out.println(ad.getFirst());//no get function
		System.out.println(ad.getLast());
		System.out.println("above exception based queue "+ad.getClass().getName());
	}
	public static void stack() {
		ArrayDeque<Integer> ad=new ArrayDeque<>();
		ad.push(10);
		ad.push(5);
		ad.push(20);
		ad.push(25);
		System.out.println(ad);
		System.out.println(ad.pop());
		System.out.println(ad.pop());
		System.out.println(ad.peek());
		System.out.println(ad);
		System.out.println("above exception less stack "+ad.getClass().getName());
	}
}
