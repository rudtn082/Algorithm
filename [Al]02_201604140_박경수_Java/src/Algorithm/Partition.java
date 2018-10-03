package Algorithm;

import java.util.ArrayList;
import java.util.Collections;

public class Partition {
	int repeat = 0; // 반복문의 횟수를 세기 위한 변수
	
	Partition() {
	}
	
	public int Partition_Pivotislast(ArrayList array, int p, int r) {
		int i = p-1;
		int repeat_temp = 0;
		for(int j = p; j < r; j++) {
			if((int)array.get(j) <= (int)array.get(r)) {
				i++;
				Collections.swap(array, i, j);
			}
			repeat_temp++;
		}
		Collections.swap(array, i+1, r);
		repeat += repeat_temp;
		return i+1;
	}
	
	public int Partition_Pivotisrandom(ArrayList array, int p, int r) {
		double randomv = Math.random();
		int Pivot = (int)(randomv * (r-p)) + p;	
		int i = p-1;
		Collections.swap(array, r, Pivot);
		int repeat_temp = 0;
		for(int j = p; j < r; j++) {
			if((int)array.get(j) <= (int)array.get(r)) {
				i++;
				Collections.swap(array, i, j);
			}
			repeat_temp++;
		}
		Collections.swap(array, i+1, r);
		repeat += repeat_temp;
		return i+1;
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
