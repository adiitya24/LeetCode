class Solution {
    public int minDifference(int[] nums) {
        int n=nums.length;
        Arrays.sort(nums);
        if(n<=4) return 0;
        int ans=nums[n-1]-nums[0];
        ans=Math.min((nums[n-1]-nums[3]),(nums[n-4]-nums[0]));
        ans=Math.min(ans,Math.min((nums[n-2]-nums[2]),(nums[n-3]-nums[1])));


return ans;

    }
 
}