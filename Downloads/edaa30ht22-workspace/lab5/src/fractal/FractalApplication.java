package fractal;

import koch.Koch;
import mountain.Mountain;
import mountain.Point;
import mountain.RandomUtilities;

public class FractalApplication {
	public static void main(String[] args) {
		Fractal[] fractals = new Fractal[2];
		fractals[0] = new Koch(300);
		fractals[1] = new Mountain(new Point(500,400), new Point(100,400), new Point(375,100), RandomUtilities.randFunc(30));
	    new FractalView(fractals, "Fraktaler", 600, 600);
	}

}
