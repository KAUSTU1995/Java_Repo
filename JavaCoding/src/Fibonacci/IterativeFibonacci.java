package Fibonacci;

public class IterativeFibonacci {
	public static void main(String arg[]){
		System.out.println(fib(4));
		System.out.println(fib(7));
		System.out.println(fib(8));
	}

	private static int fib(int i) {
		int a=0;
		int b=1;
		if(i==1 || i==0 ||i==2)
			return i;
		for(int index=2;index<=i;index++){
			int c=a+b;
			a=b;
			b=c;
		}
		return b;
		
	}

}
