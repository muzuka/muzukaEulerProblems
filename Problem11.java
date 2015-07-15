
import java.util.Scanner;
import java.io.*;

public class Problem11 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		Scanner scan = new Scanner("grid.txt");

		try {
			scan = new Scanner(new File("grid.txt"));
		}
		catch(FileNotFoundException e) {
			System.out.println("File not found!");
		}

		int grid[][] = new int[20][20];
		long vert, horz, rdiag, ldiag;
		
		for(int i = 0; i < 20; i++) {
			for(int j = 0; j < 20; j++) {
				grid[i][j] = Integer.parseInt(scan.next());
			}
		}
		
		vert = largestVerticalProduct(grid, 20, 20, 4);
		horz = largestHorizontalProduct(grid, 20, 20, 4);
		ldiag = largestLeftDiagonalProduct(grid, 20, 20, 4);
		rdiag = largestRightDiagonalProduct(grid, 20, 20, 4);
		
		System.out.println(vert);
		System.out.println(horz);
		System.out.println(ldiag);
		System.out.println(rdiag);

	}
	
	public static long largestLeftDiagonalProduct(int g[][], int row, int col, int size) {

		long max = 0;
		long pro = 1;

		for(int i = 0; i < row-size; i++) {
			for(int j = 3; j < col;j++) {
				for(int k = 0; k < size; k++) {
					pro *= g[i+k][j-k];
				}

				if(pro > max) {
					max = pro;
					System.out.printf("%d %d\n", i, j);
				}

				pro = 1;
			}
		}
		return max;
	}
	
	public static long largestRightDiagonalProduct(int g[][], int row, int col, int size) {

		long max = 0;
		long pro = 1;

		for(int i = 0; i < row-size; i++) {
			for(int j = 0; j < col-size;j++) {
				for(int k = 0; k < size; k++) {
					pro *= g[i+k][j+k];
				}

				if(pro > max) {
					max = pro;
					System.out.printf("%d %d\n", i, j);
				}

				pro = 1;
			}
		}
		return max;
	}
	
	public static long largestHorizontalProduct(int g[][], int row, int col, int size) {

		long max = 0;
		long pro = 1;

		for(int i = 0; i < row; i++) {
			for(int j = 0; j < col-size;j++) {
				for(int k = 0; k < size; k++) {
					pro *= g[i][j+k];
				}

				if(pro > max) {
					max = pro;
					System.out.printf("%d %d\n", i, j);
				}

				pro = 1;
			}
		}
		return max;
	}
	
	public static long largestVerticalProduct(int g[][], int row, int col, int size) {

		long max = 0;
		long pro = 1;

		for(int i = 0; i < row-size; i++) {
			for(int j = 0; j < col;j++) {
				for(int k = 0; k < size; k++) {
					pro *= g[i+k][j];
				}

				if(pro > max) {
					max = pro;
					System.out.printf("%d %d\n", i, j);
				}
				
				pro = 1;
			}
		}
		return max;
	}

}
