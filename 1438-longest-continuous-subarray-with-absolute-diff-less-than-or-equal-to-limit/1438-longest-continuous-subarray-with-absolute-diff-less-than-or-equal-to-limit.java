class Solution {
    public int longestSubarray(int[] nums, int limit) {
        int n=nums.length,left=0,right=0,ans=0;
        Deque<Integer> increase=new ArrayDeque<>();
        Deque<Integer> decrease=new ArrayDeque<>();
        while(right<n){
            int num=nums[right];
            while(!increase.isEmpty()&&num>increase.peekLast()){
                increase.pollLast();
            }
            increase.offerLast(num);
            while(!decrease.isEmpty()&&num<decrease.peekLast()){
                decrease.pollLast();
            }
            decrease.offerLast(num);
            while(increase.peek()-decrease.peek()>limit){
                if(increase.peek()==nums[left])
                increase.pollFirst();

                if(decrease.peekFirst()==nums[left])
                decrease.pollFirst();

                left++;
            }
            ans=Math.max(ans,right-left+1);
            right++;
        }
        return ans;
    }
}