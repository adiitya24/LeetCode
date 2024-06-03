class Solution {
    
    public int maxAreaOfIsland(int[][] grid) {
        int max=0;
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]==1)
                max=Math.max(max,dfs(grid,i,j));
            }
        }
        return max;
    }
    int dfs(int grid[][],int i,int j){
        int n=grid.length;
        int m=grid[0].length;
        if(i<0||j<0||i>=n||j>=m||grid[i][j]==0) return 0;
        int left=0,right=0,up=0,down=0;
        grid[i][j]=0;
        int ans=1;
      ans+=  dfs(grid,i,j-1);
       ans+=dfs(grid,i,j+1);
      ans+= dfs(grid,i+1,j);
        ans+=dfs(grid,i-1,j);
    
        return ans;
    }
}