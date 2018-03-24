package sorting_techniques;

import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

public class WinAlgorithm extends JPanel{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	TitledBorder winTitle;
	JTextField winField;
	
	public WinAlgorithm(){
		winTitle = new TitledBorder("Winning Algorithm");
		winField = new JTextField(24);
		
		setBorder(winTitle);
		add(winField);
		
	}
	public JTextField getWinField() { return winField; }
}