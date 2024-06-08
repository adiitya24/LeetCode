class Solution {
    public int maximumLength(int[] nums, int k) {
       int dp[][][]=new int[nums.length+1][k+1][nums.length+1];
       for(int a[][]:dp){
        for(int b[]:a){
            Arrays.fill(b,-1);
        }
       }
       return solve(nums,k,0,-1,dp); 
    }
    int solve(int[] nums,int k,int index,int prev,int[][][] dp){
        if(index==nums.length) return dp[index][k][prev+1]=0;
        if(dp[index][k][prev+1]!=-1) return dp[index][k][prev+1];
        int take=0;
        if(prev==-1||nums[index]==nums[prev]){
            take=1+solve(nums,k,index+1,index,dp);

        }
        else if(k>0){
            take=1+solve(nums,k-1,index+1,index,dp);
        }
        int nottake=solve(nums,k,index+1,prev,dp);
        return dp[index][k][prev+1]=Math.max(take,nottake);
    }
    
}