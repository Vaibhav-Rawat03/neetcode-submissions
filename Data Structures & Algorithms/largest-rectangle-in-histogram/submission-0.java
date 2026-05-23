class Solution {
    public int largestRectangleArea(int[] heights) {
        Stack<int[]> st=new Stack<>();

        int maxArea=0;

        for(int i=0;i<heights.length;i++){
            int index=i;

            while(!st.isEmpty() && st.peek()[1]>heights[i]){
                index=st.peek()[0];
                int h=st.pop()[1];

                maxArea=Math.max(maxArea, h*(i-index));
            }
            int arr[]=new int[2];
            arr[0]=index;
            arr[1]=heights[i];
            st.add(arr);
        }

        while(!st.isEmpty()){
            int idx=st.peek()[0];
            int h=st.pop()[1];

            maxArea=Math.max(maxArea, h*(heights.length-idx));
        }

        return maxArea;
    }
}