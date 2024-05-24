class Solution {
    public int maxScoreWords(String[] words, char[] letters, int[] score) {
        int freq[]=new int[26];
        int countFreq[]=new int[26];
        for(char c:letters){
            freq[c-'a']++;
        }
        int ans=0;
        ans=solve(0,0,words,score,freq,countFreq,ans);
        return ans;
    }
    int solve(int index,int currSum,String[] words,int[] score,int[] freq,int[] countFreq,int ans){
        for(int i=0;i<26;i++){
            if(countFreq[i]>freq[i]) return ans;
        }
        ans=Math.max(ans,currSum);
        for(int i=index;i<words.length;i++){
            for(char c:words[i].toCharArray()){
                countFreq[c-'a']++;
                currSum+=score[c-'a'];
            }
            ans=solve(i+1,currSum,words,score,freq,countFreq,ans);
            for(char c:words[i].toCharArray()){
                countFreq[c-'a']--;
                currSum-=score[c-'a'];
            
            }
        }
        return ans;
    }
}