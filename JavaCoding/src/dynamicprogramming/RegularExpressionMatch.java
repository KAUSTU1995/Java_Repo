package dynamicprogramming;

public class RegularExpressionMatch {
	public static void main(String[] args) {
		RegularExpressionMatch obj=new RegularExpressionMatch();
//		String A="bcaccbabaa";
//		String B="bb*c?c*?";
		String A="aaa";
		String B="*b";
//		String A="aaa";
//		String B="a*";
		dp=new int[A.length()][B.length()];
		System.out.println(obj.isMatch(A,B));
//		print(dp);
	}
	public int isMatch(final String A, final String B) {
        int lenA=A.length();
        int lenB=B.length();
        return getMatch(A,B,0,0)==-1?0:1;
    }
    
private int getMatch(String a, String b, int i, int j) {
	if(i==a.length() && j==b.length())
		return 1;
	if(j==b.length() && i<a.length()) {
		return -1;
	}
	if(i==a.length() && j<b.length()) {
		if(b.charAt(j)=='*')
			return getMatch(a, b, i, j+1);
		else
			return -1;
	}
	if(dp[i][j]!=0)
		return dp[i][j];
	if(a.charAt(i)==b.charAt(j) || b.charAt(j)=='?') {
		return dp[i][j]=getMatch(a, b, i+1, j+1);
	}
	else if(b.charAt(j)=='*') {
		return dp[i][j]=(getMatch(a, b, i+1, j)==1 || getMatch(a, b, i, j+1)==1)?1:-1;
	}
	else {
		return dp[i][j]=-1;
	}
}

//	private boolean match(char c1, char c2) {
//        return c2 == '?' || c1 == c2;
//    }
//    
//    public int isMatch(final String A, final String B) {
//        boolean[][] dp = new boolean[A.length() + 1][B.length() + 1];
//        for (int i = 0; i <= A.length(); i++) {
//            for (int j = 0; j <= B.length(); j++) {
//                if (i == 0 && j == 0) {
//                    // Empty strings are always matching
//                    dp[i][j] = true;
//                } 
//				
//				else if (j > 0 && B.charAt(j - 1) == '*') {
//                    // B ends with *, ignore it or match it with last character of A
//                    dp[i][j] = dp[i][j - 1] || (i > 0 && dp[i - 1][j]);
//                }
//
//				else if (i > 0 && j > 0 && match(A.charAt(i - 1), B.charAt(j - 1))) {
//                    // Matching last characters
//                    dp[i][j] = dp[i - 1][j - 1];
//                } 
//				
//				else {
//                    dp[i][j] = false;
//                }
//            }
//        }
//        print(dp);
//        return dp[A.length()][B.length()] ? 1 : 0;
//    }
	static int[][] dp;
//	public int isMatch(final String A, final String B) {
//        int lenA=A.length();
//        int lenB=B.length();
//        return getMatch(A,B,lenA-1,lenB-1)?1:0;
//    }
//    boolean getMatch(String A, String B, int i, int j){
//        if(i<0 && j<0){
//            return true;
//        }
//        if(i>=0 && j<0)
//        return false;
//        
//        if(i<0 && getMatch(A,B,i,j-1)){
//            return true;
//        }
//        
//        if(i<0 && j>=0){
//            return false;
//        }
//        
//        if(A.charAt(i)==B.charAt(j) || B.charAt(j)=='?'){
//            return dp[i][j]=getMatch(A,B,i-1,j-1);
//        }
//        
//        if(B.charAt(j)!='?' && B.charAt(j)!='*' && B.charAt(j)!=A.charAt(i)){
//            return dp[i][j]=false;
//        }
//        if(B.charAt(j)=='*'){
//            return dp[i][j]=(getMatch(A,B,i-1,j) || getMatch(A,B,i,j-1));
//        }
//        return dp[i][j]=false;
//    }
	private static void print(boolean[][] dp) {
		// TODO Auto-generated method stub
		for(int i=0;i<dp.length;i++) {
			for(int j=0;j<dp[0].length;j++) {
				System.out.print(dp[i][j]+" ");
			}
			System.out.println();
		}
		
	}

}
