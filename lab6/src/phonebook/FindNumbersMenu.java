package phonebook;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

@SuppressWarnings("serial")
public class FindNumbersMenu extends JMenuItem implements ActionListener {
	private PhoneBook phoneBook;
	private PhoneBookGUI gui;
	
	public FindNumbersMenu(PhoneBook phoneBook, PhoneBookGUI gui) {
		super("Find number(s)");
		this.phoneBook = phoneBook;
		this.gui = gui;
		addActionListener(this);
	}

	public void actionPerformed(ActionEvent e) {
		String name = JOptionPane.showInputDialog("Input name: ");
		
		if (name != null && name.length() > 1) {
			gui.getMessageArea().append(name + "'s numbers = " + phoneBook.findNumber(name).toString() + "\n");
		}
	}
	
}
