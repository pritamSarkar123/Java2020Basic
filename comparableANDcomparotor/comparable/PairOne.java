package comparableANDcomparotor.comparable;

public class PairOne implements Comparable<PairOne>{
	private String name;
	private int age;
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
	//natural order logic for that class obj
	//fixed
	@Override
	public int compareTo(PairOne o) { 
		//Descending order logic one 1st by age then by name Type1
//		if(this.age>o.age) return -1;
//		else if(this.age<o.age) return 1;
//		else return this.name.compareTo(o.name); //ascending by name
		
		//Descending order logic one 1st by name then by age Type1
//		if(this.name.compareTo(o.name)==0) {
//			if(this.age>o.age) return -1;
//			else if(this.age<o.age) return 1;
//			else return 0;
//		}else {
//			return this.name.compareTo(o.name);
//		}
		
		//Descending order logic one 1st by age then by name Type2
//		int ageComp=o.age-this.age;
//		return ageComp==0?this.name.compareTo(o.name):ageComp;
		
		//Descending order logic one 1st by name then by age Type2
//		int nameComp=this.name.compareTo(o.name); //ascending by name
//		return nameComp==0?o.age-this.age:nameComp;
		
		//Ascending order logic one 1st by age then by name Type1
//		if(this.age>o.age) return 1;
//		else if(this.age<o.age) return -1;
//		else return this.name.compareTo(o.name); //ascending by name
		
		//Ascending order logic one 1st by name then by age Type1
//		if(this.name.compareTo(o.name)==0) {
//			if(this.age>o.age) return 1;
//			else if(this.age<o.age) return -1;
//			else return 0;
//		}else {
//			return this.name.compareTo(o.name);
//		}
		
		//Ascending order logic one 1st by age then by name Type2
//		int ageComp=this.age-o.age;
//		return ageComp==0?this.name.compareTo(o.name):ageComp;
		
		//Ascending order logic one 1st by name then by age Type2
		int nameComp=this.name.compareTo(o.name); //ascending by name
		return nameComp==0?this.age-o.age:nameComp;
		
	}
}
