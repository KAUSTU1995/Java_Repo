package com.basic1;

public class ConcentricSquareSum {

	public static void main(String[] args) {
		int arr[][]={{4,7,8,9,3}, 
			{1, 3, 0, 9, 2}, 
			{5, 9, 9, 3, 1}, 
			{6, 7, 6, 6, 0}, 
			{3, 4, 2, 1, 5 }};
		concentricsum(arr);
		// TODO Auto-generated method stub

	}

	private static void concentricsum(int[][] arr) {
		// TODO Auto-generated method stub

		int n = arr.length;
		int row = arr.length;
		int column = row;
		int sum = 0, count = 0;
		for (int k = 0; k < Math.ceil(n/2); k++) {
			for (int i = k; i < row-k; i++) {
				for (int j = k; j < column-k; j++) {
					if (i == k) {
						sum += arr[i][j];
					}
					if (i != count && i!=n-1-count  &&(j==count || j==n-1-count)) {
						sum += arr[i][j];
					}
					/*if (j == n - 1 - count  && i!=count) {
						sum += arr[i][j];
					}*/
					if (i == n - 1 - count) {
						sum += arr[i][j];
					}

				}

			}
			System.out.println(sum);
			sum=0;

		}

	}
}
