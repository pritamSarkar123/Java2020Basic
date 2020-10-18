package finalKeyWord;

//public class MainClass extends FinalClass{...}
//this leads to error as FinalClass is final
public class MainClass {

	public static void main(String[] args) {
		FinalClass fc1=new FinalClass();
		FinalClass fc2=new FinalClass();
		FinalClass temp=fc1;
		fc1=fc2;
		fc2=temp;
		
		final FinalClass fc3=new FinalClass();
		//fc3=fc2; <- this gives compile time error
		FinalClass.methOne();
	}

}
