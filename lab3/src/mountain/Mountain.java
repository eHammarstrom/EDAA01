package mountain;

import java.util.ArrayList;

import fractal.*;

public class Mountain extends Fractal {
//	private int length;
	private Point pa, pb, pc;
	private double dev;
	private ArrayList<Side> sides = new ArrayList<Side>();
	private final int AB = 0, BC = 1, AC = 2;
	
	public Mountain(Point pointA, Point pointB, Point pointC, double deviation) {
		super();
		pa = pointA;
		pb = pointB;
		pc = pointC;
		dev = deviation;
	}

	public String getTitle() {
		return "Mountain fractal";
	}
	
	public void draw(TurtleGraphics turtle) {
//		turtle.moveTo(turtle.getWidth() / 2.0 - length / 2.0, 
//				turtle.getHeight() / 2.0 + Math.sqrt(3.0) * length / 4.0);
		drawTriangle(turtle, order, pa, pb, pc);
	}
	
	private void drawTriangle(TurtleGraphics turtle, int order, Point oldA, Point oldB, Point oldC) {
		if (order == 0) {
			turtle.moveTo(oldA.getX(), oldA.getY());
			turtle.penDown();
//			turtle.forwardTo(innerP2.getX(), innerP2.getY());
//			turtle.forwardTo(innerP3.getX(), innerP3.getY());
//			turtle.forwardTo(innerP1.getX(), innerP1.getY());
			turtle.forwardTo(oldB);
			turtle.forwardTo(oldC);
			turtle.forwardTo(oldA);
			turtle.penDown();
		} else {
//			drawTriangle(turtle, order - 1, this.p1, this.p2, this.p3);
//			Point p1temp = innerP1;
////		Point p2temp = innerP2;
//			Point p3temp = innerP3;
			sides.removeAll(sides);
			Point ab = new Point((oldA.getX() + oldB.getX()) / 2, randFunc(dev) + ((oldA.getY() + oldB.getY()) / 2));
			Point bc = new Point((oldB.getX() + oldC.getX()) / 2, randFunc(dev) + ((oldB.getY() + oldC.getY()) / 2));
			Point ac = new Point((oldA.getX() + oldC.getX()) / 2, randFunc(dev) + ((oldA.getY() + oldC.getY()) / 2));
			Side sideAB = new Side(oldA, oldB, ab);
			Side sideBC = new Side(oldB, oldC, bc);
			Side sideAC = new Side(oldA, oldC, ac);
			sides.add(sideAB);
			sides.add(sideBC);
			sides.add(sideAC);
//			sides.
//			this.p1 = innerP1;
//			this.p2 = innerP2;
//			this.p3 = innerP3;
			
			drawTriangle(turtle, order - 1, sides.get(AB).getMid(), sides.get(BC).getMid(), sides.get(AC).getMid());
			drawTriangle(turtle, order - 1, oldA, sides.get(AC).getMid(), sides.get(AB).getMid());
			drawTriangle(turtle, order - 1, sides.get(AB).getMid(), oldB, sides.get(BC).getMid());
			drawTriangle(turtle, order - 1, sides.get(AC).getMid(), sides.get(BC).getMid(), oldC);
			
			/* drawTriangle(turtle, order - 1, ab, bc, ac);
			drawTriangle(turtle, order - 1, oldA, ac, ab);
			drawTriangle(turtle, order - 1, ab, oldB, bc);
			drawTriangle(turtle, order - 1, ac, bc, oldC); */
			
//			innerP1 = new Point((innerP1.getX() + p2temp.getX()) / 2, (innerP1.getY() + p2temp.getY()) / 2);
//			turtle.moveTo(innerP2);
//			turtle.forwardTo(innerP2.getX() + 20, innerP2.getY());
//			drawTriangle(turtle, order - 1, innerP1, innerP2, innerP3);
		}
	}
	
	private static double randFunc(double dev) {
		double t = dev * Math.sqrt(-2 * Math.log(Math.random()));
		if (Math.random() < 0.5) {
			t = -t;
		}
		return t;
	}
}
