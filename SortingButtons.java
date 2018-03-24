package sorting_techniques;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import javax.swing.JButton;
import javax.swing.JPanel;

public class SortingButtons extends JPanel {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	private JButton insertButton, selectButton, quickButton, 
			mergeButton, heapButton, radixButton;
	
	public SortingButtons() {
		
		insertButton = new JButton("Insertion Sort");
		selectButton = new JButton("Selection Sort");
		quickButton = new JButton("Quick Sort");
		mergeButton = new JButton("Merge Sort");
		heapButton = new JButton("Heap Sort");
		radixButton = new JButton("Radix Button");
		
		setLayout(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();

		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 0;
		c.gridy = 0;
		c.ipady = 40;
		add(insertButton, c);
		c.gridy = 1;
		add(selectButton, c);
		c.gridy = 2;
		add(quickButton, c);
		c.gridy = 3;
		add(mergeButton, c);
		c.gridy = 4;
		add(heapButton, c);
		c.gridy = 5;
		add(radixButton, c);
		
	}
//Accessors
	public JButton getInsertButton() { return insertButton; }
	public JButton getSelectButton() { return selectButton; }
	public JButton getQuickButton()  { return quickButton; }
	public JButton getMergeButton()  { return mergeButton; }
	public JButton getHeapButton()   { return heapButton; }
	public JButton getRadixButton()  { return radixButton; }	
	
}
