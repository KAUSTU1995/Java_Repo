package backtracking;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Day62LetterPhone {
	public static void main(String[] args) {
		
		Day62LetterPhone obj=new Day62LetterPhone();
		String A="2";
		String[] result=obj.letterCombinations(A);
		for(String str:result) {
			System.out.print(str+" ");
		}
	}
	

    ArrayList<String> result;
    Map<Character,String> map;
    public String[] letterCombinations(String A) {
        int len=A.length();
        result=new ArrayList<>();
        map=new HashMap<>();
        map.put('1',"1");
        map.put('2', "abc");
        map.put('3', "def");
        map.put('4', "ghi");
        map.put('5', "jkl");
        map.put('6', "mno");
        map.put('7', "pqrs");
        map.put('8', "tuv");
        map.put('9', "wxyz");
        map.put('0', "0");
        backtrack(A,0,"");
        int size=result.size();
        String[] send=new String[size];
        int count=0;
        for(String str:result){
            send[count++]=str;
        }
        return send;
    }
    
    public void backtrack(String str,int idx, String temp){
        if(idx==str.length()){
            result.add(temp);
            return;
        }
        
            String tr=map.get(str.charAt(idx));
        for(int i=0;i<temp.length();i++){
            backtrack(str,idx+1,temp+tr.charAt(i));
        }
    }


}
