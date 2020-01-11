package com.basic1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BinarySearch {
	public static void main(String arg[])throws IOException{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int n=Integer.parseInt(br.readLine());
		int arr[]=new int[n];
		for(int i=0;i<n;i++){
			arr[i]=Integer.parseInt(br.readLine());
		}
		System.out.println("Enter number to search:");
		int number=Integer.parseInt(br.readLine());
		int result=binarySearch(arr,0,n-1,number);
		System.out.println(result);
		nouse(5);
	}
	public static int binarySearch(int arr[],int left,int right,int n){
		if(left<=right){
		int mid=(left+right)/2;
		if(arr[mid]==n)
			return mid;
		if(arr[mid]<n)
			return binarySearch(arr,mid+1,right,n);
		else 
			return binarySearch(arr,0,mid-1,n);
		}
		return -1;
		
	}
	private static int nouse(int a){
		int aa=5;
		aa++;
		System.out.print(aa);
		return 5;
	}

}
