package com.interviewbit;

public class Day68LongestCommonSubsequence {

	public static void main(String[] args) {
		Day68LongestCommonSubsequence obj=new Day68LongestCommonSubsequence();
//		int max=obj.solveBottomUp("abbcdgf", "bbadcgf");
//		System.out.println(max);
		String A="abbcdgf";
		String B="bbadcgf";
		int[][] dp=new int[A.length()+1][B.length()+1];
		int max=obj.solveTopDown(A,B,A.length(),B.length(),dp);
		System.out.println(max);
	}
	
	private int solveTopDown(String A, String B,int i,int j,int[][] dp) {
		
		 if(i==0 || j==0){
			return 0;
		}
		if(dp[i][j]!=0)
			return dp[i][j];
		if(A.charAt(i-1)==B.charAt(j-1))
		return dp[i][j]=1+solveTopDown(A, B, i-1, j-1,dp);
		else{
		int val1=solveTopDown(A, B, i, j-1,dp);
		int val2=solveTopDown(A, B, i-1, j,dp);
		return dp[i][j]=Math.max(val1, val2);
		}
	}

	//bottom up
	public int solveBottomUp(String A, String B) {
        int lenA=A.length();
        int lenB=B.length();
        int[][] dp=new int[lenA+1][lenB+1];
        for(int i=1;i<=lenA;i++){
            for(int j=1;j<=lenB;j++){
                if(A.charAt(i-1)==B.charAt(j-1)){
                    dp[i][j]=1+dp[i-1][j-1];
                }else{
                    dp[i][j]=Math.max(dp[i-1][j],dp[i][j-1]);
                }
            }
        }
        return dp[lenA][lenB];
    }
	
}
