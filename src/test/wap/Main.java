package test.wap;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

/**
 * 
 * Description: Brute force.
 * 0b845170-86d0-430f-9ada-d93fa4be7ec0
 */
public class Main {
	static List<Cube> cubes;
	static boolean success;
	static int[][][] array;
	static int P;
	static List<Location> los = new ArrayList<Location>();

	public static void solve() {
		Scanner reader = new Scanner(System.in);
		while (reader.hasNext()) {
			int M = reader.nextInt();
			int N = reader.nextInt();
			P = reader.nextInt();
			array = new int[M][M][M];
			for (int i = 0; i < M; i++) {
				for (int j = 0; j < M; j++) {
					for (int k = 0; k < M; k++) {
						array[i][j][k] = reader.nextInt();
					}
				}
			}
			cubes = new ArrayList<Cube>(N);
			for (int ii = 0; ii < N; ii++) {
				int size = reader.nextInt();
				Cube cube = new Cube(size);
				for (int i = 0; i < size; i++) {
					for (int j = 0; j < size; j++) {
						for (int k = 0; k < size; k++) {
							cube.array[i][j][k] = reader.nextInt();
						}
					}
				}
				cubes.add(cube);
			}

			Stack<Location> locations = new Stack<>();
			if (deal(0, locations)) {
				for (int i = los.size() - 1; i >= 0; i--) {
					System.out.println(los.get(i));
				}
			}
		}
		reader.close();
	}

	public static boolean deal(int index, Stack<Location> locations) {
		if (success) {
			return true;
		}
		if (index == cubes.size()) {
			success = check();
			if (success) {
				while (!locations.isEmpty()) {
					los.add(locations.pop());
				}
			}
			return success;
		}
		Cube cube = cubes.get(index);
		for (int i = 0; i <= array.length - cube.array.length; i++) {
			for (int j = 0; j <= array.length - cube.array.length; j++) {
				for (int k = 0; k <= array.length - cube.array.length; k++) {
					// embed this cube into array
					embed(cube.array, i, j, k);
					Location location = new Location(i, j, k);
					locations.push(location);
					if (deal(index + 1, locations)) {
						return true;
					}
					// remove this cube from array
					remove(cube.array, i, j, k);
					locations.pop();
				}
			}
		}
		return false;
	}

	public static void embed(int[][][] a, int x, int y, int z) {
		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < a.length; j++) {
				for (int k = 0; k < a.length; k++) {
					array[x + i][y + j][z + k] += a[i][j][k];
				}
			}
		}
	}

	public static void remove(int[][][] a, int x, int y, int z) {
		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < a.length; j++) {
				for (int k = 0; k < a.length; k++) {
					array[x + i][y + j][z + k] -= a[i][j][k];
				}
			}
		}
	}

	public static boolean check() {
		for (int i = 0; i < array.length; i++) {
			for (int j = 0; j < array.length; j++) {
				for (int k = 0; k < array.length; k++) {
					if (array[i][j][k] % P != 0) {
						return false;
					}
				}
			}
		}
		return true;
	}

	public static void main(String[] args) {
		Main.solve();
	}
}

class Cube {
	int[][][] array;

	Cube() {
	}

	Cube(int size) {
		array = new int[size][size][size];
	}

	Cube(int[][][] array) {
		this.array = array;
	}
}

class Location {
	int x;
	int y;
	int z;

	Location(int x, int y, int z) {
		this.x = x;
		this.y = y;
		this.z = z;
	}

	@Override
	public String toString() {
		return x + " " + y + " " + z;
	}
}