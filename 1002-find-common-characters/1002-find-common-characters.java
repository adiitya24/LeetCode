class Solution {
    public List<String> commonChars(String[] words) {
        int min_freq[]=new int[26];
        Arrays.fill(min_freq,1001);
        for(String s:words){
            int freq[]=new int[26];
            for(char c:s.toCharArray()){
                    freq[c-'a']++;
            }
            for(int i=0;i<26;i++){
                min_freq[i]=Math.min(min_freq[i],freq[i]);
            }
        }
        ArrayList<String> ans=new ArrayList<>();
        for(int i=0;i<26;i++){
                while(min_freq[i]-->0){
                    ans.add(String.valueOf((char)(i+'a')));
                }
        
        }
        return ans;
    }
}