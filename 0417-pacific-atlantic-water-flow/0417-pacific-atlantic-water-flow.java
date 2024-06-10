class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int m=heights.length;
        int n=heights[0].length;
        boolean[][] pacific=new boolean[m][n];
        boolean[][] atlantic=new boolean[m][n];

        for(int col=0;col<n;col++){
            dfs(0,col,m,n,pacific,heights[0][col],heights);
            dfs(m-1,col,m,n,atlantic,heights[m-1][col],heights);
        }
        
        for(int row=0;row<m;row++){
            dfs(row,0,m,n,pacific,heights[row][0],heights);
            dfs(row,n-1,m,n,atlantic,heights[row][n-1],heights);
        }
        List<List<Integer>> ans=new ArrayList<>();
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(pacific[i][j]&&atlantic[i][j])
                ans.add(Arrays.asList(i,j));
            }
        }
        return ans;
    }
    void dfs(int row,int col,int rows,int cols,boolean[][] visited,int prev,int[][] heights){
        if(row<0||col<0||row>=rows||col>=cols||visited[row][col]||prev>heights[row][col]) return ;

        visited[row][col]=true;

         dfs(row+1, col, rows, cols, visited, heights[row][col], heights);
        dfs(row-1, col, rows, cols, visited, heights[row][col], heights);
        dfs(row, col+1, rows, cols, visited, heights[row][col], heights);
        dfs(row, col-1, rows, cols, visited, heights[row][col], heights);
    }
}