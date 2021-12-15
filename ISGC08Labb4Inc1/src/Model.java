import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import se.kau.isgc08.lab4.model.Circle;
import se.kau.isgc08.lab4.model.DrawingContainer;
import se.kau.isgc08.lab4.model.Line;
import se.kau.isgc08.lab4.model.Rect;
import se.kau.isgc08.lab4.view.DrawingUtil;

public class Model {
	private String path = "C:\\Users\\Thai\\Desktop\\";

	public Line createLine(DrawingUtil da,
							int x1,
							int y1,
							int w,
							int h,
							int width,
							java.awt.Color lineColor) {
		Line line = new Line(da,x1,y1,w,h,width,lineColor);
		return line;
		
	}
	
	public Circle createCircle(DrawingUtil da,
								int x1,
								int y1,
								int w,
								int h,
								int width,
								java.awt.Color lineColor,
								java.awt.Color area) {
		Circle circle = new Circle(da,x1,y1,w,h,width,lineColor, area);
		return circle;
	}
	
	public Rect createRect(DrawingUtil da,
							int x1,
							int y1,
							int w,
							int h,
							int width,
							java.awt.Color lineColor,
							java.awt.Color area) {
		Rect rect = new Rect(da,x1,y1,w,h,width,lineColor,area);
		return rect;
	}
	
	
	public void serWriteFile(String fileName, DrawingContainer dc) {
		try(FileOutputStream fs = new FileOutputStream(path + fileName)){
			ObjectOutputStream os = new ObjectOutputStream(fs);
			os.writeObject(dc);
			os.close();
			fs.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e){
			e.printStackTrace();
		}
	}
	public DrawingContainer serReadFile(String fileName) {
		DrawingContainer dc = new DrawingContainer();
		File filePath = new File(path + fileName);
		boolean exist;
		exist = filePath.exists();
		if (exist == true) {
			try(FileInputStream fi = new FileInputStream(filePath)){
				ObjectInputStream os = new ObjectInputStream(fi);
				dc = (DrawingContainer)os.readObject();

			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
		}
		return dc;
	}
}
