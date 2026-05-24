class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        
        int maxSpeed=0;
        for(int i:piles){
            maxSpeed=Math.max(maxSpeed, i);
        }

        int otherAns=maxSpeed;
        int minSpeed=1;
        int avgSpeed=0;
        while(minSpeed<=maxSpeed){
            avgSpeed=(minSpeed+maxSpeed)/2;

            long time=0;
            for(int i: piles){
                int timePile=(int)(Math.ceil((double)i/avgSpeed));
                time=time+timePile;
                // System.out.print(timePile + " ");
            }

            // System.out.println("Avg = " + avgSpeed + " Min = " + minSpeed + " Max = " + maxSpeed + " other = " + otherAns);

            if(time<=h){
                maxSpeed=avgSpeed-1;
                otherAns=Math.min(otherAns, avgSpeed);
            }   
            else{
                minSpeed=avgSpeed+1;
            }
            // else{
            //     maxSpeed=avgSpeed-1;
            //     otherAns=Math.min(otherAns, avgSpeed);
            // }
        }

        // System.out.println("Final Avg = " + avgSpeed + " Final Min = " + minSpeed + " Final Max = " + maxSpeed + " Final other = " + otherAns);
        return otherAns;
    }
}