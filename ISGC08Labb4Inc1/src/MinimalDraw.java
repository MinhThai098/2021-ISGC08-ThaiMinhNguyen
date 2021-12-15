

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
import javax.swing.JFrame;
import javax.swing.JOptionPane;

import se.kau.isgc08.lab4.model.*;
import se.kau.isgc08.lab4.view.*;

public class MinimalDraw extends WindowAdapter implements ActionListener{
	private DrawingPanel dp;
	private JFrame j;
	private DrawingContainer dc;
	private Controller c;
	public MinimalDraw(DrawingContainer dcd) {
		c = new Controller();
		dc = dcd;
		j=new JFrame();
		j.addWindowListener(this);
		DrawingUtil da=new DrawingUtil();	
		//Line l=new Line(da,3,3,50,50,1,Color.RED);  											
		//Circle c=new Circle(da,20,20,80,80,1,Color.BLUE,null);
		//Circle c2=new Circle(da,150,150,50,250,20,Color.BLUE, Color.CYAN); 
		//Rect r=new Rect(da,320,200,80,80,5,Color.GREEN,Color.PINK); 
		//dc.add(l);   
		//dc.add(c);
		//dc.add(c2);
		//dc.add(r);
		dp = new DrawingPanel(dc); 
		dp.setBackground(Color.WHITE);  
		j.add(dp);
		j.setSize(500, 500); 
		j.setVisible(true);
		//Rect r2=new Rect(da,320,200,80,80,5,Color.GREEN,null); 
		//dc.add(r2);
		//dc.remove(r);

		j.repaint();
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	public void windowClosing (WindowEvent e) {
		String fileName = JOptionPane.showInputDialog("Filens namn:");
		c.savefile(fileName, dc);
		
		//serSkrivFil(fileName);
		System.exit(0);
	}
	

}


