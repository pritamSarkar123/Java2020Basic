package singletons;

public class MainClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		AppConfig obj1=AppConfig.getInstance();
		AppConfig obj2=AppConfig.getInstance();
		AppConfig obj3=AppConfig.getInstance();
		System.out.println(AppConfig.getInstanceCount());
		System.out.println(AppConfig.getRefRetuenCount());
	}

}
