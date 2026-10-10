
class Solution {
    public long minSumSquareDiff(int[] nums1, int[] nums2, int k1, int k2) {
        int n = nums1.length;
        long k = (long) k1 + k2;

        int[] diff = new int[n];
        int maxDiff = 0;

        for (int i = 0; i < n; i++) {
            diff[i] = Math.abs(nums1[i] - nums2[i]);
            maxDiff = Math.max(maxDiff, diff[i]);
        }

        long sum = 0;
        for (int d : diff) {
            sum += d;
        }

        if (sum <= k) return 0;

        int left = 0, right = maxDiff;

        
        while (left < right) {
            int mid = left + (right - left) / 2;
            long needed = 0;

            for (int d : diff) {
                if (d > mid) {
                    needed += d - mid;
                }
            }

            if (needed <= k) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        int limit = left;
        long remaining = k;
        long ans = 0;

        
        for (int d : diff) {
            if (d > limit) {
                remaining -= d - limit;
                d = limit;
            }
            ans += (long) d * d;
        }

        for (int i = 0; i < n && remaining > 0; i++) {
            
        }

        return calculate(nums1, nums2, k, limit);
    }

    private long calculate(int[] nums1, int[] nums2, long k, int limit) {
        int n = nums1.length;
        long remaining = k;
        long ans = 0;
        int[] diff = new int[n];

        for (int i = 0; i < n; i++) {
            diff[i] = Math.abs(nums1[i] - nums2[i]);
            if (diff[i] > limit) {
                remaining -= diff[i] - limit;
                diff[i] = limit;
            }
        }

        for (int i = 0; i < n; i++) {
            if (remaining > 0 && diff[i] == limit && limit > 0) {
                diff[i]--;
                remaining--;
            }
            ans += (long) diff[i] * diff[i];
        }

        return ans;
    }
}
