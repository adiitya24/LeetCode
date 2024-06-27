class Solution {
    public int longestOnes(int[] nums, int k) {
        int left=0,right=0,max=0,zero=0,n=nums.length;
        while(right<n){
            if(nums[right]==0)
            zero++;
        
            if(zero>k){
                while(zero>k){
                    if(nums[left]==0)
                    zero--;

                    left++;
                }
            }
            max=Math.max(max,right-left+1);
            right++;
        }
        return max;
    }
}