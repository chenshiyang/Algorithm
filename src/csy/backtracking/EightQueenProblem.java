package csy.backtracking;

/**
 * 
 * Description: 
 */
public class EightQueenProblem {
	public static void backtrack(boolean[][] table, boolean[] row, boolean[] col, boolean[] leftSlant, 
			boolean[] rightSlant, int index) {
		
		//base condition
		if(index == 8) {
			printTable(table);
			return;
		}
		
		for(int j = 0; j < 8; ++ j) {
			if(!dangerous(row, col, leftSlant, rightSlant, index, j)) {
				table[index][j] = true;
				row[index] = true;
				col[j] = true;
				leftSlant[index + j] = true;
				rightSlant[index - j + 7] = true;
				backtrack(table, row, col, leftSlant, rightSlant, index + 1);//dive into next row.
				
				//recover.
				table[index][j] = false;
				row[index] = false;
				col[j] = false;
				leftSlant[index + j] = false;
				rightSlant[index - j + 7] = false;
			}
		}
	}
	
	public static void solve(boolean[][] table) {
		//if we have some initialization conditions, we can just set here.
		boolean[] row = new boolean[8];
		boolean[] col = new boolean[8];
		boolean[] leftSlant = new boolean[15];
		boolean[] rightSlant = new boolean[15];
		backtrack(table, row, col, leftSlant, rightSlant, 0);
	}
	
	/**
	 * @param row ----
	 * @param col || 
	 * @param leftSlant like this: //
	 * @param rightSlant like this: \\
	 * @param i row index
	 * @param j col index
	 * @return
	 */
	public static boolean dangerous(boolean[] row, boolean[] col, boolean[] leftSlant, boolean[] rightSlant, int i, int j) {
		return(row[i] || col[j] || leftSlant[i + j] || rightSlant[i + 7 - j]);
	}
	
	public static void printTable(boolean[][] table) {
		System.out.println("A valid solution:");
		for(int i = 0; i < table.length; ++ i) {
			for(int j = 0; j < table[0].length; ++ j) {
				System.out.print((table[i][j] ? "Q " : "+ "));
			}
			System.out.println();
		}
		System.out.println();
	}
	
	public static void main(String[] args) {
		boolean[][] table = new boolean[8][8];
		EightQueenProblem.solve(table);
	}
}
