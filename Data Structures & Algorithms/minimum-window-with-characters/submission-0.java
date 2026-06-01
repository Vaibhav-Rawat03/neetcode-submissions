class Solution {

    public String minWindow(String s, String t) {
        if(s.length() < t.length() || t.length() == 0){
            return "";
        }

        HashMap<Character, Integer> hm=new HashMap<>();
        
        for(char c: t.toCharArray()){
            hm.put(c, hm.getOrDefault(c, 0) + 1);
        }

        int l=0, r=0;

        int size = s.length();

        int have=0, need=hm.size();

        int ans[]=new int[2];

        Arrays.fill(ans, -1);

        int minLength = Integer.MAX_VALUE;
       
        HashMap<Character, Integer> window = new HashMap<>();

        while(r<size){

            Character rc = s.charAt(r);
            window.put(rc, window.getOrDefault(rc , 0) + 1);

            if(hm.containsKey(rc) && window.get(rc).equals(hm.get(rc))){
                have++;
            }

            while(have == need){
                
                if(r - l + 1 < minLength){
                    ans[0]=l;
                    ans[1]=r;

                    minLength = r - l + 1;
                }

                window.put(s.charAt(l), window.get(s.charAt(l)) - 1);

                if(hm.containsKey(s.charAt(l)) && window.get(s.charAt(l)) < hm.get(s.charAt(l))){
                    have--;
                }

                l++;
            }

            r++;
        }

        String str;
        if(minLength == Integer.MAX_VALUE){
            str = "";
        }
        else{
            str = s.substring(ans[0] , ans[1]+1);
        }

        return str;
    }
}