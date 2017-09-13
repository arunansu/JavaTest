import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class IteratorManipulation {
	
	public static List<Integer> getEvenNumbers(List<Integer> numbers) {
		for(Iterator<Integer> iterator = numbers.iterator(); iterator.hasNext();) {
			int n = iterator.next();
			if(n % 2 != 0) {
				iterator.remove();
			}
		}
		return numbers;
	}

	public static void main(String[] args) {
		List<Integer> numbers = new ArrayList<Integer>();
		numbers.add(1);
		numbers.add(2);
		numbers.add(3);
		numbers.add(4);
		numbers.add(5);
		
		List<Integer> evenNumbers = getEvenNumbers(numbers);
		for(Integer i: evenNumbers) {
			System.out.print(i.toString() + " ");
		}
	}

}
