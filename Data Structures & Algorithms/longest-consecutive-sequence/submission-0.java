class Solution {
    public int longestConsecutive(int[] nums) {
        HashSet<Integer> hs=new HashSet<>();

        for(int i:nums){
            hs.add(i);
        }

        int ans=0;
        for(int i=0;i<nums.length;i++){
            if(!hs.contains(nums[i]-1)){
                int size=0;
                while(hs.contains(nums[i]+size)){
                    size++;
                }
                ans=Math.max(ans,size); 
            }
        }

        return ans;
    }
}