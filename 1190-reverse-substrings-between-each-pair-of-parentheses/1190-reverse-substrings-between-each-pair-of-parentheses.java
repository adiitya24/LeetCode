class Solution {
    public String reverseParentheses(String s) {
        Stack<Integer> st=new Stack<>();
        StringBuilder ans=new StringBuilder();
        for(char c:s.toCharArray()){
           if(c=='('){
            st.push(ans.length());
            }
           else if(c==')'){
            int start=st.pop();
            reverse(ans,start,ans.length()-1);
           }
           else{
            ans.append(c);
           }
        }
         return ans.toString();
    }
   private void reverse(StringBuilder sb, int start, int end) {
        while (start < end) {
            char temp = sb.charAt(start);
            sb.setCharAt(start++, sb.charAt(end));
            sb.setCharAt(end--, temp);
        }
   }
}