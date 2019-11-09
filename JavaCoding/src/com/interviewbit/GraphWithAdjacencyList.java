package com.interviewbit;

import java.util.ArrayList;

public class GraphWithAdjacencyList {
	public int vertex;
	
	public ArrayList<ArrayList<Integer>> adjacencyList=new ArrayList<ArrayList<Integer>>();
	
	public GraphWithAdjacencyList(int vertex){
		this.vertex=vertex;
		for(int i=0;i<vertex;i++){
			adjacencyList.add(new ArrayList<Integer>());
		}
	}
	
	public void addDirectedEdges(int i, int j) {
		adjacencyList.get(i).add(j);
		
	}
	
	public void printAdjacencyList(){
		for(int i=0;i<adjacencyList.size();i++){
			System.out.print(i+" -> ");
			for(int j=0;j<adjacencyList.get(i).size();j++){
				System.out.print( adjacencyList.get(i).get(j)+" ");
			}
			System.out.println();
		}
	}

}
