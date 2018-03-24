package sorting_techniques;

import java.util.Arrays;
import java.util.Collections;

public class GenerateLists {
	
	private int list[];

	//Creates a list of size defined by param
	public GenerateLists(int size) {
		list = new int[size];
		for (int i = 0; i < list.length; i++) {
			list[i] = i;
		}
	}
	
	//Sets the size of the list
	public void setList(int size) { list = new int[size]; }

	//Returns the list
	public int[] getList() { return list; }


	//Ordering functions
	
	//List is sorted from least to greatest
	public void inOrder() { Arrays.sort(list); }

	//List is sorted from greatest to least
	public void reverseOrder() { Collections.reverse(Arrays.asList(list)); }

	//List is almost in order
	public void almostOrder() {
		for(int i = 0, j = (int)(list.length/2); i < list.length && j < list.length; i++, j+=j) {
				int temp = list[j];
				list[j] = list[i];
				list[i] = temp;
		}
	}

	//List is put in a random order
	public void randomOrder() {
		for(int i = 0; i < list.length; i++) {
			int random = (int)(Math.random() * (list.length - 1));
			int temp = list[random];
			list[random] = list[i];
			list[i] = temp;
		}
	}
}
