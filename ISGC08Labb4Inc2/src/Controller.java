import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Scanner;

import javax.swing.JButton;

import se.kau.isgc08.lab4.model.Circle;
import se.kau.isgc08.lab4.model.DrawingContainer;
import se.kau.isgc08.lab4.model.Line;
import se.kau.isgc08.lab4.model.Rect;
import se.kau.isgc08.lab4.view.DrawingUtil;

public class Controller implements ActionListener {
	private MinimalDraw v;

	
	public Controller (MinimalDraw uIn) {
		v = uIn;
	}
	public void actionPerformed(ActionEvent e) {
		JButton choice = (JButton) e.getSource();
		
		Model m = new Model();
		DrawingUtil da = new DrawingUtil();
		int x, y, width, height, lineWidth;
		Color lineColor, areaColor;
		
		if(choice.getText().equals("Circle")) {
			x = v.getX();
			y = v.getY();
			width = v.getWidth();
			height = v.getHeight();
			lineWidth = v.getLineWidth();
			lineColor = v.getLineColor();
			areaColor = v.getAreaColor();
			
			Circle circle = m.createCircle(da, x, y, width, height, lineWidth, lineColor, areaColor);
			
			v.drawCircle(circle);
			
		} else if(choice.getText().equals("Rectangle")) {
			x = v.getX();
			y = v.getY();
			width = v.getWidth();
			height = v.getHeight();
			lineWidth = v.getLineWidth();
			lineColor = v.getLineColor();
			areaColor = v.getAreaColor();
			
			Rect rectangle = m.createRect(da, x, y, width, height, lineWidth, lineColor, areaColor);
			
			v.drawRectangle(rectangle);
			
		} else if (choice.getText().equals("Line")) {
			x = v.getX();
			y = v.getY();
			width = v.getWidth();
			height = v.getHeight();
			lineWidth = v.getLineWidth();
			lineColor = v.getLineColor();
			
			Line line = m.createLine(da, x, y, width, height, lineWidth, lineColor);
			
			v.drawLine(line);
		} else if (choice.getText().equals("Area Color")) {
			v.chooseAreaColor();
		} else if (choice.getText().equals("Line Color")) {
			v.chooseLineColor();
		}
	}
	
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

		
		if (num == 1) {
			System.out.println("Namnet på filen: ");
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
