import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import org.w3c.dom.events.Event;

public class Controller extends WindowAdapter implements ActionListener {
	private View v;
	
	public Controller (View uIn) {
		v = uIn;
	}
	
	@Override
	
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		JButton choice = (JButton) e.getSource();

		FileManager fm = new FileManager();
		if(choice.getText().equals("Open")) {
			String filePath = v.getFileName();
			String fileContent = fm.openFile(filePath);
			v.setText(fileContent);
			
		} else if (choice.getText().equals("New")) {
			String fileContent = "";
			v.setText(fileContent);
			
		} else if (choice.getText().equals("Save")) {
			String fileContent = v.getTextArea();
			File filePath = v.selectDir();
			fm.saveFile(filePath ,fileContent);
			
		} else if (choice.getText().equals("Save As")) {
			String filePath = v.getFileName();
			String fileContent = v.getTextArea();
			fm.saveAsFile(filePath, fileContent);
			
		} else if (choice.getText().equals("Cut")) {
			v.viewCut();
			
		} else if (choice.getText().equals("Copy")) {
			v.viewCopy();
			
		} else if (choice.getText().equals("Paste")) {
			v.viewPaste();
		}
		
	}
	public String actionPerformedConsole(int choice, String filePath) {
		FileManager fm = new FileManager();
		String fileContent = null;
		if (choice == 1) {
			fileContent = fm.openFile(filePath);
		}
		else if (choice == 2) {
			fm.saveAsFile(filePath, fileContent);
			fileContent = "Sådär nu har vi skapat en fil i " + filePath;
		}
		
		return fileContent;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		GetUiFactory g = new GetUiFactory();
		System.out.println("Hej och välkommen till notepad editor");
		System.out.println("1. Grafisk meny");
		System.out.println("2. Console meny");
		System.out.println("Välj ett av följande: ");
		Scanner sc = new Scanner(System.in);
		int num = Integer.parseInt(sc.nextLine());
		System.out.println("Du har valt följande: " + num);
		
		if (num == 1) {
			g.getUi("GRAFISK");
		} else if (num == 2) {
			g.getUi("CONSOLE");
		}
		else {
			System.out.println("Error");
		}
	}
}