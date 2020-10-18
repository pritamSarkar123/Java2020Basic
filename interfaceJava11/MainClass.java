package interfaceJava11;

class A implements Interface1,Interface2,Interface3 {
	@Override
	public void concreteMethod1() {
		System.out.println("Avoiding diamond problem by overridding");
	}
}
class B implements Interface1,Interface2,Interface3 {
	@Override
	public void concreteMethod1() {
		System.out.println("Avoiding diamond problem by overridding");
	}
}
class C implements Interface1,Interface2,Interface3 {
	@Override
	public void concreteMethod1() {
		System.out.println("Avoiding diamond problem by overridding");
	}
}

public class MainClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("A");
		A a=new A();
		a.concreteMethod1();
		a.concreteMethod2();
		System.out.println("B");
		B b=new B();
		b.concreteMethod1();
		b.concreteMethod2();
		System.out.println("C");
		C c=new C();
		c.concreteMethod1();
		c.concreteMethod2();
	}

}
