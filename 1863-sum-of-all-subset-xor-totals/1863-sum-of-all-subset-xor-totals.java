class Solution {
    
    public int subsetXORSum(int[] nums) {
        return subset(0,nums,0);
        
        
    }
    int subset(int start,int[] nums,int xor){
         
        if(start==nums.length) return xor;
      
       int nottake= subset(start+1,nums,xor);
       int take=subset(start+1,nums,xor^nums[start]);
       return nottake+take;
    }
}