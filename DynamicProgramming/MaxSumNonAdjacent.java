
public class MaxSumNonAdjacent {
	
	public static int maxSumNonAdjacent(int[] a) {
		if(a == null || a.length == 0) return 0;
		if(a.length == 1) return a[0];
		
		int[] result = new int[a.length];
		result[0] = a[0];
		
		for(int i = 1; i < a.length; i++) {
			result[i] = Math.max(a[i], result[i - 1]);
			
			if(i - 2 >= 0) {
				result[i] = Math.max(result[i], a[i] + result[i - 2]);
			}
			System.out.println("result[" + i + "] is: " + result[i] );
		}
		return result[a.length - 1];
	}

	public static void main(String[] args) {
		int[] numbers = new int[] {-4,2,-5,1,2,3,6,-5,1};
		System.out.println("Max sum of non adjacent subarray is: " + maxSumNonAdjacent(numbers));
	}

}
