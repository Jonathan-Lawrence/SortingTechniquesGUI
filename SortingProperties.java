package sorting_techniques;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JSlider;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class SortingProperties extends JPanel{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private TitledBorder listTitle;
	private JRadioButton inOrderRadButton, revOrderRadButton, almostRadButton, randRadButton;
	private ButtonGroup orderGroup;
	private JTextField lengthField;
	private JSlider lengthSlider;
	private JButton createListButton;
	
	public SortingProperties() {
		listTitle = new TitledBorder("List Properties");
		inOrderRadButton = new JRadioButton("InOrder");
		revOrderRadButton = new JRadioButton("ReverseOrder");
		almostRadButton = new JRadioButton("AlmostOrder");
		randRadButton = new JRadioButton("Random");
		
		orderGroup = new ButtonGroup();
		orderGroup.add(inOrderRadButton);
		orderGroup.add(revOrderRadButton);
		orderGroup.add(almostRadButton);
		orderGroup.add(randRadButton);
		
		lengthSlider = new JSlider(JSlider.HORIZONTAL, 0, 30000, 0);
		lengthField = new JTextField(5);
		createListButton = new JButton("Create The List");
		
		//Properties Panel Layout
		setLayout(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
		
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 0;
		c.gridy = 0;
		c.weightx= 2;
		c.ipady = 0;
		c.anchor = GridBagConstraints.LINE_END;
		add(inOrderRadButton, c);
		
		c.gridx = 3;
		c.gridy = 0;
		c.weightx = 2;
		add(revOrderRadButton,c);
		
		c.gridx = 0;
		c.gridy = 1;
		c.weightx = 2;
		add(almostRadButton,c);
		
		c.gridx = 3;
		c.gridy = 1;
		c.weightx = 2;
		add(randRadButton,c);
		
		c.gridx = 0;
		c.gridy = 2;
		c.weightx = 0;
		c.gridwidth = 3;
		c.anchor = GridBagConstraints.CENTER;
		add(lengthSlider, c);
	
		c.gridx = 3;
		c.gridy = 2;
		add(lengthField, c);

		c.gridx = 0;
		c.gridy = 3;
		c.gridwidth = 4;
		c.weighty = 1.0;
		add(createListButton, c);
		
		setBorder(listTitle);
		
		lengthSlider.setValue(0);
		lengthField.setText("0");
		
		
		//Pair JTextField and JSlider
		lengthSlider.addChangeListener(new ChangeListener() {
			@Override
			public void stateChanged(ChangeEvent e) {
				lengthField.setText(String.valueOf(lengthSlider.getValue()));
			}
		});
		lengthField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased (KeyEvent ke) {
				String typed = lengthField.getText();
				lengthSlider.setValue(0);
				if(!typed.matches("\\d+") || typed.length() > 3) {
					return;
				}
				int value = Integer.parseInt(typed);
				lengthSlider.setValue(value);
			}
		});	
	}
	
	//Accessors
	public JRadioButton getInOrderRadButton() { return inOrderRadButton; }
	public JRadioButton getRevOrderRadButton() { return revOrderRadButton; }
	public JRadioButton getAlmostRadButton() { return almostRadButton; }
	public JRadioButton getRandRadButton() { return randRadButton; }
	public JSlider getLengthSlider() { return lengthSlider; }
	public JButton getCreateListButton() { return createListButton; }
}


