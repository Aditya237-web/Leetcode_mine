class Solution {
    public int[] findSubtreeSizes(int[] parent, String s) {
        int n = parent.length;

        // Build original tree
        List<Integer>[] tree = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            tree[i] = new ArrayList<>();
        }

        for (int i = 1; i < n; i++) {
            tree[parent[i]].add(i);
        }

        // Store modified parents
        int[] newParent = new int[n];
        int[] last = new int[26];
        int[] prev = new int[n];

        Arrays.fill(last, -1);

        // Iterative DFS on original tree
        int[] stack = new int[2 * n];
        int top = 0;

        stack[top++] = 0;

        while (top > 0) {
            int event = stack[--top];

            if (event < 0) {
                // Exit event: restore previous character ancestor
                int node = ~event;
                last[s.charAt(node) - 'a'] = prev[node];
                continue;
            }

            int node = event;
            int c = s.charAt(node) - 'a';

            // Remember previous node with same character
            prev[node] = last[c];

            // Update parent
            newParent[node] =
                (last[c] != -1) ? last[c] : parent[node];

            // Current node becomes nearest ancestor
            last[c] = node;

            // Push exit event
            stack[top++] = ~node;

            // Visit children
            for (int child : tree[node]) {
                stack[top++] = child;
            }
        }

        // Build modified tree
        List<Integer>[] modified = new ArrayList[n];

        for (int i = 0; i < n; i++) {
            modified[i] = new ArrayList<>();
        }

        for (int i = 1; i < n; i++) {
            modified[newParent[i]].add(i);
        }

        // Get traversal order
        int[] order = new int[n];
        top = 0;

        stack[top++] = 0;
        int idx = 0;

        while (top > 0) {
            int node = stack[--top];
            order[idx++] = node;

            for (int child : modified[node]) {
                stack[top++] = child;
            }
        }

        // Calculate subtree sizes bottom-up
        int[] ans = new int[n];
        Arrays.fill(ans, 1);

        for (int i = n - 1; i > 0; i--) {
            int node = order[i];
            ans[newParent[node]] += ans[node];
        }

        return ans;
    }
}
