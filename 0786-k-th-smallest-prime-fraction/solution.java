class Solution {
    public int[] kthSmallestPrimeFraction(int[] arr, int k) {
        int n = arr.length;

        double low = 0.0;
        double high = 1.0;

        while (low < high) {
            double mid = (low + high) / 2.0;

            int count = 0;
            int bestNum = 0;
            int bestDen = 1;

            int j = 1;

            for (int i = 0; i < n - 1; i++) {
                if (j <= i) j = i + 1;

                while (j < n && arr[i] > mid * arr[j]) {
                    j++;
                }

                if (j == n) break;

                count += n - j;

                // Largest fraction <= mid
                if ((long) arr[i] * bestDen > (long) bestNum * arr[j]) {
                    bestNum = arr[i];
                    bestDen = arr[j];
                }
            }

            if (count == k) {
                return new int[]{bestNum, bestDen};
            }

            if (count < k) {
                low = mid;
            } else {
                high = mid;
            }
        }

        return new int[]{0, 1};
    }
}