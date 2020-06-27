package com.interviewbit;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Day181LittlePonyPartitionSort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Day181LittlePonyPartitionSort obj=new Day181LittlePonyPartitionSort();
		int[] A={6, 4, 5, 4, 8, 10, 8, 8, 11, 11, 12, 12, 12, 15, 17};
		int result=obj.solve(A);
		System.out.println(result);

	}

    public int solve(int[] A) {
        int len=A.length;
        int ans=0;
        int[] arr=Arrays.copyOf(A,A.length);
        Arrays.sort(arr);
        Map<Integer, Integer> one=new HashMap<>();
        Map<Integer, Integer> two=new HashMap<>();
        
        for(int i=0;i<len;i++){
            int k=A[i];
            int l=arr[i];
           
            if(one.containsKey(k)){
                int count=one.get(k);
                one.put(k,++count);
            }
            else{
                one.put(k,1);
            }
            if(two.containsKey(l)){
                int count=two.get(l);
                two.put(l,++count);
            }
            else{
                two.put(l,1);
            }
             if(one.containsKey(k) && two.containsKey(k)){
                int count1=one.get(k);
                int count2=two.get(k);
                count1--;
                count2--;
                if(count1==0){
                    one.remove(k);
                }
                else{
                	one.put(k, count1);
                }
                if(count2==0){
                    two.remove(k);
                }else{
                	two.put(k, count2);
                }
            }
            if(one.containsKey(l) && two.containsKey(l)){
                int count1=one.get(l);
                int count2=two.get(l);
                count1--;
                count2--;
                if(count1==0){
                    one.remove(l);
                }
                else{
                	one.put(l, count1);
                }
                if(count2==0){
                    two.remove(l);
                }
                else{
                	two.put(l, count2);
                }
            }
            if(one.size()==0 && two.size()==0){
                ans++;
            }
        }
        
        return ans;
    }


}
