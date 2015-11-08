package general;

import java.util.ArrayList;

public class District {
	ArrayList<Integer> beats;
	
	public District() {
		beats = new ArrayList<Integer>(100);
	}
	
	public void set(int index, Integer element) {
		beats.set(index, element);
	}
	
	public Integer get(int index) {
		return beats.get(index);
	}
	
	public Integer getTotal() {
		int total = 0;
		for(Integer integer : beats) {
			total += integer;
		}
		return total;
	}
}
