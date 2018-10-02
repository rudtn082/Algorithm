package Algorithm;

import java.util.ArrayList;
import java.util.Collections;

public class Merge {
	int repeat = 0; // �ݺ����� Ƚ���� ���� ���� ����
	
	public void merge(ArrayList array, int p, int mid, int r) {
		int i = p;
		int j = mid + 1;
		int repeat_temp = 0;
		
		// ������������ ����
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
	
	
	// �ݺ� Ƚ���� �����ϴ� �Լ�
	public int repeat_times() {
		return repeat;
	}
	
	// �ݺ� Ƚ���� �ʱ�ȭ�ϴ� �Լ�
	public void repeat_init() {
		repeat = 0;
	}
}