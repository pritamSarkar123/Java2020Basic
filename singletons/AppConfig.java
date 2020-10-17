package singletons;

public class AppConfig {
	private AppConfig() {
		System.out.println("Instance created");
	}
	
	private static AppConfig obj=null;
	private static int instanceCount=0;
	private static int refReturnCount=0;
	public static AppConfig getInstance() {
		if(obj==null) {
			obj=new AppConfig();
			instanceCount++;
		}
		System.out.println("Returning reference");
		refReturnCount++;
		return obj;
	}
	public static int getInstanceCount() {
		return instanceCount;
	}
	public static int getRefRetuenCount() {
		return refReturnCount;
	}
}
