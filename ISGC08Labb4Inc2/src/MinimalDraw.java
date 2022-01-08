

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Scanner;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.text.JTextComponent;

import se.kau.isgc08.lab4.model.*;
import se.kau.isgc08.lab4.view.*;

public class MinimalDraw extends WindowAdapter{
	private DrawingPanel dp;
	private JFrame j;
	private DrawingContainer dc;
	private Controller c;
	private JButton b1,b2,b3,b4, b5;
	private JTextField tX ,tY ,tHeight ,tWidth, tLineWidth;
	private final JTextPane t1,t2,t3,t4, t5;
	private Color lineColor, areaColor;
	
	public MinimalDraw(DrawingContainer dcd) {
		c = new Controller(this);
		dc = dcd;
		j=new JFrame();
		j.addWindowListener(this);
		DrawingUtil da=new DrawingUtil();	

		
		t1 = new JTextPane();
		t1.setText("X");
		t1.setBounds(880, 0, 100, 20);
		j.add(t1);
		
		tX = new JTextField();
		tX.setBounds(880, 20, 100, 20);
		j.add(tX);
		
		t2 = new JTextPane();
		t2.setText("Y");
		t2.setBounds(880, 40, 100, 20);
		j.add(t2);
		
		tY = new JTextField();
		tY.setBounds(880, 60, 100, 20);
		j.add(tY);
		
		t3 = new JTextPane();
		t3.setText("Height");
		t3.setBounds(880, 80, 100, 20);
		j.add(t3);
		
		tHeight = new JTextField();
		tHeight.setBounds(880, 100, 100, 20);
		j.add(tHeight);
		
		t4 = new JTextPane();
		t4.setText("Width");
		t4.setBounds(880, 120, 100, 20);
		j.add(t4);
		
		tWidth = new JTextField();
		tWidth.setBounds(880, 140, 100, 20);
		j.add(tWidth);
		
		t5 = new JTextPane();
		t5.setText("Line Width");
		t5.setBounds(880, 160, 100, 20);
		j.add(t5);
		
		tLineWidth = new JTextField();
		tLineWidth.setBounds(880,180,100,20);
		j.add(tLineWidth);
		
		
		b1 = new JButton("Line Color");
		b1.addActionListener(c);
		b1.setBounds(880, 200, 100, 30);
		j.add(b1);
		
		b4 = new JButton("Area Color");
		b4.addActionListener(c);
		b4.setBounds(880, 250, 100, 30);
		j.add(b4);
		
		b2 = new JButton("Rectangle");
		b2.addActionListener(c);
		b2.setBounds(880, 300, 100, 30);
		j.add(b2);
		
		b3 = new JButton("Line");
		b3.addActionListener(c);
		b3.setBounds(880, 400, 100 ,30);
		j.add(b3);
		
		
		b5 = new JButton("Circle");
		b5.addActionListener(c);
		b5.setBounds(880,500, 100, 30);
		j.add(b5);
		
		
		
		dp = new DrawingPanel(dc); 
		dp.setBackground(Color.WHITE);  
		j.add(dp);
		j.setSize(1000, 1000); 
		j.setVisible(true);

		j.repaint();
		
	}
	
	public void chooseLineColor() {
		JColorChooser colorChooser = new JColorChooser();
		
		lineColor = JColorChooser.showDialog(null, "Välj Linje färg", Color.black);
	}
	public void chooseAreaColor() {
		JColorChooser colorChooser = new JColorChooser();
		
		areaColor = JColorChooser.showDialog(null, "Välj Area färg", Color.black);
	}
	
	public int getX() {
		int x = Integer.parseInt(tX.getText()); 
		return x;
	}
	public int getY() {
		int y = Integer.parseInt(tY.getText());
		return y;
	}
	public int getHeight() {
		int height = Integer.parseInt(tHeight.getText());
		return height;
	}
	public int getWidth() {
		int width = Integer.parseInt(tWidth.getText());
		return width;
	}
	public int getLineWidth() {
		int LineWidth = Integer.parseInt(tLineWidth.getText());
		return LineWidth;
	}
	
	public Color getLineColor() {
		Color LineColor = lineColor;
		return LineColor;
	}
	public Color getAreaColor() {
		Color AreaColor = areaColor;
		return AreaColor;
	}
	
	public void drawLine(Line line) {
		dc.add(line);
		j.repaint();
	}
	public void drawRectangle(Rect rectangle) {
		dc.add(rectangle);
		j.repaint();
	}
	public void drawCircle (Circle circle) {
		dc.add(circle);
		j.repaint();
	}
	
	

	
	public void windowClosing (WindowEvent e) {
		String fileName = JOptionPane.showInputDialog("Filens namn:");
		c.savefile(fileName, dc);
		
		//serSkrivFil(fileName);
		System.exit(0);
	}


	

}


