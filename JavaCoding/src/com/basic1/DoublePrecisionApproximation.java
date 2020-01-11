package com.basic1;

import java.text.DecimalFormat;

public class DoublePrecisionApproximation {
	public static void main(String[] args) {
		DecimalFormat df=new DecimalFormat(".###");
		String str=df.format(2343.35435435);
		System.out.println(str);
		System.out.println(Math.round(4343.5435435));

	}

}
