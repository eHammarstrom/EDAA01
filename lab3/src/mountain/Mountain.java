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
		drawTriangle(turtle, order, p1, p2, p3);
	}
	
	private void drawTriangle(TurtleGraphics turtle, int order, Point innerP1, Point innerP2, Point innerP3) {
		if (order == 0) {
			turtle.moveTo(innerP1.getX(), innerP1.getY());
			turtle.penDown();
//			turtle.forwardTo(innerP2.getX(), innerP2.getY());
//			turtle.forwardTo(innerP3.getX(), innerP3.getY());
//			turtle.forwardTo(innerP1.getX(), innerP1.getY());
			turtle.forwardTo(innerP2);
			turtle.forwardTo(innerP3);
			turtle.forwardTo(innerP1);
			turtle.penDown();
		} else {
			drawTriangle(turtle, order - 1, this.p1, this.p2, this.p3);
//			Point p1temp = innerP1;
////		Point p2temp = innerP2;
//			Point p3temp = innerP3;
			Point newP1 = new Point((innerP1.getX() + innerP2.getX()) / 2, (innerP1.getY() + innerP2.getY()) / 2);
			Point newP2 = new Point((innerP2.getX() + innerP3.getX()) / 2, (innerP2.getY() + innerP3.getY()) / 2);
			Point newP3 = new Point((innerP1.getX() + innerP3.getX()) / 2, (innerP1.getY() + innerP3.getY()) / 2);
//			this.p1 = innerP1;
//			this.p2 = innerP2;
//			this.p3 = innerP3;
			drawTriangle(turtle, order - 1, newP1, newP2, newP3);
			drawTriangle(turtle, order - 1, newP1, newP2, innerP3);
			drawTriangle(turtle, order - 1, newP1, innerP2, newP3);
			drawTriangle(turtle, order - 1, innerP1, newP2, newP3);
//			innerP1 = new Point((innerP1.getX() + p2temp.getX()) / 2, (innerP1.getY() + p2temp.getY()) / 2);
//			turtle.moveTo(innerP2);
//			turtle.forwardTo(innerP2.getX() + 20, innerP2.getY());
//			drawTriangle(turtle, order - 1, innerP1, innerP2, innerP3);
		}
	}
}