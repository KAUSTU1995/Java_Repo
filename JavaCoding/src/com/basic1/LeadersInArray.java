//Leaders in an array | GeeksforGeeks
//A leader is which is greater than all its right member in an array
package com.basic1;

public class LeadersInArray {

	public static void main(String[] args) {
		int arr[]={16,17,4,3,5,2};
		findLeaders(arr);

	}
//brute force O(N^2) to use two loops
	/*private static void findLeaders(int[] arr) {
		int n=arr.length;
		for(int i=0;i<n;i++){
			int j=0;
			for( j=i+1;j<n;j++){
				if(arr[i]<arr[j])
					break;
			}
			if(j==n)
				System.out.println(arr[i]+" ");
		}
		
	}*/
//O(N) approach to traverse from right side
	private static void findLeaders(int[] arr) {
		int n=arr.length;
		int max=Integer.MIN_VALUE;
		for(int i=n-1;i>=0;i--){
			if(max<arr[i]){
				max=arr[i];
				System.out.println(arr[i]);
			}
		}
		
	}

}
