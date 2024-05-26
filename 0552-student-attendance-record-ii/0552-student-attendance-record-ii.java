class Solution {
    int mod=1000000000+7;
    int dp[][][];

    public int checkRecord(int n) {
        dp=new int[n+1][2][3];
        for(int a[][]:dp){
            for(int b[]:a){
                Arrays.fill(b,-1);
            }
        }
        return solve(n,1,2);
    }
    int solve(int n,int absence,int late){
        if(n==0) return 1;
        if(dp[n][absence][late]!=-1) return dp[n][absence][late];
        int total=0;
        total+=solve(n-1,absence,2);
        if(absence>0){
            total+=solve(n-1,absence-1,2);
            total%=mod;
        }
        if(late>0){
                total+=solve(n-1,absence,late-1);
                total%=mod;
        }
        return dp[n][absence][late]= total;
    }
}