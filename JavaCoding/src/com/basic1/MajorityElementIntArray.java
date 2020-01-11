//Majority Element | GeeksforGeeks
//Element greater than n/2 times in an array where n is size of array
package com.basic1;

public class MajorityElementIntArray {

	public static void main(String[] args) {
		int arr[]={3,3,4,2,4,4,2,4,4};
		findMajority(arr);

	}
	//O(N^2) approach
/*
	private static void findMajority(int[] arr) {
		int n=arr.length;
		for(int i=0;i<n;i++){
			int count=1;
			for(int j=i+1;j<n;j++){
				if(arr[i]==arr[j])
					count++;
			}
			if(count>n/2){
				System.out.println(arr[i]);
				break;
			}
			if(i>n/2){
				System.out.println("None");
				break;
			}
		}
		
		
	}*/

	private static void findMajority(int[] arr) {
		int n=arr.length;
		int count=1;
		int majElement=arr[0];
		for(int i=1;i<n;i++){
			if(arr[i]==majElement)
				count++;
			else{
				count--;
			}
			if(count==0){
				majElement=arr[i];
				count=1;
			}
		}
		count=0;
		for(int i=0;i<n;i++){
			if(majElement==arr[i])
				count++;
		}
		if(count>n/2)
			System.out.println(majElement);
		else
			System.out.println("None");
		
	}

}
