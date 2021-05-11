package rabinKrap;

import java.util.HashMap;
import java.util.Map;

public class RabinCrapBasic {
	public static final long prime=31;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		rabinBasic();
		rabinAdv();
	}
	public static void rabinBasic() {
		String text="abeda";
		String pattern="mda";
		char []textArr=text.toCharArray();
		char []patArr=pattern.toCharArray();
		long patternHash=hashCalculate(patArr, 0, patArr.length-1);
		long textSliceHash=hashCalculate(textArr, 0, patArr.length-1);
		int start=0;
		int end=start+patArr.length-1;
		boolean patternFound=false;
		while(end<textArr.length) {
			if(textSliceHash==patternHash && equals(textArr,patArr,start,end)) {
				System.out.println(start);
				patternFound=true;
				break;
			}
			start++;end++;
			if(end>=textArr.length) break;
			textSliceHash=recalcHash(textArr,start,end,textSliceHash);
		}
		if(!patternFound) System.out.println(-1);
	}
	public static void rabinAdv() {
		String text="abedacdcabedacdcabedacdcabedacdcabedacdcabedacdcabedacdcabedacdc";
		String []patterns={"mda","eda","bed","cdc"};
		Map<Long,String> mapToPattern=new HashMap<>();
		for(String s:patterns) {
			mapToPattern.put(hashCalculate(s.toCharArray(),0,s.length()-1),s);
		}
		char []textArr=text.toCharArray();
		int start=0;
		int end=start+patterns[0].length()-1;
		long textSliceHash=hashCalculate(textArr, 0, patterns[0].length()-1);
		boolean patternFound=false;
		while(end<textArr.length) {
			if(mapToPattern.containsKey(textSliceHash) && equals(textArr,mapToPattern.get(textSliceHash).toCharArray(),start,end)) {
				System.out.println(start+" "+mapToPattern.get(textSliceHash));
				patternFound=true;
			}
			start++;end++;
			if(end>=textArr.length) break;
			textSliceHash=recalcHash(textArr,start,end,textSliceHash);
		}
		if(!patternFound) System.out.println(-1+" "+mapToPattern.get(textSliceHash));
	}
	public static long recalcHash(char []text,int start,int end,long oldHash) {
		long val=oldHash-text[start-1];
		val/=prime;
		long newHash=val+(long)Math.pow(prime, (end-start))*text[end];
		return newHash;
	}
	public static long hashCalculate(char []text,int start,int end) {
		long hash=0;
		for(int i=start,k=0;i<=end;i++,k++) {
			hash+=text[i]*Math.pow(prime, k);
		}
		return hash;
	}
	public static boolean equals(char []text,char []pattern,int start,int end) {
		for(int i=start,k=0;i<=end;i++,k++) if(text[i]!=pattern[k]) return false;
		return true;
	}
}
