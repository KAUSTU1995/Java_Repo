//Find the missing number between 1 to N| GeeksforGeeks
//
package com.basic1;

public class FindMissingNumberArray {

	public static void main(String[] args) {
		int arr[]={1,2,4,6,3,7,8};
		int ar2[]={1,2,4,5,6};
		missingNumber(arr);
		missingNumber(ar2);
	}
/*This is where we sum the number and get the value from subracting array from sum. O(N) time complexity
but if sum too large this method fails
	private static void missingNumber(int[] arr) {
		int n=arr.length;
		int sum=(n+1)*(n+2)/2;
		for(int i=0;i<n;i++){
			sum-=arr[i];
		}
		System.out.println(sum);
		
	}
*/

	private static void missingNumber(int[] arr) {
		int n=arr.length;
		int x1=0,x2=0;
		for(int i=0;i<n;i++){
			x1=x1^arr[i];
		}
		for(int i=1;i<=n+1;i++){
			x2=x2^i;
		}
		System.out.println(x1^x2);
		
	}	

}
