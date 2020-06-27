package com.interviewbit;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Day24CountOfSmallerAfterSelf {
	//Working fine. TLE issue needs to be solved.
	public static void main(String[] args) {
		int[] A= { 140, 476, 477, 386, 413, 200, 407, 181, 248, 276, 77, 248, 222, 144, 292, 197};
		Day24CountOfSmallerAfterSelf obj=new Day24CountOfSmallerAfterSelf();
		int[] arr=obj.solve(A);
		for(int i:arr) {
			System.out.print(i+"  ");
		}
	}
	class Item{
		int val;
		int index;
		public Item(int val, int index) 
        { 
            this.val = val; 
            this.index = index; 
        } 
	}
    int arr[];
    Item array[];
    public int[] solve(int[] A) {
        int n=A.length;
        arr=new int[A.length];
        array=new Item[A.length];
        for(int i=0;i<n;i++){
            array[i]=new Item(A[i],i);
        }
        mergeSort(array,0,n-1);
        return arr;
    }
   void  mergeSort(Item[] A, int s,int e){
        if(s<e){
        int mid=s+(e-s)/2;
            mergeSort(A,s,mid);
            mergeSort(A,mid+1,e);
            merge(A,s,mid,mid+1,e);
        }
    }
    void merge(Item[] A, int i, int j,int k, int l){
       int m1=i;
       int m2=k;
       ArrayList<Item> temp=new ArrayList<>();
       while(m1<=j && m2 <= l) {
    	  if(A[m1].val<=A[m2].val) {
    		  temp.add(A[m1]);
    		  m1++;
    	  }else {
    		  findSmaller(A, m1,j);
    		  temp.add(A[m2]);
    		  m2++;
    	  }
    	   
       }
       while (m1 <= j) {
           temp.add(A[m1++]);
       }
       while (m2 <= l) {
           temp.add(A[m2++]);
       }
       swap(A,i,l,temp);
  
       
        
    }
    private void swap(Item[] A, int m1, int m2, ArrayList<Item> temp2) {
    	int temp=0;
    	for(int i=m1;i<=m2;i++) {
    		A[i]=temp2.get(temp++);
    	}
    	
	}
	void findSmaller(Item[] L, int i,int n2){
        for(int k=i;k<=n2;k++){
            arr[L[k].index]++;
        }
    }


}
