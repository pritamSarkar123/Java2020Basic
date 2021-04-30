package greedyHuffManEncodingAndDecoding;

import java.util.*;

class Node{
	public String name;
	public int value;
	public Node left,right;
	public Node(String name,int value,Node left,Node right) {
		this.name=name;this.value=value;this.left=left;this.right=right;
	}
	public int getValue() {
		return value;
	}
	@Override
	public String toString() {
		return name+" "+value+" "+left+" "+right;
		
	}
}

public class HuffManEncodingAndDecoding {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String message="ABFAABGBBCBABBCCCAEEEHGDF";
		PriorityQueue<Node> pq=preProcessMessage(message);
		Node root=createTree(pq);
		Map<Character,String> metaSender=new HashMap<>();
		Map<String,Character> metaReceiver=new HashMap<>();
		createMataData(root,metaSender,metaReceiver,"");
		String encryptedMessage=encrypt(message,metaSender);
		System.out.println(encryptedMessage);
		String decryptedMessage=decrypt(encryptedMessage,metaReceiver);
		System.out.println(decryptedMessage);
	}
	public static String encrypt(String message,Map<Character,String>meta) {
		String messageToSend="";
		for(int i=0;i<message.length();i++) {
			messageToSend+=meta.get(message.charAt(i));
		}
		return messageToSend;
	}
	public static String decrypt(String message,Map<String,Character>meta) {
		String messageToReceive="";
		int i=0;
		int j=1;
		String sub="";
		while(j<=message.length()) {
			sub=message.substring(i,j);
			if(meta.containsKey(sub)) {
				messageToReceive+=meta.get(sub);
				i=j;
			}
			j++;
		}
		return messageToReceive;
	}
	public static void createMataData(Node root,Map<Character,String> metaSender,Map<String,Character> metaReceiver,String path){
		if(root.left==null && root.right==null) {
			metaSender.put(root.name.charAt(0), path);
			metaReceiver.put(path, root.name.charAt(0));
			return;
		}
		createMataData(root.left,metaSender,metaReceiver,path+"0");
		createMataData(root.right,metaSender,metaReceiver,path+"1");
	}
	public static Node createTree(PriorityQueue<Node> pq) {
		Node root=null;
		while(pq.size()>1) {
			Node left=pq.poll();
			Node right=pq.poll();
			pq.add(new Node(null,left.value+right.value,left,right));
		}
		root=pq.poll();
		return root;
	}
	public static  PriorityQueue<Node> preProcessMessage(String message){
		PriorityQueue<Node> pq=new PriorityQueue<>(Comparator.comparing(Node::getValue));
		Map<Character,Integer> mp=new HashMap<>();
		
       // inserting values inside map
		for(int i=0;i<message.length();i++) {
			if(mp.containsKey(message.charAt(i))) {
				mp.put(message.charAt(i), mp.get(message.charAt(i))+1);
			}else {
				mp.put(message.charAt(i), 1);
			}
		}
		// inserting values in priorityQueue
		for(char c:mp.keySet()) {
			pq.add(new Node(Character.toString(c),mp.get(c),null,null));
		}
		return pq;
	}

}
