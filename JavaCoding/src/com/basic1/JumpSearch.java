package com.basic1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class JumpSearch {
	public static void main(String arg[])throws IOException{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int n=Integer.parseInt(br.readLine());
		int arr[]=new int[n];
		for(int i=0;i<n;i++){
			arr[i]=Integer.parseInt(br.readLine());
		}
		System.out.println("Enter number to search:");
		int number=Integer.parseInt(br.readLine());
		boolean result=jumpSearch(arr,number);
		System.out.println(result);
	}
	
	public static boolean jumpSearch(int arr[],int n){
		int length=arr.length;
		int step=0;
		if(arr[length-1]<n)
			return false;
		int i=0;
		while(i<=length-1){
			if(arr[i]<n){
				step=(int)Math.sqrt(length);
				i+=step;
			}
			else{
				break;
			}
		}
		int prevStep=i-step;
		for(int j=prevStep;j<=i;j++){
			if(arr[j]==n)
				return true;
		}
		return false;
	}

}
