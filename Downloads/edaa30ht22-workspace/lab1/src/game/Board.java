package game;

public class Board {
	
	private int noPins;

	
	public int getNoPins() {
		return noPins;
	}
	
	public void setUp(int a) {
		noPins = a;
	}
	
	public int takePins(int a) {
		
		noPins -= a;
		return noPins;
	}

}