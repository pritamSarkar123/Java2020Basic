package greedy;

import java.util.Comparator;
import java.util.PriorityQueue;
/*
 * we can use Item as inner class or outer class
 * but when we have to pass the obj of inner class to some another class
 * then with out making it static inner it is not possible better to use outer 
 */
/*if--------------------------------->
 * class Item{
		private int weight;
		private int profit;
		private double profitPerWeight;
		public Item(int weight,int profit,double profitPerWeight) {
			this.weight=weight;this.profit=profit;this.profitPerWeight=profitPerWeight;
		}
		public int getWeight() {
			return weight;
		}
		public int getProfit() {
			return profit;
		}
		public double getProfitPerWeight() {
			return profitPerWeight;
		}
	}
 *then---------------------------------->
 *PriorityQueue<Item> pq=new PriorityQueue<>(Comparator.comparing(Item::getProfitPerWeight).reversed());
	for(int i=0;i<weights.length;i++) {
	pq.add(new Item(weights[i],profits[i],(double)profits[i]/(double)weights[i]));
	}
 * */
public class ZeroOneKnapSackGreedy {
	private static class Item{
		//why private? because it is closely related and only used in inside the outer class
		private int weight;
		private int profit;
		private double profitPerWeight;
		public Item(int weight,int profit,double profitPerWeight) {
			this.weight=weight;this.profit=profit;this.profitPerWeight=profitPerWeight;
		}
		public int getWeight() {
			return weight;
		}
		public int getProfit() {
			return profit;
		}
		public double getProfitPerWeight() {
			return profitPerWeight;
		}
	}
	public static void main(String[] args) {
		int []weights=new int[] {2,3,5,7,1,4,1};
		int []profits=new int[] {10,5,15,7,6,18,3};
		int bagSize=15;
		zeroOne(weights,profits,bagSize);
	}
	public static void zeroOne(int []weights,int []profits,int bagSize) {
		//OR
		//PriorityQueue<Item> pq=new PriorityQueue<>(Comparator.comparing(Item::getProfitPerWeight).reversed());
		PriorityQueue<ZeroOneKnapSackGreedy.Item> pq=new PriorityQueue<>(Comparator.comparing(ZeroOneKnapSackGreedy.Item::getProfitPerWeight).reversed());
		for(int i=0;i<weights.length;i++) {
			pq.add(new ZeroOneKnapSackGreedy.Item(weights[i],profits[i],(double)profits[i]/(double)weights[i]));
		}
		int maxWeight=0;
		double maxProfit=0;
		while(!pq.isEmpty() && maxWeight<bagSize) {
			int weight=pq.peek().getWeight();
			int profit=pq.peek().getProfit();
			double profitPerWeight=pq.peek().getProfitPerWeight();
			if(maxWeight+weight<=bagSize) {
				maxProfit+=(double)profit;
				maxWeight+=weight;
			}else {
				int remainingWeight=bagSize-maxWeight;
				maxProfit+=remainingWeight*profitPerWeight;
				maxWeight+=remainingWeight;
				//break; //full bag filled
			}
			pq.poll();
		}
		System.out.println("Max profit will be : "+maxProfit);
	}
}
