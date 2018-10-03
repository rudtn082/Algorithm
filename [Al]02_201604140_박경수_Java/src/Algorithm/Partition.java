package Algorithm;

import java.util.ArrayList;
import java.util.Collections;

public class Partition {
	int repeat = 0; // �ݺ����� Ƚ���� ���� ���� ����
	
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
	
	// �ݺ� Ƚ���� �����ϴ� �Լ�
	public int repeat_times() {
		return repeat;
	}
	
	// �ݺ� Ƚ���� �ʱ�ȭ�ϴ� �Լ�
	public void repeat_init() {
		repeat = 0;
	}
}
