class Solution {

    public String encode(List<String> strs) {

        StringBuilder sb=new StringBuilder();
        for(int i=0;i<strs.size();i++){
            String s=strs.get(i);

            // Char encarr[]=new Char[s.size()];
            // int j=0;
            // for(Char c:s.toCharArray()){
            //     encarr[j++]=c + 'a';
            // }

            sb.append(s);
            sb.append("#");
            sb.append('0');
            sb.append("#");
        }
        
        System.out.print(sb);
        return sb.toString();
    }

    public List<String> decode(String str) {

        int j=0;

        char arr[]=str.toCharArray();

        List<String> ans=new ArrayList<>();

        for(int i=0;i<arr.length-1;i++){

            // if(arr[i]=='#' && Character.isDigit(arr[i+1])==true){
            //     StringBuilder sb=new StringBuilder();
            //     while(j< i){
            //         sb.append(arr[j++]);
            //     }

            //     ans.add(sb.toString());
            //     j=j+2;
            // }

            if(arr[i]=='#' && arr[i+1]=='0' && arr[i+2]=='#'){
                StringBuilder sb=new StringBuilder();
                while(j< i){
                    sb.append(arr[j++]);
                }

                ans.add(sb.toString());
                j=j+3;
            }
        }

        return ans;
    }
}
