import java.util.HashMap;
import java.util.LinkedList;

public class LRUCache {
	
	static class LinkedListNode {
		public LinkedListNode(int key, int value) {
			this.key = key;
			this.value = value;
		}
		int key;
		int value;
	}
	
	int capacity;
	HashMap<Integer, LinkedListNode> cache;
	LinkedList<LinkedListNode> cacheVals;
	
	public LRUCache(int capacity){
		this.capacity = capacity;
		cache = new HashMap<Integer, LinkedListNode>(capacity);
		cacheVals = new LinkedList<LinkedListNode>();
	}
	
	int get(int key) {
		LinkedListNode node = cache.get(key);
		if(node == null){
			return -1;
		}
		else {
			cacheVals.remove(node);
			cacheVals.addLast(node);
			return node.value;
		}
	}
	
	void set(int key, int value) {
		LinkedListNode node = cache.get(key);
		
		if (node == null) {
			evictIfNeeded();
			node = new LinkedListNode(key, value);
			cacheVals.addLast(node);
			cache.put(key, node);
		}
		else {
			node.value = value;
			cacheVals.remove(node);
			cacheVals.addLast(node);
		}
	}
	
	void evictIfNeeded(){
		if(cacheVals.size() >= capacity) {
			LinkedListNode node = cacheVals.remove();
			cache.remove(node.key);
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
