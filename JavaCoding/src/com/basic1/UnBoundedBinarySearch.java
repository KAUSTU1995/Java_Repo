package com.basic1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//To find +ve number location in unknown length of function 
public class UnBoundedBinarySearch {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int n=Integer.parseInt(br.readLine());
		int arr[]=new int[n];
		for(int i=0;i<n;i++){
			arr[i]=Integer.parseInt(br.readLine());
		}
		System.out.println("Enter number to search:");
		int number=Integer.parseInt(br.readLine());
		int result=unBoundedBinarySearch(arr,0,n-1,number);
		System.out.println(result);
		int result2=unBoundedLimitSearch();
		System.out.println(result2);
		
	}
	public static int f(int x)  
    {
		return (x*x - 10*x - 20);
		} 
  
	
	//Length Unknown function to find +ve number location
	private static int unBoundedLimitSearch() {
		int i=1;
		while(f(i)<0)
			i*=2;
		return binarySearch(i/2,i);
	}
	
	private static int binarySearch(int i1, int i2) {
		if(i1<=i2){
			int mid=(i1+i2)/2;
			if (f(mid)>0 && i1==mid || f(mid-1)<=0)
				return mid;
			if(f(mid)>0)
				return binarySearch(i1, mid-1);
			else {
				return binarySearch(mid+1, i2);
			}
		}
		return -1;
		
	}
	//Exponential Search Method

	private static int unBoundedBinarySearch(int[] arr, int s, int e, int number) {
		if(arr[s]==number)
			return s;
		int i=1;
		while(i<arr.length && arr[i]<number){
			i*=2;
		}
		if(i>arr.length)
			return -1;
		else
			return BinarySearch.binarySearch(arr, i/2, i, number);
	}

}
