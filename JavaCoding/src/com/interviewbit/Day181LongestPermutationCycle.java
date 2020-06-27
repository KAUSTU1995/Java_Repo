package com.interviewbit;

import java.util.Scanner;

public class Day181LongestPermutationCycle {

    public static void main(String[] args) {
        // YOUR CODE GOES HERE
        // Please take input and print output to standard input/output (stdin/stdout)
        // DO NOT USE ARGUMENTS FOR INPUTS
        // E.g. 'Scanner' for input & 'System.out' for output
//        Scanner sc=new Scanner(System.in);
//        int T=sc.nextInt();
        
//        while(T!=0){
            int N=7;//sc.nextInt();
            int arr[]={0,4, 2, 3, 7, 6, 5, 1};//new int[N+1];
//            for(int i=1;i<N+1;i++){
//                arr[i]=sc.nextInt();
//            }
            int result=getCycle(arr,N+1);
            System.out.print(result);
//            T--;
//        }
    }
    static int getCycle(int[] arr,int N){
        boolean[] visited=new boolean[N];
        int cycle=1;
        int max=0;
         for (int i = 1; i < N; i++) {
            if (visited[i] == false) {
                
                int temp = arr[i];
                while (arr[temp] != arr[i]) {

                    visited[temp] = true;
                    temp = arr[temp];
                    cycle++;
                }
            }
            int result = (int)(Math.log(cycle) / Math.log(2)); 
            if(result%2!=0){
                return -1;
            }
            max=Math.max(max,result);
        }
        return max;
    }


}
