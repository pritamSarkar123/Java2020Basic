package ownDs.stack;

public class MainClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Stack<Integer> ss=new Stack<>();
		ss.push(12);
		ss.push(13);
		ss.push(6);
		ss.push(5);
		System.out.println(ss.isEmpty());
		ss.shoWStack();
		Integer i;
		try {
			i=ss.peek();
			System.out.println(i);
			i=ss.pop();
			System.out.println("popped "+i);
			ss.shoWStack();
			i=ss.peek();
			System.out.println(i);
			i=ss.pop();
			System.out.println("popped "+i);
			i=ss.peek();
			System.out.println(i);
		}catch(Exception e){
			System.out.println(e.getMessage());
		}
		ss.shoWStack();
	}

}
