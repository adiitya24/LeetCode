class Solution {
    public int longestMountain(int[] arr) {
        int n=arr.length;
        int inc[]=new int[n];
        int dec[]=new int[n];
        inc[0]=0;
        dec[n-1]=0;
        for(int i=1;i<n;i++){
            if(arr[i]>arr[i-1])
            inc[i]=inc[i-1]+1;
            else
            inc[i]=0;
        }
        for(int i=n-2;i>=0;i--){
            if(arr[i]>arr[i+1])
            dec[i]=dec[i+1]+1;
            else
            dec[i]=0;
        }
        int max=0;
        for(int i=0;i<n;i++){
            if(dec[i]!=0&&inc[i]!=0)
            max=Math.max(max,inc[i]+dec[i]+1);
        }
        return max;
    }
}