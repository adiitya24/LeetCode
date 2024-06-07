class Trie {
class TrieNode{
    TrieNode children[];
    boolean isEndOfWord;
    TrieNode(){
        children=new TrieNode[26];
        isEndOfWord=false;
    }
}
TrieNode root;
    public Trie() {
        root=new TrieNode();
    }
    
    public void insert(String word) {
        TrieNode currNode=root;
        for(char c:word.toCharArray()){
            if(currNode.children[c-'a']==null){
                TrieNode newNode=new TrieNode();
                currNode.children[c-'a']=newNode;
            }
            currNode=currNode.children[c-'a'];
        }
        currNode.isEndOfWord=true;
    }
    
    public boolean search(String word) {
        TrieNode curr=root;
        for(char c:word.toCharArray()){
            if(curr.children[c-'a']==null) return false;
            curr=curr.children[c-'a'];
        }
        return curr.isEndOfWord;
    }
    
    public boolean startsWith(String prefix) {
        TrieNode curr=root;
        for(char c:prefix.toCharArray()){
            if(curr.children[c-'a']==null) return false;
            curr=curr.children[c-'a'];
        }
        return true;

    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */