class MinStack {
    ArrayList<Integer> prefix=new ArrayList<>();
    Stack<Integer> st=new Stack<>();
    public MinStack() {
        st=new Stack<>();
    }
    
    public void push(int val) {
        st.add(val);

        if(prefix.size()!=0){
            prefix.add(prefix.size(), Math.min(prefix.get(prefix.size()-1), val));
        }
        else{
            prefix.add(val);
        }
        
    }
    
    public void pop() {
        st.pop();

        prefix.remove(prefix.size()-1);
    }
    
    public int top() {
        return st.peek();
    }
    
    public int getMin() {
        return prefix.get(prefix.size()-1);
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */