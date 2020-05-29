package com.interviewbit;

import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Vector;

public class Day41LargestNumber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] A=new int[]{0,9,3,2,0};
		Day41LargestNumber obj=new Day41LargestNumber();
		System.out.print(obj.largestNumber(A));

	}
	
	static String printLargest(Vector<String> arr){ 
	      
        Collections.sort(arr, new Comparator<String>(){ 
  
        public int compare(String X, String Y) { 
        String XY=X + Y; 
        String YX=Y + X; 
        return XY.compareTo(YX) > 0 ? -1:1; 
    } 
    }); 
    Iterator it = arr.iterator();
    String str="";
    while(it.hasNext()) 
        str+=it.next(); 
        
        return str;
    }
    
    public String largestNumber(final int[] A) {
        Vector<String> arr; 
        arr = new Vector<>();
        int l=A.length;
        boolean zero=false;
        for(int i=0;i<l;i++){
            if(A[i]==0){
                zero=true;
                continue;
            }
            else
            break;
        }
        if(zero==true)
        return "0";
        
        for(int i=0;i<l;i++){
            
            arr.add(String.valueOf(A[i]));
        }
        
        return printLargest(arr);
    }

}
