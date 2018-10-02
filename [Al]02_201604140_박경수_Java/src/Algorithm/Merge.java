package Algorithm;

import java.util.ArrayList;
import java.util.Collections;

public class Merge {
	int repeat = 0; // 반복문의 횟수를 세기 위한 변수
	
	public void merge(ArrayList array, int p, int mid, int r) {
		int i = p;
		int j = mid + 1;
		int repeat_temp = 0;
		
		// 삽입정렬으로 정렬
		for(int k = p; k <= r; k++) {
			int temp_min = (int)array.get(k);
			int l = k;
			for(; l > 0 && (temp_min < (int)array.get(l-1)); l--) {
				Collections.swap(array, l, l-1);
			}
			array.remove(l);
			array.add(l, temp_min);
			repeat_temp++;
		}
		repeat += repeat_temp;
	}
	
	
	// 반복 횟수를 리턴하는 함수
	public int repeat_times() {
		return repeat;
	}
	
	// 반복 횟수를 초기화하는 함수
	public void repeat_init() {
		repeat = 0;
	}
}