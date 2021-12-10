import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;
import javax.swing.filechooser.FileSystemView;

abstract class ui{
}

class ViewConsoles extends ui {
	public ViewConsoles () {
		Controller c = new Controller(null);
		System.out.println("1. Läs fil");
		System.out.println("2. Skapa ny fil");
		Scanner sc = new Scanner(System.in);
		System.out.println("Välj ett nummer:");
		int num = Integer.parseInt(sc.nextLine());
		System.out.println("Du har valt: " + num);
		String filePath = null;
		String content;
		switch (num) {
		case 1:
			System.out.println("Ange filnamn inklusiva sökväg: ");
			System.out.println(num);
			filePath = sc.nextLine();
			content = c.actionPerformedConsole(num, filePath);
			System.out.println("innehållet är följande: \n" + content);
			break;
		case 2:
			System.out.println("Ange sökvägen för filen samt filnamn");
			filePath = sc.nextLine();
			content = c.actionPerformedConsole(num, filePath);
			System.out.println(content);
			break;
		}
		
		sc.close();
	}
}


public class View extends ui{
	private JTextField t1;
	private Controller c;
	private JTextArea text;
	private JPanel p1, p2;
	private JButton b1,b2,b3,b4,b5,b6,b7,b8;
	private JScrollPane scroll;
	
	public View() {
		JFrame f = new JFrame();
		c = new Controller(this);
		
		b1 = new JButton("Open");
		b2 = new JButton("New");
		b3 = new JButton("Save");
		b4 = new JButton("Save As");
		b5 = new JButton("Exit");
		b6 = new JButton("Cut");
		b7 = new JButton("Copy");
		b8 = new JButton("Paste");
		
		b1.addActionListener(c);
		b2.addActionListener(c);
		b3.addActionListener(c);
		b4.addActionListener(c);
		b5.addActionListener(c);
		b6.addActionListener(c);
		b7.addActionListener(c);
		b8.addActionListener(c);
		
		b1.setBounds(0, 0, 75, 25);
		b2.setBounds(75, 0, 75, 25);
		b3.setBounds(150, 0, 75, 25);
		b4.setBounds(225, 0, 90 ,25);
		b5.setBounds(705, 0, 75, 25);
		b6.setBounds(315, 0, 75, 25);
		b7.setBounds(390, 0, 75, 25);
		b8.setBounds(465, 0, 75, 25);

		f.add(b1);
		f.add(b2);
		f.add(b3);
		f.add(b4);
		f.add(b5);
		f.add(b6);
		f.add(b7);
		f.add(b8);
		
		f.addWindowListener(c);
		text = new JTextArea(780,780);
		scroll = new JScrollPane(text, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		scroll.setBounds(1, 26, 780, 780);
		f.add(scroll);
	
		f.setTitle("NotePad");
		f.setLocationRelativeTo(null);
		f.setLayout(null);
		f.setSize(800, 800);
		f.setVisible(true);

	}	

	
	public String getTextArea() {
		String fileContent = text.getText();
		return fileContent;
	}
	
	public String getFileName() {
		String filePath;
		JFileChooser jfc = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());
		int returnValue = jfc.showOpenDialog(null);
		if (returnValue == JFileChooser.APPROVE_OPTION) {
			File selectedFile = jfc.getSelectedFile();
			filePath = selectedFile.getAbsolutePath();
		} else {
			filePath = "Error";
		}
		return filePath;
	}
	
	public void setText(String fileContent) {
		System.out.println(fileContent);
		text.setText(fileContent);
	}
	
	public File selectDir() {
		File filePath = null;
		JFileChooser jfc = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());
		jfc.setDialogTitle("Välj vart du vill spara filen");
		int returnValue = jfc.showSaveDialog(null);
		if (returnValue == JFileChooser.APPROVE_OPTION) {
			filePath = jfc.getSelectedFile();
		}
		return filePath;
	}
	
	public void viewCopy() {
		text.copy();
	}
	
	public void viewCut() {
		text.cut();
	}
	
	public void viewPaste() {
		text.paste();
	}


}

class GetUiFactory{
	public ui getUi(String uiType) {
		if(uiType == null) {
			return null;
		}
		if(uiType.equalsIgnoreCase("CONSOLE")) {
			return new ViewConsoles();
		} else if(uiType.equalsIgnoreCase("GRAFISK")) {
			return new View();
		}
		return null;
	}
}