package sorting;

import java.util.Arrays;

class RNode{
	public int val;
	public RNode next;
	public RNode(int val,RNode next) {
		this.val=val;this.next=next;
	}
}

class RedixList{
	public RNode[] list;
	public RedixList() {
		list =new RNode[10];
	}
	public boolean isBlank(int i) {
		return (list[i]==null)?true:false;
	}
	public void insertAt(int i,int val) {
		RNode n=new RNode(val,null);
		if(isBlank(i)) {
			list[i]=n;
		}else {
			RNode temp=list[i];
			while(temp.next!=null) temp=temp.next;
			temp.next=n;
		}
	}
	public RNode deleteFrom(int i) {
		if(isBlank(i)) return null;
		RNode temp=list[i];
		list[i]=temp.next;
		return temp;
	}
}
public class RedixSort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// time O(dn) <- max digit length is d
		// space O(9+n)==O(n)
		redixSort();
	}
	public static void redixSort() {
		int[] arr= {10,10,10,9,8,7,6,5,4,3,3,2,1};
		int len=arr.length;
		RedixList r=new RedixList();
		int divisor=1;
		while(true) {
			boolean allZeroes=true;
			for(int i=0;i<len;i++) {
				int index=(arr[i]/divisor)%10;
				if(index!=0) allZeroes=false;
				r.insertAt(index, arr[i]);
			}
			int k=0;
			for(int i=0;i<10;i++) {
				while(!r.isBlank(i)) {
					arr[k++]=r.deleteFrom(i).val;
				}
			}
			divisor*=10;
			if(allZeroes) break;
		}
		System.out.println(Arrays.toString(arr));
	}

}
