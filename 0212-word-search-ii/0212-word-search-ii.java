class Solution {
    class Trie{
        Trie child[]=new Trie[26];
        String word;
       
    }
    Trie buildtree(String[] words){
        Trie root=new Trie();
        for(String s:words){
            Trie curr=root;
            for(char c:s.toCharArray()){
                if(curr.child[c-'a']==null) curr.child[c-'a']=new Trie();
                curr=curr.child[c-'a'];
            }
            curr.word=s;
        }
        return root;
    }
    public List<String> findWords(char[][] board, String[] words) {
        List<String> ans=new ArrayList<>();
        Trie root=buildtree(words);
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                dfs(board,i,j,root,ans);
            }
        }
        return ans;
    }
    void dfs(char board[][],int i,int j,Trie root,List<String> ans){
       if(i<0||j<0||i>=board.length||j>=board[0].length||board[i][j]=='#'||root.child[board[i][j]-'a']==null) return ;
        char c=board[i][j];
        root=root.child[c-'a'];
        if(root.word!=null){
            ans.add(root.word);
            root.word=null;
        }
        board[i][j]='#';
        dfs(board,i-1,j,root,ans);
        dfs(board,i+1,j,root,ans);
        dfs(board,i,j-1,root,ans);
        dfs(board,i,j+1,root,ans);
        board[i][j]=c;
        
    }
}