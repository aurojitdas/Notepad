package exec;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class fileIO {

	Scanner sc;
	File filePath;
	FileWriter writer;
	BufferedWriter buffer;
	notepadFrame frame;
	String fileStatus="closed";
	public fileIO(notepadFrame frame) {
		super();		
		this.frame = frame;
	}
	
	public void openFile(){
		
		try {
			sc = new Scanner(filePath);
			sc.useDelimiter("\\Z");
			frame.ta.setText(sc.next());	
			fileStatus = "open";
			sc.close();
			
				
		} catch (FileNotFoundException e) {
			
		}	catch(NoSuchElementException e){
			
		}
	}
public void saveFile(){
		
	try {
		writer = new FileWriter(filePath);
		buffer = new BufferedWriter(writer);
		buffer.write(frame.ta.getText());		
		fileStatus = "closed";
		buffer.close();
		writer.close();
	} catch (IOException e) {
		System.out.println("Error");
	}catch (NullPointerException e) {
		
	
	}
	
}
	
	
}
