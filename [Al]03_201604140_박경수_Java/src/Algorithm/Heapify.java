package Algorithm;

import java.util.ArrayList;
import java.util.Collections;

public class Heapify {

	Heapify() {
	}
	
	public void Max_Heapify(ArrayList<Integer> array, int i) {
		int l = 2*i;
		int r = 2*i+1;
		int largest = 0;
		if(l < array.size() && array.get(l) > array.get(i))
			largest = l;
		else
			largest = i;
		
		if(r < array.size() && array.get(r) > array.get(largest))
			largest = r;
		
		if(largest != i) {
			Collections.swap(array, i, largest);
			Max_Heapify(array, largest);
		}
	}
	
	public void Min_Heapify(ArrayList<Integer> array) {
		
	}
}
