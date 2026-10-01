class Solution {
    public int[] maxDepthAfterSplit(String seq) {

        int depth=0;
        int[] ans=new int[seq.length()];
        int i=0;
        for(char c:seq.toCharArray()){
            if(c=='('){
                depth++;
                ans[i++]=depth%2;

            }
            else{
                ans[i++]=depth%2;
                depth--;
            }

        }
        return ans;
        


        
        
    }
}