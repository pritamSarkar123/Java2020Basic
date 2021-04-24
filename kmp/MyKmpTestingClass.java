package kmp;

public class MyKmpTestingClass {

	public static void main(String[] args) {
		String text="ababcabcababababdvcd";
		String pattern="ababd";
		System.out.println(findPattern(text,pattern));
	}
	public static int[] fillTable(String pattern) {
		int len=pattern.length();
		int []pi=new int[len];
		int j=0;
		int i=j+1;
		while(i<len) {
			if(pattern.charAt(i)==pattern.charAt(j)) {
				pi[i]=j+1;j++;
			}else {
				while(j>0 && pattern.charAt(i)!=pattern.charAt(j)) j=pi[j-1];
				if(j==0 && pattern.charAt(i)!=pattern.charAt(j)) pi[i]=0;
				else {
					pi[i]=j+1;j++;
				}
			}
			i++;
		}
		return pi;
	}
	public static int findPattern(String text,String pattern) {
		int []pi=fillTable(pattern);
		int i=0;//<- for text
		int j=0; // <- for pattern
		int lenp=pattern.length();
		int lent=text.length();
		while(true) {
			if(j==lenp) return i-j;
			if(i==lent) return -1;
			if(pattern.charAt(j)==text.charAt(i)) j++;
			else {
				while(j>0 && pattern.charAt(j)!=text.charAt(i)) j=pi[j];
				if(j!=0 || pattern.charAt(j)==text.charAt(i)) j++;
			}
			i++;
		}
	}

}
