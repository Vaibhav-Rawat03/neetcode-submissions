class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        
        int small[], large[];

        int len1=nums1.length, len2=nums2.length;
        if(len1 <= len2){
            small=nums1;
            large=nums2;
        }
        else{
            small=nums2;
            large=nums1;
        }

        int total=len1+len2;
        int half=total/2;

        int l=0, r=small.length-1;
        while(true){
            int mid=(int)Math.floor((l+r)/2.0);

            int largearrHalf=half - mid - 2; 

            int smallMid;
            int smallRight;
            if(mid>=0){
                smallMid=small[mid];
            }
            else{
                smallMid=Integer.MIN_VALUE;
            }

            if(mid+1<=small.length-1){
                smallRight=small[mid+1];
            }
            else{
                smallRight=Integer.MAX_VALUE;
            }
            
            int largeMid;
            int largeRight;
            if(largearrHalf>=0){
                largeMid=large[largearrHalf];
            }
            else{
                largeMid=Integer.MIN_VALUE;
            }

            if(largearrHalf + 1 <=large.length-1){
                largeRight = large[largearrHalf + 1];
            }
            else{
                largeRight=Integer.MAX_VALUE;
            }
            

            if(smallMid<=largeRight && largeMid<=smallRight){  //correct partition

                if(total%2==0){
                    return ((double)Math.max(smallMid, largeMid) + Math.min(smallRight, largeRight))/2;
                }

                return Math.min(smallRight, largeRight);
            }

            else if(smallMid>largeRight){
                r = mid - 1;
            }

            else{
                l = mid + 1;
            }
            
        }
    }
}