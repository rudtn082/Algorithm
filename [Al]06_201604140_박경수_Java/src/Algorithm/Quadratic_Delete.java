package Algorithm;

import java.util.ArrayList;

public class Quadratic_Delete {
	final static int SIZE = 59;
	final static int NIL = -98765;
	final static int DELETED = -54321;
	
	public Boolean Quadratic_Delete_Start(ArrayList<Integer> Hash, int x) {
		int key = x % SIZE;
		int i = 0;

		while(Hash.get(key) != NIL) {
			if(Hash.get(key) == x) {
				Hash.remove(key);
				Hash.add(key, DELETED);
				return true;
			}
			else {
				i++;
				key = ((x % SIZE) * i) % SIZE;
			}
		}
		return false;		
	}
}
