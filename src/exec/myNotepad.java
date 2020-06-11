package exec;



public class myNotepad {

	public static void main(String[] args) {
		
		
		eventService click = new eventService();
		notepadFrame frame = new notepadFrame(click);
		fileIO fileService = new fileIO(frame);
		click.initListners(frame,fileService);
		
		
		
	}
}
