package interfaceJava11;

public interface Interface3 {
	default void concreteMethod1() {
		System.out.println("Common concrete method from interface 3");
	}
}
