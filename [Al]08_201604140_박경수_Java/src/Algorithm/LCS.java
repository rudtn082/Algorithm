package Algorithm;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class LCS {
	LCS_Length LL = new LCS_Length();
	Print_LCS print = new Print_LCS();
	ArrayList<String> array = new ArrayList<String>();
	
	public LCS() {
		data_read();
		Struct[][] st = new Struct[Integer.valueOf(array.get(0))][Integer.valueOf(array.get(2))];
		st = LL.LCS_Length(array.get(1), array.get(3));
		print.Print_LCS(st, array.get(1), Integer.valueOf(array.get(0))-1, Integer.valueOf(array.get(2))-1);
	}
	
	// 파일 읽어오기 함수
	public void data_read() {
		try {
			String path = System.getProperty("user.dir");
			File file = new File(path + "/src/Resource/LCS_Data.txt");
			FileReader filereader = new FileReader(file);
			BufferedReader bufreader = new BufferedReader(filereader);
			String line = "";
			while ((line = bufreader.readLine()) != null) {
				array.add(line);
			}
			bufreader.close();
			filereader.close();
		} catch (FileNotFoundException e) {
			System.out.println(e);
		} catch (IOException e) {
			System.out.println(e);
		}
	}
	


}
