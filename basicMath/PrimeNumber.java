package basicMath;
import java.util.Scanner;
public class PrimeNumber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
	    System.out.println("Enter the number to check whether it is prime or not ");
		int number=sc.nextInt();
		boolean prime=true;
		int i=2;
		while(i*i<=number){
		    if(number%i==0){
		        prime=false;break;
		    }
		    i++;
		}
		if(prime){
		    System.out.println(number+" is a prime number");
		}else{
		    System.out.println(number+" is not prime number");
		}
		sc.close();
	}

}
