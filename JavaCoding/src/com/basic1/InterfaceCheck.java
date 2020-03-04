package com.basic1;

import java.io.IOException;

interface A{
	int i=10;
}

 interface B{
	int i=20;
}
public class InterfaceCheck  implements A,B{
	public static void main(String[] args) throws IOException{
//		int i=30;
		 A c =new InterfaceCheck();
		System.out.println(c.i);
	}

}
