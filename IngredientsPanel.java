import java.awt.Component;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

@SuppressWarnings("serial")
public class IngredientsPanel extends JPanel{
	private JPanel ingredientPanel;
	static ArrayList<JTextField> amount;
	static ArrayList<JTextField > unit;
	static ArrayList<JTextField> ingredientName;
	private JButton addIngredient;
	public TitledBorder ingredientsBorder;
	private String ingredientsString;
	public int i = -1;

	public IngredientsPanel()
	{
		ingredientPanel = new JPanel();
		amount = new ArrayList<JTextField>();
		unit = new ArrayList<JTextField>();
		ingredientName = new ArrayList<JTextField>();
		
		ingredientPanel.setLayout(new GridLayout(0,4));
		
		ingredientPanel.add(new JLabel("Amount"));
		ingredientPanel.add(new JLabel("Unit"));
		ingredientPanel.add(new JLabel("Name"));
		ingredientPanel.add(addIngredient = new JButton("Add Ingredient"));
		
		
		addIngredient.addActionListener(
				new ActionListener()
				{
					public void actionPerformed(ActionEvent event)
					{
						++i;
						addElements();
						
						ingredientPanel.add((Component) amount.toArray()[i]);
						ingredientPanel.add((Component) unit.toArray()[i]);
						ingredientPanel.add((Component) ingredientName.toArray()[i]);
						ingredientPanel.add(new JLabel(""));
						ingredientPanel.validate();	
						
					}
					
					
				}
			);
		
		add(ingredientPanel);
		
	}
	
	public String printIngredients()
	{
		ingredientsString = new String();
		for(int i = 0; i < amount.size(); i++)
		{
			ingredientsString += amount.get(i).getText() + " " + unit.get(i).getText() + " " + ingredientName.get(i).getText();
			//System.out.println(amount.get(i).getText() + " " + unit.get(i).getText() + " " + ingredientName.get(i).getText());	
		}
		return ingredientsString;
	}
	private void addElements()
	{
		amount.add(new JTextField());
		unit.add(new JTextField());
		ingredientName.add(new JTextField());
	}
	public ArrayList<JTextField> getAmount()
	{
		return amount;
	}
	public ArrayList<JTextField> getUnit()
	{
		return unit;
	}
	public ArrayList<JTextField> getIngredientName()
	{
		return ingredientName;
	}
	public static int getAmountSize()
	{
		return amount.size();
	}
	public static int getUnitSize()
	{
		return unit.size();
	}
	public static int getIngredientSize()
	{
		return ingredientName.size();
	}
	
}
