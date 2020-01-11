//Source: GeeksForGeeks Youtube array playlist

//Union and Intersection of two sorted arrays | GeeksforGeeks
package com.basic1;

public class UnionAndIntersectionOfArray {
	 public static void main(String argr[]){
		 int ar1[]={1,3,4,5,7};
		 int ar2[]={2,3,5,6};
		 union(ar1,ar2);
		 intersection(ar1,ar2);
		 
	 }

	private static void intersection(int[] ar1, int[] ar2) {
		int n1=ar1.length;
		int n2=ar2.length;
		int i=0,j=0;
		while(i<n1 && j<n2){
			if(ar1[i]==ar2[j]){
				System.out.print(ar1[i]+" ");
				i++;
				j++;
			}
			else if(ar1[i]>ar2[j]){
				j++;
			}
			else{
				i++;
			}
		}
		System.out.println();

		
	}

	private static void union(int[] ar1, int[] ar2) {
		int n1=ar1.length;
		int n2=ar2.length;
		int i=0,j=0;
		while(i<n1 && j<n2){
			if(ar1[i]==ar2[j]){
				System.out.print(ar1[i]+" ");
				i++;
				j++;
			}
			else if(ar1[i]<ar2[j]){
				System.out.print(ar1[i]+" ");
				i++;
			}
			else{
				System.out.print(ar2[j]+" ");
				j++;
			}
		}
		while(i<n1){
			System.out.print(ar1[i]+" ");
			i++;
		}
		while(j<n2){
			System.out.print(ar2[j]+" ");
			j++;
		}
		System.out.println();
		
	}

}
