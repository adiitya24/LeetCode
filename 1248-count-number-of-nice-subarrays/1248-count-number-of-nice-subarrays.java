class Solution {
    public int numberOfSubarrays(int[] nums, int k) {
        int ans=0,n=nums.length,sum=0;
        int count[]=new int[n+1];
        count[0]=1;
        for(int a:nums){
                sum+=a&1;
                if(sum-k>=0){
                    ans+=count[sum-k];
                }
                count[sum]++;
        }
        return ans;
    }
   
}