class Solution {
    public int longestValidParentheses(String s) {
        Stack<Integer> s1=new Stack<>();
        int[] nums=new int[s.length()];
        char[] str=s.toCharArray();
        for(int i=0;i<s.length();i++){
            if(str[i]=='('){
                s1.push(i);
            }
            else{
                if(!s1.isEmpty()){
                nums[s1.pop()]=1;
                nums[i]=1;
                }
            }
        }
        int maxi=0;
        int c=0;

        for(int i=0;i<nums.length;i++){
            
            if(nums[i]==1){
                c++;
                maxi=Math.max(maxi,c);

            }
            else{
                c=0;
            }

        }
        return maxi;

        
    }
}