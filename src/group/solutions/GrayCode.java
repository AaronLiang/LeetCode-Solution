public class Solution {
    public ArrayList<Integer> grayCode(int n) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        if (n >= 0 && n <= 32) {
            boolean visited[] = new boolean[1 << n];
            search(0, visited, result, n);
        }
        return result;
    }
    
    private boolean search(int current, boolean visited[], ArrayList<Integer> result, int n) {
        result.add(current);
        visited[current] = true;
        if (result.size() == 1 << n) return true;
        for (int i = 0; i < n; i ++) {
            int next = current ^ (1 << i);
            if (!visited[next]) {
                if (!search(next, visited, result, n)) {
                    visited[next] = false;
                    result.remove(result.size() - 1);
                } else return true;
            }
        }
        return false;
    }
}

