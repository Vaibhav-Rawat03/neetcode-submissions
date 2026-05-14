class Solution {
    public int longestConsecutive(int[] nums) {
        HashSet<Integer> hs=new HashSet<>();

        for(int i:nums){
            hs.add(i);
        }

        int ans=0;
        for(int i:hs){                  //iterate over set instead of array to save time with duplicates
            if(!hs.contains(i-1)){
                int size=1;
                while(hs.contains(i+size)){
                    size++;
                }
                ans=Math.max(ans,size); 
            }
        }

        return ans;
    }
}
