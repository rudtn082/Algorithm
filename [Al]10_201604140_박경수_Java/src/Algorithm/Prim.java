package Algorithm;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Prim {

	public Prim() {

	}

	// 파일 읽어오기 함수
	public void file_read() {
		try {
			String path = System.getProperty("user.dir");
			File file = new File(path + "/src/Resource/graph_sample_prim_kruskal.txt");
			FileReader filereader = new FileReader(file);
			BufferedReader bufreader = new BufferedReader(filereader);
			String line = "";
			int index = 0;
			while ((line = bufreader.readLine()) != null) {
				// array.add(index, Integer.parseInt(line));
				index++;
			}
			bufreader.close();
			filereader.close();
		} catch (FileNotFoundException e) {
			System.out.println(e);
		} catch (IOException e) {
			System.out.println(e);
		}
	}

	// 파일 저장 함수
	public void file_save() {
		String path = System.getProperty("user.dir");
		File file = new File(path + "/src/Resource/prim_output.txt");
		FileWriter writer = null;
		try {
			writer = new FileWriter(file, false);

//				for (int i = 0; i < array.size(); i++) {
//					writer.write(array.get(i) + "\r\n");
//				}
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
