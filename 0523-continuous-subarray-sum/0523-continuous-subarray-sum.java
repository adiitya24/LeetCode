class Solution {
    public boolean checkSubarraySum(int[] nums, int k) {
        int n=nums.length;
         int mod,sum=0;
     if(n==1)
        return false;
         if(n==2){
             return (nums[0]+nums[1])%k==0;
         }
       HashMap<Integer,Integer> map=new HashMap<>();
       map.put(0,0);
       for(int i=0;i<n;i++){
           sum+=nums[i];
           mod=sum%k;
           if(map.containsKey(mod)){
               if(i>map.get(mod))
               return true;
           }else{
           map.put(mod,i+1);
           }
       }
       return false;
    }
}