package methodOverridding;

public class ChildClass extends ParentClass {
	@Override
	public void methOne() {
		System.out.println("This is method one of ChildClass");
	}
	@Override
	public void methTwo() {
		System.out.println("This is method Two of ChildClass");
	}
	public void methThree() {
		System.out.println("This is method Three of ChildClass");
	}
	public void methFour() {
		System.out.println("This is method four of ChildClass");
	}
}
