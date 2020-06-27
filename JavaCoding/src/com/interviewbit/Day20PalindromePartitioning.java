package com.interviewbit;

import java.util.ArrayList;

public class Day20PalindromePartitioning {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Day20PalindromePartitioning obj=new Day20PalindromePartitioning();
		String a="efe";
		obj.partition(a);
		for(ArrayList<String> i:result) {
			for(String str:i) {
				System.out.print(str+" ");
			}
			System.out.println();
		}

	}


    static ArrayList<ArrayList<String>> result;
	public ArrayList<ArrayList<String>> partition(String a) {
	    int len=a.length();
	    result=new ArrayList<>();
	    ArrayList<String> temp=new ArrayList<>();
	    findPartition(temp,0,len,a);
	    return result;
	    
	}
	
	void findPartition(ArrayList<String> temp, int idx, int length, String str){
	    if(idx>=length){
	        result.add(new ArrayList<>(temp));
	        return ;
	    }
	    
	    for(int i=idx;i<length;i++){
	        if(isPalin(str,idx,i)){
	            temp.add(str.substring(idx,i+1));
	            findPartition(temp,i+1,length,str);
	            temp.remove(temp.size()-1);
	        }
	    }
	}
	
	boolean isPalin(String str, int start, int end){
	    while(start<end){
	        if(str.charAt(start)==str.charAt(end)){
	            start++;
	            end--;
	        }
	        else{
	            return false;
	        }
	    }
	    return true;
	}

}
