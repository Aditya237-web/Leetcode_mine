class Solution {
    public int findContentChildren(int[] g, int[] s) {
        int l=0;
        int m=s.length;
        int r=0;
        Arrays.sort(g);
        Arrays.sort(s);
        while(l<s.length && r<g.length){
            if(g[r]<=s[l]){
                r++;
                
            }
            
                l++;
            
        }
        return r;


        
    }
}