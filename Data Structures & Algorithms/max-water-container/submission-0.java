class Solution {
    public int maxArea(int[] height) {
        int l=0, r=height.length-1;

        int ans=0;

        while(l<r){
            int water=Math.min(height[l],height[r])*(r-l);

            ans=Math.max(ans,water);

            if(height[l]<=height[r]){
                l++;
            }
            else{
                r--;
            }
        }

        return ans;
    }
}