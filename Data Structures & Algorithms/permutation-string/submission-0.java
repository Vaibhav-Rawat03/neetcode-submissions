class Solution {

    public boolean sameMap(HashMap<Character, Integer> hm, HashMap<Character, Integer> hm2){

        for(Map.Entry<Character, Integer> entry: hm.entrySet()){
            Character key=entry.getKey();
            int value= entry.getValue();

            if(hm2.containsKey(key) && hm2.get(key) == value){
                continue;
            }
            else{
                return false;
            }
        }

        return true;
    }

    public boolean checkInclusion(String s1, String s2) {
        
        if(s2.length()<s1.length()){
            return false;
        }

        HashMap<Character, Integer> hm=new HashMap<>();

        for(char c:s1.toCharArray()){
            hm.put(c, hm.getOrDefault(c, 0) + 1);
        }

        int l=0, r=0;

        HashMap<Character, Integer> hm2=new HashMap<>();

        while(r<s2.length()){

            if(!hm.containsKey(s2.charAt(r))){
                l++;
                r=l;

                hm2.clear();
            }
            else{
                
                hm2.put(s2.charAt(r), hm2.getOrDefault(s2.charAt(r), 0) + 1);
                r++;
                
                if(r-l > s1.length()-1){

                    if(sameMap(hm, hm2) ==true){
                        return true;
                    }

                    hm2.put(s2.charAt(l), hm2.get(s2.charAt(l)) - 1);

                    if(hm2.get(s2.charAt(l)) == 0){
                        hm2.remove(s2.charAt(l));
                    }
                    l++;
                }
            }
        }

        return false;
    }
}