package com.basic1;

public class Trie {
	static final int ALPHABET_SIZE=26;
	static class TrieNode{
		TrieNode children[]=new TrieNode[ALPHABET_SIZE];
		boolean isEndOfWord;
		int count=0;
		
		public TrieNode(){
			isEndOfWord=false;
			for(int i=0;i<ALPHABET_SIZE;i++){
				children[i]=null;
			}
		}
	};
	static TrieNode root;
	
	static void insert(String str){
		int length=str.length();
		TrieNode temp=root;
		for(int i=0;i<length;i++){
			int index=str.charAt(i)-'a';
			if(temp.children[index]==null){
				temp.children[index]=new TrieNode();
				temp.children[index].count=1;
			}
			else{
				temp.children[index].count=temp.children[index].count+1;
			}
			temp=temp.children[index];
			
		}
		temp.isEndOfWord=true;
		
	}
	
	static boolean search(String str){
		int length=str.length();
		TrieNode temp=root;
		int index=0;
		for(int i=0;i<length;i++){
			index=str.charAt(i)-'a';
			if(temp.children[index]==null)
				return false;
			temp=temp.children[index];
		}
		if(temp!=null && temp.isEndOfWord)
			return true;
		
		return false;
	}
	static boolean isEmpty(TrieNode root){
		for(int i=0;i<ALPHABET_SIZE;i++){
			if(root.children[i]!=null)
				return false;
		}
		return true;
	}
	
	public static TrieNode delete(TrieNode root,String str,int depth){
		if(root==null)
			return null;
		if(depth==str.length()){
			root.isEndOfWord=false;
			if(isEmpty(root)){
				root=null;
				
			}
			return root;
		}
		int index=str.charAt(depth)-'a';
		root.children[index]=delete(root.children[index],str,depth+1);
		if (isEmpty(root) && root.isEndOfWord == false) {  
	        root = null; 
	    } 
		return root;
	}
	
	public static void printTrie(TrieNode root){
		for(int i=0;i<ALPHABET_SIZE;i++){
			if(root.children[i]!=null){
				char c=(char)(i+97);
				System.out.print(c+" "+root.children[i].count+"|| ");
				printTrie(root.children[i]);
			}
		}
	}
	public static void printTrieBottumup(TrieNode root){
		if(root==null)
			return;
		for(int i=0;i<ALPHABET_SIZE;i++){
			
			if(root.children[i]!=null){
				printTrieBottumup(root.children[i]);	
				
				char c=(char)(i+97);
				System.out.print(c+" ");
			}
		}
	}
	
	
	public static void main(String arg[]){
		String keys[] = {"the", "a", "there", "answer", "any", 
                "by", "bye", "their"};
		String output[] = {"Not present in trie", "Present in trie"};
		root=new TrieNode();
		for(int i=0;i<keys.length;i++){
			insert(keys[i]);
		}
		printTrie(root);
		System.out.println();
		printTrieBottumup(root);
		System.out.println();
		
		if(search("the") == true) 
            System.out.println("the --- " + output[1]); 
        else System.out.println("the --- " + output[0]);
		
		if(search("them") == true) 
            System.out.println("them --- " + output[1]); 
        else System.out.println("them --- " + output[0]);
		
		delete(root,"the",0);
		delete(root,"by",0);
		delete(root,"bye",0);
		if(search("the") == true) 
            System.out.println("the --- " + output[1]); 
        else System.out.println("the --- " + output[0]);
		
		printTrie(root);
		System.out.println();
		printTrieBottumup(root);
	}
	
	

}
