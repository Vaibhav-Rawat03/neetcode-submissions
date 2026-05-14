class Solution {
    public int[] productExceptSelf(int[] nums) {
        int temp[]=new int [nums.length];
        
        temp[0]=1;
        for(int i=1;i<nums.length;i++){
            temp[i]=nums[i-1]*temp[i-1];
        }

        int postfix=1;

        for(int i=nums.length-1;i>=0;i--){
            temp[i]=postfix*temp[i];

            postfix=postfix*nums[i];
        }

        return temp;
    }
}