class Solution {
    public boolean isValid(String s) {
        if(s.length()%2!=0){
           return false;
       }
        Stack<Character> st=new Stack<>();

        for(char c:s.toCharArray()){
            if(st.isEmpty()){
                st.add(c);
            }
            else{
                if((st.peek()=='(' && c==')') || (st.peek()=='[' && c==']') || (st.peek()=='{' && c=='}')){
                    st.pop();
                }
                else{
                    st.add(c);
                }
            }
        }

        return st.size()==0;
    }
}