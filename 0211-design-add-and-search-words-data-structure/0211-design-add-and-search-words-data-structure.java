class WordDictionary {

    WordDictionary children[];
    boolean isEndOfWord;
  

 WordDictionary root;
    public WordDictionary() {
         children=new WordDictionary[26];
        isEndOfWord=false;
    }
    
    public void addWord(String word) {
          WordDictionary currNode=this;
        for(char c:word.toCharArray()){

            if(currNode.children[c-'a']==null){
                WordDictionary newNode=new WordDictionary();
                currNode.children[c-'a']=newNode;
            }
            currNode=currNode.children[c-'a'];
        }
        currNode.isEndOfWord=true;
    }
    
    public boolean search(String word) {
        WordDictionary curr=this;
        int i=0;
        for(char c:word.toCharArray()){
            if(c=='.'){
                for(WordDictionary t:curr.children){
                    if(t!=null&&t.search(word.substring(i+1))) return true;
                    
                }
                return false;
                
            }
            if(curr.children[c-'a']==null) return false;
                curr=curr.children[c-'a'];
                i++;
        }
        return curr!=null&&curr.isEndOfWord;
    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */