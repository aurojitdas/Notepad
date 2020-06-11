package exec;

import java.awt.BorderLayout;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;



public class notepadFrame {

	 JFrame frame = new JFrame("Auropad");
	 JPanel middlePanel = new JPanel();
	 JTextArea ta = new JTextArea(30, 105);
	 JMenuBar menuBar = new JMenuBar();
	 JMenu fileMenu = new JMenu("File");
	 JMenu helpMenu = new JMenu("Help");
	 JMenuItem about = new JMenuItem("About");
	 JMenuItem save = new JMenuItem("Save");
	 JMenuItem New = new JMenuItem("New");
	 JMenuItem open = new JMenuItem("Open");
	 JMenuItem saveAs = new JMenuItem("SaveAs");
	 JMenuItem close = new JMenuItem("Close");
	 JPanel bottomPanel = new JPanel();
	 JPanel topPanel = new JPanel();
	 eventService click;
	 JScrollPane scrollBarRight;
	 File iconF= new File("d:\\icon.png");
	 BufferedImage icon;
	
	
	public notepadFrame(eventService click){	
		try {
		
			this.click = click;
			
			
			icon = ImageIO.read(iconF);
			
			frame.setIconImage(icon);
			fileMenu.add(New);
			fileMenu.add(open);
			fileMenu.add(save);
			fileMenu.add(saveAs);
			fileMenu.add(close);
			helpMenu.add(about);
			menuBar.add(fileMenu);	
			menuBar.add(helpMenu);
			ta.setLineWrap(true);
			ta.setWrapStyleWord(true);
			ta.setLineWrap(true);
			scrollBarRight = new JScrollPane(ta);
				
			frame.getContentPane().add(scrollBarRight,BorderLayout.CENTER);
			
			
		
			frame.setJMenuBar(menuBar);
			frame.setSize(1204, 560);		
			frame.setVisible(true);
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			
			open.addActionListener(click.open);
			close.addActionListener(click.close);
			save.addActionListener(click.save);
			saveAs.addActionListener(click.saveAs);
			about.addActionListener(click.aboutMe);
			New.addActionListener(click.New);
			
			
		} catch (IOException e) {
			System.out.println(iconF);
		}
		
	}
	
}
