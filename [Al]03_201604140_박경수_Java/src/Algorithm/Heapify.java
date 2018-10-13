package Algorithm;

import java.util.ArrayList;
import java.util.Collections;

public class Heapify {

	Heapify() {
	}
	
	public void Max_Heapify(ArrayList<Integer> array, int i, int length) {
		int l = 2*i;
		int r = 2*i+1;
		int largest = 0;
		if(l <= length && array.get(l) > array.get(i))
			largest = l;
		else
			largest = i;
		
		if(r <= length && array.get(r) > array.get(largest))
			largest = r;
		
		if(largest != i) {
			Collections.swap(array, i, largest);
			Max_Heapify(array, largest, length);
		}
	}
	
	public void Min_Heapify(ArrayList<Integer> array, int i, int length) {
		int l = 2*i;
		int r = 2*i+1;
		int smallest = 0;
		if(r <= length) {
			if(array.get(l) < array.get(r))
				smallest = l;
			else smallest = r;
		}
		else if(l <= length) smallest = l;
		else return;
		
		if(array.get(smallest) < array.get(i)) {
			Collections.swap(array, i, smallest);
			Min_Heapify(array, smallest, length);
		}
	}
}
