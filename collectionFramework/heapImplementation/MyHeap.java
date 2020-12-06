package collectionFramework.heapImplementation;

import java.util.Comparator;
import java.util.PriorityQueue;

public class MyHeap {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		PriorityQueue<Student> minHeap=new PriorityQueue<>(new StudentComparatorMinHeap());
//		PriorityQueue<Student> maxHeap=new PriorityQueue<>(new StudentComparatorMaxHeap());
		
		PriorityQueue<Student> minHeap=new PriorityQueue<>((o1,o2)->o1.getAge()-o2.getAge());
		PriorityQueue<Student> maxHeap=new PriorityQueue<>((o1,o2)->o2.getAge()-o1.getAge());
		
		
		System.out.println("Min heap----------------->");
		minHeap.add(new Student("Eshani",25));
		minHeap.add(new Student("Rahul",27));
		minHeap.add(new Student("Vanu",28));
		while(!minHeap.isEmpty()) {
			System.out.println(minHeap.poll().getName());
		}
		System.out.println("Max heap----------------->");
		maxHeap.add(new Student("Eshani",25));
		maxHeap.add(new Student("Rahul",27));
		maxHeap.add(new Student("Vanu",28));
		while(!maxHeap.isEmpty()) {
			System.out.println(maxHeap.poll().getName());
		}
	}

}
class Student{
	private String name;
	private int age;
	public Student(String name,int age) {
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
}
class StudentComparatorMaxHeap implements Comparator<Student>{

	@Override
	public int compare(Student o1, Student o2) {
		// TODO Auto-generated method stub
		return o2.getAge()-o1.getAge();
	}
	
}
class StudentComparatorMinHeap implements Comparator<Student>{

	@Override
	public int compare(Student o1, Student o2) {
		// TODO Auto-generated method stub
		return o1.getAge()-o2.getAge();
	}
	
}
