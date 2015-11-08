package general;

public class District {
	int[] beats;
	
	public District() {
		beats = new int[100];
	}
	
	public void set(int index, Integer element) {
		beats[index] = element;
	}
	
	public Integer get(int index) {
		return beats[index];
	}
	
	public Integer getTotal() {
		int total = 0;
		for(Integer integer : beats) {
			total += integer;
		}
		return total;
	}
}
