package com.interviewbit;

import java.util.Stack;

public class Day66DecodeString {
	public static void main(String[] args) {
		Day66DecodeString obj=new Day66DecodeString();
		String A="2[e]4[v2[kit]]";
		String str=obj.solve(A);
		System.out.println(str);
		
	}
	

    public String solve(String A) {
        int len=A.length();
        Stack<Character> st=new Stack<>();
        String result="";
        int i=0;
        while(i<len) {
        	char c=A.charAt(i);
        	st.push(c);
        	if(st.size()!=0 && st.peek()==']') {
        		st.pop();
        		String temp="";
        		while(st.peek()!='[') {
        			temp=st.pop()+temp;
        		}
        		st.pop();
        		int loopTime=st.pop()-'0';
        		while(loopTime!=0) {
        			for(int k=0;k<temp.length();k++) {
        				st.push(temp.charAt(k));
        			}
        			loopTime--;
        		}
        	}
        	i++;
        }
        for(char c:st) {
        	result+=c;
        }
        return result;
    }


}
