package calculator;

import java.util.Scanner;

import static calculator.Operation.*;

public class RunTextMode {
	
	public static void main(String[] args) {
		StackComputing stc = new StackComputing();
		
		Scanner sc = new Scanner(System.in);
		
		while (!sc.next().equalsIgnoreCase("quit")) {
			String inData = sc.next();
			
			switch (inData) {
			case "+":
				stc.execute(PLUS);
				break;
			case "*":
				stc.execute(TIMES);
				break;
			case "/":
				stc.execute(DIVIDES);
				break;
			}
		}
	}
}
