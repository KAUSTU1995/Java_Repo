package com.interviewbit;

public class Day42FlightRange {
	public static void main(String[] args) {
		Day42FlightRange obj=new Day42FlightRange();
		int A=5;
		int[][] B={{1,2,10},{2,3,20},{2,5,25}};
		int[] arr=obj.solve(A, B);
		for(int i:arr){
			System.out.println(i+" ");
		}
		
	}
	
public int[] solve(int A, int[][] B) {
        
        int arr[]=new int[A+2];
        
        for(int i=0;i<B.length;i++){
            arr[B[i][0]]+=B[i][2];
            arr[B[i][1]+1]+=-B[i][2];
        }
        int result[]=new int[A];
        for(int i=1;i<arr.length-1;i++){
        	arr[i]+=arr[i-1];
        	result[i-1]=arr[i];
//            System.out.print(result[i-1]+" ");
        }
//        for(int i=0;i<result.length;i++){
//        	System.out.println(result[i]);
//        }
        return result;
    }

}
