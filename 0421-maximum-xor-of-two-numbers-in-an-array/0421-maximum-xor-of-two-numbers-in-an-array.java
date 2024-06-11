class Solution {
    class Trie{
      Trie one,zero;
    }
    public int findMaximumXOR(int[] nums) {
        Trie root=new Trie();
        for(int a:nums){
            insert(root,a);
        }
        int max=0;
        for(int a:nums){
            max=Math.max(max,findmax(root,a));
        }
        return max;
        
    }
    void insert(Trie root,int n){
        Trie curr=root;
        for(int i=31;i>=0;i--){
            int bit=(n>>i)&1;
            if(bit==0){
                if(curr.zero==null){
                    Trie newnode=new Trie();
                    curr.zero=newnode;
                    
                }
                curr=curr.zero;
            }
            else{
                if(curr.one==null){
                    Trie newnode=new Trie();
                    curr.one=newnode;
                    
                }
                curr=curr.one;
            }

        }
    }
    int findmax(Trie root,int n){
        int ans=0;
        Trie curr=root;
        for(int i=31;i>=0;i--){
        int    bit=(n>>i)&1;
            if(bit==0){
                if(curr.one!=null){
                    ans+=(1<<i);
                    curr=curr.one;
                }
                else{
                    curr=curr.zero;
                }
            }
            else{
                if(curr.zero!=null){
                    ans+=(1<<i);
                    curr=curr.zero;
                }
                else{
                    curr=curr.one;
                }
            }
        }
        return ans;
    }
}