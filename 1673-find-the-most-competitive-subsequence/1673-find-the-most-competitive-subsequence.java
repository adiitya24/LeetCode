class Solution {
    public int[] mostCompetitive(int[] nums, int k) {
        int ans[]=new int[k];
        int n=nums.length,i=0;
        int eliminate=n-k;
        Stack<Integer> st=new Stack<>();
        while(i<n){
                while(!st.isEmpty()&&st.peek()>nums[i]&&eliminate>0){
                    st.pop();
                    eliminate--;
                }
                st.push(nums[i++]);
        }
        while(eliminate-->0){
            st.pop();
        }
        i=k-1;
        while(!st.isEmpty()){
            ans[i--]=st.pop();
        }
        // for(i=k-1;i>=0;i--){
        //     ans[i]=st.pop();
        // }
        return ans;

    }
}