class Solution {
    public int trap(int[] height) {
        int prefix[]=new int[height.length];

        for(int i=1;i<height.length;i++){
            prefix[i]=Math.max(prefix[i-1], height[i-1]);
        }

        int postfix[]=new int[height.length];

        for(int j=height.length-2;j>-1;j--){
            postfix[j]=Math.max(postfix[j+1], height[j+1]);
        }

        int ans=0;

        for(int i=0;i<height.length;i++){
            int water=0;

            water=Math.min(prefix[i],postfix[i])-height[i];

            if(water>0){
                ans=ans+water;
            }
        }

        return ans;
    }
}