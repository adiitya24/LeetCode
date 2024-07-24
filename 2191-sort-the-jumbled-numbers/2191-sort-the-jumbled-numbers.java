class Solution {
    public int[] sortJumbled(int[] mapping, int[] nums) {
        int n=nums.length;
        int arr[][]=new int[n][2];
        for(int i=0;i<n;i++){
            arr[i][1]=i;
            if(nums[i]==0)
            arr[i][0]=mapping[0];
            else
            arr[i][0]=replace(mapping,nums[i]);

           // System.out.println(arr[i][0]);
        }
        Arrays.sort(arr,(a,b)->{
            if(a[0]!=b[0])
            return a[0]-b[0];
            else
           return a[1]-b[1];
        });
        int ans[]=new int[n];
        for(int i=0;i<n;i++){
            ans[i]=nums[arr[i][1]];
        }
        return ans;
    }
    int replace(int[] mapping,int n){
        int ans=0;
        int placevalue=1;
        while(n>0){
            int index=n%10;
            ans+=placevalue*mapping[index];
            placevalue*=10;
            n/=10;
        }
        return ans;
    }
}