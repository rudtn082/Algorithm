package Algorithm;

import java.util.ArrayList;

public class Build_Heap {
	Heapify heapify = new Heapify();
	
	Build_Heap() {
	}
	
	public void Max_Build_Heap(ArrayList<Integer> array) {
		for(int i = (array.size() / 2) ; i > 0; i--) {
			heapify.Max_Heapify(array, i);
		}
	}
	
	public void Min_Build_Heap(ArrayList<Integer> array) {
		
	}
}
