class Solution {
    public int minAddToMakeValid(String s) {
        Stack<Character> s1=new Stack<>();
        int needed=0;
        for(char c:s.toCharArray()){
            if(c=='('){
                s1.push(c);

            }
            else{
                if(!s1.isEmpty()){
                    s1.pop();
                }
                else{
                    needed++;

                }
            }
        }
        return s1.size()+needed;
        
    }
}