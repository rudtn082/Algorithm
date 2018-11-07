package Algorithm;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Hash_Table {
	ArrayList<Integer> array = new ArrayList<>();
	
	public Hash_Table() {
		System.out.println("Hash_Table is starting..."+ "\n");
		System.out.println("------------------------------------------------");
	}
	
	
	// Data1에 파일 읽어오기 함수
	public void Data1_read() {
		try {
			String path = System.getProperty("user.dir");
			File file = new File(path + "/src/Resource/Data1.txt");
			FileReader filereader = new FileReader(file);
			BufferedReader bufreader = new BufferedReader(filereader);
			String line = "";
			int index = 0;
			while ((line = bufreader.readLine()) != null) {
				array.add(index, Integer.parseInt(line));
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
	
	// Data2에 파일 읽어오기 함수
	public void Data2_read() {
		try {
			String path = System.getProperty("user.dir");
			File file = new File(path + "/src/Resource/Data2.txt");
			FileReader filereader = new FileReader(file);
			BufferedReader bufreader = new BufferedReader(filereader);
			String line = "";
			int index = 0;
			while ((line = bufreader.readLine()) != null) {
				array.add(index, Integer.parseInt(line));
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
	
	// Data3에 파일 읽어오기 함수
	public void Data3_read() {
		try {
			String path = System.getProperty("user.dir");
			File file = new File(path + "/src/Resource/Data3.txt");
			FileReader filereader = new FileReader(file);
			BufferedReader bufreader = new BufferedReader(filereader);
			String line = "";
			int index = 0;
			while ((line = bufreader.readLine()) != null) {
				array.add(index, Integer.parseInt(line));
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

}
