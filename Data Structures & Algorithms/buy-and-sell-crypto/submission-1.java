class Solution {
    public int maxProfit(int[] prices) {
        int ans=0;

        int minprice=Integer.MAX_VALUE;
        for(int i=0;i<prices.length;i++){
            
            minprice=Math.min(minprice, prices[i]);
            if(minprice<prices[i]){
                ans=Math.max(ans, prices[i]-minprice);
            }
        }

        return ans;
    }
}