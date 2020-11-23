package comparableANDcomparotor.comparator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Comparator;

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
		arr.add(new PairOne("vusha",26));
		arr.forEach(System.out::println);
		
		
		Collections.sort(arr,new SortByAgeThenByName());
		System.out.println("-------------------");
		arr.forEach(System.out::println);
		
		
		Collections.sort(arr,new SortByNameThenByAge());
		System.out.println("-------------------");
		arr.forEach(System.out::println);
		
		
		//Sort by age then name
		Collections.sort(arr,new Comparator<PairOne>() {// Anonymous class
			@Override
			public int compare(PairOne o1, PairOne o2) {
				int ageComp=o1.age-o2.age;
				return ageComp==0?o1.name.compareTo(o2.name):ageComp;
			}
		});
		System.out.println("-------------------");
		arr.forEach(System.out::println);
		
		
		//*************
		//using lambda function, when one interface contains one function only
		//it is better to use lambda function
		// the second argument of Collections.sort() is a comparator
		//which contains only one function
		Collections.sort(arr,(PairOne o1, PairOne o2)->{
				int ageComp=o1.age-o2.age;
				return ageComp==0?o1.name.compareTo(o2.name):ageComp;
			});
		System.out.println("-------------------");
		arr.forEach(System.out::println);
		
		
		//no need of declaring types of o1 and o2 as known to us in prior
		Collections.sort(arr,(o1,o2)->{
			int ageComp=o1.age-o2.age;
			return ageComp==0?o1.name.compareTo(o2.name):ageComp;
		});
		System.out.println("-------------------");
		arr.forEach(System.out::println);
		
		
		//when we have nothing but only one return statement
		//based on 1st age wise(asc) then name wise(asc) 
		Collections.sort(arr,(o1,o2)->o1.age-o2.age==0?o1.name.compareTo(o2.name):o1.age-o2.age);
		System.out.println("-------------------");
		arr.forEach(System.out::println);
		
		
		//based on name wise (asc)
		Collections.sort(arr,(o1,o2)->o1.name.compareTo(o2.name));
		System.out.println("-------------------");
		arr.forEach(System.out::println);
		
		
		//based on age wise (asc)
		Collections.sort(arr,(o1,o2)->o1.age-o2.age);
		System.out.println("-------------------");
		arr.forEach(System.out::println);
		
		//predefined comparator
		//based on age wise (asc)
		Collections.sort(arr,Comparator.comparing(PairOne::getAge));
		System.out.println("-------------------");
		arr.forEach(System.out::println);
		
		//based on age wise (desc)
		Collections.sort(arr,Comparator.comparing(PairOne::getAge).reversed());
		System.out.println("-------------------");
		arr.forEach(System.out::println);
		
		//based on name asc then age asc
		Collections.sort(arr,Comparator.comparing(PairOne::getName).thenComparing(PairOne::getAge));
		System.out.println("based on name asc then age asc -------------------");
		arr.forEach(System.out::println);
		
		
		//based on name desc then age asc
		Collections.sort(arr,Comparator.comparing(PairOne::getName).reversed().thenComparing(PairOne::getAge));
		System.out.println("based on name desc then age asc -------------------");
		arr.forEach(System.out::println);
		
		
		//based on name asc then age desc
		Collections.sort(arr,Comparator.comparing(PairOne::getName).reversed().thenComparing(PairOne::getAge).reversed());
		System.out.println("based on name asc then age desc -------------------");
		arr.forEach(System.out::println);
		
		//based on name desc then age desc
		Collections.sort(arr,Comparator.comparing(PairOne::getName).thenComparing(PairOne::getAge).reversed());
		System.out.println("based on name desc then age desc -------------------");
		arr.forEach(System.out::println);
	}

}