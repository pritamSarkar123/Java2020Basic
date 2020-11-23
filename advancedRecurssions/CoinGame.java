package advancedRecurssions;

public class CoinGame {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//https://www.youtube.com/watch?v=JMxl5rk7kGo
//		int[] coins= {1,5,7,3,2,4};
		int[] coins= {1,5,700,3};
		int score=coinGame(coins, 0, coins.length-1);
		System.out.println(score);
	}
	public static int coinGame(int[] coins,int l,int r) {
		//our goal is to maximize our score
		//opposite players goal is to minimize our score by choosing the correct one
		if(l+1==r) {
			return Math.max(coins[l], coins[r]);
		}
		                         //after player 2 have chosen the coin, the minimum score we get
		return Math.max(coins[l]+Math.min(coinGame(coins, l+2, r), coinGame(coins, l+1, r-1)),
				        //after player 2 have chosen the coin, the minimum score we get
				coins[r]+Math.min(coinGame(coins, l+1, r-1), coinGame(coins, l, r-2)));
	}

}
