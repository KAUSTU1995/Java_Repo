package com.basic1;

import java.io.IOException;
import java.util.Collections;
import java.util.PriorityQueue;

public class HeapPriorityQueue {
	public static void main(String arg[])throws IOException{
		//Adding Collections.reverseOrder() makes it max heap,else it is minheap
		PriorityQueue<Integer> pq=new PriorityQueue<Integer>(Collections.reverseOrder());
		pq.add(8);
		pq.add(3);
		pq.add(5);
		pq.add(2);
		pq.add(9);
		pq.add(18);
		Object[] arr=pq.toArray();
		//extract min/max and delete from queue;
		int val=pq.remove();
		System.out.println(val);
		//peek the min/max or top element
		System.out.println(pq.peek());
		
		for(int i=0;i<arr.length;i++){
			System.out.print(arr[i]+" ");
		}
		
	}

}
