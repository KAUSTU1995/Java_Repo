package com.basic1;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class HackerRankPubmatic {
	
	static Trie root;
	
	static class Trie{
        boolean isEnd;
        int count;
        Trie children[]=new Trie[26];
        Trie(){
            isEnd=false;
            count=0;
            for(int i=0;i<26;i++){
                children[i]=null;
            }
        }
    }
	
	public static void main(String arg[])throws IOException{
		List<String> names=new ArrayList<>();
		names.add("jack");
//		names.add("jackson");
		names.add("jackie");
//		names.add("jacquline");
		names.add("dan");
//		names.add("dann");
		names.add("danny");
		names.add("daniel");
		names.add("dasy");
		names.add("dasyss");
		names.add("str");
		List<String> query=new ArrayList<>();
		query.add("jack");
		query.add("dan");
		query.add("dasy");
		query.add("qwe");
		HackerRankPubmatic.findCompletePrefixes(names, query);
	}
	
	public static void findCompletePrefixes(List<String> names, List<String> query) {
		   root=new Trie();
		   for(String str:names)
		   insertInTrie(root, str);

		   List<Integer> result=new ArrayList<>();
		   for(String str:query){
		       int a=search(root, str);
		       result.add(a);
		   }
		   printResult(result);

		   }
	
    private static void printResult(List<Integer> result) {
		// TODO Auto-generated method stub
    	for(int i:result)
    		System.out.print(i+" ");
		
	}

	public static void insertInTrie(Trie root, String str){
        char[] arr=str.toCharArray();
        Trie temp=root;
        for(int i=0;i<arr.length;i++){
            int c=arr[i];
            int idx=c-'a';
            if(temp.children[idx]==null){
            	temp.children[idx]=new Trie();
            	temp.children[idx].count=1;
            }
            else{
            	temp.children[idx].count=temp.children[idx].count+1;
            }
            temp=temp.children[idx];
        }
        temp.isEnd=true;
    }
    public static int search(Trie root, String str){
        char[] arr=str.toCharArray();
        Trie temp=root;
        int idx=0;
        int presentCount=0;
        for(int i=0;i<arr.length;i++){
            int c=arr[i];
            idx=c-'a';
            if(temp.children[idx]==null)
            return 0;
            else{
            	if(temp.children[idx].isEnd==true && i==arr.length-1)
            	presentCount=temp.children[idx].count-1;
            	else{
            		presentCount=temp.children[idx].count;
            	}
            	temp=temp.children[idx];
            }
        }
        return presentCount;
    }

   
}
