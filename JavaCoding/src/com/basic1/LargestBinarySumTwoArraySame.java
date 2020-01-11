// Source: GeeksForGeeks Youtube array playlist

//Longest Span with same Sum in two Binary arrays
package com.basic1;

public class LargestBinarySumTwoArraySame {
	/* This approach contains O(n^2) time solution
	 
	   public static void main(String argr[])throws IOException{
		int ar1[]={0,1,0,1,1,1,1};
		int ar2[]={1,1,1,1,1,0,1};
		int maxLen=0;
		for(int i=0;i<ar1.length;i++){
			int sum1=0;
			int sum2=0;
			for(int j=i;j<ar2.length;j++){
				sum1+=ar1[j];
				sum2+=ar2[j];
				if(sum1==sum2){
					int max=j-i+1;
					if(maxLen<max)
						maxLen=max;
				}
			}
		}
		System.out.println(maxLen);
		
		
	}*/
	
//	This solution uses O(n) time and O(n) space complexity
	public static void main(String argr[]){
		int ar1[]={0,1,0,0,0,0};
		int ar2[]={1,0,1,0,0,1};
		int maxLen=0;
		int n=ar1.length;
		int diff[]=new int[2*n+1];
		for(int i=0;i<2*n+1;i++)
			diff[i]=-1;
		int preSum1=0;
		int preSum2=0;
		for(int i=0;i<n;i++){
			preSum1+=ar1[i];
			preSum2+=ar2[i];
			int currDiff=preSum1-preSum2;
			int diffSum=n+currDiff;
			if(currDiff==0)
				maxLen=i+1;
			else if(diff[diffSum]==-1)
				diff[diffSum]=i;
			else{
				int max=i-diff[diffSum];
				if(max>maxLen)
					maxLen=max;
			}
		}
		System.out.println(maxLen);
		
	}

}
