package dynamicProgramming;

public class LongestPalindromSubstring {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//problem:-https://www.youtube.com/watch?v=UflHuQj6MVA
		String str="aaabbaabaaaaabbaaaabbaabaaaaabbaaaabbaabaaaaabbaaaabbaabaaaaabbaaaabbaabaaaaabbaaaabbaabaaaaabbaaaabbaabaaaaabbaaaabbaabaaaaabba";
//		allSubstrings(str);
		longestPalinSubstrigBrut(str);
		longestPalinSubstrigDynamic(str);
		
	}
	public static void allSubstrings(String str) {
		int len=str.length();
		int m;
		for(int i=1;i<=len;i++) { //top to bottom 
			m=0;
			for(int j=len-i+1;j>=1;j--) { //left to right
				for(int k=m;k<m+i;k++) { //window
					System.out.print(str.charAt(k));
				}System.out.print(" ");
				m++;
			}System.out.println();
		}
	}
	public static void longestPalinSubstrigBrut(String str) { //O(n^3)
		int loopCount=0;
		int len=str.length();
		int m,n;
		boolean palin;
		int start=0,end=0,maxLenght=Integer.MIN_VALUE;
		for(int i=1;i<=len;i++) {
			m=0;
			for(int j=len-i+1;j>=1;j--) { //left to right
				palin=true;
				n=m+i-1;
				for(int k=m;k<m+i;k++) { //window
					loopCount++;
					if(k>n) break;
					else if(str.charAt(n)!=str.charAt(k)) {palin=false;break;}
					n--;
				}
				if(palin==true && i>maxLenght) {
					maxLenght=i;start=m;end=m+i-1;
				}
				m++;
			}
		}
		System.out.println("Longest Palindrom");
		for(int i=start;i<=end;i++) {
			System.out.print(str.charAt(i));
		}System.out.println("\nLoop count = "+loopCount);
	}
	public static void longestPalinSubstrigDynamic(String str) { //O(n^2)
		int loopCount=0;
		int len=str.length();
		boolean [][]palin=new boolean[len][len];
		for(int i=0;i<len;i++) {
			for(int j=0;j<len;j++) {
				palin[i][j]=false;
			}
		}
		
		int start=0,end=0,maxLength=Integer.MIN_VALUE;
		//filling len 1 and 2 elements 1st
		for(int i=0;i<len;i++) {
			palin[i][i]=true; 
			maxLength=1;start=i;end=i;
			if(i+1<len) {
				palin[i][i+1]=str.charAt(i)==str.charAt(i+1)?true:false;
				if(palin[i][i+1] && 2>maxLength) {
					maxLength=2;start=i;end=i+1;
				}
			}
		}
		for(int diff=3;diff<=len;diff++) {
			for(int i=0;i<len;i++) {
				loopCount++;
				int j=i+diff-1;
				if(j<len) {
					palin[i][j]=str.charAt(i)==str.charAt(j) && palin[i+1][j-1]==true?true:false;
					if(palin[i][j] && diff>maxLength) {maxLength=diff;start=i;end=j;}
				}
				
			}
		}
		System.out.println("Longest Palindrom");
		for(int i=start;i<=end;i++) {
			System.out.print(str.charAt(i));
		}System.out.println("\nLoop count = "+loopCount);
	}
}
