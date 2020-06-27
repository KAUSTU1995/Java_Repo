package com.interviewbit;

import java.util.HashMap;

public class Day27Equal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Day27Equal obj=new Day27Equal();
		int[] A={9, 5, 4, 9, 3, 6, 8, 7, 1, 2, 8, 7, 2, 9,
				7, 1, 3, 9, 7, 8, 1, 0, 5, 5 };
		int[] arr=obj.equal(A);
		for(int i:arr){
			System.out.print(i+" ");
		}

	}
	

    
    class Pair{
        int first;
        int second;
        Pair(int i,int j){
            first=i;
            second=j;
        }
    }
    public int[] equal(int[] A) {
        // Arrays.sort(A);
        int len=A.length;
        HashMap<Integer,Pair> map=new HashMap<>();
        int[] arr=new int[4];
        boolean isFirst=true;
        for(int i=0;i<len;i++){
            for(int j=i+1;j<len;j++){
                int k=A[i]+A[j];
                if(!map.containsKey(k)){
                    map.put(k,new Pair(i,j));
                }
                else{
                    Pair p=map.get(k);
                    if(p.first!=i && p.second != i && i!=j && p.first!=j && p.second!=j){
                    if(isFirst || p.first<arr[0] || p.second<arr[1] || i<arr[2] ){
                        arr[0]=p.first;
                        arr[1]=p.second;
                        arr[2]=i;
                        arr[3]=j;
                        isFirst=false;
                    }
                    }
                  
                }
            }
        }
        return !isFirst?arr:new int[]{-1};
    }


}
