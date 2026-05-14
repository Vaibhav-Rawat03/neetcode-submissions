class Solution {
    public boolean isValidSudoku(char[][] board) {
        HashSet<String> row=new HashSet<>();
        HashSet<String> col=new HashSet<>();
        HashSet<String> box=new HashSet<>();

        for(int i=0;i<board.length;i++){
            for(int j=0;j<board.length;j++){
                char num = board[i][j];

                if(num != '.'){
                    if(row.contains(num + "at row" + i) || col.contains(num + "at col" + j) || box.contains(num + "at row" + i/3 + "at col" + j/3)){
                        return false;
                    }

                    row.add(num + "at row" + i);
                    col.add(num + "at col" + j);
                    box.add(num + "at row" + i/3 + "at col" + j/3);
                }
                
            }
        }
        return true;
    }
}