class Solution {
    public int[] maxNumber(int[] nums1, int[] nums2, int k) {
        int len1=nums1.length;
        int len2=nums2.length;
        int maxRes[]=new int[k];
        for(int i=0;i<=k;i++){
            int j=k-i;
            if(i<=len1&&(k-i)<=len2){
                int max1[]=findMaxArray(nums1,i);
                int max2[]=findMaxArray(nums2,j);
                int res[]=merge(max1,max2,k);
                boolean compareRes=findMax(res,maxRes,0,0);
                if(compareRes){
                    maxRes=res;
                }
            }
        }
        return maxRes;
    }
    int[] findMaxArray(int nums[],int k){
        int ans[]=new int[k];
        int n=nums.length,i=0;
        int eliminate=n-k;
        Stack<Integer> st=new Stack<>();
        while(i<n){
                while(!st.isEmpty()&&st.peek()<nums[i]&&eliminate>0){
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
        
        return ans;
    }
    boolean findMax(int[] nums1,int[] nums2,int p1,int p2){
        while(p1<nums1.length&&p2<nums2.length){
            if(nums1[p1]<nums2[p2])
            return false;
            else if(nums1[p1]>nums2[p2])
            return true;
            else{
                p1++;
                p2++;
            }
        }
        return p1!=nums1.length;
    }
    int[] merge(int nums1[],int nums2[],int k){
        int ans[]=new int[k];
        int i=0,p1=0,p2=0;
        while(i<k){
        ans[i++]=findMax(nums1,nums2,p1,p2)?nums1[p1++]:nums2[p2++];
        }
        return ans;
    }

}