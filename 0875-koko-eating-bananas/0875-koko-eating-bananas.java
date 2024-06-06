class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int low=1,mid,ans=-1;
        int high=0;
        for(int a:piles){
            high=Math.max(high,a);
        }
        while(low<=high){
            mid=(low+high)/2;
            if(check(piles,mid,h)){
                ans=mid;
                high=mid-1;

            }else{
                low=mid+1;
            }
        }
        return ans;
    }
    boolean check(int[] piles,int mid,int h){
       if(mid==0) return false;
       int i=0;
       while(h>=0&&i<piles.length){
        h-=Math.ceil((double)piles[i]/mid);
        i++;
       }
        
        return (h>=0&&i==piles.length);
    }
}