package fractal;

import mountain.Mountain;
import mountain.Point;
import koch.Koch;

public class FractalApplication {
	public static void main(String[] args) {
		Fractal[] fractals = new Fractal[2];
		fractals[0] = new Koch(300);
		fractals[1] = new Mountain(new Point(300, 200), new Point(500, 400), new Point(100, 350), 7);
	    new FractalView(fractals, "Fraktaler");
	}
}
