package general;

public class District {
	public int[] beats;
	public int num;
	
	public District(int num) {
		beats = new int[100];
		this.num = num;
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
