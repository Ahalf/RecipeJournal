import javax.swing.*;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


@SuppressWarnings("serial")
public class DesktopFrame extends JFrame{
	//protected Recipe it;
	private JDesktopPane desktop;
	protected static JInternalFrame addFrame;
	protected JInternalFrame searchFrame;
	
	
	public DesktopFrame()
	{
		super("Recipe Journal");
		desktop = new JDesktopPane();
		add(desktop);
		JMenuBar menuBar = new JMenuBar();
		JMenu add = new JMenu("Add");
		JMenu search = new JMenu("Search");
		JMenu viewAll = new JMenu("View All");
		
		JMenuItem addOption = new JMenuItem("Add");
		add.add(addOption);
		
		JMenuItem searchOption = new JMenuItem("Search");
		search.add(searchOption);
		
		JMenuItem addView = new JMenuItem("View All");
		viewAll.add(addView);
		
		menuBar.add(add);
		menuBar.add(search);
		menuBar.add(viewAll);
		setJMenuBar(menuBar);
		
		addOption.addActionListener(
				new ActionListener()
				{
					public void actionPerformed(ActionEvent event)
					{
						
						addFrame = new JInternalFrame("Add Recipe", true, true, true, true);
						
						addFrame.getContentPane().setPreferredSize(new Dimension(700,500));
						addFrame.setSize(700, 500);
						
						Recipe it = new Recipe();
						JScrollPane scrollWindow = new JScrollPane(it);
						scrollWindow.setPreferredSize(new Dimension(250, 80));
				        scrollWindow.setAlignmentX(LEFT_ALIGNMENT);
						
						
						addFrame.add(scrollWindow);
						addFrame.setVisible(true);
						
						desktop.add(addFrame);
					}
				}
			);
		searchOption.addActionListener(
				new ActionListener()
				{
					public void actionPerformed(ActionEvent event)
					{
						searchFrame = new JInternalFrame("Search Recipe", true, true, true, true);
						
						searchFrame.getContentPane().setPreferredSize(new Dimension(700,500));
						searchFrame.setSize(700,  500);
						
						Search search = new Search();
						JScrollPane searchScrollWindow = new JScrollPane(search);
						searchScrollWindow.setPreferredSize(new Dimension(250,80));
						searchScrollWindow.setAlignmentX(LEFT_ALIGNMENT);
						
						searchFrame.add(searchScrollWindow);
						searchFrame.setVisible(true);
						desktop.add(searchFrame);
					}
				}
				
				
				
				
				);
		
	}
}
