package com.interviewbit;

public class Day34KthCharacterInDoubleDecryptedString {
	public static void main(String[] args) {
		String str="ew41fq96tp62jg80xv97jm";
		int B=84;
		Day34KthCharacterInDoubleDecryptedString obj=new Day34KthCharacterInDoubleDecryptedString();
		String result=obj.solve(str, B);
		System.out.println(result);
		
	}
    public String solve(String A, int B) {
        char re=getEncoding(A.toCharArray(),B);
        return String.valueOf(re);
    }
    char getEncoding(char[] str, int k){
    int i, j;
    int n = str.length; 
    int len=0; 
    int num=0;
    int freq; 
    i = 0; 
    String alpha="";
    while (i < n)  
    { 
        j = i; 
         len = 0; 
        freq = 0; 
        while (j < n && Character.isAlphabetic(str[j]))  
        { 
            alpha+=str[j];
            j++; 
            len++; 
        } 
        while (j < n && Character.isDigit(str[j])) 
        { 
            freq = freq * 10 + (str[j] - '0'); 
            j++; 
        }
        num = (num+len)*freq; 
        if (k > num) 
        { 
            k -= num; 
            i = j; 
        }
        else 
        { 
            k--; 
            k %= len; 
            return alpha.charAt(k); 
        } 
    } 
    return str[k - 1];
    }
}
