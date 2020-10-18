package interfaceJava11;

public interface Interface2 {
	default void concreteMethod1() {
		System.out.println("Common concrete method from interface 2");
	}
	default void concreteMethod2() {
		System.out.println("concrete method uniquily present in interfacce 2");
	}
}
