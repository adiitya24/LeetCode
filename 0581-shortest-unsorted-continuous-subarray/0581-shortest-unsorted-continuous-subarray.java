class Solution {
    public int findUnsortedSubarray(int[] nums) {
        int i1=-1,max=0;
        int temp[]=nums.clone();
        Arrays.sort(temp);
        for(int i=0;i<nums.length;i++){
            if(nums[i]!=temp[i]){
                if(i1==-1){
                    i1=i;
                }
                else{
                    max=Math.max(max,i-i1+1);
                }
            }
        }
        return max;
    }
}