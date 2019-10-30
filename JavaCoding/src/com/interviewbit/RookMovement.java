package com.interviewbit;

import java.util.LinkedList;
import java.util.Queue;
public class RookMovement {

	public static void main(String[] args) {
		RookMovement rook=new RookMovement();
		String[] matrix={"00010", "00011", "11000", "01000"};
		int result=rook.solve(1,1,4,5,matrix );
		System.out.println(result);

	}
    public int solve(int A, int B, int C, int D, String[] E) {
        int row=E.length;
        int column=E[0].length();
        Point adjacencyMatrix[][]=new Point[row][column];
        convertToAdjacencyMatrix(E, row, column, adjacencyMatrix);
        return getShortestStepsMatrix(adjacencyMatrix,A-1,B-1,C-1,D-1,row,column);
        
    }
	private void convertToAdjacencyMatrix(String[] E, int row, int column, Point[][] adjacencyMatrix) {
		for(int i=0;i<row;i++){
            for(int j=0;j<column;j++){
                char c=E[i].charAt(j);
                int val=Character.getNumericValue(c);
                adjacencyMatrix[i][j]=new Point(i,j,val);
            }
        }
	}
    private int getShortestStepsMatrix(Point[][] adjacencyMatrix,int A, int B,int C,int D,int row,int column){
        int dist[][]=new int[row][column];
        Queue<Point> q = new LinkedList<>(); 
        boolean visited[][]=new boolean[row][column];
        defaultValueSetter(row, column, dist, visited);
        visited[A][B] = true; 
        dist[A][B] = 0; 
        q.add(adjacencyMatrix[A][B]);
        while(q.size()!=0){
            Point p=q.peek();
            q.remove();
            checkUp(q,p,adjacencyMatrix,visited,dist);
            checkDown(q,p,adjacencyMatrix,visited,dist);
            checkLeft(q,p,adjacencyMatrix,visited,dist);
            checkRight(q,p,adjacencyMatrix,visited,dist);
        }
        return dist[C][D];
    }
	private void defaultValueSetter(int row, int column, int[][] dist, boolean[][] visited) {
		for (int i = 0; i < row; i++) {
            for(int j=0;j<column;j++){
                visited[i][j] = false; 
                dist[i][j] = 0; 
            }
       
        }
	}
     private void checkUp(Queue<Point> q,Point p,Point[][] adjacencyMatrix,boolean[][] visited,int[][] dist){
             for(int j=p.x;j>=0;j--){
                 Point up=adjacencyMatrix[j][p.y];
                 if(up.value!=1 && visited[up.x][up.y]==false){
                 q.add(up);
                 visited[up.x][up.y]=true;
                 dist[up.x][up.y]=dist[p.x][p.y]+1;
                 }
                 else if(up.value==1)
                 break;
             }
     }
     private void checkDown(Queue<Point> q,Point p,Point[][] adjacencyMatrix,boolean[][] visited,int[][] dist){
    	 int row=adjacencyMatrix.length;
    	 for(int j=p.x;j<row;j++){
    		 Point up=adjacencyMatrix[j][p.y];
    		 if(up.value!=1 && visited[up.x][up.y]==false){
    			 q.add(up);
    			 visited[up.x][up.y]=true;
    			 dist[up.x][up.y]=dist[p.x][p.y]+1;
    		 }
    		 else if(up.value==1)
    			 break;
    	 }
     }
    private void checkLeft(Queue<Point> q,Point p,Point[][] adjacencyMatrix,boolean[][] visited,int[][] dist){
    	for(int j=p.y;j>=0;j--){
    		Point up=adjacencyMatrix[p.x][j];
    		if(up.value!=1 && visited[up.x][up.y]==false){
    			q.add(up);
    			visited[up.x][up.y]=true;
    			dist[up.x][up.y]=dist[p.x][p.y]+1;
    		}
    		else if(up.value==1)
    			break;
    	}
     }
     private void checkRight(Queue<Point> q,Point p,Point[][] adjacencyMatrix,boolean[][] visited,int[][] dist){
    	 int col=adjacencyMatrix[0].length;
    	 for(int j=p.y;j<col;j++){
    		 Point up=adjacencyMatrix[p.x][j];
    		 if(up.value!=1 && visited[up.x][up.y]==false){
    			 q.add(up);
    			 visited[up.x][up.y]=true;
    			 dist[up.x][up.y]=dist[p.x][p.y]+1;
    		 }
    		 else if(up.value==1)
    			 break;
    	 }
     }
    class Point{
        int x;
        int y;
        int value;
        Point(int x,int y,int value){
            this.x=x;
            this.y=y;
            this.value=value;
        }
    }
}