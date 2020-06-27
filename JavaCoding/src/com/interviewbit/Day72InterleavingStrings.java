package com.interviewbit;

public class Day72InterleavingStrings {
	public static void main(String[] args) {
		Day72InterleavingStrings obj=new Day72InterleavingStrings();
		String A="LgR8D8k7t8KIprKDTQ7aoo7ed6mhKQwWlFxXpyjPkh";
		String B="Q7wQk8rqjaH971SqSQJAMgqYyETo4KmlF4ybf";
		String C="Q7wLgR8D8Qkk7t88KIrpqjarHKD971SqSQJTQ7aoAMgoq7eYd6yETmhoK4KmlQwWFlF4xybXfpyjPkh";
//		System.out.println(obj.topDown(A, B, C));
		System.out.println(obj.isInterleave(A, B, C));
//		String A="noUdRp97xFvpifeSXGwOjcVNhHo9N2D";
//		String B="6iZItw9A3fj86uYx04tvWKLtl9BK";
//		String C="n6ioUdRpZ97ItwxF9Av3fj86upYxif0eS4XtvWKLtlG9wOBKjcVNhHo9N2D";
//		System.out.println(obj.bottomup(A, B, C));
	}
	
	
	public boolean isInterleave(String s1, String s2, String s3) {
        if (s3.length() != s1.length() + s2.length()) {
            return false;
        }
        boolean dp[][] = new boolean[s1.length() + 1][s2.length() + 1];
        for (int i = 0; i <= s1.length(); i++) {
            for (int j = 0; j <= s2.length(); j++) {
                if (i == 0 && j == 0) {
                    dp[i][j] = true;
                } else if (i == 0) {
                    dp[i][j] = dp[i][j - 1] && s2.charAt(j - 1) == s3.charAt(i + j - 1);
                } else if (j == 0) {
                    dp[i][j] = dp[i - 1][j] && s1.charAt(i - 1) == s3.charAt(i + j - 1);
                } else {
                    dp[i][j] = (dp[i - 1][j] && s1.charAt(i - 1) == s3.charAt(i + j - 1)) || (dp[i][j - 1] && s2.charAt(j - 1) == s3.charAt(i + j - 1));
                }
            }
        }
        return dp[s1.length()][s2.length()];
    }
	
	
	
	
	
//	public int bottomup(String A, String B, String C) {
//        int lenA=A.length();
//        int lenB=B.length();
//        int lenC=C.length();
//        if(lenA+lenB!=lenC)
//        return 0;
//        int k=0;
//        System.out.print(lenA+ " "+ lenB+" "+lenC);
//        boolean[][] dp=new boolean[lenA+1][lenB+1];
//        int i=0;
//        int j=0;
//        while(i<lenA && j<lenB){
//        	if(A.charAt(i)==C.charAt(k)  && B.charAt(j)==C.charAt(k)){
//        		dp[i][j]=dp[i-1][j] || dp[i][j-1];
//        		i++;
//        		j++;
//        	}
//        	else if(A.charAt(i)==C.charAt(k)  && B.charAt(j)!=C.charAt(k))
//        }
//        return dp[lenA][lenB]?1:0;
//    }

    int k;
    public int topDown(String A, String B, String C) {
        int lenA=A.length();
        int lenB=B.length();
        int lenC=C.length();
        if(lenA+lenB!=lenC)
        return 0;
        
        k=lenA+lenB;
        if(getResult(A,B,C,lenA,lenB,lenC)){
            return 1;
        }
        return 0;
    }
    boolean getResult(String A, String B, String C, int i, int j, int k){
        if(i<=0 && j<=0 && k<=0){
            return true;
        }
        if(i<=0 && j<=0 && k>0)
        return false;
        
        if((i>0 || j>0) && k<=0)
        return false;
        
        if(i>0 && j>0 && A.charAt(i-1)==C.charAt(k-1) &&  B.charAt(j-1)==C.charAt(k-1)){
        	return getResult(A,B,C,i-1,j,k-1) || getResult(A,B,C,i,j-1,k-1);
        }
        if((i>0 && A.charAt(i-1)==C.charAt(k-1))|| (j>0 &&  B.charAt(j-1)!=C.charAt(k-1))){
            return getResult(A,B,C,i-1,j,k-1);
        } 
        if((i>0 && A.charAt(i-1)!=C.charAt(k-1)) ||  (j>0 && B.charAt(j-1)==C.charAt(k-1))){
            return getResult(A,B,C,i,j-1,k-1);
        }
        return false;
    }


}
