package Fibonacci;

public class RecursiveFibonacciWithDP {
	static int ans[]=new int[100];
	public static void main(String arg[]){
		ans[0]=0;
		ans[1]=1;
		System.out.println(fib(4));
		System.out.println(fib(7));
		System.out.println(fib(8));
	}

	private static int fib(int i) {
		if(ans[i]!=0 ||i==0){
			return ans[i];
		}
		ans[i]=fib(i-1)+fib(i-2);
		return ans[i];
	}

}
