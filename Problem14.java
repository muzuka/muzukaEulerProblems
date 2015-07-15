
public class Problem14 {

	/**
	 * Finds largest Collatz chain with a starting number under a million
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		
		long current;
		int count, maxcount = 0;
		
		for(long i = 1000000; i > 1; i--) {
			current = i;
			count = 0;
			while(current != 1) {
				if(current % 2 == 0) {
					current = current / 2;
				}
				else {
					current = (3 * current) + 1;
				}
				count++;
			}
			
			count++;
			if(count > maxcount) {
				maxcount = count;
			}
		}
		
		System.out.printf("The longest chain is: %d\n", maxcount);

	}

}
