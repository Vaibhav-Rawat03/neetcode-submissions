class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        TreeMap<Integer, Integer> tm=new TreeMap<>(Collections.reverseOrder());

        for(int i=0;i<position.length;i++){
            tm.put(position[i], speed[i]);
        }

        Stack<Double> st=new Stack<>();

        for(Map.Entry<Integer,Integer> entry:tm.entrySet()){
            double time=( (double)(target - entry.getKey() )/ entry.getValue());

            System.out.println(time);
            if(st.isEmpty()){
                st.add(time);
            }
            else{
                if(st.peek() < time){
                    st.add(time);
                }
                else{
                    continue;
                }
            }
        }
        
        return st.size();

    }
}