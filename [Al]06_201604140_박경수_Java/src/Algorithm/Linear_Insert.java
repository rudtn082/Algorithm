package Algorithm;

import java.util.ArrayList;

public class Linear_Insert {
	final static int SIZE = 59;
	final static int NIL = -98765;
	private int crash = 0; // Ãæµ¹È½¼ö
	
	public void Linear_Insert_Start(ArrayList<Integer> Hash, int x) {
		int key = x % SIZE;
		while(Hash.get(key) != NIL) {
			key = (key + 1) % SIZE;
			crash++;
		}
		Hash.remove(key);
		Hash.add(key, x);
	}
	
	public int crash_times() {
		return crash;
	}
}
