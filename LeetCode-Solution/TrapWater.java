public class Solution {
  public int trap(int[] A) {
	  Stack<Integer> stack = new Stack<Integer>();
	  int result = 0;
	  for (int i = 0; i < A.length; i ++) {
		  while (!stack.empty() && A[stack.peek()] < A[i]) {
		    int top = stack.pop();
	      if (!stack.empty()) 
           result += (Math.min(A[i], A[stack.peek()]) - A[top])*(i - stack.peek() - 1);
		  }
      stack.push(i);
    }	       
    return result;
  }  
}
