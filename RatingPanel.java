import java.awt.GridLayout;
import java.util.Hashtable;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;

@SuppressWarnings("serial")
public class RatingPanel extends JPanel{
	
	private JPanel ratingPanel;
	private JSlider rating;
	private Hashtable<Integer, JLabel> labels;
	final int MIN = 1;
	final int MAX = 5;
	
	public RatingPanel()
	{
		ratingPanel = new JPanel();
		ratingPanel.setLayout(new GridLayout(2,1));
		rating = new JSlider(JSlider.HORIZONTAL, MIN, MAX, 3);
		rating.setMajorTickSpacing(1);
		rating.setPaintTicks(true);
		rating.setPaintLabels(true);
		
		labels = new Hashtable<Integer,JLabel>();
		for(Integer i = 1; i < 6; i++ )
		{
			labels.put( new Integer( i ), new JLabel(i.toString()) );
		}
		rating.setLabelTable( labels );
		
		ratingPanel.add(new JLabel("      Did you like this recipe?"));
		ratingPanel.add(rating);
		add(ratingPanel);
	}
	
	public int getRating()
	{
		return rating.getValue();
	}

}
