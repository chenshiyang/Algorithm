package csy.backtracking;

public class EightQueen {
    public void solve(int[][] table) {
        if(null == table || table.length == 0) {
            return;
        }
        //列
        boolean[] yarry = new boolean[table.length];
        //左斜
        boolean[] larry = new boolean[2 * table.length - 1];
        //右斜
        boolean[] rarry = new boolean[2 * table.length - 1];
        backtrack(table, yarry, larry, rarry, 0, 0);
    }

    private void backtrack(int[][] table, boolean[] yarry, boolean[] larry, boolean[] rarry, int row, int count) {
        //如果已经处理完所有行,说明找到一种解法
        if(count == yarry.length) {
            printSolution(table);
            return;
        }
        for(int col = 0; col < yarry.length; col ++) {
            //根据当前的row和col计算左斜行数和右斜行数
            int l = row + col;
            int r = row - col + 7;
            //如果对应的列或左斜行或右斜行已被占用
            if(yarry[col] || larry[l] || rarry[r]) {
                continue;
            }
            //未被占用, 将皇后放在table[row][col]处
            table[row][col] = 1;
            //占用对应的列和斜行
            yarry[col] = true;
            larry[l] = true;
            rarry[r] = true;
            //递归进入下一行
            backtrack(table, yarry, larry, rarry, row + 1, count + 1);
            //恢复
            table[row][col] = 0;
            yarry[col] = false;
            larry[l] = false;
            rarry[r] = false;

//            //不在table[row][col]放置皇后
//            backtrack(table, yarry, larry, rarry, row + 1, count);
        }
    }

    private void printSolution(int[][] table) {
        for(int i = 0; i < table.length; i ++) {
            for(int j = 0; j < table[0].length; j ++) {
                System.out.print(table[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println("===============");
    }

    public static void main(String[] args) {
        int[][] table = new int[8][8];
        EightQueen so = new EightQueen();
        so.solve(table);
    }
}
