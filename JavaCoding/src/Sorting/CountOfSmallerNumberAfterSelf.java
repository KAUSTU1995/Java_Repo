package Sorting;
//The approach does not work so please visit this link for correct and optimized approach
//https://www.geeksforgeeks.org/count-of-smaller-elements-on-right-side-of-each-element-in-an-array-using-merge-sort/?ref=rp
public class CountOfSmallerNumberAfterSelf {

	public static void main(String[] args) {
		CountOfSmallerNumberAfterSelf obj = new CountOfSmallerNumberAfterSelf();
		int arr[] = { 64, 150, 31, 249, 328, 125, 365, 353, 84, 204, 118 };
		for(int i:obj.solve(arr))
		System.out.print(i+" ");

	}
	public int[] solve(int[] A) {
		int len = A.length;
		int[] arr = new int[len];
		if (len == 0)
			return arr;
		arr[len - 1] = 0;
		int i = len - 2;
		int j = len - 1;
		int count = 0;
		while (i <= j && i >= 0 && j >= 0) {
			if ((i + 1) == j && A[i] > A[j]) {
				arr[i] = arr[j] + 1;
				i--;
				j--;
				continue;
			} else if ((i + 1) == j && A[i] == A[j]) {
				arr[i] = arr[j]+count;
				i--;
				j--;
				count=0;
				continue;
			}
			j++;
			if (j < len && A[i] == A[j]) {
				arr[i] = arr[j];
				i--;
				j = i + 1;
				count=0;
			}
			else if (j < len && A[i] > A[j]) {
				count++;
			}
			else if (j >= len) {
				arr[i] = count;
				count=0;
				i--;
				j = i + 1;
			}
		}
		return arr;
	}

}
