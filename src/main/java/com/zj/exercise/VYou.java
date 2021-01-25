package com.zj.exercise;

import org.junit.Test;

/**
 * @program algorithm
 * @description: Given an m x n 2d grid map of '1's (land) and '0's (water), return the number of islands which the sum of 1‘s on the island equal S (S>0).
 * An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically.
 * You may assume all four edges of the grid are all surrounded by water.
 * Example 1:
 * Input: grid = [
 * ["1","1","1","1","0"],
 * ["1","1","0","1","0"],
 * ["1","1","0","0","0"],
 * ["0","0","0","0","0"]
 * ], S = 9
 * Output: 1
 * public int sumIslands(char[][] grid, int S){
 * // implementation
 * }
 * //----------
 * // unit test
 * //----------
 * Tip: using Junit4.
 * public void sumIslandsTest(){
 * char[][] grid = [
 * ["1","1","1","1","0"],
 * ["1","1","0","1","0"],
 * ["1","1","0","0","0"],
 * ["0","0","0","0","0"]
 * ];
 * int S = 8;
 * // test implementation
 * }
 * @author: zhangbo
 * @create: 2021/01/19 10:35
 */

public class VYou {
    private int row = 0;
    private int col = 0;
    private int mark = 0;
    private int spaceNum = 0;

    /**
     * 解题思路：深度优先
     * @param grid
     * @param S
     * @return
     */
    public int numIslands(char[][] grid, int S){

        if(grid.length == 0 || grid[0].length == '0'){
            return 0;
        }
        row = grid.length;
        col = grid[0].length;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if(grid[i][j] == '0') continue;
                dfs(grid, i, j);
                //判断 isLands 与 S 是否相等
                if(S == spaceNum){
                    mark++;
                }
                spaceNum = 0;
            }
        }
        return mark;
    }

    private void dfs(char[][] grid, int i, int j){
        //越界判断
        if(i < 0 || j< 0 || i>= row||j >=col){
            return;
        }
        if(grid[i][j] == '0'){
            return;
        }
        grid[i][j] = '0';
        spaceNum ++;
        //对下上右左递归判断
        dfs(grid, i + 1, j);
        dfs(grid, i - 1, j);
        dfs(grid, i, j + 1);
        dfs(grid, i, j - 1);
    }






    @Test
    public void sumIslandsTest() {
        // test implementation
        char[][] grid = new char[][]{
                {'1', '1', '1', '1', '0'},
                {'1', '1', '0', '1', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '0', '0', '0'}
        };
        int S = 8;
        System.out.println(this.sumIslands(grid, S));
    }

    /**
     * implementation
     * @param grid
     * @param S
     * @return
     */
    public int sumIslands(char[][] grid, int S) {
        // implementation
        return this.numIslands(grid, S);
    }
}

