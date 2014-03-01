public class Solution {
    public boolean isMatch(String s, String p) {
	    if (s == null || p == null) return false;
	    return matchHelper(s, 0, p, 0);
    }

    private boolean matchHelper(String s, int i, String p, int j) {
	    if (j == p.length()) return i == s.length();
	    //regulate that p.charAt[j] won't be '*'
	    if (p.charAt(j) == '*') return matchHelper(s, i, p, j + 1);
	
	    //p.charAt[j + 1] is '*'
    	if (j == p.length() - 1 || p.charAt(j + 1) != '*')
	    	return (i < s.length()) && (s.charAt(i) == p.charAt(j) || p.charAt(j) == '.') && matchHelper(s, i + 1, p , j + 1);
	    	
	    //p.charAt[j + 1] is not '*' 
			for (int k = i; k <= s.length(); k ++) {
		    if (k > i && p.charAt(j) != '.' && p.charAt(j) != s.charAt(k - 1)) return false;   // if letter and not matched
		    if (matchHelper(s, k, p, j + 2)) return true;
	    }     
      
			return false;
    }
}

