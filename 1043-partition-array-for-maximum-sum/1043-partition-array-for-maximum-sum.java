class Solution {
    public int maxSumAfterPartitioning(int[] arr, int k) {
      int n=arr.length;
      int dp[]=new int[n];
      Arrays.fill(dp,-1);
        return solve(arr,0,k,dp);
    }
    int solve(int[] arr,int id,int k,int[] dp){
        if(id==arr.length) return 0;

        if(dp[id]!=-1) return dp[id];

        int max=0,res=0;
        for(int i=id;i<id+k&&i<arr.length;i++){
            max=Math.max(max,arr[i]);
            res=Math.max(res,solve(arr,i+1,k,dp)+(i-id+1)*max);
        }
        return dp[id]=res;
        

    }
}