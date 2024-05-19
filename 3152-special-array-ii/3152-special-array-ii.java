class Solution {
    public boolean[] isArraySpecial(int[] nums, int[][] queries) {
        int n=nums.length;
        int check[]=new int[n];
        int count=0;
        for(int i=1;i<n;i++){
            if(nums[i]%2==nums[i-1]%2){
                count++;   
            }
              check[i]=count;
        }
        int q=queries.length;
        boolean ans[]=new boolean[q];
    for(int i=0;i<q;i++){
        int mistakes=check[queries[i][1]]-check[queries[i][0]];
        if(mistakes==0) ans[i]=true;
    }
    return ans;
    }
}