package greedy;

import java.util.Comparator;
import java.util.PriorityQueue;

class Item{
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
public class ZeroOneKnapSackGreedy {
	public static void main(String[] args) {
		int []weights=new int[] {2,3,5,7,1,4,1};
		int []profits=new int[] {10,5,15,7,6,18,3};
		int bagSize=15;
		zeroOne(weights,profits,bagSize);
	}
	public static void zeroOne(int []weights,int []profits,int bagSize) {
		PriorityQueue<Item> pq=new PriorityQueue<>(Comparator.comparing(Item::getProfitPerWeight).reversed());
		for(int i=0;i<weights.length;i++) {
			pq.add(new Item(weights[i],profits[i],(double)profits[i]/(double)weights[i]));
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
