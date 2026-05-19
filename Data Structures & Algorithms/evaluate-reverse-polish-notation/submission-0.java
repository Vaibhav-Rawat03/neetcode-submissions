class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> st=new Stack<>();

        for(String c:tokens){
            if(c.equals("+")){
                int a=st.pop();
                int b=st.pop();

                st.add(a+b);
            }
            else if(c.equals("*")){
                int a=st.pop();
                int b=st.pop();

                st.add(a*b);
            }
            else if(c.equals("-")){
                int a=st.pop();
                int b=st.pop();

                st.add(b-a);
            }
            else if(c.equals("/")){
                int a=st.pop();
                int b=st.pop();

                st.add(b/a);
            }
            else{
                st.add(Integer.parseInt(c));
            }
        }

        return st.pop();
    }
}