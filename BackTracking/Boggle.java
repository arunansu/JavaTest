import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

/*Given an NxN grid of characters and a dictionary, find all words which can be made from the characters in grid 
 * and present in the given dictionary. A word can start and end at any character in the grid. Next character must 
 * be adjacent to previous character in any of the directions i.e. up, down, left, right and diagonal. Character at 
 * each position in grid can be used only once while making a word.
 */
// Runtime complexity: O(n^n), T(n) = n^2*T(n-1)
// Memory complexity: O(n^2)
public class Boggle {
	char[][] grid;
	Set<String> dictionary;
	boolean[][] state;
	
	Boggle(char[][] g, HashSet<String> d) {
		grid = g;
		dictionary = d;
		state = new boolean[g.length][g.length];
		for(int i = 0; i < g.length; i++) 
			for(int j = 0; j < g.length; j++)
				state[i][j] = false;
	}
	
	public static class IntPair {
		public int first;
		public int second;
		public IntPair(int x, int y) {
			this.first = x;
			this.second = y;
		}
	}
	
	ArrayList<IntPair> findAllNumbers(int x, int y) {
		ArrayList<IntPair> nbrs = new ArrayList<IntPair>();
		int start_x = Math.max(0, x - 1);
		int start_y = Math.max(0, y - 1);
		int end_x = Math.min(grid.length - 1, x + 1);
		int end_y = Math.min(grid.length - 1, y + 1);
		
		for(int i = start_x; i <= end_x; i++) {
			for(int j = start_y; j <= end_y; j++) {
				if(state[i][j]) {
					continue;
				}
				nbrs.add(new IntPair(i,j));
			}
		}
		return nbrs;
	}
	
	void findWordsRec(int i, int j, StringBuilder current, HashSet<String> words) {
		//System.out.println("Current: " + current.toString());
		if(current.length() >= 0 && dictionary.contains(current.toString().toLowerCase())) {
			words.add(current.toString());
			//System.out.println(current);
		}
		ArrayList<IntPair> nbrs = findAllNumbers(i,j);
		for(IntPair pr : nbrs) {
			current.append(grid[pr.first][pr.second]);
			state[pr.first][pr.second] = true;
			findWordsRec(pr.first, pr.second, current, words);
			current.setLength(current.length() - 1);
			state[pr.first][pr.second] = false;
		}
	}
	

	public HashSet<String> findAllWords() {
		HashSet<String> words = new HashSet<String>();
		StringBuilder currentWord = new StringBuilder();
		for(int i = 0; i < grid.length; i++)
			for(int j = 0; j < grid.length; j++)
				findWordsRec(i, j, currentWord, words);
		return words;
	}
	public static void main(String[] args) {
		char[][] g = {{'C','A','T'}, {'R','R','E'}, {'T','O','N'}};
		HashSet<String> d = new HashSet<String>();
		d.add("cat");
		d.add("cater");
		d.add("art");
		d.add("toon");
		d.add("moon");
		d.add("not");
		d.add("eat");
		d.add("ton");
		Boggle b = new Boggle(g, d);
		HashSet<String> words = b.findAllWords();
		//System.out.println(g[2][0]);
		//System.out.println(words.size());
		for(String w : words) {
			System.out.print(w + " ");
		}
	}

}
