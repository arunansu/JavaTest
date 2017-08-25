
public class LargestSumSubArray {
	
	public static int maxSumSubArray(int[] arr) {
		if(arr == null || arr.length == 0) return 0;
		if(arr.length == 1) return arr[0];
		
		int currMax = arr[0];
		int globalMax = arr[0];
		
		for(int i = 1; i < arr.length; i++) {
			if(currMax < 0) {
				currMax = arr[i];
			}
			else {
				currMax += arr[i];
			}
			
			if(currMax > globalMax) {
				globalMax = currMax;
			}
		}
		
		return globalMax;
		
	}

	public static void main(String[] args) {
		int[] numbers = new int[] {-4,2,-5,1,2,3,6,-5,1};
		System.out.println("Max sum of subarray is: " + maxSumSubArray(numbers));
	}

}
