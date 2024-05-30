class Solution {
    public int countTriplets(int[] arr) {
        int ans=0,xor,j,i,n=arr.length;
        for(i=0;i<n;i++){
             xor=arr[i];
            for(j=i+1;j<n;j++){
               xor^=arr[j];
                if(xor==0)
            ans+=j-i;
            }
           
        }
        return ans;
    }
    
}