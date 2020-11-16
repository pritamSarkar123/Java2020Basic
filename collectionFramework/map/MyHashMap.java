package collectionFramework.map;

import java.util.*;
import java.util.Map.Entry;

public class MyHashMap {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//in java open hashing means chaining is used
		//MOST of the operations O(1)
		//no collision -> key not present
		//collision + match -> key already present 
		//collision + not match ->next jump
		//default length of hash list is 16
		//load factor(alpha)=n/m should be <0.75
		// if >=0.75 then size of hash table increased by multiple of 2
		//Entity >==> <Key , Value, NEXT>
		//Hash function returns a long 
		//each time an Entity object added it added at the end,(after finishing all)
		//(comparisons)
		Map<String,Integer> hm=new HashMap<>();
		System.out.println(hm.isEmpty()+" "+hm.size());
		hm.put("One",1);
		hm.put("Two",2);
		hm.put("Three",3);
		hm.put("Four",4);
		hm.put("Five",5);
		System.out.println(hm.isEmpty()+" "+hm.size());
		Map<String,Integer> hm1=new HashMap<>();
		hm1.put("Six",6);
		hm1.put("Seven",7);
		hm1.put("Eight",8);
		hm.putAll(hm1);
		System.out.println(hm);
		hm.putIfAbsent("Eight", 80);
		hm.putIfAbsent("Nine",9);
		System.out.println(hm);
		hm.remove("Eight");
		hm.remove("Nine",90);
		System.out.println(hm);
		System.out.println(hm.containsValue(6));
		System.out.println(hm.containsKey("One"));
		hm.replace("Six",60);
		hm.replace("Six",60,6);
		System.out.println(hm);
		System.out.println(hm.values());
		System.out.println(hm.keySet());
		System.out.println(hm.entrySet());
		Set<Entry<String,Integer>> entrySet=hm.entrySet(); // references stored
		//need to update all values in main hash table
		for(Entry<String,Integer> e:entrySet) {
			e.setValue(e.getValue()*10);
		}
		System.out.println(hm);
	}

}
