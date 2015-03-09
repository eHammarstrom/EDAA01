package phonebook;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JMenuItem;

@SuppressWarnings("serial")
public class ShowAllMenu extends JMenuItem implements ActionListener {
	PhoneBook phoneBook;
	PhoneBookGUI gui;
	
	public ShowAllMenu(PhoneBook phoneBook, PhoneBookGUI gui) {
		super("Show all");
		this.phoneBook = phoneBook;
		this.gui = gui;
		addActionListener(this);
	}
	
	public void actionPerformed(ActionEvent e) {
		StringBuilder sb = new StringBuilder();
		
		sb.append("Showing all:\n");
		
		for (String name : phoneBook.names()) {
			sb.append(" - " + name + " = " + phoneBook.findNumber(name) + "\n");
		}
		
		gui.getMessageArea().append(sb.toString());
	}
}
