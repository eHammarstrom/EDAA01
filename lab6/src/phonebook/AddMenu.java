package phonebook;
import javax.swing.*;
import java.awt.event.*;

@SuppressWarnings("serial")
public class AddMenu extends JMenuItem implements ActionListener {
	private PhoneBook phoneBook;
	private PhoneBookGUI gui;
	
	public AddMenu(PhoneBook phoneBook, PhoneBookGUI gui) {
		super("Add");
		this.phoneBook = phoneBook;
		this.gui = gui;
		addActionListener(this);
	}
	
	 public void actionPerformed(ActionEvent e) {
		 String name = JOptionPane.showInputDialog("Input name: ");
		 
		 String number = JOptionPane.showInputDialog("Input number: ");
		 
		 if (number != null && name != null && name.length() > 1 && number.length() > 1) {
			 phoneBook.put(name, number);
			 gui.getMessageArea().append(name + " - " + number + " has been added.\n");
		 }
	 }
}
