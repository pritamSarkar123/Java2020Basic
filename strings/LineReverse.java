package strings;

import java.util.Scanner;
public class LineReverse {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		String line=sc.nextLine();
		strRevIter(line);
		sc.close();
	}
	static void strRevIter(String str) {
		int start=str.length()-1;
		int end=0;
		String rev="";
		while(start>=0) {
			while(start>=0 && str.charAt(start)==' ') {
				start--;
			}
			end=start;
			while(start>=0 && str.charAt(start)!=' ') {
				start--;
			}
			rev=rev.concat(" "+str.substring(start+1, end+1));
		}
		System.out.println(rev.substring(1));
	}
	

}
