//Find the minimum distance between two numbers | GeeksforGeeks
//Duplication allowed
//Two number are different whose distance to be found out

package com.basic1;

public class MinimumDistanceBetweenTwoNumber {
	public static void main(String[] args) {
		int arr[]={3,5,4,2,6,5,6,6,5,4,8,3};
		int ar2[]={2,5,3,5,4,4,2,3};
		minDist(arr,3,6);
		minDist(ar2,3,2);
	}
//A little tricky and uses O(N) time complexity.
	private static void minDist(int[] arr, int x, int y) {
		int n=arr.length;
		int prev=0;
		int min=Integer.MAX_VALUE;
		for(int i=0;i<n;i++){
			if(arr[i]==x ||arr[i]==y){
				prev=i;
				break;
			}
		}
		for(int i=prev+1;i<n;i++){
			if(arr[i]==x || arr[i]==y){
				if(arr[prev]!=arr[i] && min>(i-prev)){
					min=i-prev;
					prev=i;
				}
				else{
					prev=i;
				}
			}
		}
		System.out.println(min);
		
	}

	/* Uses O(N^2) time complexity
	   private static void minDist(int[] arr,int x,int y) {
		int n=arr.length;
		int min=Integer.MAX_VALUE;
		for(int i=0;i<n;i++){
			for(int j=i+1;j<n;j++){
				if((arr[i]==x && arr[j]==y || arr[i]==y && arr[j]==x) && Math.abs(i-j)<min )
					min=Math.abs(i-j);
			}
		}
		System.out.println(min);
		
	}*/

}
