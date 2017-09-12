//Given scoring option 1, 2, 4, how many ways can you score n points
//S(n) = S(n - 1) + S(n - 2) + S(n - 3)
public class NumberOfWaysScore {
	
	public static int scoringOptionRec(int n) {
		if(n <= 0) return 0;
		int[] result = new int[n + 1];
		result[0] = 1;
		return scoringOptionWithArray(n, result);
	}
	
	public static int scoringOptionWithArray(int n, int[] result) {
		if (n < 0) return 0;
		if (result[n] > 0) return result[n];
		result[n] = scoringOptionWithArray(n - 1, result)
				+ scoringOptionWithArray(n - 2, result)
				+ scoringOptionWithArray(n - 4, result);
		return result[n];
	}
	
	public static int scoringOptionDP(int n) {
		if (n <= 0) return 0;
		int[] result = new int[4];
		result[3] = 1;
		for(int i = 0; i <= n; i++) {
			int sum = result[3] + result[2] + result[0];
			result[0] = result[1];
			result[1] = result[2];
			result[2] = result[3];
			result[3] = sum;
		}
		return result[3];
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
