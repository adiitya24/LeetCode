class Solution {
    public int numSteps(String s) {
       int ans=0,carry=0;
       for(int i=s.length()-1;i>0;i--){
        if(s.charAt(i)-'0'+carry==1){
            carry=1;
            ans+=2;
        }
        else{
            ans+=1;
        }
       }
    
        return ans+carry;
    }
}