package com.basic1;

public class ThreeNumbersIB {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ThreeNumbersIB obj=new ThreeNumbersIB();
		System.out.println(obj.solve(948125, 570209, 137698, 998981666));//10058
		System.out.println(obj.solve(268,3752,1455,8565));//36
		System.out.println(obj.solve(5883,7384,1592,7931));//6
	}
	
	public int solve(int A, int B, int C, int D) {
		if(A==1 || B==1 || C==1)
			return D-1;
        int count=0;
        int p=D/A;
       if(D%A==0)p--;
       
       int q=D/B;
       if(D%B==0)q--;
       
       int r=D/C;
       if(D%C==0)r--;
       
       int s=D/(A*B);
//       if(D%(A*B)==0)s--;
       
       int t=D/(B*C);
//       if(D%(C*B)==0)t--;
       
       int u=D/(A*C);
//       if(D%(A*C)==0)u--;
       
       int v=D/(A*B*C);
//       if(D%(A*B*C)==0)v--;
       
       count=p+q+r-s-t-u-v;
        return count;
    }
}

