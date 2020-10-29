package ownDs.queue;

public class LinkedList<E> {
	
	private class Node<V>{
		public V value;
		public Node<V> next;
		public Node<V> prev;
		public Node(V value) {
			this.value=value;
			this.next=null;
			this.prev=null;
		}
	}
	public Node<E> head;
	public Node<E> tail;
	public int nodeCount;
	public LinkedList(){
		head=null;
		nodeCount=0;
	}
	public void add(int index,E value) {
		if(head==null) {
			System.out.println("index out of range entering at end");
			add(value);
			return;
		}
		if(index==0) {
			add(value);
			return;
		}
		if(index>=nodeCount) {
			System.out.println("index out of range entering at end");
			Node<E> newNode=new Node<>(value);
			tail.next=newNode;
			newNode.prev=tail;
			tail=newNode;
			nodeCount++;
			return;
		}
		if(index==nodeCount-1) {
			Node<E> newNode=new Node<>(value);
			newNode.next=tail;
			newNode.prev=tail.prev;
			tail.prev.next=newNode;
			tail.prev=newNode;
			nodeCount++;
			return;
		}
		Node<E> newNode=new Node<>(value);
		int count=index-1;
		Node<E> temp=head;
		while(count>0) {
			temp=temp.next;
			count--;
		}
		newNode.next=temp.next;
		temp.next.prev=newNode;
		temp.next=newNode;
		newNode.prev=temp;
		nodeCount++;
	}
	public void add(E value) {
		Node<E> newNode=new Node<>(value);
		if(head==null) {
			tail=newNode;
		}else {
			head.prev=newNode;
		}
		newNode.next=head;
		head=newNode;
		nodeCount++;
	}
	public void showList() {
		Node<E> temp=head;
		for(int i=0;i<nodeCount;i++) {
			System.out.print(temp.value+" ");
			temp=temp.next;
		}
		System.out.println();
	}
	public void remove(int index) throws Exception {
		if(index>=nodeCount) {
//			System.out.println("Index out of range");
			throw new Exception("Empty list");
		}
		if(index==0) {
			head.next.prev=null;
			head=head.next;
			nodeCount--;
			return;
		}
		int count=index-1;
		Node<E> temp=head;
		while(count>0) {
			temp=temp.next;
			count--;
		}
		if(temp.next.next==null) {
//			tail.prev=null;
			tail=temp;
			temp.next=null;
			nodeCount--;
			return;
		}else {
			temp.next.next.prev=temp;
			temp.next=temp.next.next;
			nodeCount--;
		}	
	}
	public E getValue(int index) throws Exception{
		if(index>=nodeCount) {
//			System.out.println("Index out of range");
			throw new Exception("Empty list");
		}
		int count=index;
		Node<E> temp=head;
		while(count>0) {
			temp=temp.next;
			count--;
		}
		return temp.value;
	}
}
