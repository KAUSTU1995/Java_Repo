package Fibonacci;

public class RecursiveFibonacci {
	public static void main(String arg[]){
		System.out.println(fib(4));
		System.out.println(fib(7));
		System.out.println(fib(8));
	}

	private static int fib(int n) {
		// TODO Auto-generated method stub
		if(n==1 || n==0)
			return n;
		return fib(n-1)+fib(n-2);
		
	}

}
