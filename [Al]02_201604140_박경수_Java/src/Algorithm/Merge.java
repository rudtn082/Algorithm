package Algorithm;

import java.util.ArrayList;
import java.util.Collections;

public class Merge {
	
	public void merge(ArrayList array, int p, int mid, int r) {
		// 삽입정렬으로 정렬
		for(int k = p; k <= r; k++) {
			int temp = (int)array.get(k);
			int l = k;
			for(; l > 0 && (temp < (int)array.get(l-1)); l--) {
				Collections.swap(array, l, l-1);
			}
			array.remove(l);
			array.add(l, temp);
		}
	}
}