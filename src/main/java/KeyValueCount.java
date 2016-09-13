import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;

public class KeyValueCount {
	
	public static void CountKey(String[] pairs) {
		HashMap<String, Integer> countMap = new HashMap<String, Integer>();
		for(String pair: pairs) {
			String[] pairArray = pair.split(",");
			if(countMap.containsKey(pairArray[0])){
				countMap.put(pairArray[0], countMap.get(pairArray[0]) + Integer.parseInt(pairArray[1]));
			}
			else {
				countMap.put(pairArray[0], Integer.parseInt(pairArray[1]));
			}
		}
		Iterator<Entry<String, Integer>> it = countMap.entrySet().iterator();
		while(it.hasNext()) {
			Entry<String, Integer> pairItem = (Entry<String, Integer>) it.next();
			System.out.println(pairItem.getKey() + "," + pairItem.getValue());
			it.remove();
		}
	}

	public static void main(String[] args) {
		String[] pairs = {"Aaron,2", "Christina,3", "Aaron,3", "Christina,4"};
		CountKey(pairs);
	}

}
