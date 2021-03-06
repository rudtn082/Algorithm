package Algorithm;

import java.util.ArrayList;

public class Linear_Delete {
	final static int SIZE = 59;
	final static int NIL = -98765;
	final static int DELETED = -54321;
	
	public Boolean Linear_Delete_Start(ArrayList<Integer> Hash, int x) {
		int key = x % SIZE;

		while(Hash.get(key) != NIL) {
			if(Hash.get(key) == x) {
				Hash.remove(key);
				Hash.add(key, DELETED);
				return true;
			}
			else key = (key + 1) % SIZE;
		}
		
		return false;		
	}
}
