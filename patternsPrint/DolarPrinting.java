package patternsPrint;
import java.util.Scanner;
public class DolarPrinting {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		int num=sc.nextInt();
		for(int i=0;i<num;i++){
		    for(int k=0;k<=i;k++){
		        System.out.print(" ");
		    }
		    for(int j=0;j<num-i;j++){
		        System.out.print("$ ");
		    }
		    System.out.println();
		}
		System.out.println();
		System.out.println();
		for(int i=0;i<num;i++){
		    for(int k=0;k<=i;k++){
		        System.out.print("  ");
		    }
		    for(int j=0;j<num-i;j++){
		        System.out.print("$ ");
		    }
		    System.out.println();
		}
		System.out.println();
		System.out.println();
		for(int i=0;i<num;i++){
		  //  for(int k=0;k<=i;k++){
		  //      System.out.print("  ");
		  //  }
		    for(int j=0;j<num-i;j++){
		        System.out.print("$ ");
		    }
		    System.out.println();
		}
		System.out.println();
		System.out.println();
		for(int i=0;i<num;i++){
		    for(int k=0;k<num-i-1;k++){
		        System.out.print("  ");
		    }
		    for(int j=0;j<=i;j++){
		        System.out.print("$ ");
		    }
		    System.out.println();
		}
		sc.close();
	}

}
