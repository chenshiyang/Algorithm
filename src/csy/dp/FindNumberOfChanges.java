package csy.dp;

/**
 *
 * m种零钱组合成n元,有多少种组合
 */
public class FindNumberOfChanges {
    public int solve(int[] moneys, int sum) {
        int[][] table = new int[sum + 1][moneys.length + 1];
        // 组合成0元的方式只有一种:什么面值都不取
        for(int j = 0; j < table[0].length; j ++) {
            table[0][j] = 1;
        }
        // 什么面值都不取的情况下,组合成任何大于0的金额的方式都为0种
        for(int i = 1; i < table.length; i ++) {
            table[i][0] = 0;
        }
        for(int i = 1; i < table.length; i ++) {
            for(int j = 1; j < table[0].length; j ++) {
                //不使用面额为moneys[j-1]的钱
                table[i][j] = table[i][j - 1];
                // 加上使用面额为moneys[j-1]的钱
                if(i - moneys[j - 1] >= 0) {
                    table[i][j] += table[i - moneys[j - 1]][j];
                }
            }
        }
        printTable(table);
        return table[table.length - 1][table[0].length - 1];
    }

    private void printTable(int[][] table) {
        for(int i = 0; i < table.length; i ++) {
            for(int j = 0; j < table[0].length; j ++) {
                System.out.print(table[i][j] + "\t");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int[] moneys = {1, 2, 3, 4};
        FindNumberOfChanges so = new FindNumberOfChanges();
        System.out.println(so.solve(moneys, 10));

        int[] moneys2 = {1, 2, 5, 10};
        System.out.println(so.solve(moneys2, 5));
    }
}
