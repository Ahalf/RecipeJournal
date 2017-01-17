import java.awt.Component;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JEditorPane;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class InstructionPanel extends JPanel{
	
	
	private JPanel instructionPanel;
	private ArrayList<JTextField> instructions;
	private JButton addInstruction;
	private Integer i;
	public InstructionPanel()
	{
		 instructionPanel = new JPanel();
		 instructionPanel.setLayout(new GridLayout(0,2));
		 instructionPanel.add(new JLabel(""));
		 instructionPanel.add(addInstruction = new JButton("Add Instruction"));
		 instructions = new ArrayList<JTextField>();
		 i = -1;
		 
		 addInstruction.addActionListener(
				 new ActionListener()
					{
						public void actionPerformed(ActionEvent event)
						{
							++i;
							Integer step = i + 1;
							instructionPanel.add(new JLabel(step.toString()));
							instructions.add(new JTextField());
							instructionPanel.add((Component) instructions.toArray()[i]);
							
						}
				 
					}
				 
				 );
		 add(instructionPanel);
	}
	public String printInstructions()
	{
		String instructionsString = new String();
		for(int i = 0; i < instructions.size(); i++)
		{
			instructionsString += i+1 + ". " + instructions.get(i).getText() + '\n';
			//System.out.println(i+1 + ". " + instructions.get(i).getText());
		}
		return instructionsString;
	}
}
