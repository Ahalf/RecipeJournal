import java.awt.Dimension;
import java.io.IOException;

import javax.swing.JEditorPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

@SuppressWarnings("serial")
public class NotesPanel extends JPanel{
	private JEditorPane notesPane;
	private JPanel notesPanel;
	JScrollPane notesScrollPane;
	
	
	public NotesPanel()
	{
		
			 notesPanel = new JPanel();
			 notesPane = createEditorPane();
			 
			 
			 notesScrollPane = new JScrollPane(notesPane);
		     notesScrollPane.setVerticalScrollBarPolicy(
		                        JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		     notesScrollPane.setPreferredSize(new Dimension(250, 145));
		        
			 
			 //notesScrollPane.add(notesPane);
			 notesPanel.add(notesScrollPane);
			 
			 add(notesPanel);
			 
			
	}
	
	private JEditorPane createEditorPane() {
        JEditorPane editorPane = new JEditorPane();
        editorPane.setEditable(true);
 
        return editorPane;
    }
	
	public String getNotesText()
	{
		return notesPane.getText();
	}
}


