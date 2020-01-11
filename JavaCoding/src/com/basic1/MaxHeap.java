package com.basic1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MaxHeap {
	static int heapSize=0;
	static int arr[];
	static int capacity;
	public static void main(String arg[])throws IOException{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int length=Integer.parseInt(br.readLine());
		capacity=length;
		arr=new int[capacity];
		int heap[]=new int[capacity];
		for(int i=0;i<length;i++){
			int value=Integer.parseInt(br.readLine());
			heap[i]=value;
			insertKey(value);
		}
		
		buildHeap(heap);
		printHeap(heap,heap.length);
		System.out.println(extractMax());
		printHeap(arr,heapSize);
	}

	private static int extractMax() {
		if(heapSize<=0)
			return Integer.MAX_VALUE;
		if(heapSize==1){
			return arr[--heapSize];
		}
		int temp=arr[0];
		arr[0]=arr[heapSize-1];
		arr[heapSize-1]=temp;
		maxHeapify(arr, 0, --heapSize);
		
		return temp;
		
	}

	private static void printHeap(int[] heap,int length) {
		for(int i=0;i<length;i++){
			System.out.print(heap[i]+" ");
		}
		System.out.println();
		
		
	}

	private static void insertKey(int value) {
		if(heapSize==capacity){
			System.out.print("Heap Full");
			return;
		}
		heapSize++;
		int index=heapSize-1;
		arr[index]=value;
		while(index!=0 && arr[parent(index)]<arr[index]){
		int temp=arr[parent(index)];
		arr[parent(index)]=arr[index];
		arr[index]=temp;
		index=parent(index);
		}
		
		
	}

	private static int parent(int index) {
		// TODO Auto-generated method stub
		return (index-1)/2;
	}
	private static int left(int index) {
		// TODO Auto-generated method stub
		return 2*index+1;
	}
	private static int right(int index) {
		// TODO Auto-generated method stub
		return 2*index+2;
	}

	private static void buildHeap(int[] arr) {
		int len=arr.length;
		int start=len/2-1;
		for(int i=start;i>=0;i--){
			maxHeapify(arr,i,arr.length);
		}
		
	}

	private static void maxHeapify(int[] arr, int i,int length) {
		int largest=i;
		int left=left(i);
		int right=right(i);
		if(left<length && arr[left]>arr[largest])
			largest=left;
		if(right<length && arr[right]>arr[largest])
			largest=right;
		if(largest!=i){
			int temp=arr[largest];
			arr[largest]=arr[i];
			arr[i]=temp;
			maxHeapify(arr, largest,length);
		}
		
	}

}
