package strings;

public class Anagrams {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String a="basiparachromatin";
		String b="marsipobranchiata";
		if(a.length()==b.length()) {
			int[] count=new int[26]; //by default zeroes
			a=a.toLowerCase();
			b=b.toLowerCase();
			int num;
			for(int i=0;i<a.length();i++) {
				num=(int)a.charAt(i)-97;
				count[num]++;
			}
			for(int i=0;i<b.length();i++) {
				num=(int)b.charAt(i)-97;
				count[num]--;
			}
			boolean anagram=true;
			for(int x:count) {
				if(x>0) {
					anagram=false;
					break;
				}
			}
			if(anagram) {
				System.out.println("Anagram");
			}else {
				System.out.println("Not anagram");
			}
		}else {
			System.out.println("Not anagram");
		}
	}

}
