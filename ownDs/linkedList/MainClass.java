package ownDs.linkedList;

public class MainClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LinkedList<Integer> ll=new LinkedList<>(); 
		for(int i=0;i<5;i++) {
			ll.add(i+1);
		}
		ll.showList();
		ll.add(1,20);
		ll.showList();
		ll.add(5,25);
		ll.showList();
		ll.add(30,55);
		ll.showList();
		try {
			ll.remove(7);
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		ll.showList();
		try {
			ll.remove(1);
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		ll.showList();
		ll.add(30,55);
		ll.showList();
		try {
			Integer val=ll.getValue(2);
			System.out.println(val);
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}

}
