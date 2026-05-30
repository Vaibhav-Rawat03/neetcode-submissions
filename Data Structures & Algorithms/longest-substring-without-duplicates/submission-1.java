class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashSet<Character> hs=new HashSet<>();

        int maxSize = 0;
        int l=0, r=l;

        while(r<s.length()){

            char rc = s.charAt(r);
            char lc = s.charAt(l);
            if(hs.contains(rc)){
                maxSize = Math.max(maxSize, hs.size());

                while(lc != rc){
                    l++;

                    hs.remove(lc);

                    lc = s.charAt(l);
                    
                }
                if(lc == rc){
                    l++;
                    r++;
                }
            }
            else{
                hs.add(rc);
                r++;
            }
        }

        return Math.max(maxSize,hs.size());
    }
}