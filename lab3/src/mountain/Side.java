package mountain;

import fractal.*;

public class Side {
	private Point a;
	private Point b;
	private Point mid;

	public Side(Point a, Point b, Point mid) {
		this.a = a;
		this.b = b;
		this.mid = mid;
	}
	
	public Point getMid() {
		return mid;
	}
//	public Point getMid() {
//		return new Point((a.getX() + b.getX()) / 2, (a.getY() + b.getY()) / 2);
//	}
	
	public Point getA() {
		return a;
	}
	
	public Point getB() {
		return b;
	}
}