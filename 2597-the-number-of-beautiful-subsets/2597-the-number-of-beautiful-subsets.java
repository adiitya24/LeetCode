class Solution {
    int map[]=new int[1001];
    public int beautifulSubsets(int[] nums, int k) {
        Arrays.sort(nums);
        return sub(0,nums,k);
    }
    int sub(int i,int nums[],int k){
        if(i>=nums.length) return 0;
        int take=0,nottake=0;
        if(nums[i]-k<0||map[nums[i]-k]==0){
            map[nums[i]]++;
            take=1+sub(i+1,nums,k);
            map[nums[i]]--;
        }
        nottake=sub(i+1,nums,k);
        return take+nottake;
    }
}