class Solution {
    public int trap(int[] height) {
        
        int ans=0;

        int l=0, r=height.length-1;
        int maxL=height[l], maxR=height[r];

        while(l<=r){
            int water;
            if(maxL <= maxR){
                water=Math.max(0,Math.min(maxL,maxR)-height[l]);
                maxL=Math.max(maxL, height[l]);
                l++;
            }
            else{
                water=Math.max(0,Math.min(maxL,maxR)-height[r]);
                maxR=Math.max(maxR, height[r]);
                r--;
            }

            ans=ans+water;
        }

        return ans;
    }
}