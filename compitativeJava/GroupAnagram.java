package compitativeJava;
import java.util.*;
public class GroupAnagram {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] strs= {"eat","tea","tan","ate","nat","bat"};
		System.out.println(groupAnagrams(strs));
//		MyEntry m1=new MyEntry("tan");
//		MyEntry m2=new MyEntry("nat");
//		System.out.println(m1.equals(m2));
//		System.out.println(m1.hashCode() +" "+m2.hashCode());
	}
	public static List<List<String>> groupAnagrams(String[] strs){
//		Map<Integer,List<String>> map=new HashMap<>();
//		MyEntry obj;
//		for(String s:strs) {
//			obj=new MyEntry(s);
//			if(!map.containsKey(obj.hashCode())) {
//				map.put(obj.hashCode(),new LinkedList<String>());
//			}
//			map.get(obj.hashCode()).add(s);
//		}
//		return new LinkedList<List<String>>(map.values());
		Map<String,List<String>> map=new HashMap<>();
        for(String str:strs){
            char[] c=str.toCharArray();
            Arrays.sort(c);
            String sorted=new String(c);
            if(!map.containsKey(sorted)){
                map.put(sorted,new LinkedList<String>());
            }
            map.get(sorted).add(str);
        }
        return new LinkedList<List<String>>(map.values());
	}

}
//class MyEntry{
//	String word;
//	public MyEntry(String word) {
//		this.word=word;
//	}
//	@Override
//	public boolean equals(Object other) {
//		MyEntry obj=(MyEntry)other;
//		if(obj.word==null) return false;
//		return word.equals(obj.word);
//	}
//	@Override
//	public int hashCode() {
//		final int prime = 31;
//		int result = 1;
//		int sum=0;
//		int[] arr=new int[26];
//		for(int i=0;i<26;i++) arr[i]=0;
//		if(word==null) sum=0;
//		else {
//			for(int i=0;i<word.length();i++) {
//				arr[word.charAt(i)-97]++;
//			}
//			for(int i=0;i<26;i++) {
//				if(arr[i]!=0) {
//					sum+=arr[i]*(int)Math.pow(2, i);
//				}
//			}
//		}
//		result = prime * result + sum;
//		return result;
//	}
//}
