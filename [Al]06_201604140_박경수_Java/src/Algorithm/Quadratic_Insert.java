package Algorithm;

import java.util.ArrayList;

public class Quadratic_Insert {
	final static int SIZE = 59;
	final static int NIL = -98765;
	private int crash = 0; // Ãæµ¹È½¼ö
	
	public void Quadratic_Insert_Start(ArrayList<Integer> Hash, int x) {
		int key = x % SIZE;
		int i = 0;
		
         while(Hash.get(key) != NIL) {
			i++;
  			key = ((x % SIZE) * i) % SIZE;
			crash++;
		}
		Hash.remove(key);
		Hash.add(key, x);
	}
	
	public int crash_times() {
		return crash;
	}

}
