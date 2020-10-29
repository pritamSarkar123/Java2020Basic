package collectionFramework.linkedList;

import java.util.*;
public class MainClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Long> ll=new LinkedList<>();
		List<Long> al=new ArrayList<>();
		insertAtBegin(ll);
		insertAtBegin(al);
	}
	static void insertAtBegin(List<Long> l) {
		//for linked list each insert at begin takes O(1) time
		//for array list each insert at begin takes O(n) time
		long start=System.currentTimeMillis();
		for(long i=0;i<500000;i++) {
			l.add(0,i);
		}
		long end=System.currentTimeMillis();
		System.out.println(l.getClass().getName()+" needs "+(end-start)+" time");
	}

}
