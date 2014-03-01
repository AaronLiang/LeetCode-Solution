public class Solution {
  public int candy(int[] ratings) {
    if (ratings == null || ratings.length == 0) return 0;
    int head = 0;
    int len;
    int result = 0;
    int first = 0;
    int last = 1;
    
    while (head < ratings.length) {
      len = 1;
      while (head + len < ratings.length && ratings[head + len] < ratings[head + len - 1]) ++ len;
      first = (head > 0 && ratings[head] > ratings[head - 1]) ? Math.max(last + 1, len) : len;
      result += first + (len - 1) * len /2; 
      last = (len > 1 ? 1 : first);
      head += len;
    }
    return result;
  }
}

