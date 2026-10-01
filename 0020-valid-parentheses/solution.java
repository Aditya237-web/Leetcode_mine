class Solution {
    public boolean isValid(String s) {
        Stack<Character> a=new Stack<>();
        //int i=s.length();
        for(char i:s.toCharArray()){
            if(i=='(' || i=='{' || i=='['){
                a.push(i);
            }
            else{
                if(a.isEmpty()) return false;
                char top=a.pop();
                if(i==')' && top!='(') return false;
                if(i=='}' && top!='{') return false;
                if(i==']' && top!='[') return false;

            } 
        }
        return a.isEmpty();
       
        
    }
}