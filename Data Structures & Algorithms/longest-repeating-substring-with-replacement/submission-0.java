class Solution {

    public int maxFreq(HashMap<Character , Integer> hm){

        if(hm.size()==0){
            return 0;
        }

        int maxFreq=0;

        for(int value:hm.values()){    
                maxFreq=Math.max(maxFreq, value);
            }

        return maxFreq;
    }

    public int characterReplacement(String s, int k) {
        
        HashMap<Character, Integer> hm=new HashMap<>();
        int l=0, r=l;

        int ans=0;
        
        int maxFreq=0;

        while(r<s.length()){

            char lc=s.charAt(l);
            char rc=s.charAt(r);

            int windowSize = r - l + 1;

            hm.put(rc, hm.getOrDefault(rc, 0) + 1);

            maxFreq = maxFreq(hm);

            if(windowSize - maxFreq <= k ){
                ans=Math.max(ans, windowSize);
            }
            else{

                while(windowSize - maxFreq > k){
                    hm.put(lc, hm.get(lc) - 1);

                    l++;

                    lc=s.charAt(l);

                    maxFreq = maxFreq(hm);
                    windowSize = r - l + 1;
                }

            }

            r++;
        }

        return ans;
    }
}