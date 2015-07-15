
public class Problem48 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		StringNum sum = new StringNum(0);
		for(int i = 1; i <= 1000; i++) {
			sum = sum.add(sum, sum.power(new StringNum(i), new StringNum(i)));
		}
		System.out.println(sum.getNumber());
	}

}
