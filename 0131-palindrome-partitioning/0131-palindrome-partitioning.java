class Solution {
    List<List<String>> ans=new ArrayList<>();
    public List<List<String>> partition(String s) {

        partion(s,0,s.length(),new ArrayList<>());
        return ans;
    }
    void partion(String s,int i,int j,List<String> curr){
        if(i>=j) {ans.add(new ArrayList<>(curr));
        return;
        }
        for(int k=i;k<j;++k){
            String substring=s.substring(i,k+1);
            if(ispallindrome(substring)){
                curr.add(substring);
                partion(s,k+1,j,curr);
                curr.remove(curr.size()-1);
            }
        }
    }
  boolean  ispallindrome(String s){

    int start=0,end=s.length()-1;
        while(start<=end){
            if(s.charAt(start)!=s.charAt(end))
            return false;

            start++;
            end--;
        }
        return true;
    }
}