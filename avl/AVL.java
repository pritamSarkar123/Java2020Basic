package avl;
public class AVL <V extends Comparable<V>>{
	private class TreeNode<K extends Comparable<K>>{
		private K val;
		private TreeNode<K> left;
		private TreeNode<K> right;
		private int height;
		public TreeNode(K val) {
			this.val=val;
			this.left=null;this.right=null;this.height=1;
		}
		@Override
		public String toString() {
			return "TreeNode [val=" + val + ", left=" + left + ", right=" + right + ", height=" + height + "]";
		}
	}
	private TreeNode<V> root;
	public AVL() {
		this.root=null;
	}
	private int leftHeight(TreeNode<V> node) {
		return (node.left!=null)?node.left.height:0;
	}
	private int rightHeight(TreeNode<V> node) {
		return (node.right!=null)?node.right.height:0;
	}
	private int calcHeight(TreeNode<V> node) {
		return Math.max(leftHeight(node), rightHeight(node))+1;
	}
	private int balanceFactor(TreeNode<V> node) {
		return leftHeight(node) - rightHeight(node);
	}
	private TreeNode<V> inorderSuccssor(TreeNode<V> node){
		TreeNode<V> temp=node.right;
		while(temp.left!=null) temp=temp.left;
		return temp;
	}
	private TreeNode<V> inorderPredessor(TreeNode<V> node){
		TreeNode<V> temp=node.left;
		while(temp.right!=null) temp=temp.right;
		return temp;
	}
	private TreeNode<V> LLrotate(TreeNode<V> node){
		TreeNode<V> temp=node.left;
		node.left=temp.right;
		temp.right=node;
		node.height=calcHeight(node);
		temp.height=calcHeight(temp);
		return temp;
	}
	private TreeNode<V> RRrotate(TreeNode<V> node){
		TreeNode<V> temp=node.right;
		node.right=temp.left;
		temp.left=node;
		node.height=calcHeight(node);
		temp.height=calcHeight(temp);
		return temp;
	}
	private TreeNode<V> balanceNode(TreeNode<V> node,boolean delete){
		int n=0,l=0,ll=0,lr=0,r=0,rr=0,rl=0;
		if(node!=null) {
			n=balanceFactor(node);
			if(node.left!=null) {
				l=balanceFactor(node.left);
				if(node.left.left!=null)
					ll=balanceFactor(node.left.left);
				if(node.left.right!=null)
					lr=balanceFactor(node.left.right);
			}
			if(node.right!=null) {
				r=balanceFactor(node.right);
				if(node.right.right!=null)
					rr=balanceFactor(node.right.right);
				if(node.right.left!=null)
					rl=balanceFactor(node.right.left);
			}
		}
		if(n==2 && l==1 && ll==0) {
			node=LLrotate(node);
		}else if(n==2 && l==-1 && lr==0) {
			node.left=RRrotate(node.left);
			node=LLrotate(node);
		}else if(n==-2 && r==-1 && rr==0) {
			node=RRrotate(node);
		}else if(n==-2 && r==1 && rl==0) {
			node.right=LLrotate(node.right);
			node=RRrotate(node);
		}
		if(delete==true) {
			if(n==2 && l==0 && ll==0) {
				node=LLrotate(node);
			}else if(n==-2 && r==0 && rr==0) {
				node=RRrotate(node);
			}
		}
		return node;
	}
	private TreeNode<V> delete(TreeNode<V> node,V val){
		if(node==null) return null;
		if(node.val.compareTo(val)>0) node.left=delete(node.left,val);
		else if(node.val.compareTo(val)<0) node.right=delete(node.right,val);
		else {
			if(node.left==null) return node.right;
			else if(node.right==null) return node.left;
			else {
				int lh=leftHeight(node);
				int rh=rightHeight(node);
				if(lh>rh) {
					TreeNode<V> pred=inorderPredessor(node);
					node.val=pred.val;
					node.left=delete(node.left,node.val);
				}else {
					TreeNode<V> succ=inorderSuccssor(node);
					node.val=succ.val;
					node.right=delete(node.right,node.val);
				}
			}
		}
		node.height=calcHeight(node);
		node=balanceNode(node,true);
		return node;
	}
	private TreeNode<V> insert(TreeNode<V> node,V val){
		if(node==null) return new TreeNode<V>(val);
		if(node.val.compareTo(val)>0) node.left=insert(node.left,val);
		else node.right=insert(node.right,val);
		node.height=calcHeight(node);
		node=balanceNode(node,true);
		return node;
	}
	private void inorder(TreeNode<V> node) {
		if(node==null) return;
		inorder(node.left);
		System.out.println(node.val+"-> height "+node.height);
		inorder(node.right);
	}
	public void insert(V val) {
		root=insert(root,val);
	}
	public void delete(V val) {
		root=delete(root,val);
	}
	public void showTree() {
		inorder(root);
		System.out.println();
	}
}
