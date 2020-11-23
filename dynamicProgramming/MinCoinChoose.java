package dynamicProgramming;

import java.util.Arrays;

public class MinCoinChoose {
	static int stepCounter=0;
	public static void main(String[] args) {
		//in dynamic programming we have all future possibilities in our hand
		// then in each step we have to decide which path we have to choose now
		// unlike greedy approach there is no predefined path follow rules
		
		// TODO Auto-generated method stub
		//Problem:-https://www.youtube.com/watch?v=-NTaXJ7BBXs
		//need to make 
		int cost=35;
		//types of coins available
		int[] coins= {1,5,7,9,8};
		System.out.println(minCoinChoose(cost, coins)+" steps = "+stepCounter);
		
		stepCounter=0;
		int[] memTable=new int[cost+1];
		Arrays.fill(memTable, -1);
		memTable[0]=0;// when no cost left no of coins to be picked 0
		System.out.println(minCoinChooseMemoization(cost, coins, memTable)+" steps = "+stepCounter);
	}
	public static int minCoinChoose(int cost,int[] coins) {//O(m^n)
		//m<-no of iterations in each call == coins.length
		//and n<- max depth(when each time picking "1"==cost)
		//O(m^n) <- atmost
		stepCounter++;
		if(cost==0) return 0; //no coin to lift
		int currentlyCoinPicked=Integer.MAX_VALUE;
		for(int i=0;i<coins.length;i++) {
			if(cost-coins[i]>=0) {
				int previouslyPicked=minCoinChoose(cost-coins[i], coins);
				//this step no of coins increased by one and then return the minimum one
				if(previouslyPicked+1<currentlyCoinPicked && previouslyPicked+1<Integer.MAX_VALUE) {
					currentlyCoinPicked=previouslyPicked+1;
				}
			}
		}
		return currentlyCoinPicked;
	}
	public static int minCoinChooseMemoization(int cost,int[] coins,int[] memTable) {//O(m.n)
		//n<- max no of calls occurs == cost  
		//m<- no of iterations in each call == coins.length
		//time O(n.m)
		stepCounter++;
		int currentlyCoinPicked=Integer.MAX_VALUE;
		int previouslyPicked;
		for(int i=0;i<coins.length;i++) {
			if(cost-coins[i]>=0) {
				if(memTable[cost-coins[i]]!=-1) {
					previouslyPicked=memTable[cost-coins[i]];
				}else {
					previouslyPicked=minCoinChooseMemoization(cost-coins[i], coins, memTable);
					memTable[cost-coins[i]]=previouslyPicked;
				}
				if(previouslyPicked+1<currentlyCoinPicked && previouslyPicked+1<Integer.MAX_VALUE) {
					currentlyCoinPicked=previouslyPicked+1;
				}
			}
		}
		return memTable[cost]=currentlyCoinPicked;
	}

}
