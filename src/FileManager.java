import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileManager {

	public String openFile(String filePath) {
		String fileContent = null;
		try(BufferedReader br = new BufferedReader(new FileReader(filePath))){
			StringBuilder sb = new StringBuilder();
			String line = br.readLine();
			
			while (line != null) {
				sb.append(line);
				sb.append(System.lineSeparator());
				line = br.readLine();
			}
			fileContent = sb.toString();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return fileContent;
	}
	public void saveAsFile(String filePath, String fileContent) {
		try {
			BufferedWriter bw = new BufferedWriter(new FileWriter(filePath));
			bw.write(fileContent);
			bw.close();
		} catch (Exception e) {
			return;
		}
	}
	public void saveFile(File filePath, String fileContent) {
		try {
			BufferedWriter bw = new BufferedWriter(new FileWriter(filePath));
			bw.write(fileContent);
			bw.close();
		} catch (Exception e) {
			return;
		}
		
	}
	
}
