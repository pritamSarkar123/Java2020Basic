package avl;

public class MyAvlTree {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		AVL<Integer> avl=new AVL<>();
		System.out.println("after insertion");
		avl.insert(1);
		avl.insert(2);
		avl.insert(3);
		avl.insert(5);
		avl.showTree();
		avl.delete(3);
		System.out.println("after deletion");
		avl.showTree();
		avl.insert(7);
		avl.insert(9);
		avl.insert(8);
		avl.insert(2);
		System.out.println("after insertion");
		avl.showTree();
	}

}
