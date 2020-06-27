package dynamicprogramming;

import java.util.ArrayList;

public class RectangleSum {
	public static void main(String[] args) {
		int[][] A= {{1, 2, -1, -4, -20},{-8, -3, 4, 2, 1},{3, 8, 10, 1, 3},{-4, -1, 1, 7, -6}};
		RectangleSum obj=new RectangleSum();
		System.out.println(obj.solve(A));
		
	}

    public int solve(int[][] A) {
        int ans=Integer.MIN_VALUE;
        int n=A.length;
        int m=A[0].length;
        
        for(int i=0;i<m;i++){
            ArrayList<Integer> temp=new ArrayList<>();
            for(int j=i;j<m;j++){
                for(int k=0;k<n;k++){
                    int val=A[k][j];
                    if(temp.size()>k){
                        temp.set(k,val+temp.get(k));
                    }
                    else{
                        temp.add(k,val);
                    }
                }
                ans=Math.max(ans,kadane(temp));
            }
        }
        return ans;
    }
    int kadane(ArrayList<Integer> A){
        int ans=Integer.MIN_VALUE;
        int n=A.size();
        int sum=0;
        for(int i=0;i<n;i++){
            if(sum+A.get(i)>0){
                sum+=A.get(i);
            }
            else{
                sum=0;
            }
            ans=Math.max(ans,sum);
        }
        return ans;
    }


}
