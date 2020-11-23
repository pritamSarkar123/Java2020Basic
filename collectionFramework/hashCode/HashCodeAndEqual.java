package collectionFramework.hashCode;

import java.util.HashSet;
import java.util.Set;

public class HashCodeAndEqual {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//Concept:-HashCode and Equals _ Java Placement Course _ Lecture 49
		// top most parent class of any class is "Object"
		//methods:- 
		/*
		 * getClass()
		 *** hashCode()
		 * wait()
		 * toString()
		 * clone()
		 *** equals()
		 * finalize()
		 * notify()
		 * notifyAll()
		 */
		//equals is subset of hashCode //property wise
		/*
		 * if two objects are equal , then they must have same hash code
		 * vice versa is not true
		 * */
		/*hashCode()->function()->position() in long, used in hash map*/
		Set<Number> numSet=new HashSet<>();
		numSet.add(new Number("one",1));
		numSet.add(new Number("two",2));
		numSet.add(new Number("one",1));// will not be added as equal and hashCode
		//already overridden from Object class to the Number class
		System.out.println(numSet);
	}

}
class Number{
	String name;
	int value;
	public Number(String name,int value) {
		this.name=name;
		this.value=value;
	}
	public Number() {
		this.name="";
		this.value=0;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + value;
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Number other = (Number) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (value != other.value)
			return false;
		return true;
	}
	
}
