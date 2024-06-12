class Solution {
    public int[] xorQueries(int[] arr, int[][] queries) {
        int n=queries.length,i=0;
        int ans[]=new int[n];
        int prefix[]=new int[arr.length];
        prefix[0]=arr[0];
        for(i=1;i<arr.length;i++){
            prefix[i]=prefix[i-1]^arr[i];
        }
        i=0;
        for(int q[]:queries){
                int a=q[0];
                int b=q[1];
                if(a==0)
                ans[i++]=prefix[b];
                else
                ans[i++]=prefix[b]^prefix[a-1];

        }
        return ans;
    }
}