package mountain;

import fractal.*;

public class Mountain extends Fractal {
//	private int length;
	private Point p1, p2, p3;
	
	public Mountain(Point p1, Point p2, Point p3) {
		super();
		this.p1 = p1;
		this.p2 = p2;
		this.p3 = p3;
	}

	public String getTitle() {
		return "Mountain fractal";
	}
	
	public void draw(TurtleGraphics turtle) {
//		turtle.moveTo(turtle.getWidth() / 2.0 - length / 2.0, 
//				turtle.getHeight() / 2.0 + Math.sqrt(3.0) * length / 4.0);
		drawTriangle(turtle, order, this.p1, this.p2, this.p3);
	}
	
	private void drawTriangle(TurtleGraphics turtle, int order, Point innerP1, Point innerP2, Point innerP3) {
		if (order == 0) {
			turtle.penDown();
			turtle.moveTo(innerP1.getX(), innerP1.getY());
			turtle.forwardTo(innerP2);
			turtle.forwardTo(innerP3);
			turtle.forwardTo(innerP1);
			turtle.penDown();
		} else {
			drawTriangle(turtle, order - 1, this.p1, this.p2, this.p3);
			Point p1temp = innerP1;
			innerP1 = new Point((innerP1.getX() + innerP2.getX()) / 2, (innerP1.getY() + innerP2.getY()) / 2);
			innerP2 = new Point((innerP2.getX() + innerP3.getX()) / 2, (innerP2.getY() + innerP3.getY()) / 2);
			innerP3 = new Point((p1temp.getX() + innerP3.getX()) / 2, (p1temp.getY() + innerP3.getY()) / 2);
			drawTriangle(turtle, order - 1, innerP1, innerP2, innerP3);
			turtle.moveTo(this.p1.getX(), this.p1.getY());
			drawTriangle(turtle, order - 1, this.p1, innerP1, innerP3);
		}
	}
}
