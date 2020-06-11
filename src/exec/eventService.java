package exec;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;




import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.filechooser.FileSystemView;



public class eventService {

	
	notepadFrame f;
	JFileChooser fileChooser = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory()); 
	FileNameExtensionFilter filterTXT = new FileNameExtensionFilter("Text Files", "txt");
	
	fileIO fileService;
	
	
	public void initListners(notepadFrame frame,fileIO fileService){
		this.f = frame;
		this.fileService = fileService;
		
	}
	
	public ActionListener open = new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent arg0) {
			 // invoke the showsOpenDialog function to show the save dialog 
			fileChooser.setFileFilter(filterTXT);
	        int r = fileChooser.showOpenDialog(null); 
  
            // if the user selects a file 
            if (r == JFileChooser.APPROVE_OPTION) {
            	
                // set the label to the path of the selected file 
            	fileService.filePath = new File(fileChooser.getSelectedFile().getAbsolutePath());
             
            	fileService.openFile();
            } 
	
			
		}
	};
	
	
	public ActionListener save = new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent arg0) {
			
			if (fileService.filePath == null ){
				
				int retval=fileChooser.showSaveDialog(f.frame);
				
			    if (retval == JFileChooser.APPROVE_OPTION) {
			    	
			     fileService.filePath = fileChooser.getSelectedFile();
			     fileService.saveFile();
			    }
								
			}else{
				fileService.saveFile();
			}
			
		}
	}; 
	
	public ActionListener close = new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent arg0) {
			   System.exit(0);
			
		}
	};
	
	
	public ActionListener aboutMe = new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent arg0) {
			
			JOptionPane.showMessageDialog(f.frame," You are using a notepad created by Aurojit","About",JOptionPane.INFORMATION_MESSAGE);
			
			
		}
	};
	
	ActionListener saveAs = new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent arg0) {
						
			int retval=fileChooser.showSaveDialog(f.frame);
			
		    if (retval == JFileChooser.APPROVE_OPTION) {
		    	
		     fileService.filePath = fileChooser.getSelectedFile();
		     fileService.saveFile();
		    }		
		}
	};
	
	ActionListener New = new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent arg0) {
			
			if(fileService.fileStatus.equalsIgnoreCase("open")){
				if (fileService.filePath == null ){
					
					int retval=fileChooser.showSaveDialog(f.frame);
					
				    if (retval == JFileChooser.APPROVE_OPTION) {
				    	
				     fileService.filePath = fileChooser.getSelectedFile();
				     fileService.saveFile();
				     fileService.filePath=null;
				    }
									
				}else{
					fileService.saveFile();
					fileService.filePath=null;
				}
			}else{
				f.ta.setText("");
				fileService.filePath=null;
			}
			
		}
	};
	
}
