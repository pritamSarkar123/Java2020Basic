package patternsPrint;
import java.util.Scanner;
public class BlankTriangle {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		int num=sc.nextInt();
		for(int i=0;i<num;i++){
		    for(int j=0;j<num-i-1;j++){
		        System.out.print("  ");
		    }
		    for(int k=0;k<=i;k++){
		        System.out.print("$   ");
		    }
		    System.out.println();
		}
		System.out.println();
		System.out.println();
		for(int i=0;i<num/2;i++){
		    for(int j=0;j<=i;j++){
		        System.out.print("$  ");
		    }
		    System.out.println();
		}
		for(int i=num/2;i<num;i++){
		    for(int j=0;j<num-i;j++){
		        System.out.print("$  ");
		    }
		    System.out.println();
		}
		System.out.println();
		System.out.println();
		int count=1;
		for(int i=0;i<num;i++){
		    for(int j=0;j<num-i-1;j++){
		        System.out.print("  ");
		    }
		    for(int k=0;k<=i;k++){
		        System.out.print(count+"   ");
		        count++;
		    }
		    System.out.println();
		}
		System.out.println();
		System.out.println();
		for(int i=0;i<num;i++){
		    for(int j=0;j<num-i-1;j++){
		        System.out.print("  ");
		    }
		    for(int k=0;k<=i;k++){
		        System.out.print("$   ");
		    }
		    System.out.println();
		}
		System.out.println();
		System.out.println();
		System.out.println("$ ");
		for(int i=1;i<num-1;i++) {
			System.out.print("$");
			for(int j=0;j<i-1;j++) {
				System.out.print("  ");
			}
			System.out.println(" $");
		}
		for(int k=0;k<num;k++) {
			System.out.print("$ ");
		}
		sc.close();
	}

}
