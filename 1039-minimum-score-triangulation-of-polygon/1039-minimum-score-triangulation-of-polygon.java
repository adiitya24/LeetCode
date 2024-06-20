class Solution {
    int dp[][]=new int[51][51];
    
    public int minScoreTriangulation(int[] values) {
      for(int a[]:dp){
        Arrays.fill(a,-1);
      }
        return mcm(values,1,values.length-1);
    }
    int mcm(int values[],int i,int j){
        if(i>=j) return 0;
        if(dp[i][j]!=-1) return dp[i][j];
        int ans=Integer.MAX_VALUE;
        for(int k=i;k<j;k++){
            int temp=mcm(values,i,k)+mcm(values,k+1,j)+values[i-1]*values[k]*values[j];
            ans=Math.min(ans,temp);
        }
        return dp[i][j]=ans;

    }
}