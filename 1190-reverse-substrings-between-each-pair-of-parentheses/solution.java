class Solution {
    public String reverseParentheses(String s) {
        Stack<Integer> skip=new Stack<>();
        StringBuilder ans=new StringBuilder();
        for(char c: s.toCharArray()){
            // opening bracket se phle ki length store karlo stack mai
            if(c=='('){
                skip.push(ans.length());

            }
            //reverse karna hai jaise hi closing bracket mil jaata hai abhi dekha hua opening bracket se pahle ki length se lekar 
            // abhi tak jitni tumhari string bani hai
            else if(c==')'){

                int start=skip.pop();
                String part=ans.substring(start,ans.length());
                part=new StringBuilder(part).reverse().toString();
                ans.replace(start,ans.length(),part);
            }
            // ans mai apna jitne bhi characters hai expect the bracets store karlo
            else{
                ans.append(c);
            }
        }
        return ans.toString();

    }
}