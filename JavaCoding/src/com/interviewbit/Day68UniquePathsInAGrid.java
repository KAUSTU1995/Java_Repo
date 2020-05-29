package com.interviewbit;

public class Day68UniquePathsInAGrid {
	int[][] visited;
    int row;
    int column;
    
	public static void main(String[] args) {
		Day68UniquePathsInAGrid obj=new Day68UniquePathsInAGrid();
		int[][] A={{0,1}};
		System.out.println(obj.uniquePathsWithObstacles(A));
	}
	
    public int uniquePathsWithObstacles(int[][] A) {
        row=A.length;
        column=A[0].length;
        visited=new int[row][column];
        if(A[row-1][column-1]==1)
        	return 0;
        getPaths(A,0,0);
        return visited[0][0];
    }
    int getPaths(int[][] A,int i,int j){
        if(i==row-1 && j==column-1){
            return visited[i][j]=1;
        }
        if(i>=row || j>=column){
            return 0;
        }
        if(visited[i][j]!=0){
        	return visited[i][j];
        }
        if(A[i][j]!=1)
        visited[i][j]=getPaths(A,i+1,j)+getPaths(A,i,j+1);
        
        return visited[i][j];
        
    }

}
