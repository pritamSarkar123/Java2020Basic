package comparableANDcomparotor.comparable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
public class MyClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<PairOne> arr=new ArrayList<>();
		arr.add(new PairOne("pritam",26));
		arr.add(new PairOne("rahul",25));
		arr.add(new PairOne("rishika",26));
		arr.add(new PairOne("rahul",23));
		arr.add(new PairOne("poushali",22));
		arr.add(new PairOne("eshani",24));
		arr.forEach(System.out::println);
		Collections.sort(arr);
		System.out.println("-------------------");
		arr.forEach(System.out::println);
	}

}
