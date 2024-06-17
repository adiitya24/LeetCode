class Solution {
    public boolean judgeSquareSum(int c) {
        long low=1,high=c,root=0;
        while(low<=high){
            long mid=low+(high-low)/2;
            if(mid*mid==c) return true;
            if(mid*mid>c){
                high=mid-1;
            }
            else{
                root=mid;
                low=mid+1;
            }
        }

        low=0;
        high=root;

        while(low<=high){
            long prod=low*low+high*high;
            if(prod==c) return true;
            if(prod>c){
                high--;
            }
            else{
                low++;
            }
        }
        return false;
    }
}