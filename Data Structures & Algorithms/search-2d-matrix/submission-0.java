class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int midArr=0;

        int leftArr=0, rightArr=matrix.length-1;
        
        while(leftArr<=rightArr){
            midArr=(leftArr+rightArr)/2;

            if(matrix[midArr][0] <= target && matrix[midArr][matrix[0].length-1]>=target){
                break;
            }
            else if(matrix[midArr][0] > target){
                rightArr=midArr-1;
            }
            else{
                leftArr=midArr+1;
            }
        }

        int mid;

        int left=0, right=matrix[0].length-1;

        while(left<=right){
            mid=(left+right)/2;

            if(matrix[midArr][mid]==target){
                return true;
            }
            else if(matrix[midArr][mid]<target){
                left=mid+1;
            }
            else{
                right=mid-1;
            }
        }

        return false;
    }
}