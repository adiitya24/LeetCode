class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashSet<Character> set=new HashSet<>();
        int max=0,left=0,right=0,n=s.length();
        while(right<n){
            char c=s.charAt(right);
             while(set.contains(c)){
                set.remove(s.charAt(left));
                left++;
            }
           
                set.add(c);
            
        
           max=Math.max(max,right-left+1);
           right++;
        }
        
        
        return max;
    }
}