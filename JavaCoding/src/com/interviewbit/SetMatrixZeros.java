package com.interviewbit;

import java.util.ArrayList;

public class SetMatrixZeros {

	public static void main(String[] args) {

		SetMatrixZeros obj = new SetMatrixZeros();
		ArrayList<ArrayList<Integer>> a = new ArrayList<>();
		ArrayList<Integer> int1 = new ArrayList<>();
		int1.add(1);
		int1.add(1);

		ArrayList<Integer> int2 = new ArrayList<>();
		int2.add(0);
		int2.add(0);
		
		a.add(int1);
		a.add(int2);

		obj.setZeroes(a);
		
		print(a);
	}

	private static void print(ArrayList<ArrayList<Integer>> a) {

		for(ArrayList<Integer> obj:a){
			for(int i:obj){
				System.out.print(i+"  ");
			}
			System.out.println();
		}
	}

	public void setZeroes(ArrayList<ArrayList<Integer>> a) {
		boolean isCol = false;
		for (int i = 0; i < a.size(); i++) {
			if (a.get(i).get(0) == 0) {
				isCol = true;
			}
			for (int j = 1; j < a.get(i).size(); j++) {
				if (a.get(i).get(j) == 0) {
					a.get(i).set(0, -1);
					a.get(0).set(j, -1);
				}
			}
		}

		for (int i = 1; i < a.size(); i++) {
			for (int j = 1; j < a.get(i).size(); j++) {
				if (a.get(i).get(0) == -1 || a.get(0).get(j) == -1) {
					a.get(i).set(j, 0);
				}
			}
		}
		if (a.get(0).get(0) == -1) {
			for (int i = 0; i < a.get(0).size(); i++) {
				a.get(0).set(i, 0);
			}
		}
		if (isCol) {
			for (int i = 0; i < a.size(); i++) {
				a.get(i).set(0, 0);
			}
		}
	}

}
