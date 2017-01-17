import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.filechooser.FileNameExtensionFilter;

@SuppressWarnings("serial")
public class UploadPanel extends JPanel{
	
	private JPanel upload;
	private JButton openFile;
	private JFileChooser file;
	private ArrayList<BufferedImage> fileContainer;
	private JOptionPane invalidOption;
	private BufferedImage image;
	
	public UploadPanel()
	{
		upload = new JPanel();
		openFile = new JButton("Add picture");
		file = new JFileChooser();
		
		upload.add(openFile);
		openFile.addActionListener(
				new ActionListener()
				{
					public void actionPerformed(ActionEvent event)
					{
						int value = file.showOpenDialog(UploadPanel.this);
						if(value == JFileChooser.APPROVE_OPTION)
						{
							try{
								File selectedFile = file.getSelectedFile();
								FileNameExtensionFilter filter = new FileNameExtensionFilter(
								        "JPG & GIF Images", "jpg", "gif");
								file.setFileFilter(filter);
								image = ImageIO.read(selectedFile);
								fileContainer.add(image);
								System.out.println("End");
							}
							catch(NullPointerException e)
							{
								System.out.println(e);
							}
							catch(IOException e)
							{
								System.out.println(e);
							}
							
						}
						else if(value != JFileChooser.CANCEL_OPTION)
						{
							invalidOption = new JOptionPane();
							JOptionPane.showMessageDialog(null,
								    "Invalid Option.");
						}
					}
				});
		add(upload);
	}
}
