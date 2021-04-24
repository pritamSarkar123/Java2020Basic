package hashingOne;

class MyPair{
	int key;
	int value;
	int valid;
	public MyPair(int key,int value,int valid) {
		this.key=key;
		this.value=value;
		this.valid=valid;
	}
	public MyPair() {
		key=0;value=0;valid=0;
	}
}
public class MyHashTable {
	int size;
	MyPair []table;
	int filled;
	public MyHashTable() {
		size=11;
		table=new MyPair[size];
		filled=0;
	}
	public MyHashTable(int size) {
		this.size=size;
		table=new MyPair[this.size];
		filled=0;
	}
	public MyHashTable(MyHashTable mht) {
		this.size=mht.size;
		table=new MyPair[size];
		filled=0;
	}
	private void rehash() {
		this.size*=2;
		MyPair []tempTab=new MyPair[this.size];
		for(int i=0;i<this.table.length;i++) {
			if(this.table[i]!=null && this.table[i].valid==1) {
				int index=hashKeyForInsert(tempTab,this.table[i].key);
				tempTab[index]=new MyPair(this.table[i].key,this.table[i].value,1);
			}
		}
		this.table=tempTab;
		
	}
	private int hashKeyForInsert(MyPair table[],int key) {
		int a=key%table.length;
		int b=0;
		while(table[(a+b) % table.length]!=null && table[(a+b) % table.length].valid!=0) {
			if(table[(a+b) % table.length].valid==1 && table[(a+b) % table.length].key==key) {
				System.out.print("Updating----> ");
				break; //means already present //need to be updated
			}
			b++;
		}
		return (a+b) % table.length;
	}
	private int hashKeyForSearch(int key) {
		int a=key%this.table.length;
		int b=0;
		boolean found=false;
		while(this.table[(a+b) % this.table.length]!=null && this.table[(a+b) % this.table.length].valid!=0) {
			if(this.table[(a+b) % this.table.length].valid==1 && this.table[(a+b) % this.table.length].key==key){
				found=true;break;
			}
			b++;
		}
		if(found) {
			return (a+b) % this.table.length;
		}else {
			return -1;
		}
	}
	public void delete(int key) {
		int index=this.hashKeyForSearch(key);
		if(index!=-1) {
			this.table[index].valid=0;
			System.out.println(key+" deleted");
			this.filled--;
		}else {
			System.out.println("Absent");
		}
	}
	public void search(int key) {
		int index=this.hashKeyForSearch(key);
		if(index!=-1) {
			System.out.println(key+" "+this.table[index].value);
		}else {
			System.out.println("Absent");
		}
	}
	public boolean insert(int key,int value) {
		if(this.filled/(double)this.size >=0.5) {
			System.out.println(this.filled/(double)this.size +" rehashing obvious");
			this.rehash();
		}
		int index=this.hashKeyForInsert(this.table,key);
		this.table[index]=new MyPair(key,value,1);
		this.filled++;
		return true;
	}
	public void showTable() {
		for(int i=0;i<this.table.length;i++) {
			if(this.table[i]!=null && this.table[i].valid==1) {
				System.out.println("[ "+i+" ] key = "+this.table[i].key+" value= "+this.table[i].value);
			}
		}
	}
}
