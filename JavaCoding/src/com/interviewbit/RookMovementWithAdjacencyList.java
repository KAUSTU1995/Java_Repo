package com.interviewbit;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class RookMovementWithAdjacencyList {
	public static void main(String[] args) {
		RookMovementWithAdjacencyList rook=new RookMovementWithAdjacencyList();
		String[] matrix={"00010", "00011", "11000", "01000"};
		int result=rook.solve(1,1,4,5,matrix );
		System.out.println(result);

	}

public int solve(int A, int B, int C, int D, String[] E) {
    int row=E.length;
    int col=E[0].length();
    int arr[][]=new int[row][col];
    convertToIntegerMatrix(E, row, col, arr);
    
    int v=row*col;
    ArrayList<ArrayList<Integer>> list = initializeAdjacencyList(v);
    
    addEdges(arr,list,v);
    
    int source=(A-1)*col+(B-1);
    int dest=(C-1)*col+(D-1);
    int min=getShortestDist(list,source,dest,v);
    
    return min;
    
}

private ArrayList<ArrayList<Integer>> initializeAdjacencyList(int v) {
	ArrayList<ArrayList<Integer>> list=new ArrayList<ArrayList<Integer>>(v);
     for(int i=0;i<v;i++){
        ArrayList<Integer> ar1=new ArrayList<Integer>();
        list.add(ar1);
    }
	return list;
}

private void convertToIntegerMatrix(String[] E, int row, int col, int[][] arr) {
	for(int i=0;i<row;i++){
        for(int j=0;j<col;j++){
            char c=E[i].charAt(j);
            arr[i][j]=Character.getNumericValue(c);
        }
    }
}
private int getShortestDist(ArrayList<ArrayList<Integer>> list,int src,int dest,int v){
    int dist[]=new int[v];
    Queue<Integer> q = new LinkedList<>(); 
    boolean visited[]=new boolean[v];
    for (int i = 0; i < v; i++) { 
    visited[i] = false; 
    dist[i] = Integer.MAX_VALUE; 
    }
    visited[src] = true; 
    dist[src] = 0; 
    q.add(src);
     while (q.size()!=0) { 
    int u = q.peek(); 
    q.remove(); 
    for (int i = 0; i < list.get(u).size(); i++) { 
        if (visited[list.get(u).get(i)] == false) { 
            visited[list.get(u).get(i)] = true; 
            dist[list.get(u).get(i)] = dist[u] + 1; 
            q.add(list.get(u).get(i)); 
 
            if (list.get(u).get(i) == dest) 
               return dist[dest]; 
        } 
    } 
}
return -1;
    
}


private void addEdges(int[][] arr,ArrayList<ArrayList<Integer>> list,int v){
    int row=arr.length;
    int col=arr[0].length;
    for(int i=0;i<row;i++){
        for(int j=0;j<col;j++){
                int index=i*col+j;
                if(arr[i][j]==1)
                continue;
                for(int k=j+1;k<col;k++){
                    if(arr[i][k]==0){
                        int pos=i*col+k;
                        list.get(index).add(pos);
                        list.get(pos).add(index);
                    }
                    else
                    break;
                }
                for(int k=i+1;k<row;k++){
                    if(arr[k][j]==0){
                        int pos=k*col+j;
                        list.get(index).add(pos);
                        list.get(pos).add(index);
                    }
                    else
                    break;
                }
        }
    }
}

}
