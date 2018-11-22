package Algorithm;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Print_LCS {
	ArrayList<Character> array = new ArrayList<Character>();
	private final int LEFTUP = 0; // ↖
	private final int LEFT = 1; // ←
	private final int UP = 2; // ↑
	
	public void Print_LCS(Struct[][] struct, String X, int i, int j) {
		if(i == 0 || j == 0) return;
		if(struct[i][j].getArrow() == LEFTUP) {
			Print_LCS(struct, X, i-1,j-1);
			array.add(X.charAt(i));
		}
		else if(struct[i][j].getArrow() == UP) {
			Print_LCS(struct, X, i-1,j);
		}
		else Print_LCS(struct, X, i,j-1);
		
		save();
	}
	
	// 파일 저장 함수
	public void save() {
		String path = System.getProperty("user.dir");
		File file = new File(path + "/src/Resource/Output.txt");
		FileWriter writer = null;
		try {
			writer = new FileWriter(file, false);
			for (int i = 0; i < array.size(); i++) {
				writer.write(array.get(i));
			}
			writer.flush();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (writer != null)
					writer.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
