package hashingOne;

public class MyClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MyHashTable mht=new MyHashTable();
		System.out.println(mht.insert(25, (25+20)*5));
		System.out.println(mht.insert(14, (13+20)*5));
		System.out.println(mht.insert(18, (19+20)*5));
		System.out.println(mht.insert(15, (15+20)*5));
		System.out.println(mht.insert(25, (12+20)*5));
		System.out.println(mht.insert(17, (11+20)*5));
		System.out.println(mht.insert(34, (15+20)*5));
		System.out.println(mht.insert(35, (12+20)*5));
		System.out.println(mht.insert(47, (11+20)*5));
		
		mht.showTable();
		mht.search(25);
		mht.search(89);
		mht.delete(25);
		mht.search(25);
		mht.showTable();
	}

}
