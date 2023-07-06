public class NumberIslands {

//    Leetcode problem - 200. Number of Islands
//    https://leetcode.com/problems/number-of-islands/description/

    public int numIslands(char[][] mat) {

        int count =0;
        for(int i=0; i<mat.length; i++){
            for(int j=0; j<mat[i].length; j++){
                if(mat[i][j]=='1'){
                    island(mat, i, j);
                    count++;
                }
            }
        }
        return count;
    }

    public void island(char[][] mat, int i, int j){

        if(i<0 || j<0 || i>mat.length-1 || j>mat[0].length-1)return;
        if(mat[i][j]=='0')return;

        mat[i][j]='0';

        island(mat, i+1, j);
        island(mat, i-1, j);
        island(mat, i, j+1);
        island(mat, i, j-1);
    }

}
