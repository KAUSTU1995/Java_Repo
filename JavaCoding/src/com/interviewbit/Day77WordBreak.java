package com.interviewbit;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class Day77WordBreak {
	public static void main(String[] args) {
		Day77WordBreak obj=new Day77WordBreak();
		String A="myinterviewtrainer";
		ArrayList<String> B=new ArrayList<>();
		B.add("interview");
		B.add("my");
		B.add("trainer");
		System.out.println(obj.wordBreak(A, B));
		
		
	}
	
	public int wordBreak(String s, ArrayList<String> B) {
        boolean[] t = new boolean[s.length()+1];
        t[0] = true; //set first to be true, why?
        //Because we need initial state
        Set<String> dict = new HashSet<>(B);
        for(int i=0; i<s.length(); i++){
            //should continue from match position
            if(!t[i]) 
                continue;
 
            for(String a: dict){
                int len = a.length();
                int end = i + len;
                if(end > s.length())
                    continue;
 
                if(t[end]) continue;
 
                if(s.substring(i, end).equals(a)){
                    t[end] = true;
                }
            }
        }
 
        return t[s.length()]?1:0;
    }
	
//	int[] dp;
//    public int wordBreak(String A, ArrayList<String> B) {
//        int len=A.length();
//        dp=new int[len];
//        
//        for(int i=0;i<len;i++){
//            String str=A.substring(0,i+1);
//            if(B.contains(str)){
//                dp[i]=1;
//            }
//            for(int j=0;j<i;j++) {
//            String arr=A.substring(j+1,i+1);
//            if(dp[j]==1 && B.contains(arr)){
//                dp[i]=1;
//                 break;
//            }
//            }
//        }
//        
//        return dp[len-1];
//    }

//	Top down: recursion +memoize
//    int[] dp;
//    public int wordBreak(String A, ArrayList<String> B) {
//        int len=A.length();
//        dp=new int[len];
//        for(int i=0;i<len;i++) {
//        	dp[i]=-1;
//        }
//        int result=getBreak(A,B,0);
//        return result;
//    }
//    int getBreak(String A,ArrayList<String> B, int start){
//    	
//    	if(start>=A.length()) {
//    		return 1;
//    	}
//    	if(dp[start]!=-1)
//    		return dp[start];
//    	
//        
//        for(int i=start;i<A.length();i++){
//            String str=A.substring(start,i+1);
//            if(B.contains(str) && getBreak(A,B,i+1)==1){
//                return dp[start]=1;
//            }
//        }
//        return dp[start]=0;
//    }

//    Brute force- Only recursion
//    int getBreak(String A,ArrayList<String> B, int start){
//    	if(start>=A.length())
//    		return 1;
//        
//        for(int i=start;i<A.length();i++){
//            String str=A.substring(start,i+1);
//            if(B.contains(str) && getBreak(A,B,i+1)==1){
//                return 1;
//            }
//        }
//        return 0;
//    }


}
