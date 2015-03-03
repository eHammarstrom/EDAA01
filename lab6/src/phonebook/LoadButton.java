package phonebook;
import javax.swing.*;

import java.awt.FileDialog;
import java.awt.Frame;
import java.awt.event.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.ObjectInputStream;
import java.util.Scanner;

public class LoadButton extends JButton implements ActionListener {
	private PhoneBook phoneBook;
	private PhoneBookGUI gui;

	public LoadButton(PhoneBook phoneBook, PhoneBookGUI gui) {
		super("Load");
		this.phoneBook = phoneBook;
		this.gui = gui;
		addActionListener(this);
	}
	
	private void loadFile() {
		JFileChooser fileDialog = new JFileChooser();
		 int returnVal = fileDialog.showOpenDialog(gui);
		 
		 if (returnVal == JFileChooser.APPROVE_OPTION) {
			 File file = fileDialog.getSelectedFile();
			 
			 try {
				Scanner sc = new Scanner(new File(file.getName()));
				String name = null;
				String number = null;
				
				while (sc.hasNextLine()) {
					if (sc.nextLine().equals("*START"))
						name = sc.nextLine();
					while (!(number = sc.nextLine()).equals("*END"))
						phoneBook.put(name, number);
				}
				sc.close();
				
				gui.setPhoneBook(phoneBook);
			} catch (FileNotFoundException e1) {
				e1.printStackTrace();
			}
		 } else {
			 return;
		 }
	}
	
	 public void actionPerformed(ActionEvent e) {
		 loadFile();
		 
		 /* try {
			 FileDialog fd = new FileDialog(new Frame(), "Load...", FileDialog.LOAD);
			 fd.setFile("*.txt");
			 fd.setDirectory(".\\");
			 fd.setLocation(50, 50);
			 fd.show();
			 
			 String fileName = fd.getFile();
			 
			 try {
				 ObjectInputStream in = new ObjectInputStream(new FileInputStream(fileName));
				 
				 phoneBook = (PhoneBook) in.readObject();
			 } catch (Exception exception) {
				 exception.printStackTrace();
			 }
		 } catch (Exception exception) {
			 exception.printStackTrace();
		 } */
		 
		 // http://docs.oracle.com/javase/tutorial/uiswing/components/filechooser.html
		 
		 /* JFileChooser fileDialog = new JFileChooser();
		 int returnVal = fileDialog.showOpenDialog(gui);
		 
		 if (returnVal == JFileChooser.APPROVE_OPTION) {
			 File file = fileDialog.getSelectedFile();
			 
			 try {
				Scanner sc = new Scanner(new File(file.getName()));
				String name = null;
				String number = null;
				
				while (sc.hasNextLine()) {
					if (sc.nextLine().equals("*START"))
						name = sc.nextLine();
					while (!(number = sc.nextLine()).equals("*END"))
						phoneBook.put(name, number);
				}
				sc.close();
				
				gui.setPhoneBook(phoneBook);
			} catch (FileNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		 } else {
			 return;
		 } */
	 }
}