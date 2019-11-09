package com.interviewbit;

import java.util.ArrayList;
import java.util.Stack;

public class DFSImplementation extends  GraphWithAdjacencyList{
	boolean visited[]=new boolean[this.vertex];

	public DFSImplementation(int vertex) {
		super(vertex);
	}

	public static void main(String[] args) {
		DFSImplementation connectedGraph=new DFSImplementation(5);
		addDirectedEdgesInConnectedGraph(connectedGraph);
		connectedGraph.printAdjacencyList();
		connectedGraph.DFSReachableNodes(0);
		
		DFSImplementation disconnectedGraph=new DFSImplementation(5);
		addDirectedEdgesInDisconnectedGrph(disconnectedGraph);
		disconnectedGraph.printAdjacencyList();
		disconnectedGraph.DFSWithAllNodes();
	}

	private static void addDirectedEdgesInDisconnectedGrph(DFSImplementation disconnectedGraph) {
//		disconnectedGraph.addDirectedEdges(0,1);
		disconnectedGraph.addDirectedEdges(0,2);
		disconnectedGraph.addDirectedEdges(1,2);
		disconnectedGraph.addDirectedEdges(1,4);
		disconnectedGraph.addDirectedEdges(2,0);
		disconnectedGraph.addDirectedEdges(2,3);
		disconnectedGraph.addDirectedEdges(3,3);
		
	}

	private void DFSWithAllNodes() {
		for(int i=0;i<this.vertex;i++){
			if(visited[i]==false)
				DFSReachableNodes(i);
		}
	}
	private static void addDirectedEdgesInConnectedGraph(DFSImplementation graph) {
		graph.addDirectedEdges(1,0);
		graph.addDirectedEdges(0,2);
		graph.addDirectedEdges(2,1);
		graph.addDirectedEdges(0,3);
		graph.addDirectedEdges(1,4);
	}

	public void DFSReachableNodes(int vertex){
		
		Stack<Integer> stack=new Stack<>();
		visited[vertex]=true;
		stack.push(vertex);
		while(!stack.empty()){
			int current=stack.peek();
			System.out.print(current+" ");
			stack.pop();			for(int i=0;i<this.adjacencyList.get(current).size();i++){
				if(visited[this.adjacencyList.get(current).get(i)]==false){
					visited[this.adjacencyList.get(current).get(i)]=true;
					stack.push(this.adjacencyList.get(current).get(i));

				}
			}
		}
		System.out.println();

	}



}
