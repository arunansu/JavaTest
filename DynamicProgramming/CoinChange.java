
public class CoinChange {
	//Compute O(amount * denominations), Memory O(amount)
	public static int coinChange(int amount, int[] denominations) {
		int[] solutions = new int[amount + 1];
		solutions[0] = 1;
		
		for(int den: denominations) {
			for(int i = den; i <= amount; i++) {
				solutions[i] += solutions[i - den];
			}
		}
		return solutions[solutions.length - 1];
	}

	public static void main(String[] args) {
		
	}

}
