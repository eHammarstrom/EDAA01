package calculator;

import static calculator.Operation.*;

public class StackComputing {
	CalculatorStack cs;
	private boolean isPressed = false;
	private boolean isOperated = false;
	
	public StackComputing() {
		cs = new CalculatorStack();
	}
	
	public int[] getStack() {
		return cs.getStack();
	}
	
	public void setIsPressed(boolean set) { isPressed = set; }
	
	public boolean getIsPressed() { return isPressed; }
	
	public void setIsOperated(boolean set) { isOperated = set; }
	
	public boolean getIsOperated() { return isOperated; }
	
	public void execute(Operation operation) {
		isPressed = true;
		
		switch (operation) {
		case PLUS:
			plus();
			isOperated = true;
			break;
		case MINUS:
			minus();
			isOperated = true;
			break;
		case TIMES:
			times();
			isOperated = true;
			break;
		case DIVIDES:
			divides();
			isOperated = true;
			break;
		case ENTER:
			enter();
			break;
		case CLEAR:
			clear();
			break;
		case CHS:
			chs();
			break;
		case CLEARSTACK:
			clearstack();
			break;
		}
	}
	
	private int plus() {
		int temp = cs.pop() + cs.pop();
		
		return cs.push(temp);
	}
	
	private int minus() {
		int temp0 = cs.pop();
		int temp1 = cs.pop();
		
		return cs.push(temp1 - temp0);
	}
	
	private int times() {
		int temp = cs.pop() * cs.pop();
		
		return cs.push(temp);
	}
	
	private int divides() {
		int temp = -1;
		int temp0 = cs.pop();
		int temp1 = cs.pop();
		
		if (temp0 != 0) {
			temp = temp1 / temp0;
			return cs.push(temp);
		} else {
			cs.push(0);
			cs.push(0);
			return temp;
		}
	}
	
	private int enter() {
		int temp0 = cs.pop();
		cs.push(temp0);
		return cs.push(temp0);
	}
	
	private void clear() {
		cs.pop();
		cs.push(0);
	}
	
	private void chs() {
		int temp = cs.pop();
		cs.push(-temp);
	}
	
	private void clearstack() {
		for (int i = 0; i < 5; i++) 
			cs.push(0);
	}
}
