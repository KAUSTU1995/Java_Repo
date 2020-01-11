/*N, M = map(int, input().split())
X = int(input())
left = right = int(X)
Sum = 1 + N
M-=1
print(Sum)
isitthere = {X}
while M > 0:
    X = int(input())
    if(X not in isitthere):
        if(X>left and X<right):
            Sum+=2*X
        elif(X<left):
            Sum = Sum + left + X
            left=X
        elif(X>right):
            Sum = Sum + right + X
            right = X
        isitthere.add(X)
    print (Sum)
    M -= 1
*/

package com.basic1;

import java.io.IOException;
import java.util.HashSet;
import java.util.Scanner;

public class GoodRanges {
	public static void main(String[] args)throws IOException{
		Scanner sc=new Scanner(System.in);
		long n=sc.nextLong();
		long q=sc.nextLong();
		HashSet<Long> arr=new HashSet<Long>();
		long xy=sc.nextLong();
				System.out.println(1+n);
		arr.add(xy);
			long left=0;
			long right=0;
			left=right=xy;
			q--;
			long sum=1+n;
		while(q>0){
			long x=sc.nextLong();
			
			System.out.println();
			if(!arr.contains(x)){
			if(x>left && x<right){
				sum+=2*x;
			}
			else if(x<left){
				sum+=left+x;
				left=x;
			}
			else if(x>right){
			sum+=x+right;
			right=x;
			}
			arr.add(x);
		}
			System.out.println(sum);
			q--;
		}
		sc.close();	
	}
}
