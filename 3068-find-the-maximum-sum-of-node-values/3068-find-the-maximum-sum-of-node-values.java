class Solution {
    public long maximumValueSum(int[] nums, int k, int[][] edges) {
     long sum=0,count=0,minDiff=Integer.MAX_VALUE;
     for(long a:nums){
        sum+=Math.max(a^k,a);
        count+=(a^k)>a?1:0;
        minDiff=Math.min(minDiff,Math.abs((a^k)-a));
     }   
     return sum-(count%2==1?minDiff:0);
    }
}