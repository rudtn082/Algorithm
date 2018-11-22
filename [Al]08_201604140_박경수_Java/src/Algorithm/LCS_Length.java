package Algorithm;

import java.util.ArrayList;

public class LCS_Length {
	private final int LEFTUP = 0; // ¢ÿ
	private final int LEFT = 1; // °Á
	private final int UP = 2; // °Ë

	public Struct[][] LCS_Length(String X, String Y) {
		int m = X.length();
		int n = Y.length();
		
		Struct[][] table= new Struct[m][n];
		
		//√ ±‚»≠
		for(int i = 0; i < m; i++) {
			for(int j = 0; j < n; j++) {
				table[i][j] = new Struct();
			}
		}
		
		for(int i = 1; i < m; i++) {
			table[i][0].setNumber(0);
		}		
		
		for(int i = 0; i < n; i++) {
			table[0][i].setNumber(0);
		}
		
		for(int i = 1; i < m; i++) {
			for(int j = 1; j < n; j++) {
				if(X.charAt(i) == Y.charAt(j)) {
					table[i][j].setNumber(table[i-1][j-1].getNumber()+1);
					table[i][j].setArrow(LEFTUP);
				}
				else if(table[i-1][j].getNumber() >= table[i][j-1].getNumber()) {
					table[i][j].setNumber(table[i-1][j].getNumber());
					table[i][j].setArrow(UP);
				}
				else {
					table[i][j].setNumber(table[i][j-1].getNumber());
					table[i][j].setArrow(LEFT);
				}
			}
		}
		return table;
	}
}
