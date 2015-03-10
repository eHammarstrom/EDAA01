package calculator;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import calculator.CalculatorFrame.NumField;

public class OprKey extends JButton implements ActionListener {
	private StackComputing sc;
	private Operation opr;
	private CalculatorFrame cf;
	
	public OprKey(StackComputing sc, Operation opr, String label, CalculatorFrame cf) {
		super(label);
		this.sc = sc;
		this.opr = opr;
		this.cf = cf;
		setPreferredSize(new Dimension(85, 50));
		addActionListener(this);
	}
	
	public void actionPerformed(ActionEvent event) {
		sc.execute(opr);
		
		for (int i = 0; i < 4; i++) {
			cf.getFields()[i].setText(Integer.toString(sc.getStack()[i]));
		}
		
		StringBuilder sb = new StringBuilder();
		
		sb.append("Test print the stack:\n");
		for (int n : sc.getStack())
			sb.append(n + "\n");
		
		System.out.println(sb);
	}
	
}
