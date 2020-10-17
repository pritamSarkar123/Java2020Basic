package arrayBasic;

public class TwoDarray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] a;
		a=new int[5][6];
		System.out.println("2d \"a\" array created in heap");
		int b[][]= {
				{1,2,3,4,5},
				{6,7,8},
				{9,10,11,10,23}
		};
		System.out.println("2d \"b\" array created in stack ");
	}

}
