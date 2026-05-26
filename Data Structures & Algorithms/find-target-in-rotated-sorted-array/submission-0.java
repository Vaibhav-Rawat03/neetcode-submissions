class Solution {
    public int search(int[] nums, int target) {
        
        // Find the Min element
        int l=0, r=nums.length-1;

        while(l<r){
            int m=(l+r)/2;
            if(nums[m]<nums[r]){
                r=m;
            }
            else{
                l=m+1;
            }
        }

        // System.out.print(l);

        // Now set the l and right according the portion where target is
        if(target>=nums[l] && target <=nums[nums.length-1]){
            r=nums.length-1;
        }
        else{
            r=l-1;
            l=0;
        }

        // Normal binary search
        while(l<=r){
            int mid=(l+r)/2;

            if(nums[mid]==target){
                return mid;
            }
            else if(nums[mid]>target){
                r=mid-1;
            }
            else{
                l=mid+1;
            }
        }

        return -1;
    }
}