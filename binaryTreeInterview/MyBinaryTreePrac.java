package binaryTreeInterview;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;
public class MyBinaryTreePrac {

	public static void main(String[] args) {
		BinaryTree bt=new BinaryTree();
		bt.createTreeRecurssive();
		bt.showTreeInOrderRecurssive();
		bt.showTreePreOrderRecurssive();
		bt.showTreePostOrderRecurssive();
		bt.checkLevels();
		bt.diameterAndDepth();
		
		bt.deleteNodeOfValue(3);
		
		bt.showTreeInOrderRecurssive();
		bt.showTreePreOrderRecurssive();
		bt.showTreePostOrderRecurssive();
		bt.checkLevels();
		bt.diameterAndDepth();
	
	}
}
class BinaryTree{
	public static class TreeNode{
		public int val;
		public TreeNode left;
		public TreeNode right;
		public TreeNode(int val) {
			this.val=val;
		}		
	}
	public TreeNode root;
	public Scanner sc;
	public BinaryTree() {
		root=null;
		sc=new Scanner(System.in);
	}
	public void createTreeIterative() {
		System.out.println("Enter root value ");
		int val=sc.nextInt();
		if(val!=-1) {
			Deque<BinaryTree.TreeNode> dq=new LinkedList<>();
			root=new BinaryTree.TreeNode(val);
			dq.add(root);
			while(!dq.isEmpty()) {
				BinaryTree.TreeNode front=dq.pollFirst();
				System.out.println("Enter value for the left child of "+front.val);
				val=sc.nextInt();
				if(val!=-1) {
					front.left=new BinaryTree.TreeNode(val);
					dq.add(front.left);
				}
				System.out.println("Enter value for the right child of "+front.val);
				val=sc.nextInt();
				if(val!=-1) {
					front.right=new BinaryTree.TreeNode(val);
					dq.add(front.right);
				}
			}
		}
		
		
	}
	public void insertNode(BinaryTree.TreeNode node) {
		int val;
		System.out.println("Enter value for the left child of "+node.val);
		val=sc.nextInt();
		if(val!=-1) {
			node.left=new BinaryTree.TreeNode(val);
			insertNode(node.left);
		}
		System.out.println("Enter value for the right child of "+node.val);
		val=sc.nextInt();
		if(val!=-1) {
			node.right=new BinaryTree.TreeNode(val);
			insertNode(node.right);
		}
	}
	public void createTreeRecurssive() {
		System.out.println("Enter root value ");
		int val=sc.nextInt();
		if(val!=-1) {
			root=new BinaryTree.TreeNode(val);
			insertNode(root);
		}
	}
	public void showTreeInOrderRecurssive() {
		inOrderRecurssiveShow(root);
		System.out.println();
	}
	public void showTreePreOrderRecurssive() {
		preOrderRecurssiveShow(root);
		System.out.println();
	}
	public void showTreePostOrderRecurssive() {
		postOrderRecurssiveShow(root);
		System.out.println();
	}
	private void inOrderRecurssiveShow(BinaryTree.TreeNode node) {
		if(node==null) return;
		inOrderRecurssiveShow(node.left);
		System.out.print(node.val+" ");
		inOrderRecurssiveShow(node.right);
	}
	private void preOrderRecurssiveShow(BinaryTree.TreeNode node) {
		if(node==null) return;
		System.out.print(node.val+" ");
		inOrderRecurssiveShow(node.left);
		inOrderRecurssiveShow(node.right);
	}
	private void postOrderRecurssiveShow(BinaryTree.TreeNode node) {
		if(node==null) return;
		inOrderRecurssiveShow(node.left);
		inOrderRecurssiveShow(node.right);
		System.out.print(node.val+" ");
	}
	private BinaryTree.TreeNode findNodeBFS(int val){
		Deque<BinaryTree.TreeNode> dq=new LinkedList<>();
		dq.add(root);
		while(!dq.isEmpty()) {
			BinaryTree.TreeNode node=dq.pollFirst();
			if(node.val==val) return node;
			if(node.left!=null) dq.add(node.left);
			if(node.right!=null) dq.add(node.right);
		}
		return null;
	}
	private BinaryTree.TreeNode findNodeDFS(int val){
		Deque<BinaryTree.TreeNode> dq=new LinkedList<>();
		dq.add(root);
		while(!dq.isEmpty()) {
			BinaryTree.TreeNode node=dq.pollLast();
			if(node.val==val) return node;
			if(node.left!=null) dq.add(node.left);
			if(node.right!=null) dq.add(node.right);
		}
		return null;
	}
	private BinaryTree.TreeNode findParentNode(int val){
		Deque<BinaryTree.TreeNode> dq=new LinkedList<>();
		dq.add(root);
		while(!dq.isEmpty()) {
			BinaryTree.TreeNode node=dq.pollFirst();
			if(node.left!=null && node.left.val==val) return node;
			if(node.right!=null && node.right.val==val) return node;
			if(node.left!=null) dq.add(node.left);
			if(node.right!=null) dq.add(node.right);
		}
		return null;
	}
	public void deleteNodeOfValue(int val) {
		BinaryTree.TreeNode parentNode=findParentNode(val);
		if(parentNode==null) return;
		System.out.println("Parent -> "+parentNode.val);
		deleteNode(parentNode,val);
	}
	private void deleteNode(BinaryTree.TreeNode parentNode,int val) {
		BinaryTree.TreeNode node;
		if(parentNode.left!=null && parentNode.left.val==val) {
			node=parentNode.left;
			if(node.left==null && node.right==null) {
				parentNode.left=null;
			}else if(node.left!=null && node.right==null) {
				parentNode.left=node.left;
			}else if(node.left==null && node.right!=null) {
				parentNode.left=node.right;
			}else {
				node.val=node.left.val;
				deleteNode(node,node.val);
			}
		}else if(parentNode.right!=null && parentNode.right.val==val) {
			node=parentNode.right;
			if(node.left==null && node.right==null) {
				parentNode.right=null;
			}else if(node.left!=null && node.right==null) {
				parentNode.right=node.left;
			}else if(node.left==null && node.right!=null) {
				parentNode.right=node.right;
			}else {
				node.val=node.left.val;
				deleteNode(node,node.val);
			}
		}
	}
	public void checkLevels() {
		Deque<BinaryTree.TreeNode> dq=new LinkedList<>();
		dq.add(root);
		int level=0;
		while(!dq.isEmpty()) {
			int s=dq.size();
			while(s>0) {
				BinaryTree.TreeNode node=dq.pollFirst();
				System.out.println("Node : "+node.val+" Level : "+level);
				if(node.left!=null) dq.add(node.left);
				if(node.right!=null) dq.add(node.right);
				s--;
			}
			level++;
		}
	}
	public void diameterAndDepth() {
		System.out.println(Arrays.toString(diaDepth(root)));
	}
	private int[] diaDepth(BinaryTree.TreeNode node) {
		int []diaDep=new int[] {0,0}; //{diameter,depth}
		if(node==null) return diaDep;
		int []leftDiaDep=diaDepth(node.left);
		int []rightDiaDep=diaDepth(node.right);
		diaDep[0]=Math.max(Math.max(leftDiaDep[0],rightDiaDep[0]),(leftDiaDep[1]+rightDiaDep[1]));
		diaDep[1]=Math.max(leftDiaDep[1], rightDiaDep[1])+1;
		return diaDep;
	}
	@Override
	protected void finalize() {
		sc.close();
	}
}
