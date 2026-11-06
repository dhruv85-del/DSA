
import java.util.*;

class Solution {
    public int[] countServers(int n, int[][] logs, int x, int[] queries) {

        // Step 1: Sort logs based on time
        Arrays.sort(logs, (a, b) -> a[1] - b[1]);

        // Step 2: Store queries with their original indices
        int m = queries.length;
        int[][] q = new int[m][2];

        for (int i = 0; i < m; i++) {
            q[i][0] = queries[i];
            q[i][1] = i;
        }

        // Step 3: Sort queries based on time
        Arrays.sort(q, (a, b) -> a[0] - b[0]);

        // Step 4: HashMap to store server frequencies
        HashMap<Integer, Integer> map = new HashMap<>();

        int[] ans = new int[m];

        int left = 0;
        int right = 0;

        // Step 5: Sliding window
        for (int i = 0; i < m; i++) {

            int start = q[i][0] - x;
            int end = q[i][0];

            // Add logs within the current window
            while (right < logs.length && logs[right][1] <= end) {

                int server = logs[right][0];

                map.put(server, map.getOrDefault(server, 0) + 1);

                right++;
            }

            // Remove logs outside the current window
            while (left < right && logs[left][1] < start) {

                int server = logs[left][0];

                map.put(server, map.get(server) - 1);

                if (map.get(server) == 0) {
                    map.remove(server);
                }

                left++;
            }

            // Servers with zero requests
            ans[q[i][1]] = n - map.size();
        }

        return ans;
    }
}
