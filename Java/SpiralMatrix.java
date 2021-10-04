/**
 * Given a 2D array, print it in spiral form. See the following examples.

Examples:

Input:
        1    2   3   4
        5    6   7   8
        9   10  11  12
        13  14  15  16
Output: 
1 2 3 4 8 12 16 15 14 13 9 5 6 7 11 10 


Input:
        1   2   3   4  5   6
        7   8   9  10  11  12
        13  14  15 16  17  18
Output: 
1 2 3 4 5 6 12 18 17 16 15 14 13 7 8 9 10 11
 */


 // Java program for the above approach
import java.util.*;

class Practice {
	static int R = 4;
	static int C = 4;

	
	static void print(int arr[][], int i, int j, int m,
					int n)
	{
		
		if (i >= m || j >= n) {
			return;
		}

	
		for (int p = i; p < n; p++) {
			System.out.print(arr[i][p] + " ");
		}


		for (int p = i + 1; p < m; p++) {
			System.out.print(arr[p][n - 1] + " ");
		}

	
		if ((m - 1) != i) {
			for (int p = n - 2; p >= j; p--) {
				System.out.print(arr[m - 1][p] + " ");
			}
		}

	
		if ((n - 1) != j) {
			for (int p = m - 2; p > i; p--) {
				System.out.print(arr[p][j] + " ");
			}
		}
		print(arr, i + 1, j + 1, m - 1, n - 1);
	}

	public static void main(String[] args)
	{
		int a[][] = { { 1, 2, 3, 4 },
					{ 5, 6, 7, 8 },
					{ 9, 10, 11, 12 },
					{ 13, 14, 15, 16 } };

		
		print(a, 0, 0, R, C);
	}
}

