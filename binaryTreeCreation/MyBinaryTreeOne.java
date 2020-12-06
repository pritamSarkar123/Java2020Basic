package binaryTreeCreation;
import java.util.Scanner;
import java.util.ArrayDeque;

public class MyBinaryTreeOne {

	//if we made this class as main tree class
	//then we can easily use 
	//static Scanner sc =new Scanner(System.in);
	//as only one scanner will be used through the program execution
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BinaryTree bt=new BinaryTree();
		bt.createTreeRecurssive();
//		bt.createTreeIterative();
		bt.showTree();
	}

}
class BinaryTree{
	class Node{
		int value;
		Node left,right; //by default null
		public Node(int value) {
			this.value=value;
		}
	}
	Node head=null;
	public BinaryTree() {}
	public void createTreeIterative() {
		ArrayDeque<Node> ad=new ArrayDeque<>();
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter head value :");
		int value=sc.nextInt();
		head=new Node(value);
		ad.addLast(head);
		while(!ad.isEmpty()) {
			Node popped=ad.pollFirst();
			System.out.println("Enter left child of "+ popped.value );
			value=sc.nextInt();
			if(value!=-1) {
				popped.left=new Node(value);
				ad.addLast(popped.left);
			}
			System.out.println("Enter right child of "+popped.value);
			value=sc.nextInt();
			if(value!=-1) {
				popped.right=new Node(value);
				ad.addLast(popped.right);
			}
		}
		sc.close();
	}
	public void createTreeRecurssive() {
		Scanner sc=new Scanner(System.in);
		//******do not create multiple instances of scanner recursively
		System.out.println("Enter the head value ");
		int value=sc.nextInt();
		if(value==-1) {System.out.println("No tree"); sc.close(); return;}
		head=new Node(value);
		System.out.println("Enter left child of head "+ head.value );
		head.left=this.recurssiveCreate(sc);
		System.out.println("Enter right child of head "+ head.value );
		head.right=this.recurssiveCreate(sc);
		sc.close();
	}
	private Node recurssiveCreate(Scanner sc) {
		int value=sc.nextInt();
		if(value==-1) return null;  
		Node n=new Node(value);
		System.out.println("Enter left child of "+ n.value );
		n.left=this.recurssiveCreate(sc);
		System.out.println("Enter right child of "+ n.value );	
		n.right=this.recurssiveCreate(sc);
		return n;
	}
	public void showTree() {
		this.inOrder(head);
		System.out.println();
	}
	private void inOrder(Node n) {
		if(n==null) return;
		inOrder(n.left);
		System.out.print(n.value+" ");
		inOrder(n.right);
	}
	
}
