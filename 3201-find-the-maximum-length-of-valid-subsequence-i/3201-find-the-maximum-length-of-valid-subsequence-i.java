class Solution {
    public int maximumLength(int[] nums) {
        int maxLength=0,length=0;
        int n=nums.length;
        int parity[]=new int[n];
        for(int i=0;i<n;i++){
            parity[i]=nums[i]%2;
        }

        for(int i=0;i<n;i++){
            if(parity[i]==0)
            length++;
        }
        maxLength=Math.max(maxLength,length);
        length=0;
        for(int i=0;i<n;i++){
            if(parity[i]==1)
            length++;
        }
        maxLength=Math.max(maxLength,length);
        length=0;
        boolean even_odd=true;
        for(int i=0;i<n;i++){
            if(even_odd){
                if(parity[i]==0){
                    length++;
                    even_odd=false;
                }
            }
            else{
                if(parity[i]==1){
                    length++;
                    even_odd=true;
                }
            }
        }
        maxLength=Math.max(maxLength,length);
        boolean odd_even=true;
        length=0;
        for(int i=0;i<n;i++){
            if(odd_even){
                if(parity[i]==1){
                    length++;
                    odd_even=false;
                }
            }
            else{
                if(parity[i]==0){
                    length++;
                    odd_even=true;
                }
            }
        }
        maxLength=Math.max(maxLength,length);
        return maxLength;

    }
}