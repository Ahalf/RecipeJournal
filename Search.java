import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

@SuppressWarnings("serial")
public class Search extends JPanel{
	
	private JPanel criteriaPanel;
	private JButton submit;
	private JTextField searchField;
	private JComboBox<String> criteria;
	private final String[] options = {"--", "Recipe Name", "Ingredient", "Type", "Rating"};
	
	private TitledBorder criteriaBorder;
	
	public Search()
	{
		setLayout(new GridLayout(1,2));
		criteriaPanel = new JPanel();
		submit = new JButton("Search");
		
		criteria = new JComboBox<String>(options);
		searchField = new JTextField();
		searchField.setColumns(20);
		
		criteriaBorder = BorderFactory.createTitledBorder("Search Criteria");
		criteriaPanel.setBorder(criteriaBorder);
		
		criteriaPanel.add(criteria);
		criteriaPanel.add(searchField);
		criteriaPanel.add(submit);
		
		add(criteriaPanel);
		
		submit.addActionListener(
				
				new ActionListener()
				{
					public void actionPerformed(ActionEvent event)
					{
						System.out.println(getCriteria());
						System.out.println(getSearchTerm());
					}
				});
		
	}
	
	public String getCriteria()
	{
		return criteria.getSelectedItem().toString();
	}
	public String getSearchTerm()
	{
		return searchField.getText();
	}

}
