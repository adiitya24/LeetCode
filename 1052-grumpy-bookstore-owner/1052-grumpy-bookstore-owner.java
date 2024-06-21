class Solution {
    public int maxSatisfied(int[] customers, int[] grumpy, int minutes) {
        int prev=0,next=0,window=0,total=0,ans=0;
        int left=0,right=0;
        for(int i=0;i<grumpy.length;i++){
            if(grumpy[i]==0)
            total+=customers[i];
        }
        next=total;
     //   System.out.println(next);
        while(right<customers.length&&right<minutes){
            window+=customers[right];
            if(grumpy[right]==0)
            next-=customers[right];

            right++;
        }
       
        
        ans=Math.max(ans,prev+window+next);
        while(right<customers.length){
           
        prev+=grumpy[left]==0?customers[left]:0;
        window-=customers[left];
        
        window+=customers[right];
        next-=grumpy[right]==0?customers[right]:0;
        left++;
        ans=Math.max(ans,prev+window+next);
        right++;
        }
        return ans;
    }
}