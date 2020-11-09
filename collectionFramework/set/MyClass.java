package collectionFramework.set;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;

public class MyClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		hashSet();
		treeSet();
		linkedHashSet();
	}
	public static void hashSet() {
		// all operations in O(1) time
		// unordered, duplicates not allowed
		Set<Integer> hs1=new HashSet<>();
		Set<Integer> hs2=new HashSet<>();
		for(int i=0;i<10;i++) {
			hs1.add(i);
		}
		for(int i=5;i<15;i++) {
			hs2.add(i);
		}
		System.out.println(hs1);
		System.out.println(hs2);
		hs1.retainAll(hs2); //intersection
		System.out.println(hs1);
		
		hs1.addAll(hs2);//union
		System.out.println(hs1);
		
		System.out.println(hs1.containsAll(hs2));
	}
	public static void treeSet() {
		// most of the operations in O(1) time
		// some takes linear times
		// ascending order
		Set<Integer> hs1=new TreeSet<>();
		Set<Integer> hs2=new TreeSet<>();
		for(int i=0;i<10;i++) {
			hs1.add(i);
		}
		for(int i=5;i<15;i++) {
			hs2.add(i);
		}
		System.out.println(hs1);
		System.out.println(hs2);
		hs1.retainAll(hs2); //intersection
		System.out.println(hs1);
		
		hs1.addAll(hs2);//union
		System.out.println(hs1);
		
		System.out.println(hs1.containsAll(hs2));
	}
	public static void linkedHashSet() {
		// most of the operations in O(1) time
		// some takes linear times
		// same as input order
		Set<Integer> hs1=new LinkedHashSet<>();
		Set<Integer> hs2=new LinkedHashSet<>();
		for(int i=0;i<10;i++) {
			hs1.add(i);
		}
		for(int i=5;i<15;i++) {
			hs2.add(i);
		}
		System.out.println(hs1);
		System.out.println(hs2);
		hs1.retainAll(hs2); //intersection
		System.out.println(hs1);
		
		hs1.addAll(hs2);//union
		System.out.println(hs1);
		
		System.out.println(hs1.containsAll(hs2));
	}
	

}
