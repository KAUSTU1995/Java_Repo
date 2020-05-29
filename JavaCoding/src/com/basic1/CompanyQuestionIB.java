package com.basic1;

public class CompanyQuestionIB {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str="zrzbmnmgqoo";
		CompanyQuestionIB obj=new CompanyQuestionIB();
		System.out.println(obj.solve(str));
	}
	public int solve(String A) {
        int len=A.length();
        char[] arr=A.toCharArray();
        char[] result=new char[2*len];
        if(isPalindrome(arr,0,A.length()-1)){
            return 0;
        }
        int min=0;
        int count=0;
        for(int i=len-1;i>=0;i--){
            result[count++]=arr[i];
        }
        min=getPalin(arr,0,len-1,1);
        // System.out.print(min+" ");
        for(int i=min;i<len;i++){
            result[count++]=arr[i];
            if(isPalindrome(result,0,count-1)){
               return count-len;
            }
        }
        // System.out.print(count+" ");
        return len-1;
        
    }
    boolean isPalindrome(char[] A,int s,int e){
        if(s>e){
            return true;
        }
        if(A[s]==A[e]){
            s++;
            e--;
            return isPalindrome(A,s,e);
        }
        else{
            return false;
        }
    }
    int getPalin(char[] arr, int s, int e, int p){
         int len=arr.length;
         for(int i=1;i<len;i++){
              if(isPalindrome(arr,0,len-i)){
                  return len-i+1;
        }
         }
         return 1;
    }

}


    

