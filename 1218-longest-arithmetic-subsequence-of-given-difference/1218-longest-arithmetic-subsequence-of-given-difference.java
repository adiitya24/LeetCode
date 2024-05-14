class Solution {
    public int longestSubsequence(int[] arr, int difference) {
         HashMap<Integer, Integer> map = new HashMap<>();
        int longest = 0;
        
        for(int i=0; i<arr.length; i++) {
            int current = arr[i];
            int previous = current - difference;
            int length = map.getOrDefault(previous, 0) + 1;
            
            map.put(current, length);
            longest = Math.max(longest, length);
        }
        
        return longest;
    }
}