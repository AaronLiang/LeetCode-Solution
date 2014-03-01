public class Solution {
    public String strStr(String haystack, String needle) {
        if (haystack == null || needle == null || needle.length() == 0) return haystack;
				// get kmp table
        int[] table = new int[needle.length()];
        int p = -1, q = 0;
        table[0] = -1;
				while (q < needle.length() - 1) {
            while (p != -1 && needle.charAt(p) != needle.charAt(q)) p = table[p];
            p ++; q ++;
            table[q] = (needle.charAt(p) == needle.charAt(q) ? table[p] : p);
        }   
				//match
        p = 0; q = 0;
        while (q + p < haystack.length()) {
            if (needle.charAt(p) == haystack.charAt(q + p)) {
                p ++;
                if (p == needle.length()) return (haystack.substring(q));
            } else {
                q = q + p - table[p];
                p = (table[p] == -1 ? 0 : table[p]);
            }
        }
        return null;
    }
}

