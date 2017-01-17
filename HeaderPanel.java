import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

@SuppressWarnings("serial")
public class HeaderPanel extends JPanel{
	
	private JPanel headerPanel;
	private JTextField name;
	private JComboBox<String> type;
	private String[] types = {"--","Dinner", "Breakfast", "Lunch", "Dessert"};
	
	public HeaderPanel()
	{
		headerPanel = new JPanel();
		headerPanel.setLayout(new GridLayout(2,1));
		headerPanel.add(new JLabel("Recipe Name"));
		name = new JTextField("Name");
		headerPanel.add(name);
		headerPanel.add(new JLabel("Type of recipe:"));
		type = new JComboBox<String>(types);
		headerPanel.add(type);
		add(headerPanel);
		
	}
	public String getName()
	{
		return name.getText();
	}
	public String getType()
	{
		return type.getSelectedItem().toString();
	}

}
