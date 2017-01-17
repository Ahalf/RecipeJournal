import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.Component;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;


@SuppressWarnings("serial")
public class Recipe extends JPanel{
	
	
	private TitledBorder headerBorder;
	private TitledBorder ingredientsBorder;
	private TitledBorder instructionBorder;
	private TitledBorder notesBorder;
	private TitledBorder ratingBorder;
	private TitledBorder uploadBorder;
	
	private HeaderPanel headerPanel;
	private IngredientsPanel ingPanel;
	private InstructionPanel instructionPanel;
	private NotesPanel notesPanel;
	private RatingPanel ratingPanel;
	private JPanel submitPanel;
	private UploadPanel uploadPanel;
	private JButton submit;
	
	private JOptionPane success;
	private String successString;
	
	public Recipe()
	{
		setLayout(new GridLayout(7,1));
		
		submit = new JButton("Submit");
		
		headerPanel = new HeaderPanel();
		headerBorder = BorderFactory.createTitledBorder("General");
		headerPanel.setBorder(headerBorder);
		
		ingPanel = new IngredientsPanel();
		ingredientsBorder = BorderFactory.createTitledBorder("Ingredients");
		ingPanel.setBorder(ingredientsBorder);
		
		instructionPanel = new InstructionPanel();
		instructionBorder = BorderFactory.createTitledBorder("Instructions");
		instructionPanel.setBorder(instructionBorder);
		
		notesPanel = new NotesPanel();
		notesBorder = BorderFactory.createTitledBorder("Notes");
		notesPanel.setBorder(notesBorder);
		
		ratingPanel = new RatingPanel();
		ratingBorder = BorderFactory.createTitledBorder("Rating");
		ratingPanel.setBorder(ratingBorder);
		
		uploadPanel = new UploadPanel();
		uploadBorder = BorderFactory.createTitledBorder("Upload Photo");
		uploadPanel.setBorder(uploadBorder);
		
		submitPanel = new JPanel();
		submitPanel.add(submit);
		
		submit.addActionListener(
				new ActionListener()
				{
					public void actionPerformed(ActionEvent event)
					{
							successString = new String(
									"Recipe Name: " + headerPanel.getName() +
									"\nRecipe Type: " + headerPanel.getType() +
									"\nIngredients\n" +
									ingPanel.printIngredients() + '\n' +
									instructionPanel.printInstructions() +
									notesPanel.getNotesText() + 
									"\nRating: " + ratingPanel.getRating()
									);
							success = new JOptionPane();
							success.setMessage(successString);
							JOptionPane.showMessageDialog(null, successString);
							int value = -1;
							value = JOptionPane.CANCEL_OPTION;
							if(value != -1)
							{
								DesktopFrame.addFrame.dispose();
							}
					}
				});
		
		add(headerPanel);
		add(ingPanel);
		add(instructionPanel);
		add(notesPanel);
		add(ratingPanel);
		add(uploadPanel);
		add(submitPanel);
		setVisible(true);
		
		
	}
	
	public void PrintToConsole()
	{
		System.out.println("Recipe Name: " + headerPanel.getName());
		System.out.println("Recipe Type: " + headerPanel.getType());
		System.out.println("Ingredients");
		ingPanel.printIngredients();
		instructionPanel.printInstructions();
		System.out.println(notesPanel.getNotesText());
		System.out.println("Rating: " + ratingPanel.getRating());
	}
	
	
	
	
	
	
	
	
}
