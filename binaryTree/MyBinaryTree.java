package binaryTree;

import java.util.ArrayDeque;

public class MyBinaryTree {

	public static void main(String[] args) {
		BinaryTree bt=new BinaryTree();
		int []arr= {25,18,50,19,20,35,60,-1,15,18,25,20,40,55,70,-1,-1,-1,-1,-1,-1,-1,25,-1,-1,-1,-1,-1,-1,-1,-1};
		bt.createTree(arr);
		bt.showTree();
		int []ar=bt.longestBst();
		System.out.println(ar[1]);
	}

}
class BinaryTree{
	class Node{
		int value;
		Node left;
		Node right;
		public Node(int value,Node left,Node right) {
			this.value=value;this.left=left;this.right=right;
		}
	}
	Node head;
	public BinaryTree() {
		head=null;
	}
	public void createTree(int []arr) {
		if(arr.length==0 || arr[0]==-1) {
			return;
		}
		ArrayDeque<Node> ad=new ArrayDeque<>();
		head=new Node(arr[0],null,null);
		ad.addLast(head);
		System.out.println("head created "+head.value );
		int i=1;
		while(!ad.isEmpty()) {
			Node popped=ad.pollFirst();
			if(arr[i]!=-1) {
				popped.left=new Node(arr[i],null,null);
				System.out.println("left child created "+ popped.left.value);
				ad.addLast(popped.left);
			}
			i++;
			if(arr[i]!=-1) {
				popped.right=new Node(arr[i],null,null);
				System.out.println("right child created "+ popped.right.value);
				ad.addLast(popped.right);
			}
			i++;
		}
	}
	public void showTree() {
		this.inOrder(head);
		System.out.println();
	}
	public void inOrder(Node n) {
		if(n==null) return;
		inOrder(n.left);
		System.out.print(n.value+" ");
		inOrder(n.right);
	}
	public int[] longestBst() {
		return longestBst(head);
	}
	public void fillValues(int []arr,int a,int b,int c,int d) {
		arr[0]=a;arr[1]=b;arr[2]=c;arr[3]=d;
	}
	public int[] longestBst(Node n) {
		//Problem:-https://www.youtube.com/watch?v=4fiDs7CCxkc
		
		//in case of no left or right child
//		int []left= {1,0,Integer.MIN_VALUE,Integer.MIN_VALUE};
//		int []right= {1,0,Integer.MAX_VALUE,Integer.MAX_VALUE};
		int []left;
		int []right;
		int []current=new int[4];
		
		if(n.left==null && n.right!=null) { //only right child exist
			right=longestBst(n.right);
			if((right[0]==1) && (n.value<right[2])) { 
				//if bst including current node
				this.fillValues(current, 1, right[1]+1, n.value, right[3]);
			}else {
				this.fillValues(current, 0, right[1], 0, 0);
			}
		}else if(n.right==null && n.left!=null) { //only left child exist
			left=longestBst(n.left);
			if((left[0]==1) && (n.value>left[3])) {
				//if bst including current node
				this.fillValues(current, 1, left[1]+1, left[2], n.value);
			}else {
				this.fillValues(current, 0, left[1], 0, 0);
			}
		}else if(n.left!=null && n.right!=null) { //both child exhist
			left=longestBst(n.left);
			right=longestBst(n.right);
			//if both side bst
			//if current node value is greater than left nodes max val
			//and smaller than right nodes min val
			//if bst including current node
			if((left[0]==1 && right[0]==1) && (n.value>left[3] && n.value<right[2])) { 
				this.fillValues(current, 1, left[1]+right[1]+1, left[2], right[3]);
				//no of nodes up to the current node
				//left[2] min of total bst
				//right[3] max of total bst
			}else {
				this.fillValues(current, 0, Math.max(left[1], right[1]), 0, 0);
			}
		}else {// no child exist
			this.fillValues(current, 1, 1, n.value, n.value);
		}	
		return current;
	}
}
