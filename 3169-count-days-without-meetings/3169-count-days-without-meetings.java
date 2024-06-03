class Solution {
    public int countDays(int days, int[][] meetings) {
        Arrays.sort(meetings,(a,b)->(a[0]-b[0]));
        int ans=0,prev=meetings[0][0];
        ans+=Math.abs(meetings[0][0]-1);  
        
        for(int i=1;i<meetings.length;i++){
             if(meetings[i][0]<=meetings[i-1][1]){
               if(meetings[i][1]<meetings[i-1][1]){
                   meetings[i][1]=meetings[i-1][1];
               }
           }
            else{
                ans+=meetings[i][0]-meetings[i-1][1]-1;
              }
        }
        ans+=Math.abs(meetings[meetings.length-1][1]-days);
        return ans;
    }
}