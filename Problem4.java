
/*
 * Finds the largest product of 2 3-digit numbers.
 * The product must be a palindrome
 *
 */

public class Problem4 {

    public static void main(String args[]) {
	
		int max = 0;
		int total = 0;
		for(int i = 999; i > 0; i--) {
		    for(int j = 999; j > 0; j--) {

				total = i*j;
				
				if(total > max && isPalindrome(total)) {
				    max = total;
				}
		    }
		}

		System.out.printf("The largest palindrome is %d\n", max);
	
    }
    
    public static boolean isPalindrome(int num) {
		String s = Integer.toString(num);
		int i = 0;
		int j = s.length() - 1;

		while(i < j) {

		    if(s.charAt(i) != s.charAt(j)) {
				return false;
		    }

		    i++;
		    j--;
		}
		return true;
    }

}