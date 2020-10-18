package interfaceJava11;

public interface Interface1 {
	default void concreteMethod1() {
		System.out.println("Common concrete method from interface 1");
	}
}
