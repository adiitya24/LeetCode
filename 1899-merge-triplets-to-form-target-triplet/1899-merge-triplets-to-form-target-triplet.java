class Solution {
    public boolean mergeTriplets(int[][] triplets, int[] target) {
       int ans[]=new int[3];
        for(int a[]:triplets){
           if(a[0]<=target[0]&&a[1]<=target[1]&&a[2]<=target[2]){
            ans=new int[]{Math.max(a[0],ans[0]),Math.max(a[1],ans[1]),Math.max(a[2],ans[2])};

           }
        }
        return Arrays.equals(ans,target);
    
    }
}