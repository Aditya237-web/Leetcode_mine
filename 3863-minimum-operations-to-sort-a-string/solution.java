class Solution {
    public int minOperations(String s) {
        int n = s.length();

        // 1. Already sorted
        boolean sorted = true;

        for (int i = 1; i < n; i++) {
            if (s.charAt(i) < s.charAt(i - 1)) {
                sorted = false;
                break;
            }
        }

        if (sorted) {
            return 0;
        }

        // 2. For length 2, the only substring containing
        //    both characters is the entire string, which is not allowed.
        if (n == 2) {
            return -1;
        }

        // 3. Find minimum and maximum characters
        char min = s.charAt(0);
        char max = s.charAt(0);

        for (int i = 1; i < n; i++) {
            min = (char) Math.min(min, s.charAt(i));
            max = (char) Math.max(max, s.charAt(i));
        }

        // 4. Minimum is already at the beginning
        //    OR maximum is already at the end
        if (s.charAt(0) == min || s.charAt(n - 1) == max) {
            return 1;
        }

        // 5. Minimum or maximum is somewhere in the middle
        for (int i = 1; i < n - 1; i++) {
            if (s.charAt(i) == min || s.charAt(i) == max) {
                return 2;
            }
        }

        // 6. Both minimum and maximum are inside,
        //    so 3 operations are required.
        return 3;
    }
}