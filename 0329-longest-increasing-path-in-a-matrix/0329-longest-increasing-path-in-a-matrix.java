class Solution {
    public int longestIncreasingPath(int[][] matrix) {
        int m=matrix.length;
        int n=matrix[0].length;
        int dp[][]=new int[m+1][n+1];
        for(int a[]:dp){
            Arrays.fill(a,-1);
        }
        int max=0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                max=Math.max(max,solve(matrix,i,j,dp));
            }
        }
        return max+1;
    }
    int solve(int m[][],int i,int j,int[][] dp){
        int left=0,right=0,up=0,down=0;
        if(dp[i][j]!=-1) return dp[i][j];
        int temp=m[i][j];
        if(i-1>=0&&m[i-1][j]>m[i][j]){
            m[i][j]=-1;
            down=1+solve(m,i-1,j,dp);
            m[i][j]=temp;
        }
        if(i+1<m.length&&m[i+1][j]>m[i][j]){
            m[i][j]=-1;
            up=1+solve(m,i+1,j,dp);
            m[i][j]=temp;
        }
        if(j-1>=0&&m[i][j-1]>m[i][j]){
            m[i][j]=-1;
            left=1+solve(m,i,j-1,dp);
            m[i][j]=temp;

        }
        if(j+1<m[0].length&&m[i][j+1]>m[i][j]){
            m[i][j]=-1;
            right=1+solve(m,i,j+1,dp);
            m[i][j]=temp;
        }
        return dp[i][j]= Math.max(Math.max(left,right),Math.max(up,down));

        

        
        
    }
}