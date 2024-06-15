class Solution {
    public String minWindow(String s, String t) {
        if (s == null || t == null || s.length() == 0 || t.length() == 0 ||
                s.length() < t.length()) {
            return new String();
        }
        int freq[]=new int[128];
        int left=0,right=0,start=0,count=t.length(),minLen=Integer.MAX_VALUE;
        for(char c:t.toCharArray()){
            freq[c]++;
        }
        char ch[]=s.toCharArray();
        while(right<ch.length){
            if(freq[ch[right++]]-->0){
                count--;

            }
            while(count==0){
                if(right-left<minLen){
                    minLen=right-left;
                    start=left;
                }
                if(freq[ch[left++]]++==0){
                    count++;
                }
            }
        }
       
        return minLen == Integer.MAX_VALUE ? new String() :
                new String(ch, start, minLen);
    }
}