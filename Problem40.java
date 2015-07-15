
import java.util.Scanner;

// Builds Champernowne's constant and works with it
public class Problem40 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int num = 0;
		
		System.out.println("Enter a number:\n");
		num = in.nextInt();
		
		System.out.println(champBuild(num));
		
	}
	
	// Builds Champernowne Constant to n or more digits
	public static char champBuild(int n) {
		String champ = "";
		int i = 1;
		while(champ.length() <= n) {
			champ = champ + Integer.toString(i);
			i++;
		}
		return champ.charAt(n-1);
		
	}

}