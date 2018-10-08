package Algorithm;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Counting_Sort {
	ArrayList<Integer> array = new ArrayList<>();
	ArrayList<Integer> temp_array = new ArrayList<>();
	ArrayList<Integer> sorted_array = new ArrayList<>();
	
	Counting_Sort() {
		test100_read();
		test1000_read();
	}
	
	public int max() {
		int temp = array.get(0);
		for(int i = 1; i < array.size(); i++) {
			if(temp < array.get(i)) {
				temp = array.get(i);
			}
		}
		return temp;
	}
	
	public void Counting_Sort() {
		for(int i = 0; i < max(); i++) {
			temp_array.add(0);
		}
		for(int i = 0; i < array.size(); i++) {
			temp_array.get(array.get(i));
			temp_array.set(, element)
		}
	}
	
	// 100라인에 파일 읽어오기 함수
	public void test100_read() {
		try {
			String path = System.getProperty("user.dir");
			File file = new File(path + "/src/Resource/test_100.txt");
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
	
	// 1000라인에 파일 읽어오기 함수
	public void test1000_read() {
		try {
			String path = System.getProperty("user.dir");
			File file = new File(path + "/src/Resource/test_1000.txt");
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
	
	// 100라인에 대한 정렬 후 파일 저장 함수
	public void test100_save() {
		String path = System.getProperty("user.dir");
		File file = new File(path + "/src/Resource/Merge_100.txt");
		FileWriter writer = null;
		try {
			writer = new FileWriter(file, false);

			for (int i = 0; i < array.size(); i++) {
				writer.write(array.get(i) + "\r\n");
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
	
	// 1000라인에 대한 정렬 후 파일 저장 함수
	public void test1000_save() {
		String path = System.getProperty("user.dir");
		File file = new File(path + "/src/Resource/Merge_1000.txt");
		FileWriter writer = null;
		try {
			writer = new FileWriter(file, false);

			for (int i = 0; i < array.size(); i++) {
				writer.write(array.get(i) + "\r\n");
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
