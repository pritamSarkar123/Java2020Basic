package collectionFramework.arrayList;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import java.util.Iterator;
import java.util.Collections;
public class MainClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//ArrayList:- resize able array
		//LinkedList:- doubly linked list
		//Stack:- LiFo
		//List<-implements-ArrayList
		//List<-implements-LinkedList
		//List<-implements-Stack
		List<Pair<String,String>> listOne=new LinkedList<>();
		List<Pair<String,String>> listTwo=new ArrayList<>();
		List<Pair<String,String>> listThree=new ArrayList<>();
		
		listTwo.add(new Pair<String, String>("Pritam","Sarkar"));
		listTwo.add(new Pair<String,String>("Eshani","Jas"));
		listTwo.add(1,new Pair<String,String>("Rahul","Banerjee"));
		listTwo.add(1,new Pair<String,String>("Rishika","Kundu"));
		System.out.println("add()");
		System.out.println(listTwo.size());
		for(Pair<String,String> p: listTwo) {
			System.out.println(p.x+" "+p.y);
		}
		
		listOne.add(new Pair<String,String>("Debrup","Kar"));
		listOne.add(new Pair<String,String>("Jyotirmay","Das"));
		listOne.add(new Pair<String,String>("Pratush","Sarkar"));
		
		listTwo.addAll(listOne);
		
		System.out.println("addAll()");
		System.out.println(listTwo.size());
		for(Pair<String,String> p: listTwo) {
			System.out.println(p.x+" "+p.y);
		}
		
//		listThree.add(new Pair<String,String>("Rahul","Banerjee"));
//		listThree.add(new Pair<String,String>("Jyotirmay","Das"));
		
		listThree.add(listTwo.get(2));
		listThree.add(listTwo.get(4));
		
		listTwo.removeAll(listThree);
		listTwo.set(0, new Pair<String,String>("Vanu","Sarkar"));
		listTwo.remove(3);
		System.out.println("removeAll(), size(),get(),set(),remove(),iterator()");
		System.out.println(listTwo.size());
		Iterator<Pair<String,String>> it=listTwo.iterator();
		while(it.hasNext()) {
			Pair<String,String> abc=it.next();
			System.out.println(abc.x+" "+abc.y);
		}
		
		
//		for(Pair<String,String> p: listTwo) {
//			System.out.println(p.x+" "+p.y);
//		}
		listTwo.clear();
		System.out.println("clear(),isEmpty()");
		System.out.println(listTwo.isEmpty());
		System.out.println(listTwo.size());
		methOne();
		methTwo();
	}
	public static void methOne() {
		List<Integer> li=new LinkedList<>();
		List<Integer> ai=new ArrayList<>();
		for(int i=10;i>0;i--) {
			li.add(i);ai.add(i);
		}
		ai.addAll(li);
		
		//*****array of generics an not be created
		
		//only wrapper class arrays allowed
		Integer[] arr=new Integer[ai.size()];
		ai.toArray(arr);
		
		for(Integer i:arr) {
			System.out.print(i+" ");
		}
		System.out.println();
		Collections.sort(ai);
		System.out.println(ai);
		
		Collections.sort(ai,Collections.reverseOrder());
		System.out.println(ai);
	}
	public static void methTwo() {
		List<Integer> li=new LinkedList<>();
		List<Integer> ai=new ArrayList<>();
		for(int i=10;i>0;i--) {
			li.add(i);ai.add(i);
		}
		ai.addAll(li);
		System.out.println("----------------");
		//one method
		Object []obj1=ai.toArray();
		for(Object o:obj1) {
			System.out.print(o+" ");
		}System.out.println();
		System.out.println("----------------");
		//two method
		Integer []obj2=new Integer[ai.size()];
		ai.toArray(obj2);
		for(Integer i:obj2) {
			System.out.print(i+" ");
		}System.out.println();
		System.out.println("----------------");
		System.out.println(ai instanceof ArrayList);
	}
}
