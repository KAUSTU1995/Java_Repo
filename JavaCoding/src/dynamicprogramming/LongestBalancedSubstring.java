package dynamicprogramming;

public class LongestBalancedSubstring {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LongestBalancedSubstring obj=new LongestBalancedSubstring();
		String A="[]]";
		System.out.println(obj.LBSlength(A));

	}
	

    // DO NOT MODIFY THE ARGUMENTS WITH "final" PREFIX. IT IS READ ONLY
    public int LBSlength(final String A) {
        int len=A.length();
        if(A.isEmpty())
        return 0;
        if(len==0)
        return 0;
        int dp[]=new int[len];
        int curMax=0;
            for(int i=1;i<len;i++){
                if(A.charAt(i)=='>' || A.charAt(i) == ')' || A.charAt(i) == ']' || A.charAt(i) == '}'){
                    if( (A.charAt(i) == '>' && A.charAt(i-1) == '<') || 
                        (A.charAt(i) == ')' && A.charAt(i-1) == '(') ||
                        (A.charAt(i) == ']' && A.charAt(i-1) == '[') ||
                        (A.charAt(i) == '}' && A.charAt(i-1) == '{') ){
                            dp[i] = (i-2) >= 0 ? (dp[i-2] + 2) : 2;
                            curMax = Math.max(dp[i],curMax);
                    }   
                
                    else{
                        if( (i-dp[i-1]-1)>=0 && (
                        (A.charAt(i) == '>' && A.charAt(i-dp[i-1]-1) == '<') || 
                        (A.charAt(i) == ')' && A.charAt(i-dp[i-1]-1) == '(') ||
                        (A.charAt(i) == ']' && A.charAt(i-dp[i-1]-1) == '[') ||
                        (A.charAt(i) == '}' && A.charAt(i-dp[i-1]-1) == '{')) )
                        {
                            dp[i]= dp[i-1] + 2+ ((i-dp[i-1]-2 >= 0)?dp[i-dp[i-1]-2]:0);
                            curMax=Math.max(curMax,dp[i]);
                        }
                    
                    }
                }   
                
            }
        return curMax;
    }


}
