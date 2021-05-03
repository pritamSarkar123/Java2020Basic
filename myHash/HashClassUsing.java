package myHash;
import java.util.*;
class Node<K,V>{
	private K key;
	private V value;
	private Node<K,V> next;
	public Node() {
		key=null;
		value=null;
		next=null;
	}
	public Node(K key,V value) {
		this.key=key;this.value=value;this.next=null;
	}
	public K getKey() {
		return key;
	}
	public void setKey(K key) {
		this.key = key;
	}
	public V getValue() {
		return value;
	}
	public void setValue(V value) {
		this.value = value;
	}
	public Node<K, V> getNext() {
		return next;
	}
	public void setNext(Node<K, V> next) {
		this.next = next;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((key == null) ? 0 : key.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Node<K,V> other = (Node<K,V>) obj;
		if (key == null) {
			if (other.key != null)
				return false;
		} else if (!key.equals(other.key))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Node [key=" + key + ", value=" + value + "]";
	}	
}		

class MyHash<K,V>{
	public Object other;
	private Object[] hashTable;
	private int initialSize;
	private double loadingFactor;
	private int noOfNodes;
	public MyHash() {
		initialSize=16;
		loadingFactor=0.75;
		createTable(initialSize);
	}
	public MyHash(int initialSize) {
		this.initialSize=initialSize;
		loadingFactor=0.75;
		createTable(initialSize);
	}
	public MyHash(double loadingFactor) {
		this.loadingFactor=loadingFactor;
		initialSize=16;
		createTable(initialSize);
	}
	public MyHash(int initialSize,double loadingFactor) {
		this.loadingFactor=loadingFactor;
		this.initialSize=initialSize;
		createTable(initialSize);
	}
	public MyHash(MyHash<K,V> otherHash) {
		createTable(otherHash.initialSize);
		loadingFactor=otherHash.loadingFactor;
		noOfNodes=otherHash.noOfNodes;
		//TODO remaining insertion of other elements a deep copy
	}
	private void createTable(int initialSize) {
		hashTable=new Object[initialSize];
		Arrays.fill(hashTable, null);
		noOfNodes=0;
	}
	private int getSlot(Node<K,V> node) {
		return node.hashCode() % initialSize;
	}
	public int getTableLength() {
		return hashTable.length;
	}
	public int size() {
		return noOfNodes;
	}
	public void showHash() {
		for(int i=0;i<hashTable.length;i++) {
			if(hashTable[i]!=null) {
				System.out.print("Slot ["+i+"]->");
				@SuppressWarnings("unchecked")
				Node<K,V> temp=(Node<K,V>)hashTable[i];
				while(temp!=null) {
					System.out.print(" ("+temp.getKey()+" "+temp.getValue()+")");
					temp=temp.getNext();
				}System.out.println();
			}
		}
	}
	@SuppressWarnings("unchecked")
	public void put(K key,V value) {
		Node<K, V> node=new Node<>(key,value);
		int slot=getSlot(node);
		Node<K,V> temp=(Node<K,V>)hashTable[slot];
		if(temp==null) { hashTable[slot]=node;}
		else {
			while(temp.getNext()!=null) {
				if(temp.equals(node)) {
					temp.setValue(value);
					return;
				}
				temp=temp.getNext();
			}
			temp.setNext(node);
		}
		noOfNodes++;
		checkSizeForRehashing();
	}
	private void checkSizeForRehashing() {
		if((int)Math.ceil((noOfNodes*100)/(loadingFactor*100))>(initialSize)) {
			rehash(initialSize,initialSize*2);
		}
	}
	public V get(K key) {
		V value=null;
		Node<K,V> node=new Node<>(key,value);
		int slot=getSlot(node);
		@SuppressWarnings("unchecked")
		Node<K,V> temp=(Node<K,V>)hashTable[slot];
		while(temp!=null) {
			if(temp.equals(node)) return temp.getValue();
			temp=temp.getNext();
		}
		return null;
	}
	public boolean containsKey(K key) {
		V value=null;
		Node<K,V> node=new Node<>(key,value);
		int slot=getSlot(node);
		@SuppressWarnings("unchecked")
		Node<K,V> temp=(Node<K,V>)hashTable[slot];
		while(temp!=null) {
			if(temp.equals(node)) return true;
			temp=temp.getNext();
		}
		return false;
	}
	private Node<K,V> deleteRecurssive(Node<K,V> node,K key){
		if(node==null) return null;
		if(node.getKey().equals(key)) {
			return node.getNext();
		}
		else {
			node.setNext(deleteRecurssive(node.getNext(),key));
			return node;
		}
	}
	public void delete(K key) {
		V value=null;
		Node<K,V> node=new Node<>(key,value);
		int slot=getSlot(node);
		boolean wasKey=containsKey(key);
		@SuppressWarnings("unchecked")
		Node<K,V> temp=(Node<K,V>)hashTable[slot];
		hashTable[slot]=deleteRecurssive(temp,key);
		if(wasKey) {
			noOfNodes--;
		}
	}
	private void rehash(int oldLength,int newSize) {
		this.initialSize=newSize;
		Object []oldhashTable=hashTable;
		hashTable=new Object[initialSize];
		for(int i=0;i<oldLength;i++) {
			@SuppressWarnings("unchecked")
			Node<K,V> temp=(Node<K,V>)oldhashTable[i];
			while(temp!=null) {
				put(temp.getKey(),temp.getValue());
				temp=temp.getNext();
			}
		}
	}
	public Set<Node<K,V>> entrySet() {
		Set<Node<K,V>> es=new HashSet<>();
		for(int i=0;i<hashTable.length;i++) {
			if(hashTable[i]!=null) {
				@SuppressWarnings("unchecked")
				Node<K,V> temp=(Node<K,V>)hashTable[i];
				while(temp!=null) {
					es.add(temp);
					temp=temp.getNext();
				}
			}
		}
		return es;
	}
	public Set<K> keySet(){
		Set<K> keys=new HashSet<>();
		for(int i=0;i<hashTable.length;i++) {
			if(hashTable[i]!=null) {
				@SuppressWarnings("unchecked")
				Node<K,V> temp=(Node<K,V>)hashTable[i];
				while(temp!=null) {
					keys.add(temp.getKey());
					temp=temp.getNext();
				}
			}
		}
		return keys;
	}
	public List<V> values(){
		List<V> values =new LinkedList<>();
		for(int i=0;i<hashTable.length;i++) {
			if(hashTable[i]!=null) {
				@SuppressWarnings("unchecked")
				Node<K,V> temp=(Node<K,V>)hashTable[i];
				while(temp!=null) {
					values.add(temp.getValue());
					temp=temp.getNext();
				}
			}
		}
		return values;
	}
}


public class HashClassUsing {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MyHash<Integer,Integer> mh=new MyHash<>(5);
		int n=0;
		for(int i=0;i<30;i++) {
			mh.put(i, (2*i+1)%5);
			n++;
		}
		
		mh.showHash();
		System.out.println(mh.entrySet());
		System.out.println(mh.keySet());
		System.out.println(mh.values());
		mh.delete(15);
		System.out.println(mh.entrySet());
		System.out.println(mh.keySet());
		System.out.println(mh.values());

	}
}
