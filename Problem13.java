
import java.util.Scanner;
import java.io.*;

public class Problem13 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		
		try {
			scan = new Scanner(new File("numbers.txt"));
		}
		catch(FileNotFoundException e) {
			System.out.println("File not Found!");
		}
		
		String lines[] = new String[100];
		int cols[] = new int[51];
		
		// get numbers
		for(int i = 0; i < 100; i++) {
			lines[i] = scan.nextLine();
		}
		
		int j = 0;
		for(int i = 50; i >= 0; i--) {
			
			cols[i] = getSumOfCol(lines, j);
			
			if(i < 49) {
				cols[i] += cols[i+1]/10;
				String ans = Integer.toString(cols[i+1]);
				cols[i+1] = Character.getNumericValue(ans.charAt(ans.length()-1));
			}
			
			j++;
		}
		
		for(int i = 0; i < 50; i++) {
			System.out.print(cols[i]);
			System.out.print(" ");
		}
	}
	
	// Sums all digits in a common column
	public static int getSumOfCol(String l[], int n) {
		
		int sum = 0;
		
		for(int i = 0; i < l.length; i++) {
			try {
				sum += Character.getNumericValue(l[i].charAt((l[i].length()-1)-n));
			}
			catch(StringIndexOutOfBoundsException e) {
				sum += 0;
			}
		}
		
		return sum;
	}
}
