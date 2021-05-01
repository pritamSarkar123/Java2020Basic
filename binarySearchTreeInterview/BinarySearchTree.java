package binarySearchTreeInterview;

class Node{
	int val;
	Node left;
	Node right;
	public Node(int val,Node left,Node right) {
		this.val=val;this.left=left;this.right=right;
	}
	@Override
	public String toString() {
		return "Node [val=" + val + ", left=" + left + ", right=" + right + "]";
	}
}
class BST{
	Node root;
	public BST() {
		root=null;
	}
	public void createTree(int[] nodeValues) {
		for(int val:nodeValues) {
			insert(val);
		}
	}
	public void insert(int val) {
		root=insertNode(root,val);
	}
	private Node insertNode(Node root,int val) {
		if(root==null) {
			return new Node(val,null,null);
		}
		if(root.val<val) {
			root.right=insertNode(root.right,val);
		}else {
			root.left=insertNode(root.left, val);
		}
		return root;
	}
	private int findHeight(Node root) {
		if(root==null) return 0;
		else return Math.max(findHeight(root.left), findHeight(root.right))+1;
	}
	private Node inorderPredessor(Node root) {
		Node temp=root.left;
		while(temp.right!=null) {
			temp=temp.right;
		}
		return temp;
	}
	private Node inorderSucceeor(Node root) {
		Node temp=root.right;
		while(temp.left!=null) {
			temp=temp.left;
		}
		return temp;
	}
	public void delete(int val) {
		if(root==null) return;
		root=deleteNodeRec(root,val);
	}
	private Node deleteNodeRec(Node root,int val) {
		if(root==null) return null;
		else if(root.val<val) {
			root.right=deleteNodeRec(root.right,val);
		}else if(root.val>val) {
			root.left=deleteNodeRec(root.left, val);
		}else {
			if(root.left==null) return root.right;
			else if(root.right==null) return root.left;
			else {
				int leftHeight=findHeight(root.left);
				int rightHeight=findHeight(root.right);
				if(leftHeight>rightHeight) {
					Node inPre=inorderPredessor(root);
					root.val=inPre.val;
					root.left=deleteNodeRec(root.left,root.val);
				}else {
					Node inSuc=inorderSucceeor(root);
					root.val=inSuc.val;
					root.right=deleteNodeRec(root.right,root.val);
				}
			}
		}
		return root;
	}
	public void show() {
		showTree(root);
		System.out.println();
	}
	private void showTree(Node root) {
		if(root==null) return;
		showTree(root.left);
		System.out.print(root.val+" ");
		showTree(root.right);
	}
}
public class BinarySearchTree {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr= {15,10,19,2,13,12,25};
		BST tree=new BST();
		tree.createTree(arr);
		tree.show();
		System.out.println("---------------------------");
		
		tree.delete(12);
		tree.show();
		System.out.println("---------------------------");
		
		tree.delete(15);
		tree.show();
		System.out.println("---------------------------");
		
	}

}
