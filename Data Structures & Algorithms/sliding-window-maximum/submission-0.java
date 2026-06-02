class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        
        Deque<Integer> dq = new ArrayDeque<>();

        for(int i=0;i<k;i++){
   
            while(dq.size() > 0 && nums[i]>dq.peekLast()){
                dq.removeLast();
            }
            dq.addLast(nums[i]);

        }

        int l=0, r=k-1;

        int ans[]=new int[nums.length - (k-1)];

        int ansIdx=0;

        while(r<nums.length){

            ans[ansIdx++]=dq.peekFirst();

            if(nums[l] == dq.peekFirst()){
                dq.removeFirst();
            }

            l++;
            r++;

            if(r>=nums.length){
                break;
            }

            while(dq.size() > 0 && nums[r]>dq.peekLast()){
                dq.removeLast();
            }
            dq.addLast(nums[r]);

        }

        return ans;
    }
}