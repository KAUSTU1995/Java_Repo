package com.interviewbit;

public class Day68LongestPalindromicSubsequence {

	static int dpr[][];
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Day68LongestPalindromicSubsequence obj=new Day68LongestPalindromicSubsequence();
//		String find="agbddba";
		String find="bebdeeedaddecebbbbbabebedc";
		int result=obj.solve(find);
		String str=obj.printSubsequence(dpr, result,find);
		System.out.println("The string is: "+str+" "+" of size: "+result);
		

	}

    public int solve(String A) {
        int len=A.length();
        int[][] dp=new int[len][len];
//        int[][] dp={{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};
        int result=solveBottomUp(A,dp);
        dpr=dp;
        return result;
    }
    int solveBottomUp(String A,int[][] dp){
        int len=A.length();
        for(int i=0;i<A.length();i++){
            dp[i][i]=1;
        }
        for(int i=0;i<len;i++){
            int k=0;
            for(int j=i+1;j<len;j++){
//            	System.out.print((k++)+" "+j+"   ");
            	if(A.charAt(k)==A.charAt(j)){
            		dp[k][j]=2+dp[k+1][j-1];
            	}
            	else{
            		dp[k][j]=Math.max(dp[k+1][j], dp[k][j-1]);
            	}
            	k++;
            	
            }
//            System.out.println();
            
        }
        return dp[0][len-1];
    }
    
    
    //issue in this code try this string:"bebdeeedaddecebbbbbabebedc"
    String printSubsequence(int[][] dp,int size,String str){
    	String temp="";
    	int len=dp[0].length;
    	int i=0;
    	int j=len-1;
    	int length=size;
    	int counter=0;
    	if(length%2==0){
    		counter=length/2;
    	}else{
    		counter=length/2+1;
    	}
    	while(length>=counter && i<len && j>=0){
    		if(str.charAt(i)==str.charAt(j)){
    			char tt=str.charAt(i);
    			temp=tt+temp;
    			i++;
    			j--;
    			length--;
    		}
    		else{
    			if( i<len-1 && j>0 && dp[i+1][j]>dp[i][j-1]){
//    				temp=str.charAt(i)+temp;
    				i++;
    			}
    			else{
//    				temp=str.charAt(j)+temp;
    				j--;
    			}
    		}
//    		length--;
    	}
    	
    	if(size%2!=0){
    		String ord="";
    		for(int k=1;k<counter;k++){
    			ord=temp.charAt(k)+ord;
    		}
    		temp=ord+temp;
    	}
    	else{
    		String ord="";
    		int leng=temp.length();
    		int p=0;
    		while(counter!=1){
    			ord=ord+temp.charAt(leng-p-1);
    			p++;
    			counter--;
    		}
    		temp=ord+temp;
    	}
//    	while(length!=0){
//    		int move=temp.length()-length;
//    		temp=temp.charAt(move++)+temp;
//    		length--;
//    	}
    	return temp;
    }

}
