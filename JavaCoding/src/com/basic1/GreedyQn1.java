package com.basic1;

public class GreedyQn1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		GreedyQn1 qq=new GreedyQn1();
		int[] B=new int[]{1,3};
		System.out.println(qq.solve(2, B));
		

	}
	
	    public String solve(int A, int[] B) {
	        if(B[0]!=1 && B[0]!=2)
	        return "No";
	        int len=B.length;
	        boolean arr[]=new boolean[4];
	        arr[1]=true;
	        arr[2]=true;
	        arr[3]=false;
	        for(int i=0;i<len;i++){
	            if(arr[1]==true && arr[2]==true){
	                if(B[i]!=1 && B[i]!=2){
	                    return "No";
	                }
	                else{
	                    if(B[i]==1){
	                        arr[2]=false;
	                        arr[3]=true;
	                    }else{
	                        arr[1]=false;
	                        arr[3]=true;
	                    }
	                }
	            }
	            else if(arr[1]==true && arr[3]==true){
	                if(B[i]!=1 && B[i]!=3){
	                    return "No";
	                }
	                else{
	                    if(B[i]==1){
	                        arr[2]=true;
	                        arr[3]=false;
	                    }else{
	                        arr[1]=false;
	                        arr[2]=true;
	                    }
	                }
	            }
	            else if(arr[2]==true && arr[3]==true){
	                if(B[i]!=2 && B[i]!=3){
	                    return "No";
	                }
	                else{
	                    if(B[i]==2){
	                        arr[3]=false;
	                        arr[1]=true;
	                    }else{
	                        arr[2]=false;
	                        arr[1]=true;
	                    }
	                }
	            }
	            else{
	                return "No";
	            }
	        }
	        return "Yes";
	    }
	


}
