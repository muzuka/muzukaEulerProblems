
import java.util.ArrayList;

public class Power {
	int power;
	int base;
	
	public Power() {
		
	}
	
	public Power(Power a) {
		this.power = a.power;
		this.base = a.base;
	}
	
	public Power(int b, int p) {
		this.power = p;
		this.base = b;
	}
	
	public int solve() {
		int pro = 1;
		for(int i = 0; i < power; i++) {
			pro *= base;
		}
		return pro;
	}
	
	public boolean decompose(Power limits[]) {
		for(int i = 0; i < limits.length; i++) {
			if(this.base == limits[i].solve()) {
				this.base = limits[i].base;
				this.power *= limits[i].power;
				return true;
			}
		}
		return false;
	}
	
	public Power[] getDecomposablePowers(int limit) {
		ArrayList<Power> inv = new ArrayList<Power>();
		for(int i = 2; i < limit; i++) {
			for(int j = 2; j < limit; j++) {
				Power a = new Power(i, j);
				if(a.solve() > limit) {
					break;
				}
				else {
					inv.add(a);
				}
			}
			if(new Power(i, 2).solve() > limit) {
				break;
			}
		}
		return inv.toArray(new Power[inv.size()]);
	}
	
	public boolean isEqual(Power a, Power b) {
		if(a.base == b.base && a.power == b.power) {
			return true;
		}
		else {
			return false;
		}
	}
	
	public String toString() {
		return Integer.toString(base) + "^" + Integer.toString(power);
	}
}
