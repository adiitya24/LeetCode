class Solution {
    public int numSquares(int n) {
    int dp[]=new int[n+1];
    Arrays.fill(dp,-1);
       return help(n,dp);
        }
     int help(int n,int[] dp){
            if(n==0)return 0;
            int val;
            if(n<0) return Integer.MAX_VALUE;
            int ans=Integer.MAX_VALUE;
            for(int i=1;i*i<=n;i++){
                
                if(dp[n-i*i]!=-1)
                val=dp[n-i*i];
                else
                val=help(n-i*i,dp);

                ans=Math.min(ans,1+val);
            }
        return dp[n]=ans;
        
    }
}