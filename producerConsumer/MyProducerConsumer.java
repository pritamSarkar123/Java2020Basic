package producerConsumer;

class Company{
	int buffer;
	boolean full;
	synchronized public void produce_element(int n) throws Exception {
		if(full) { //synchronization
			wait();
		}
		buffer=n;
		System.out.println("Prodused element is : "+buffer);
		full=true;
		notify(); //inter thread communication
	}
	synchronized public int consume_element() throws Exception {
		if(!full) { //synchronization
			wait();
		}
		System.out.println("Consumed Element is : "+buffer);
		full=false;
		notify(); //inter thread communication
		return buffer;
	}	
}

class Producer extends Thread{
	Company c;
	Producer(Company c){
		this.c=c;
	}
	@Override
	public void run() {
		int i=0;
		while(true) {
			i++;
			try {
				this.c.produce_element(i);
			}catch(Exception e){}
			try {
				Thread.sleep(1000);
			}catch(Exception e) {}
		}
	}
}
class Consumer extends Thread{
	Company c;
	Consumer(Company c){
		this.c=c;
	}
	@Override
	public void run() {
		while(true) {
			try {
				this.c.consume_element();
			}catch(Exception e){}
			try {
				Thread.sleep(2000);
			}catch(Exception e) {}
		}
	}
}

public class MyProducerConsumer {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Company comp=new Company();
		Producer prod=new Producer(comp);
		Consumer cons=new Consumer(comp);
		prod.start();
		cons.start();

	}

}
