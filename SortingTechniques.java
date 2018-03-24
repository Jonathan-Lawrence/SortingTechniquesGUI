package sorting_techniques;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class SortingTechniques extends JFrame implements ActionListener {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	SortingButtons sortingPanel;
	SortingProperties propertiesPanel;
	SortingResults resultsPanel;
	WinAlgorithm winPanel;

	JPanel panelWest, panelEast;
	
	boolean listGenerated = false;
	
	SortingAlgorithms sort;
	GenerateLists genList;
	
	String listProperties = "";
	
	public SortingTechniques() {
		
		sort = new SortingAlgorithms(0,0,0);
		
		panelWest = new JPanel();
		panelEast = new JPanel();
		
		sortingPanel = new SortingButtons();
		propertiesPanel = new SortingProperties();
		resultsPanel = new SortingResults();
		winPanel = new WinAlgorithm();
		
		panelWest.add(sortingPanel, BorderLayout.CENTER);
		this.add(panelWest, BorderLayout.WEST);
		
		panelEast.add(winPanel, BorderLayout.NORTH);
		panelEast.add(propertiesPanel, BorderLayout.CENTER);
		panelEast.add(resultsPanel, BorderLayout.SOUTH);
		this.add(panelEast, BorderLayout.CENTER);
		
	//Adding ActionListener
		//ActionListener Sorting Buttons panel
		sortingPanel.getInsertButton().addActionListener(this);
		sortingPanel.getSelectButton().addActionListener(this);
		sortingPanel.getQuickButton().addActionListener(this);
		sortingPanel.getMergeButton().addActionListener(this);
		sortingPanel.getHeapButton().addActionListener(this);
		sortingPanel.getRadixButton().addActionListener(this);
		
		//ActionListener List Properties
		propertiesPanel.getCreateListButton().addActionListener(this);
		
	}
	
	public void actionPerformed(ActionEvent event) {
		if (event.getSource() == propertiesPanel.getCreateListButton()) {
			
			genList = new GenerateLists(propertiesPanel.getLengthSlider().getValue());
			
			if(propertiesPanel.getInOrderRadButton().isSelected()) { 
				genList.inOrder();
				listProperties = "InOrder";
			}
			else if(propertiesPanel.getRevOrderRadButton().isSelected()) { 
				genList.reverseOrder(); 
				listProperties = "ReverseOrder";
			}
			else if(propertiesPanel.getAlmostRadButton().isSelected()) { 
				genList.almostOrder();
				listProperties = "AlmostOrder";
			}
			else if(propertiesPanel.getRandRadButton().isSelected()) { 
				genList.randomOrder();
				listProperties = "Random";
			}
		}
		else if(listGenerated == true && event.getSource() == sortingPanel.getInsertButton()) { 
			sort.insertionSort(genList.getList());
			if(sort.compareWinner()) { winPanel.winField.setText("Insertion Sort"); }
		}
		else if(listGenerated == true && event.getSource() == sortingPanel.getSelectButton()) { 
			sort.selectionSort(genList.getList()); 
			if(sort.compareWinner()) { winPanel.winField.setText("Selection Sort"); }
		}
		else if(listGenerated == true && event.getSource() == sortingPanel.getQuickButton()) { 
			sort.quickSort(genList.getList());
			if(sort.compareWinner()) { winPanel.winField.setText("QuickSort"); }
		}
		else if(listGenerated == true && event.getSource() == sortingPanel.getMergeButton()) { 
			sort.mergeSort(genList.getList(), 0, genList.getList().length-1, true);
			if(sort.compareWinner()) { winPanel.winField.setText("Merge Sort"); }
		}
		else if(listGenerated == true && event.getSource() == sortingPanel.getHeapButton()) { 
			sort.heapSort(genList.getList());
			if(sort.compareWinner()) { winPanel.winField.setText("Heap Sort"); }
		}
		else if(listGenerated == true && event.getSource() == sortingPanel.getRadixButton()) { 
			sort.radixSort(genList.getList(), genList.getList().length);
			if(sort.compareWinner()) { winPanel.winField.setText("Radix Sort");}
		}
		
		
		if(listGenerated == true) { 
			resultsPanel.getNField().setText(Integer.toString(propertiesPanel.getLengthSlider().getValue()));
			resultsPanel.getDataTypeField().setText(listProperties);
			resultsPanel.getSortField().setText(sort.getSort());
			resultsPanel.getCompField().setText(Integer.toString(sort.getComps()));
			resultsPanel.getMvmtField().setText(Integer.toString(sort.getMvmts()));
			resultsPanel.getTimeField().setText(Long.toString(sort.getTime()));
		}
		listGenerated = true;
	}
}
		



