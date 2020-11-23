package comparableANDcomparotor.comparator;

import java.util.Comparator;

public class PairOne {
	String name;
	int age;
	public PairOne(String name,int age) {
		this.name=name;this.age=age;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	@Override
	public String toString() {
		return "Pair One [ name = "+ this.name+" age = "+this.age+" ]";
	}
}

//below classes can also be defined in MyClass file
//but here is more clear
class SortByNameThenByAge implements Comparator<PairOne>{

	@Override
	public int compare(PairOne o1, PairOne o2) {
		//Descending order logic one 1st by name then by age Type1
//		if(o1.name.compareTo(o2.name)==0) {
//			if(o1.age>o2.age) return -1;
//			else if(o1.age<o2.age) return 1;
//			else return 0;
//		}else {
//			return o1.name.compareTo(o2.name);
//		}
		
		//Descending order logic one 1st by name then by age Type2
//		int nameComp=o1.name.compareTo(o2.name); //ascending by name
//		return nameComp==0?o2.age-o1.age:nameComp;
		
		//Ascending order logic one 1st by name then by age Type1
//		if(o1.name.compareTo(o2.name)==0) {
//			if(o1.age>o2.age) return 1;
//			else if(o1.age<o2.age) return -1;
//			else return 0;
//		}else {
//			return o1.name.compareTo(o2.name);
//		}
		
		//Ascending order logic one 1st by name then by age Type2
		int nameComp=o1.name.compareTo(o2.name); //ascending by name
		return nameComp==0?o1.age-o2.age:nameComp;
	}	
}

class SortByAgeThenByName implements Comparator<PairOne>{

	@Override
	public int compare(PairOne o1, PairOne o2) {
		//Descending order logic one 1st by age then by name Type1
//		if(o1.age>o2.age) return -1;
//		else if(o1.age<o2.age) return 1;
//		else return o1.name.compareTo(o2.name); //ascending by name
		
		//Descending order logic one 1st by age then by name Type2
//		int ageComp=o2.age-o1.age;
//		return ageComp==0?o1.name.compareTo(o2.name):ageComp;
		
		//Ascending order logic one 1st by age then by name Type1
//		if(o1.age>o2.age) return 1;
//		else if(o1.age<o2.age) return -1;
//		else return o1.name.compareTo(o2.name); //ascending by name
		
		//Ascending order logic one 1st by age then by name Type2
		int ageComp=o1.age-o2.age;
		return ageComp==0?o1.name.compareTo(o2.name):ageComp;
	}
	
}
