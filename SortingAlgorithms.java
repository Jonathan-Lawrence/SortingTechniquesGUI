package sorting_techniques;

import java.util.Arrays;

public class SortingAlgorithms {
	
	private String sort = ""; //holds the sort name
	private int comps = 0; //the number of comparisons
	private int mvmts = 0; //the number of movements or swaps
	private long time = 0; //the time spent per operation
	private int [] list; //list to be performed upon
	
	private long winnerTime = -1; //time of the winning algorithm 
	
//Constructor	
	public SortingAlgorithms(int c, int m, long t) {
		comps = c;
		mvmts = m;
		time = t;
	}
	
//ACCESSORS//
	public String getSort() { return sort; }
	public int getComps() { return comps; }
	public int getMvmts() { return mvmts; }
	public long getTime() { return time; }
	
//FUNCTIONS//
//Insertion Sort
	public void insertionSort(int [] src) {
		sort = "Insertion";
		comps = 0;
		mvmts = 0;
		time = 0;
		
		list = src.clone();
		
		long startTime = System.currentTimeMillis();
		
        for (int i=1; i<list.length; i++, comps++)
        {
            int currentElement = list[i];
            
            int j;
            for(j = i-1; j>=0 && list[j] > currentElement; j--, comps++) {
            	list[j + 1] = list[j]; mvmts++;
            }
            list[j + 1] = currentElement;
        }
        
        long endTime = System.currentTimeMillis();
        time = endTime - startTime;
        }
	
//Selection Sort
	public void selectionSort(int [] src) {
		sort = "Selection";
		comps = 0;
		mvmts = 0;
		time = 0;
		
		list = src.clone();
		
		long startTime = System.currentTimeMillis();
		
		int n = list.length;
		 
        // One by one move boundary of unsorted subarray
        for (int i = 0; i < n-1; i++)
        {
            // Find the minimum element in unsorted array
            int min = i;
            for (int j = i+1; j < n; j++, comps++)
                if (list[j] < list[min]) {
                		comps++;
                    min = j; mvmts++;
                }
            // Swap the found minimum element with the first
            // element
            int temp = list[min]; mvmts++;
            list[min] = list[i];
            list[i] = temp;
        }
        
        long endTime = System.currentTimeMillis();
        time = endTime - startTime;
	}
	
//Quick Sort
	public void quickSort(int[] list) {
		quickSort(list, 0, list.length-1, true);
	}
	public void quickSort(int [] src, int first, int last, boolean firstRun) {
		if(firstRun) {
			sort = "Quick";
			comps = 0;
			mvmts = 0;
			time = 0;
		}
		list = src.clone();
		
		long startTime = System.currentTimeMillis();
		
		if(last > first) {
			int pivot = partition(list,first,last);
			quickSort(list, first, pivot - 1, false);
			quickSort(list, pivot + 1, last, false);
		}
		long endTime = System.currentTimeMillis();
        time = endTime - startTime;
	}
	
	public int partition(int[] list, int first, int last) {	
		int pivot = list[first];
		int low = first + 1; 
		int high = last;
		
		while (high > low) {
			comps++;
			while (low <= high && list[low] <= pivot) {
				comps++;
				low++;
			}
			while (low <= high && list[high] > pivot) {
				comps++;
				high--;
			}
			if (high > low) {
				comps++;
				int temp = list[high]; mvmts++;
				list[high] = list[low];
				list[low] = temp; 
			}
		}
		
		while (high > first && list[high] >= pivot) {
			comps++;
			high--;
		}
		comps++;
		if (pivot > list[high]) {
			list[first] = list[high]; mvmts++;
			list[high] = pivot;
			return high;
		}
		else {
			return first;
		}
	}

	
//Merge Sort
	public void mergeSort(int [] src, int l, int r, boolean firstRun) {
		if(firstRun) {
			sort = "Merge";
			comps = 0;
			mvmts = 0;
			time = 0;
		}
		
		list = src.clone();
		
		long startTime = System.currentTimeMillis();
		
		if(l < r) {
			int m = (l + r)/2;
			mergeSort(list, l, m, false);
			mergeSort(list, m + 1, r, false);
			
			merge(list, l, m, r);	
		}
		
		long endTime = System.currentTimeMillis();
        time = endTime - startTime;
	}
    void merge(int list[], int l, int m, int r)
    {
        int n1 = m - l + 1;
        int n2 = r - m;
 
        int L[] = new int [n1];
        int R[] = new int [n2];
 
        for (int i=0; i<n1; ++i) {
            L[i] = list[l + i];
            mvmts++;
        }
        for (int j=0; j<n2; ++j) {
            R[j] = list[m + 1 + j];
            mvmts++;
        }
 
 
        int i = 0, j = 0;
 
        int k = l;
        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) {
            		comps++;
                list[k] = L[i];
                i++;
                mvmts++;
            }
            else {
            		comps++;
                list[k] = R[j];
                j++;
                mvmts++;
            }
            k++;
        }
 
        while (i < n1) {
        		comps++;
            list[k] = L[i];
            i++;
            k++;
            mvmts++;
        }

        while (j < n2) {
        		comps++;
            list[k] = R[j];
            j++;
            k++;
            mvmts++;
        }
    }
	
//Heap Sort
	public void heapSort(int [] src) {
		sort = "Heap";
		comps = 0;
		mvmts = 0;
		time = 0;
		
		list = src.clone();
		
		long startTime = System.currentTimeMillis();
		
		int n = list.length;

		for (int i = n / 2 - 1; i >= 0; i--, comps++)
			heapify(list, n, i);
		
		for (int i = n - 1; i >= 0; i--) {
			int temp = list[0]; mvmts++;
			list[0] = list[i];
			list[i] = temp;
			
			heapify(list, i, 0);
		}
		
		long endTime = System.currentTimeMillis();
        time = endTime - startTime;
	}
	private void heapify(int [] list,int n, int i) { 
		int max = i;
		int l = 2 * i + 1;
		int r = 2 * i + 2;
		
		// If left child is larger than root
        if (l < n && list[l] > list[max]) {
        		comps+=2;
            max = l; mvmts++;
        }
        // If right child is larger than largest so far
        if (r < n && list[r] > list[max]) {
        		comps+=2;
        		max = r; mvmts++;
        }
        // If largest is not root
        comps++;
        if (max != i)
        {
            int temp = list[i]; mvmts++;
            list[i] = list[max];
            list[max] = temp;
 
            // Recursively heapify the affected sub-tree
            heapify(list, n, max);
        }
	}
//Radix Sort
	public int getMax(int list[], int n) {
		int max = list[0];
		for (int i = 1; i < n; i++, comps++)
			if (list[i] > max) {
				max = list[i]; mvmts++;
			}
		return max;
	}
	public void countSort(int list[], int n, int exp) {
		int output[] = new int[n];
		int i;
		int count[] = new int[10];
		Arrays.fill(count, 0);
		
		for (i = 0; i < n; i++, comps++)
			count[ (list[i]/exp)%10 ]++;
		
		for (i = 1; i < 10; i++, comps++) {
			count[i] += count[i - 1];
			mvmts++;
		}
		
		for (i = n - 1; i >= 0; i--, comps++)
		{
			output[count[ (list[i]/exp)%10 ] - 1] = list[i]; mvmts++;
            count[ (list[i]/exp)%10 ]--;
		}
		
		for (i = 0; i < n; i++, comps++)
			list[i] = output[i]; mvmts++;
	}
	public void radixSort(int [] src, int n) {
		sort = "Radix";
		comps = 0;
		mvmts = 0;
		time = 0;
		
		list = src.clone();
		
		long startTime = System.currentTimeMillis();
		
		int m = getMax(list, n);
		
		for (int exp = 1; m/exp > 0; exp *= 10, mvmts++)
			countSort(list, n, exp);
		
		long endTime = System.currentTimeMillis();
        time = endTime - startTime;
	}
	
	public boolean compareWinner() {
		long possibleTime = time;
		if(winnerTime == -1 || possibleTime < winnerTime) {
			winnerTime = possibleTime;
			return true;
		}
		else { return false; }
	}
}
