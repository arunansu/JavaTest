
public class Fibonacci {
	//Runtime complexity O(2^n)
	//Memory Complexity O(n), because all numbers are computed in one stack.
	public static int fibonacciRec(int n) {
		if(n == 0 || n == 1) return n;
		else return fibonacciRec(n - 2) + fibonacciRec(n - 1);
	}
	
	//Runtime complexity O(n)
	//Memory complexity O(1)
	public static int fibonacci(int n) {
		if(n == 0 || n == 1) return n;
		else {
			int f1 = 0;
			int f2 = 1;
			int res = 0;
			for(int i = 2; i <= n; i++) {
				res = f1 + f2;
				f1 = f2;
				f2 = res;
			}
			return res;
		}
	}
	
	public static void main(String[] args) {
		int n = 4;
		System.out.println("Fib Rec: " + fibonacciRec(n));
		System.out.println("Fib: " + fibonacci(n));
	}
}
