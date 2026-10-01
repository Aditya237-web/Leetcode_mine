class Solution {
    public int minSumOfLengths(int[] arr, int target) {
        int n = arr.length;
        int INF = n + 1;

        // best[i] = minimum length of a valid subarray
        // completely inside arr[0...i-1]
        int[] best = new int[n + 1];
        java.util.Arrays.fill(best, INF);

        java.util.HashMap<Integer, Integer> map = new java.util.HashMap<>();

        int prefix = 0;
        int ans = INF;

        map.put(0, 0);

        for (int i = 1; i <= n; i++) {
            prefix += arr[i - 1];

            // Carry forward the best answer seen so far
            best[i] = best[i - 1];

            // Need prefix[j] = prefix - target
            if (map.containsKey(prefix - target)) {
                int j = map.get(prefix - target);
                int len = i - j;

                // Previous subarray must end before j
                if (best[j] != INF) {
                    ans = Math.min(ans, len + best[j]);
                }

                // This subarray can become the best one ending at/before i
                best[i] = Math.min(best[i], len);
            }

            // Store latest prefix index
            map.put(prefix, i);
        }

        return ans == INF ? -1 : ans;
    }
}