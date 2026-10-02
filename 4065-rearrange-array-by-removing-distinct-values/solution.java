class Solution {
    public int[] rearrangeArray(int[] nums) {
        int n=nums.length;
        
        int[] ans=new int[nums.length];
        int[] count=new int[101];
        for(int i:nums){
            count[i]++;
        }
        int index=0;
        while(index<n){
            for(int v=1;v<=100;v++){
                if(count[v]>0){
                    ans[index++]=v;
                    count[v]--;

                }
                
            }
        }
        return ans;
    }
}