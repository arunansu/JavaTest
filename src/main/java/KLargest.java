import java.util.Comparator;
import java.util.PriorityQueue;

public class KLargest {
	
	public static int findKthLargest(int[] nums, int k)
	{
		Comparator<Integer> comparator = new IntegerComparator();
		PriorityQueue<Integer> q = new PriorityQueue<Integer>(k, comparator);
		for(int i: nums) {
			q.offer(i);
			
			if(q.size() > k) {
				q.poll();
			}
		}
		return q.peek();
	}

	public static void main(String[] args) {
		int[] a = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
		System.out.println(findKthLargest(a, 3));
	}
}
