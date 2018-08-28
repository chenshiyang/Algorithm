package csy.dfs;

public class NumberOfIslands {
    public int numIslands(char[][] grid) {
        if(null == grid || grid.length < 1 || grid[0].length < 1) {
            return 0;
        }
        int[][] table = new int[grid.length][grid[0].length];
//        int islandNumber = 1;//岛屿的编号
        int numIsland = 0;//岛屿数量
        for(int i = 0; i < grid.length; i ++) {
            for(int j = 0; j < grid[0].length; j ++) {
                if(grid[i][j] == '1' && table[i][j] == 0) {
                    numIsland += 1;
                    dfs(grid, numIsland, i, j, table);
                }
            }
        }
        return numIsland;
    }

    private void dfs(char[][] grid, int islandNumber, int i, int j, int[][] table) {
        //如果越界 或者 该点已被访问
        if(i < 0 || j < 0 || i >= grid.length || j >= grid[0].length || table[i][j] > 0 || grid[i][j] == '0') {
            return;
        }
        table[i][j] = islandNumber;
        dfs(grid, islandNumber, i - 1, j, table);//上
        dfs(grid, islandNumber, i + 1, j, table);//下
        dfs(grid, islandNumber, i, j - 1, table);//左
        dfs(grid, islandNumber, i, j + 1, table);//右
    }

    public static void main(String[] args) {
        NumberOfIslands so = new NumberOfIslands();
        char[][] grid = {
                "11110".toCharArray(),
                "11010".toCharArray(),
                "11000".toCharArray(),
                "00000".toCharArray()
        };
        System.out.println(so.numIslands(grid));
        char[][] grid2 = {
                "11000".toCharArray(),
                "11000".toCharArray(),
                "00100".toCharArray(),
                "00011".toCharArray()
        };
        System.out.println(so.numIslands(grid2));

        char[][] grid3 = {
                "11000".toCharArray(),
                "11100".toCharArray(),
                "00100".toCharArray(),
                "00111".toCharArray()
        };
        System.out.println(so.numIslands(grid3));
        char[][] grid4 = {
                "110000101".toCharArray(),

        };
        System.out.println(so.numIslands(grid4));
    }
}
