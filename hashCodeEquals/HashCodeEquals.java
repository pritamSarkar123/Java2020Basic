package hashCodeEquals;
import java.util.*;
class Student{
	private int id;
	private String name;
	public Student(int id,String name) {
		this.id=id;this.name=name;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
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
		Student other = (Student) obj;
		if (id != other.id)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + "]";
	}
}
class Book{
	private String book;
	public Book(String book) {
		this.book=book;
	}
	public String getBook() {
		return book;
	}
	public void setBook(String book) {
		this.book = book;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((book == null) ? 0 : book.hashCode());
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
		Book other = (Book) obj;
		if (book == null) {
			if (other.book != null)
				return false;
		} else if (!book.equals(other.book))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Book [book=" + book + "]";
	}
}

public class HashCodeEquals {

	public static void main(String[] args) {
		Student s1=new Student(60,"pritam");
		Student s2=new Student(60,"pritan");
		System.out.println(s1.equals(s2));
		System.out.println(s1.hashCode());
		System.out.println(s2.hashCode());
		func1();
		func2();
	}
	public static void func1() {
		Map<Student,Book> mp=new HashMap<>();
		mp.put(new Student(60,"pritam"), new Book("physics"));
		mp.put(new Student(60,"pritam"), new Book("chemistry"));
		mp.put(new Student(61,"pritam"), new Book("physics"));
		for(Student s:mp.keySet()) {
			System.out.println(s+"-->"+mp.get(s));
		}
	}
	public static void func2() {
		Set<Student> st=new HashSet<>();
		st.add(new Student(60,"pritam"));
		st.add(new Student(60,"pritam"));
		st.add(new Student(61,"pritam"));
		for(Student s:st) {
			System.out.println(s);
		}
	}
}
