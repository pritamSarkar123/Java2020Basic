package dynamicProgramming;

public class _0_1_knapsack {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//      Problem:- https://www.youtube.com/watch?v=y6kpGJBI7t0&list=PLUcsbZa0qzu06aTDvZ6vz3zpn80jGzfCR&index=5
		int []weights= {0,1,3,4,6};
		int []profits= {0,20,30,10,50};
		int maxBagCapacity=10;
		knapSackDynam(weights, profits, maxBagCapacity);
	}
	public static void knapSackDynam(int []weights,int []profits,int maxBagCapacity) {
		//uninitialized local variable with default value
		int [][]profitTable=new int[weights.length][maxBagCapacity+1];
//		if row no 0 <- all zero , when we have 0 weights to add
//		if col no 0 <- all zero , when we have 0 weights to add
		
		for(int weight=1;weight<weights.length;weight++) {
			for(int bagCap=1;bagCap<=maxBagCapacity;bagCap++) {
//				profitTable[weight-1][bagCap] <-we do not add the element , so profit remains unchanged
//		        profits[weight]+profitTable[weight-1][bagCap - weights[weight]]<- we added the element, and remaining weight will be filled weight
//				maxProfit
				if(bagCap - weights[weight]>=0) {
					profitTable[weight][bagCap]=Math.max(profitTable[weight-1][bagCap], profits[weight]+profitTable[weight-1][bagCap - weights[weight]]);
				}else {
					profitTable[weight][bagCap]=profitTable[weight-1][bagCap];
				}
			}
		}
		for(int i=0;i<weights.length;i++) {
			for(int j=0;j<=maxBagCapacity;j++) {
				System.out.print(profitTable[i][j]+" ");
			}System.out.println();
		}
		int i=profitTable.length-1;
		int j=profitTable[0].length-1;
		System.out.println("Maximum profit will be "+profitTable[i][j]);
		while(i>0 && j>0) {
			if(profitTable[i][j]!=profitTable[i-1][j]) {
				System.out.println("Weight "+weights[i]+" added");
				j=j-weights[i];
			}
			i--;
		}
	}
}
