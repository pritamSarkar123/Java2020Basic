package arrayBasic;
import java.util.Scanner;
public class ArrayBasic {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		int num;
		System.out.println("Enter number of students ");
		num=sc.nextInt();
		// below arrays created in stack
		int sections[]= {1,2,3,4,5};
		int[] divisions= {1,2,3,4,5};
		// below arrays created in heaps
		int[] rolls,sectors;
		double marks[];
		rolls=new int[num];
		sectors=new int[num];
		marks=new double[num];
		// initial values by default zeroes
		for(int i=0;i<rolls.length;i++) {
			System.out.print(rolls[i]+" ");
		}
		for(int i=0;i<rolls.length;i++) {
			rolls[i]=sc.nextInt();
			sectors[i]=sc.nextInt();
			marks[i]=sc.nextDouble();
		}
		for(int i=0;i<rolls.length;i++) {
			System.out.println(rolls[i]+" "+sections[i]+" "+divisions[i]+" "+sectors[i]+" "+marks[i]);
		}
		sc.close();
	}

}
