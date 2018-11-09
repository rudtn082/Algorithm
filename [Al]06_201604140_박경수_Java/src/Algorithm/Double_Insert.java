package Algorithm;

import java.util.ArrayList;

public class Double_Insert {
	final static int SIZE = 97;
	final static int SIZE2 = 59;
	final static int NIL = -98765;	
	private int crash = 0; // Ãæµ¹È½¼ö
	
	public void Double_Insert_Start(ArrayList<Integer> Hash, int x) {
		int key = x % SIZE;
		int i = 0;
		
		while(Hash.get(key) != NIL) {
			i++;
			key = ((x % SIZE) + i * (x % SIZE2)) % SIZE;
			crash++;
		}
		Hash.remove(key);
		Hash.add(key, x);
	}
	
	public int crash_times() {
		return crash;
	}
}
