
import java.util.ArrayList;

public class Problem29 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ArrayList<Power> inv = new ArrayList<Power>();
		Power theList[] = new Power().getDecomposablePowers(500);
		
		Power current = new Power();
		for(int i = 2; i <= 500; i++) {
			for(int j = 2; j <= 500; j++) {
				current = new Power(i, j);
				if(!current.decompose(theList)) {
					if(!searchArrListForPower(current, inv)) {
						inv.add(current);
					}
				}
				else {
					if(!searchArrListForPower(current, inv)) {
						inv.add(current);
					}
				}
				
			}
			
		}
		System.out.println(inv.size());
	}

	public static boolean searchArrListForPower(Power a, ArrayList<Power> g) {
		for(int i = 0; i < g.size(); i++) {
			if(a.isEqual(a, g.get(i))) {
				return true;
			}
		}
		return false;
	}

}
