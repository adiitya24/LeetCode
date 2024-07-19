class Solution {
    public List<Integer> luckyNumbers (int[][] matrix) {
        List<Integer> ans=new ArrayList<>();
        int r=matrix.length;
        int c=matrix[0].length;
        int min[]=new int[r];
        int max[]=new int[c];
        for(int i=0;i<r;i++){
            int ind=matrix[i][0];
            for(int j=0;j<c;j++){
                if(ind>matrix[i][j]){
                    ind=matrix[i][j];
                }
            }
            min[i]=ind;
        }
        for(int i=0;i<c;i++){
            int ind=matrix[0][i];
            for(int j=0;j<r;j++){
                if(ind<matrix[j][i]){
                    ind=matrix[j][i];
                }
            }
            max[i]=ind;
        }
        for(int i=0;i<r;i++){
            for(int j=0;j<c;j++){
                    if(min[i]==max[j]){
                        ans.add(min[i]);
                    }
            }
        }
        return ans;
    }
}