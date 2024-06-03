class Solution {
    ArrayList<String> ans=new ArrayList<>();
    public List<String> generateParenthesis(int n) {
       solve("",n,n);
        return ans;
    }
    void solve(String s,int open,int close){
        if(open==0&&close==0){
            ans.add(s);
            return;
        }
        if(open>close) return;
        if(open==0){
            while(close>0){
                s=s+")";
                close--;
            }
            ans.add(s);
            return;
        }
        if(open>0){
        String s1=s+"(";
        solve(s1,open-1,close);
        }

        if(open<close){
            String s2=s+")";
            solve(s2,open,close-1);
        }

    }
}