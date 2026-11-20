
import java.util.Arrays;

class Solution {
    public int[] getStrongest(int[] arr, int k) {

        Arrays.sort(arr);

        int n = arr.length;
        int median = arr[(n - 1) / 2];

        int left = 0;
        int right = n - 1;

        int[] result = new int[k];

        for (int i = 0; i < k; i++) {

            if (Math.abs(arr[left] - median) >
                Math.abs(arr[right] - median)) {

                result[i] = arr[left];
                left++;

            } else {
                result[i] = arr[right];
                right--;
            }
        }

        return result;
    }
}
