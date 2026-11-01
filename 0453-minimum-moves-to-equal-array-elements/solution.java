class Solution {
    public int minMoves(int[] nums) {
        int mini=nums[0];
        int n=nums.length;
        for(int i=1;i<n;i++){
            if(nums[i]<mini){
                mini=nums[i];
            }
        }
        int moves=0;
        for(int i=0;i<n;i++){
            moves+=nums[i]-mini;
        }
        return moves;
    }
}