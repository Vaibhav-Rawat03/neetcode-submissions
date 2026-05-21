class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        Stack<int[]> st=new Stack<>();
        int ans[]=new int[temperatures.length];

        for(int i=0;i<temperatures.length;i++){
            int temp[]=new int[2];

            if(st.size()==0){
                temp[0]=temperatures[i];
                temp[1]=i;
                st.add(temp);
            }
            else{
                
                while(st.size()>0 && temperatures[i]>st.peek()[0]){
                    int v=st.peek()[1];
                    ans[v]=i-v;
                    st.pop();
                }
                temp[0]=temperatures[i];
                temp[1]=i;
                st.add(temp);
            }
        }

        return ans;
    }
}