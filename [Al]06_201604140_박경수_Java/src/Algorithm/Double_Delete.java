package Algorithm;

import java.util.ArrayList;

public class Double_Delete {
	final static int SIZE = 97;
	final static int SIZE2 = 59;
	final static int NIL = -98765;
	final static int DELETED = -54321;
	
	public Boolean Double_Delete_Start(ArrayList<Integer> Hash, int x) {
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
				key = ((x % SIZE) + i * (x % SIZE2)) % SIZE;
			}
		}
		
		return false;		
	}
}
