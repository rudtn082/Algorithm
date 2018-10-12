package Algorithm;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

public class Heap_Sort {
	Heapify heapify = new Heapify();
	ArrayList<Integer> array = new ArrayList<>(); //A - 정렬 할 배열
	Build_Heap bh = new Build_Heap();
	
	public Heap_Sort() {
		System.out.println("Heap_Sort is starting..."+ "\n");
		Heap_Sorting();

		System.out.println("Heap_Sort save successful");
		System.out.println("------------------------------------------------");
		
	}
	
	public void Heap_Sorting() {
		test100_read();
		Max_Heap_Sort();
		test100_save();
	}
	
	public void Max_Heap_Sort() {
		bh.Max_Build_Heap(array);
		for(int i = array.size()-1; i > 1; i--) {
			Collections.swap(array, 1, i);
			heapify.Max_Heapify(array, 1);
		}
	}
	
	public void Min_Heap_Sort() {
		
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
		File file = new File(path + "/src/Resource/Heap_100.txt");
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
		File file = new File(path + "/src/Resource/Heap_1000.txt");
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
