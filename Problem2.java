
/*
 * This program solves the Euler problem #2
 * It finds the sum of the even numbers in the fibbonaci sequence up to the number below 4 million.
 * 
 * 
 *
 */


public class Problem2 {

    public static void main(String args[]) {

		int sum = 0;
		int curfib = 0;
		int i = 0;

		while(curfib < 4000000) {
		    curfib = fib(i);
		    if(curfib % 2 == 0) {
			sum = sum + curfib;
		    }
		    i++;
		}
		
		System.out.println(sum);
    }

    public static int fib(int n) {
		if(n < 2) {
		    return n;
		}
		else {
		    return fib(n-1) + fib(n-2);
		}
    }
}