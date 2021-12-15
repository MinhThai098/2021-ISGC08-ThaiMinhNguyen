import java.util.Scanner;

import se.kau.isgc08.lab4.model.DrawingContainer;

public class Controller {
	
	public void savefile(String fileName, DrawingContainer dc) {
		Model m = new Model();
		m.serWriteFile(fileName, dc);
	}
	
	public static void main(String[] args) {
		Model m = new Model();
		Scanner sc = new Scanner(System.in);
		System.out.println("Hej, vill du läsa in en fil?");
		System.out.println("1. Ja");
		System.out.println("2. Nej");
		int num = Integer.parseInt(sc.nextLine());
		System.out.println("Namnet på filen: ");
		
		if (num == 1) {
			String fileName;
			fileName = sc.nextLine();
			System.out.println(fileName);
			DrawingContainer dc = m.serReadFile(fileName);
			MinimalDraw md = new MinimalDraw(dc);
		} else if (num == 2) {
			DrawingContainer dc = new DrawingContainer();
			MinimalDraw md = new MinimalDraw(dc);
		} else {
			System.out.println("Error");
		}
	}
}
