class Solution {

    public String encode(List<String> strs) {
        String enc="";

        for(int i=0;i<strs.size();i++){
            String len=String.valueOf(strs.get(i).length());
            enc+=len;
            enc+="#";
            enc+=strs.get(i);        
        }
        System.out.println(enc);
        return enc;
    }

    public List<String> decode(String str) {
        List<String> arr=new ArrayList<>();
        String s="";
        int i=0,count=0;
        while(i<str.length()){
            if(str.charAt(i)=='#'){
                int l=Integer.parseInt(str.substring(i-count,i));

                for(int j=i+1;j<=i+l;j++){
                    s+=str.charAt(j);
                }
                arr.add(s);
                s="";
                i+=l+1;
                count=0;
            }
            else{
                count++;
                i++;
            }
        }
        return arr;
    }
}
