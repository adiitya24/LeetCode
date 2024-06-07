class Solution {
    class Trie{
        Trie[] child;
        boolean isEnd;
        Trie(){
            child=new Trie[26];
            isEnd=false;
        }
    }
    Trie root=new Trie();
    public String replaceWords(List<String> dictionary, String sentence) {
        for(String s:dictionary){
            insert(s);
        }
        StringBuilder ans=new StringBuilder();
        String str[]=sentence.split(" ");
        for(String s:str){
            ans.append(searchPrefix(s));
            ans.append(" ");
        }
        return ans.toString().trim();

    }
    void insert(String s){
        Trie curr=root;
        for(char c:s.toCharArray()){
            if(curr.child[c-'a']==null){
                Trie newNode=new Trie();
                curr.child[c-'a']=newNode;
            }
            curr=curr.child[c-'a'];
        }
        curr.isEnd=true;
    }
    String searchPrefix(String s){
        Trie curr=root;
        int j=0,i;
        for(char c:s.toCharArray()){
                j++;
                if(curr.child[c-'a']==null)
                return s;
                else if(curr.child[c-'a'].isEnd){
                    return s.substring(0,j);
                }
                else{
                    curr=curr.child[c-'a'];
                }
        }
        return s;
    }

}