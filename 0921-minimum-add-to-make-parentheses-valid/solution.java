class Solution {
    public int minAddToMakeValid(String s) {
        Stack<Character> s1=new Stack<>();
        int need=0;
        for(char c:s.toCharArray()){
            if(c=='('){
                s1.add(c);
            }
            else{
                if(!s1.isEmpty()){
                    s1.pop();
                }
                else{
                    need++;
                }
            }
        }
        return s1.size()+need;
        
    }
}