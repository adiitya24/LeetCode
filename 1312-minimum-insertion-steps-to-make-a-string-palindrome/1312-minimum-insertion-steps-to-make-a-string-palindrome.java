class Solution {
    public int minInsertions(String s) {
        StringBuilder s2=new StringBuilder(s);
        s2.reverse();
        int n=s.length();
        String str=s2.toString();
        int dp[][]=new int[n+1][n+1];
        for(int i=0;i<=n;i++){
            dp[i][0]=0;
            dp[0][i]=0;
        }
        for(int i=1;i<=n;i++){
            for(int j=1;j<=n;j++){
                if(s.charAt(i-1)==str.charAt(j-1)){
                    dp[i][j]=dp[i-1][j-1]+1;
                }
                else{
                    dp[i][j]=Math.max(dp[i-1][j],dp[i][j-1]);
                }
            }
        }
        int insert=n-dp[n][n];
        return insert;
    }
}