package Sorting;

public class MergeSort {
	public static void main(String[] args) {
		int arr[]= {1,4,7,2,65,35,33,1,2,7,6,98,23,12};
		MergeSort obj=new MergeSort();
		obj.mergesort(arr,0,arr.length-1);
		for(int i:arr) {
			System.out.print(i+" ");
		}
	}
	
	public void mergesort(int[] arr,int start,int end) {
		if(start<end) {
			int mid=start+(end-start)/2;
			mergesort(arr,start,mid);
			mergesort(arr,mid+1,end);
			merge(arr,start,mid,end);
		}
	}

	private void merge(int[] arr, int start, int mid, int end) {
		int n1=mid-start+1;
		int n2=end-mid;
		int l[]=new int[n1];
		int r[]=new int[n2];
		int start1=0;
		int start2=0;
		for(int i=0;i<n1;i++) {
			l[i]=arr[start+i];
		}
		for(int i=0;i<n2;i++) {
			r[i]=arr[mid+1+i];
		}
		while(start1<n1 && start2<n2) {
			if(l[start1]<=r[start2]) {	
				arr[start++]=l[start1++];
			}else {
				arr[start++]=r[start2++];
			}
		}
		while(start1<n1) {
			arr[start++]=l[start1++];
		}
		while(start2<n2) {
			arr[start++]=r[start2++];
		}
	}

}
