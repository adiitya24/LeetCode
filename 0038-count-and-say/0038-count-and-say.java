class Solution {
    public String countAndSay(int n) {
        if(n==1) return "1";
        StringBuilder s=new StringBuilder("1");
        for(int i=1;i<n;i++){
            int l=0,r=s.length();
            StringBuilder temp=new StringBuilder();
            while(l<r){
                int count=1;
                
                while(l<r-1&&s.charAt(l)==s.charAt(l+1)){
                    l++;
                    count++;
                }
                temp.append(Integer.toString(count));
                temp.append(s.charAt(l));
                l++;
            }
            s=temp;
        }
        return s.toString();
    }
}