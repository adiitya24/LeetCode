class Solution {
    public int getMaximumGold(int[][] grid) {
        int max=0;
       // boolean vis[][]=new boolean[grid.length][grid[0].length];
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]!=0){
                    max=Math.max(max,path(i,j,grid));
                }
            }
            
        }
        return max;
    }
    int path(int i,int j,int grid[][]){
        int m=grid.length;
        int n=grid[0].length;
        if(i<0||j<0||i>=m||j>=n)
        return 0;
     if(grid[i][j]==0) return 0;
        int left=0,right=0,up=0,down=0;
        int currGold=grid[i][j];
        grid[i][j]=0;
        left=path(i,j-1,grid);
        right=path(i,j+1,grid);
        up=path(i-1,j,grid);
        down=path(i+1,j,grid);
        grid[i][j]=currGold;
        return currGold+Math.max(left,Math.max(right,Math.max(up,down)));
    }
}