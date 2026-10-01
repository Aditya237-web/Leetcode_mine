class Solution {
    public int reverseDegree(String s) {
        int ans = 0;

        for (int i = 0; i < s.length(); i++) {
            int normal = s.charAt(i) - 'a' + 1;
            int reverse = 26 - normal + 1;

            ans += reverse * (i + 1);
        }

        return ans;
    }
}