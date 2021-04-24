package compitativeJava.sums;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Two_Three_Four_Sum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		funcOne();
		funcTwo();
		funcThree();
	}
	public static void funcOne() {
		int[] arr={0, -1, 2, -3, 1};
		int target=-2;
		List<List<Integer>> ans=twoSum(arr,target);
		System.out.println("Two sum ans ------------------------->");
		if(ans.isEmpty()) System.out.println("no pair exhist");
		else {
			for(int i=0;i<ans.size();i++) {
				for(int j=0;j<ans.get(i).size();j++) {
					System.out.print(ans.get(i).get(j)+" ");
				}System.out.println();
			}
		}
	}
	public static void funcTwo() {
		int[] arr={12, 3, 4, 1, 6, 9};
	    int target=24;
		List<List<Integer>> ans=threeSum(arr,target);
		System.out.println("Three sum ans ------------------------->");
		if(ans.isEmpty()) System.out.println("no triplet exhist");
		else {
			for(int i=0;i<ans.size();i++) {
				for(int j=0;j<ans.get(i).size();j++) {
					System.out.print(ans.get(i).get(j)+" ");
				}System.out.println();
			}
		}
	}
	public static void funcThree() {
		int[] arr={1,0,-1,0,-2,2};
	    int target=0;
		List<List<Integer>> ans=fourSum(arr,target);
		System.out.println("Four sum ans ------------------------->");
		if(ans.isEmpty()) System.out.println("no quad exhist");
		else {
			for(int i=0;i<ans.size();i++) {
				for(int j=0;j<ans.get(i).size();j++) {
					System.out.print(ans.get(i).get(j)+" ");
				}System.out.println();
			}
		}
	}
	public static List<List<Integer>> twoSum(int[] arr,int target){
		List<List<Integer>> ans=new ArrayList<>();
		Arrays.sort(arr);
		int p=0;
		int q=arr.length-1;
		//we don't have to bother about left of p 
		// because p will take care of those elements
		while(p<q) {
			int temp=arr[p]+arr[q];
			if(temp>target) q--;
			else if(temp<target) p++;
			else {
				List<Integer> res=new ArrayList<>();
				res.add(arr[p]);
				res.add(arr[q]);
				ans.add(res);
				//avoid duplicate
				while(p<q && arr[p]==res.get(0)) p++;
				while(p<q && arr[q]==res.get(1)) q--;
			}
		}
		return ans;
	}
	public static List<List<Integer>> threeSum(int[] arr,int target){
		List<List<Integer>> ans=new ArrayList<List<Integer>>();
		Arrays.sort(arr);
		int n=arr.length;
		for(int i=0;i<n;i++) {
			int new_target=target-arr[i];
			int p=i+1;// left of p taken care by i
			int q=n-1;
			while(p<q) {
				int temp=arr[p]+arr[q];
				if(temp>new_target) q--;
				else if(temp<new_target) p++;
				else {
					List<Integer> res=new ArrayList<Integer>();
					res.add(arr[i]);
					res.add(arr[p]);
					res.add(arr[q]);
					ans.add(res);
					while(p<q && arr[p]==res.get(1)) p++;
					while(p<q && arr[q]==res.get(2)) q--;
				}
			}
			while(i+1<n && arr[i+1]==arr[i]) i++;
		}
		return ans;
	}
	public static List<List<Integer>> fourSum(int[] arr,int target){
		List<List<Integer>> ans=new ArrayList<List<Integer>>();
		Arrays.sort(arr);
		int n=arr.length;
		for(int i=0;i<n;i++) {
			for(int j=i+1;j<n;j++) {
				int new_target=target-arr[i]-arr[j];
				int p=j+1;// left of p taken care by i and j
				int q=n-1;
				while(p<q) {
					int temp=arr[p]+arr[q];
					if(temp>new_target) q--;
					else if(temp<new_target) p++;
					else {
						List<Integer> res=new ArrayList<Integer>();
						res.add(arr[i]);res.add(arr[j]);
						res.add(arr[p]);res.add(arr[q]);
						ans.add(res);
						while(p<q && arr[p]==res.get(2)) p++;
						while(p<q && arr[q]==res.get(3)) q--;
					}
				}
				while(j+1< n && arr[j+1]==arr[j]) j++;
			}
			while(i+1<n && arr[i+1]==arr[i]) i++;
		}
		return ans;
	}
}
