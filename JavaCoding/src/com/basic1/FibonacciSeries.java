package com.basic1;

import java.io.IOException;
import java.util.Scanner;

public class FibonacciSeries {
	private static int fib(int fibPosition ){
		int a=0;
		int b=1;
		if(fibPosition==1)
			return a;
		if(fibPosition==2)
			return b;
		for(int i=3;i<=fibPosition;i++){
			int c=a+b;
			a=b;
			b=c;
		}
		return b;
	}
	public static void main(String arg[])throws IOException{
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the position for which fibonacci number is required:");
		int position=sc.nextInt();
		int value=fib(position);
		System.out.println("The fibonscci number at position:"+position+" is:"+value);
		sc.close();
	}

}
