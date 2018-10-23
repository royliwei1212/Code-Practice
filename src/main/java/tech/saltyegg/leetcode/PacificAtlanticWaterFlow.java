package tech.saltyegg.leetcode;

import java.util.ArrayList;
import java.util.List;

public class PacificAtlanticWaterFlow {

    public List<int[]> pacificAtlantic(int[][] matrix) {
        List<int[]> result = new ArrayList<>();
        if(matrix == null || matrix.length == 0||matrix[0] == null || matrix[0].length == 0) return result;
        int r = matrix.length;
        int c = matrix[0].length;

        int[][] dir = new int[][]{{0,1},{1,0}, {-1,0},{0,-1}};
        boolean[][] cp = new boolean[r][c];
        for(int i =0;i<c; i++) {cp[0][i]=true;helper(cp, matrix, dir, 0, i);}
        for(int i =0;i<r; i++) {cp[i][0]=true;helper(cp, matrix, dir, i, 0);}

        boolean[][] ca = new boolean[r][c];
        for(int i =0;i<c; i++) {ca[r-1][i]=true;helper(ca, matrix, dir, r-1, i);}
        for(int i =0;i<r; i++) {ca[i][c-1]=true;helper(ca, matrix, dir, i, c-1);}

        for(int i = 0; i < r; i++){
            for(int j = 0; j < c; j++){
                if(cp[i][j] && ca[i][j]) result.add(new int[]{i,j});
            }
        }
        return result;
    }

    private void helper(boolean[][] c, int[][] matrix, int[][] dir, int m, int n){
        for(int i = 0 ;i<4; i++){
            int x = m+dir[i][0], y = n + dir[i][1];
            if(x <0 || y < 0 || x >= matrix.length || y >= matrix[0].length || !c[m][n] || matrix[m][n] > matrix[x][y] || c[x][y]) continue;
            c[x][y] = true;
            helper(c, matrix,  dir, x, y);
        }
    }
}
