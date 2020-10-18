package interfaceJava8;

public class MainClass extends Student implements Youtuber,Coder {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//static methods from STudent class
		setName("Pritam Sarkar");
		studentDetails();
		//non static implemented methods
		MainClass mc=new MainClass();
		mc.doesVideoEditing();
		mc.doesCoding();
		mc.uploadesVideo();
		
		// can access only implemented methods of Youtuber interface
		Youtuber y1=mc;
		y1.doesVideoEditing();
		y1.uploadesVideo();
		
		// can access only implemented methods of Coder interface
		Coder c1=mc;
		c1.doesCoding();
		
	}

	@Override
	public void doesVideoEditing() {
		// TODO Auto-generated method stub
		System.out.println("his editing rank is "+editingRank);
	}

	@Override
	public void doesCoding() {
		// TODO Auto-generated method stub
		System.out.println("his coding rank is "+codingRank);
	}

	@Override
	public void uploadesVideo() {
		// TODO Auto-generated method stub
		System.out.println("his youtube rank is "+youtubeRank);
		
	}
	

}
