import java.util.HashMap;
import java.util.Map;

public class ArrayTest {
	
	public static int countDuplicates(int[] numbers) {
		int dupes = 0;
		Map<Integer, Integer> numCounts = new HashMap<Integer, Integer>();
		for(int i : numbers) {
			if(numCounts.containsKey(i)){
				numCounts.put(i, numCounts.get(i) + 1);
			}
			else {
				numCounts.put(i, 1);
			}
		}
		for(int i: numCounts.keySet()) {
			if(numCounts.get(i) > 1) {
				dupes++;
			}
		}
		return dupes;
	}

	public static void main(String[] args) {
		int[] numbers = new int[] {1,1,2,3,4,5,6,7,8,3,9,0};
		
		System.out.println(countDuplicates(numbers));
	}

}
