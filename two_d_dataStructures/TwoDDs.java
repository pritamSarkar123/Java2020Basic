package two_d_dataStructures;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class TwoDDs {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		funcOne();
		arrOfArrORLinkedList();
		listOfArrORLinkedList();

	}
	public static List<LinkedList<Integer>> funcOne(){
		System.out.println("Array of Linkedlist created");
		List<LinkedList<Integer>> aol=new ArrayList<LinkedList<Integer>>();
		return aol;
	}
	public static List<List<Integer>> arrOfArrORLinkedList(){
		System.out.println("Array of array or list created");
		List<List<Integer>> aoal=new ArrayList<List<Integer>>();
		return aoal;
	}
	public static List<List<Integer>> listOfArrORLinkedList(){
		System.out.println("LinkedList of array or list created");
		List<List<Integer>> loal=new LinkedList<List<Integer>>();
		return loal;
	}

}
