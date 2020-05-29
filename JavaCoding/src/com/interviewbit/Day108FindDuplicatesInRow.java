package com.interviewbit;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class Day108FindDuplicatesInRow {

	public static void main(String[] args) {

		Day108FindDuplicatesInRow obj=new Day108FindDuplicatesInRow();
		ArrayList<ArrayList<Integer>> A=new ArrayList<>();
		ArrayList<Integer> arr=new ArrayList<>();
		arr.add(1);
		arr.add(0);
		arr.add(0);
		
		ArrayList<Integer> arr1=new ArrayList<>();
		arr1.add(0);
		arr1.add(1);
		arr1.add(0);
		
		ArrayList<Integer> arr2=new ArrayList<>();
		arr2.add(0);
		arr2.add(1);
		arr2.add(0);
		
		A.add(arr);
		A.add(arr1);
		A.add(arr2);
		
		print(obj.solve(A));
	}
	
	public ArrayList<Integer> solve(ArrayList<ArrayList<Integer>> A) {
        ArrayList<Integer> arr=new ArrayList<>();
       Set<String> set=new HashSet<>();
       for(int i=0;i<A.size();i++){
           StringBuffer sb=new StringBuffer();
           for(int j=0;j<A.get(i).size();j++){
               sb.append(A.get(i).get(j));
           }
           String str=sb.toString();
           if(!set.contains(str)){
               set.add(str);
           }
           else{
               arr.add(i+1);
           }
       }
       return arr;
   }
	
	private static void print(ArrayList<Integer> a) {

		for(Integer i:a){
			
				System.out.print(i+"  ");
			
		}
	}

}
