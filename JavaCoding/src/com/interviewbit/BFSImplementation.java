package com.interviewbit;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class BFSImplementation extends  GraphWithAdjacencyList{
	boolean visited[]=new boolean[this.vertex];

	public BFSImplementation(int vertex) {
		super(vertex);
	}

	public static void main(String[] args) {
		BFSImplementation connectedGraph=new BFSImplementation(5);
		addDirectedEdgesInConnectedGraph(connectedGraph);
		connectedGraph.printAdjacencyList();
		connectedGraph.BFSReachableNodes(0);

		BFSImplementation disconnectedGraph=new BFSImplementation(5);
		addDirectedEdgesInDisconnectedGrph(disconnectedGraph);
		disconnectedGraph.printAdjacencyList();
		disconnectedGraph.BFSWithAllNodes();
	}

	private static void addDirectedEdgesInDisconnectedGrph(BFSImplementation disconnectedGraph) {
		disconnectedGraph.addDirectedEdges(0,1);
		disconnectedGraph.addDirectedEdges(0,2);
		disconnectedGraph.addDirectedEdges(1,2);
		disconnectedGraph.addDirectedEdges(1,4);
		disconnectedGraph.addDirectedEdges(2,0);
		disconnectedGraph.addDirectedEdges(2,3);
		disconnectedGraph.addDirectedEdges(3,3);

	}

	private void BFSWithAllNodes() {
		for(int i=0;i<this.vertex;i++){
			if(visited[i]==false)
				BFSReachableNodes(i);
		}
	}
	private static void addDirectedEdgesInConnectedGraph(BFSImplementation graph) {
		graph.addDirectedEdges(1,0);
		graph.addDirectedEdges(0,2);
		graph.addDirectedEdges(2,1);
		graph.addDirectedEdges(0,3);
		graph.addDirectedEdges(1,4);
	}

	public void BFSReachableNodes(int vertex){

		Queue<Integer> queue=new LinkedList<>();
		visited[vertex]=true;
		queue.add(vertex);
		while(!queue.isEmpty()){
			int current=queue.peek();
			System.out.print(current+" ");
			queue.remove();
			for(int i=0;i<this.adjacencyList.get(current).size();i++){
				if(visited[this.adjacencyList.get(current).get(i)]==false){
					visited[this.adjacencyList.get(current).get(i)]=true;
					queue.add(this.adjacencyList.get(current).get(i));

				}
			}
		}
		System.out.println();

	}





}
