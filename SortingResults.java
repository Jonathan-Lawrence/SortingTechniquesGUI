package sorting_techniques;

import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.TitledBorder;

public class SortingResults extends JPanel{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	TitledBorder resTitle;
	JLabel NLabel, dataTypeLabel, sortLabel,
		   compLabel, mvmtLabel, timeLabel;
	JTextField NField, dataTypeField, sortField,
			   compField, mvmtField, timeField;
//ACCESSORS//
	public JTextField getNField() { return NField; }
	public JTextField getDataTypeField() { return dataTypeField; }
	public JTextField getSortField() { return sortField; }
	public JTextField getCompField() { return compField; }
	public JTextField getMvmtField() { return mvmtField; }
	public JTextField getTimeField() { return timeField; }
 	
	public SortingResults() {
		resTitle = new TitledBorder("Experimental Results");
		NLabel = new JLabel("N:", SwingConstants.RIGHT);
		dataTypeLabel = new JLabel("DataType:", SwingConstants.RIGHT);
		sortLabel = new JLabel("Sort:", SwingConstants.RIGHT);
		compLabel = new JLabel("Comparisons:", SwingConstants.RIGHT);
		mvmtLabel = new JLabel("Movements:", SwingConstants.RIGHT);
		timeLabel = new JLabel("Total time:", SwingConstants.RIGHT);
	
		NField = new JTextField(12);
		dataTypeField = new JTextField(10);
		sortField = new JTextField(10);
		compField = new JTextField(10);
		mvmtField = new JTextField(10);
		timeField = new JTextField(10);
		
		setLayout(new GridLayout(6,2));
		
		setBorder(resTitle);
		add(NLabel);
		add(NField);
		add(dataTypeLabel);
		add(dataTypeField);
		add(sortLabel);
		add(sortField);
		add(compLabel);
		add(compField);
		add(mvmtLabel);
		add(mvmtField);
		add(timeLabel);
		add(timeField);
	}
}
