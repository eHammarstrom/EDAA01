package phonebook;
import javax.swing.*;

import java.awt.event.*;

@SuppressWarnings("serial")
public class RemoveMenu extends JMenuItem implements ActionListener {
	private PhoneBook phoneBook;
	private PhoneBookGUI gui;
	
	public RemoveMenu(PhoneBook phoneBook, PhoneBookGUI gui) {
		super("Remove");
		this.phoneBook = phoneBook;
		this.gui = gui;
		addActionListener(this);
	}
	
	 public void actionPerformed(ActionEvent e) {
		 String name = JOptionPane.showInputDialog("Input name: ");
		 
		 if (name != null && name.length() > 1) {
			 phoneBook.remove(name);
			 gui.getMessageArea().append(name + " has been removed.\n");
		 }
	 }
}
