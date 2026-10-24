class Solution {
    public boolean canJump(int[] nums) {
        int n=nums.length;
        // boolean is_zero=false;
        // for(int i=0;i<n;i++){
        //     if(nums[i]==0){
        //         is_zero=true;


        //     }
        //     if(!is_zero){
        //         return true;
        //     }
        // }
        
        int maxIndex=0;
        for(int i=0;i<n;i++){
            
           
            if(i>maxIndex){
                return false;

            }
            maxIndex=Math.max(nums[i]+i,maxIndex);
            if(maxIndex>n-1){
                return true;
            }
             
        }

        return true;
        
    }
}