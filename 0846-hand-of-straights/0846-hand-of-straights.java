class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        int n=hand.length;
        if(n%groupSize!=0) return false;
        Arrays.sort(hand);
        for(int i=0;i<n;i++){
            if(hand[i]>=0){
                if(!formGroup(hand,i,n,groupSize))
                return false;
            }
        }
        return true;
    }
    boolean formGroup(int[] hand,int i,int n,int groupSize){
        int next=hand[i]+1;
        int count=1;
        hand[i]=-1;
        i++;
        while(i<n&&count<groupSize){
            if(hand[i]==next){
                next=hand[i]+1;
                hand[i]=-1;
                count++;
                
            }
            i++;
        }
        if(count!=groupSize) return false;
        return true;
    }
}