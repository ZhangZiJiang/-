package com.zj.test;

import org.junit.Test;

import java.util.ArrayList;

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

public class Two {

    @Test
    public void sumIslandsTest() {
        char[][] grid = new char[][]{
                {'1', '1', '1', '1', '0'},
                {'1', '1', '0', '1', '0'},
                {'1', '1', '0', '0', '1'},
                {'0', '0', '0', '0', '1'}
        };

        int S = 9;
        // test implementation
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
        return this.helper(grid, S);
    }


    private int row;
    private int col;
    /**
     * 思路：使用并查集这种方式，统计岛屿的数量，当等于 S 时，将返回值加 1，最后返回此值
     *
     * @param grid
     * @param S
     * @return
     */
    private int helper(char[][] grid, int S) {

        //校验
        if(grid.length == 0){
            return 0;
        }
        row = grid.length;
        col = grid[0].length;

        //等于S的岛屿数量
        int islands = 0;
        int spaces = 0;
        ArrayList<Integer> arr = new ArrayList<>();
        int mark = 0;
        UnionFind unionFind = new UnionFind(row * col);
        int[][] directions = {{1, 0}, {0, 1}};
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j] == '0') {
                    islands++;
                } else {
                    // 此时 grid[i][j] == '1'
                    // 分别判断下和右是否为1
                    for (int[] direction : directions) {
                        int newX = i + direction[0];//1 + i
                        int newY = j + direction[1];//0 + j
                        // 先判断坐标合法，再检查右边一格和下边一格是否是陆地
                        if (newX < row && newY < col && grid[newX][newY] == '1') {
                            spaces++;
                            unionFind.union(getIndex(i, j), getIndex(newX, newY));
                        }
                    }
                    System.out.println("1这里：" + (unionFind.getCount() - islands));
                }
                System.out.println("2这里：" + (unionFind.getCount() - islands));
            }
            System.out.println("3这里：" + (unionFind.getCount() - islands));
        }
        System.out.println("最初返回值：" + (unionFind.getCount() - islands));
        return mark;

    }
    private int getIndex(int i, int j) {
        return i * col + j;
    }


    private class UnionFind{
        /**
         * 连通分量的个数
         */
        private int count;
        private int[] parent;

        public int getCount() {
            return count;
        }

        public UnionFind(int n) {
            this.count = n;
            parent = new int[n];
            for (int i = 0; i < n; i++) {
                parent[i] = i;
            }
        }

        private int find(int x) {
            while (x != parent[x]) {
                parent[x] = parent[parent[x]];
                x = parent[x];
            }
            return x;
        }

        public void union(int x, int y) {
            int xRoot = find(x);
            int yRoot = find(y);
            if (xRoot == yRoot) {
                return;
            }

            parent[xRoot] = yRoot;
            count--;
        }

    }
}
