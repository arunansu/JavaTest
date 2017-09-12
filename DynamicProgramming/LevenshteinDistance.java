//Levenshtein distance Lev_a_b between string a, b of size i, j is
//Lev_a_b(i,j) = max(i,j) if min(i,j) == 0
//else min(Lev_a_b(i - 1),j) + 1, Lev_a_b(i, j - 1) + 1, Lev_a_b(i - 1, j - 1) + cost)
//where cost = 0 if a == b else 1
public class LevenshteinDistance {
	public static int minimum(int a, int b, int c) {
		return Math.min(Math.min(a, b), c);
	}
    //Compute O(n^2), Memory O(n^2)
	public static int editistance2DArray(String s1, String s2) {
		if(s1 == s2) return 0;
		if(s1.length() == 0) return s2.length();
		if(s2.length() == 0) return s1.length();
		
		int[][] d = new int[s1.length() + 1][s2.length() + 1];
		
		for(int i = 0; i <= s1.length(); i++) {
			d[i][0] = i;
		}
		
		for(int j = 0; j <= s2.length(); j++) {
			d[0][j] = j;
		}
		
		int cost;
		for(int i = 1; i <= s1.length(); i++) {
			for(int j = 1; j <= s2.length(); j++) {
				if(s1.charAt(i - 1) == s2.charAt(j - 1)) {
					cost = 0;
				}
				else {
					cost = 1;
				}
				d[i][j] = minimum(d[i-1][j] + 1, d[i][j - 1] + 1, d[i - 1][j - 1] + cost);
			}
		}
		return d[s1.length()][s2.length()];
	}
	
	public static int editDistance2Array(String s1, String s2) {
		if(s1 == s2) return 0;
		if(s1.length() == 0) return s2.length();
		if(s2.length() == 0) return s1.length();
		
		int[] d1 = new int[s1.length() + 1];
		int[] d2 = new int[s2.length() + 1];
		
		for(int i = 0; i < d1.length; i++) d1[i] = i;
		
		int cost;
		
		for(int i = 0; i < s1.length(); i++) {
			d2[0] = i + 1;
			for(int j = 0; j < s2.length(); j++) {
				if(s1.charAt(i) == s2.charAt(j))
					cost = 0;
				else
					cost = 1;
				d2[j + 1] = minimum(d2[j] + 1, d1[j + 1] + 1, d1[j] + cost);
				
			}
			for(int j = 0; j < d2.length; j++) {
				d1[j] = d2[j];
			}
		}
		return d2[s2.length()];
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
