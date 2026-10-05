class Solution {
    public int scoreOfParentheses(String s) {
        Stack<Integer> s1=new Stack<>();
        int score=0;
        
        for(char c:s.toCharArray()){
            if(c=='('){
                s1.push(score);
                score=0;
            }
            else{
                if(!s1.isEmpty()){
                    int prev=s1.pop();
                    score=prev+Math.max(2*score,1);
                }
            }
        }
        return score;
        
    }
}