class Solution {
    
    public int orangesRotting(int[][] grid) {
        
         Queue<int[]> q=new LinkedList<>();
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]==2)
                {
                    q.add(new int[]{i,j});
                }
            }
        }
        int ans=0;
        while(!q.isEmpty()){
            int size=q.size();
       //     System.out.println(size+" "+ans);
          
            System.out.println(size+" "+ans);

            for(int k=0;k<size;k++){
                    int[] polled=q.poll();
                    int i=polled[0];
                    int j=polled[1];
        if(i-1>=0&&grid[i-1][j]==1){
        grid[i-1][j]=2;
        q.add(new int[]{i-1,j});
        }

        if(i+1<grid.length&&grid[i+1][j]==1){
        grid[i+1][j]=2;
        q.offer(new int[]{i+1,j});
        }

        if(j-1>=0&&grid[i][j-1]==1){
        grid[i][j-1]=2;
        q.offer(new int[]{i,j-1});
        }
        if(j+1<grid[0].length&&grid[i][j+1]==1){
        grid[i][j+1]=2;
        q.offer(new int[]{i,j+1});
        }

            }
            if(q.size()>0)
            ans++;
        }
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]==1) return -1;
            }
        }
        
        return ans;
        
    }
   
}