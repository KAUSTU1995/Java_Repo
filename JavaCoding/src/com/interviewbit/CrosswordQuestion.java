package com.interviewbit;

public class CrosswordQuestion {
	static String matrix[]={
			"*##a#*****",
			"##********",
			"*#*b**#b**",
			"*##b**#b**",
			"*##fb*#b**",
			"*#**h*#b*#",
			"*##n**#b**",
			"*#t######*",
			"*##r**p***",
			"##*######b"
	};
	static int rowLength=matrix.length;
	static int columnLength=matrix[0].length();
	static String word="";

	public static void main(String[] args) {

		 word="cat";
		boolean isSolvable=solvePuzzle();
		System.out.print(isSolvable);

	}

	private static boolean solvePuzzle() {
		return checkAllRowInMatrix() || checkAllColumnInMatrix();
	}

	private static boolean checkAllColumnInMatrix() {
		
		int maxColumnLength=rowLength-word.length()+1;
		if(maxColumnLength>=0){
			for(int i=0;i<maxColumnLength;i++){
				for(int j=0;j<columnLength;j++){
					if(checkSingleColumn(i,j))
						return true;
				}
			}
		}
		return false;
	}

	private static boolean checkAllRowInMatrix() {
		int maxRowLength=columnLength-word.length()+1;
		if(maxRowLength>=0){
			for(int i=0;i<rowLength;i++){
				for(int j=0;j<maxRowLength;j++){
					if(checkSingleRow(i,j))
						return true;
				}
			}
		}
		return false;
	}


	private static boolean checkSingleColumn(int i, int j) {
		int wordIndex=0;
		int matrixIndex=i;
		for( int p=0;p<word.length();p++){
			char c=matrix[matrixIndex].charAt(j);
			if(c=='#'){
				break;
			}
			else if(c=='*'){
				wordIndex++;
			}
			else if(c==word.charAt(wordIndex)){
				wordIndex++;
			}
			else{
				break;
			}
			matrixIndex++;
		}
		return isVerticalLengthMatchingWord(i, j, wordIndex, matrixIndex);
	}

	private static boolean isVerticalLengthMatchingWord(int i, int j, int wordIndex, int matrixIndex) {
		if(wordIndex==word.length()){
			if((i+matrixIndex)>=matrix.length){
				if((i-1)>=0 && matrix[i-1].charAt(j)=='#')
					return true; 
				else if((i-1)<0)
					return true;
			}
			else if((i+matrixIndex)<matrix[i].length() && matrix[i+matrixIndex].charAt(j)=='#'){
				if((i-1)>=0 && matrix[i-1].charAt(j)=='#')
					return true;
				else if((i-1)<0)
					return true;
			}
		}
		return false;
	}

	private static boolean checkSingleRow(int i, int j) {
		String row=matrix[i].substring(j,matrix[i].length());
		int wordIndex=0;
		int matrixIndex=0;
		for( matrixIndex=0;matrixIndex<word.length();matrixIndex++){
			char c=row.charAt(matrixIndex);
			if(c=='#'){
				break;
			}
			else if(c=='*'){
				wordIndex++;
			}
			else if(c==word.charAt(wordIndex)){
				wordIndex++;
			}
			else{
				break;
			}
		}
		return isHorizontalLengthMatchingWithWord(i, j, wordIndex, matrixIndex);
	}

	private static boolean isHorizontalLengthMatchingWithWord(int i, int j, int wordIndex, int matrixIndex) {
		if(wordIndex==word.length()){ 
			if((j+matrixIndex)>=matrix[i].length() ){
				if((j-1)>=0 && matrix[i].charAt(j-1)=='#')
					return true; 
				else if((j-1)<0)
					return true;
			}
			else if((j+matrixIndex)<matrix[i].length() && matrix[i].charAt(j+matrixIndex)=='#'){ 
				if((j-1)>=0 && matrix[i].charAt(j-1)=='#')
					return true;
				else if((j-1)<0)
					return true;
			}
		}
		return false;
	}

}
