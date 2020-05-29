package Greedy;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class BusandPassenger {

	private static int[] solve;

	public static void main(String[] args) {
		int arr[]={15, 6, 3, 1, 10};
		String str="0000011111";
		BusandPassenger bp=new BusandPassenger();
		solve = bp.solve(arr,str);
		for(int i:solve){
			System.out.println(i+" ");
		}
		
	} 

    public int[] solve(int[] A, String B) {
        int lenBusRows=A.length;
        int passenger=B.length();
        int[] C=new int[passenger];
        Map<Integer,Integer> map=new HashMap<>();
        PriorityQueue<Integer> minHeap=new PriorityQueue<>();
        PriorityQueue<Integer> maxHeap=new PriorityQueue<>(Collections.reverseOrder());
        for(int i=0;i<lenBusRows;i++){
        	map.put(A[i],i+1);
            minHeap.add(A[i]);
        }
        for(int i=0;i<passenger;i++){
            char c=B.charAt(i);
            if(c=='0' && minHeap.size()!=0){
            	int k=minHeap.remove();
                C[i]=map.get(k);
                maxHeap.add(k);
            }
            else if(c=='1' && maxHeap.size()!=0){
                int k=map.get(maxHeap.remove());
                C[i]=k;
            }
            else{
                return new int[]{-1};
            }
        }
        return C;
        
    }

}
