class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        
        List<List<Integer>> ans=new ArrayList<>();

        Arrays.sort(nums);

        for(int i=0;i<nums.length-2;i++){
            if(i>0 && nums[i-1]==nums[i]){
                continue;
            }
            int l=i+1, r=nums.length-1;
            int target=0-nums[i];

            List<Integer> temp=new ArrayList<>();
            while(l<r){
                if(nums[l]+nums[r]==target){
                    temp.add(nums[i]);
                    temp.add(nums[l]);
                    temp.add(nums[r]);

                    ans.add(new ArrayList<>(temp));
                    temp.clear();
                    l++;
                    r--;

                    while(l<nums.length && nums[l-1]==nums[l]){
                        l++;
                    }

                    while(r<nums.length-1 && r>=0 && nums[r+1]==nums[r]){
                        r--;
                    }
                }
                else if(nums[l]+nums[r]>target){
                    r--;
                }
                else{
                    l++;
                }
            }
        }

        // List<List<Integer>> ans2 = new ArrayList<>(ans);
        return ans ;
    }
}