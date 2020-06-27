package com.interviewbit;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class Day70Ndigitnumbers {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Day70Ndigitnumbers obj=new Day70Ndigitnumbers();
		System.out.println(obj.solve(2, 2));

	}
    public int solve(int A, int B) {
        int ans=0;
        for(int i=1;i<=10;i++) {
        	ans+=getCount(A-1,B-i);
        }
        return ans;
    }
    
    //recursive only
    int getCount(int index, int sum){
        if(index==0){
            if(sum==0){
                return 1;
            }
            else{
                return 0;
            }
        }
        if(sum<0)
        	return 0;
        int ans=0;
        for(int i=0;i<=9;i++){
            ans+=getCount(index-1,sum-i);
        }
		return ans;
    }


}
