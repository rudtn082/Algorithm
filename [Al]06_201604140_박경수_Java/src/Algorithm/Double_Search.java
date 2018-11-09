package Algorithm;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Double_Search {
	ArrayList<String> search_result = new ArrayList<>();
	final static int SIZE = 97;
	final static int SIZE2 = 59;
	final static int NIL = -98765;
	
	public Boolean Double_Search_Start(ArrayList<Integer> Hash, int x) {
		int key = x % SIZE;
		int i = 0;
		
		while(Hash.get(key) != NIL) {
			if(Hash.get(key) == x) {
				search_result.add(x + " " + key);
				return true;
			}
			else {
				i++;
				key = ((x % SIZE) + i * (x % SIZE2)) % SIZE;
			}
		}
		
		return false;		
	}
	
	// 검색 결과를 저장하는 함수
	public void save() {
		String path = System.getProperty("user.dir");
		File file = new File(path + "/src/Resource/Double.txt");
		FileWriter writer = null;
		try {
			writer = new FileWriter(file, false);

			for (int i = 0; i < search_result.size(); i++) {
				writer.write(search_result.get(i) + "\r\n");
			}
			System.out.println("...save...");
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
