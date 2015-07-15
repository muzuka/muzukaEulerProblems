
/*
 * Finds the largest prime factor of the number 600851475143
 *
 * written by: Sean Brown
 */


public class Problem3 {

    public static void main(String args[]) {

		Long target = 600851475143L;
		int currentp = 0;
		
		for(int i = 6857; i < target; i++) {
		    if(isPrime(i)) {
				if(target % i == 0) {
				    currentp = i;
				    System.out.println(i);
				    break;
				}
		    }
		}
		System.out.println(currentp);
    }

    public static boolean isPrime(int prime) {
		if(prime == 1) {
		    return false;
		}
		else if(prime == 2) {
		    return true;
		}
		for(int a = 2; a < prime; a++) {
		    if(prime % a == 0) {
			return false;
		    }
		}
		return true;
    }

}