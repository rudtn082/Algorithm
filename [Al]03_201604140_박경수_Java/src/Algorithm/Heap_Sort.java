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
	ArrayList<Integer> array = new ArrayList<>();
	Build_Heap bh = new Build_Heap();
	
	public Heap_Sort() {
		System.out.println("Heap_Sort is starting..."+ "\n");
		Heap_Sorting();
		System.out.println("Heap_Sort save successful");
		System.out.println("------------------------------------------------");
		
	}
	
	public void init_array() {
		array.clear();
	}
	
	public void Heap_Sorting() {
		line_100();
		line_1000();
	}
	
	public void line_100() {
		init_array();
		test100_read();
		Max_Heap_Sort();
		test100_Max_save();
		init_array();
		test100_read();
		Min_Heap_Sort();
		test100_Min_save();
	}
	
	public void line_1000() {
		init_array();
		test1000_read();
		long start = System.nanoTime();
		Max_Heap_Sort();
		long end = System.nanoTime();
		long time1 = end - start;
		test1000_Max_save();
		init_array();
		test1000_read();
		start = System.nanoTime();
		Min_Heap_Sort();
		end = System.nanoTime();
		long time2 = end - start;
		test1000_Min_save();
		System.out.println("1000_MAX 시간은 " + ((long)time1 / 1000000000.0) + " / 1000_MIN 시간은 " + ((long)time2 / 1000000000.0));
	}
	
	public void Max_Heap_Sort() {
		bh.Max_Build_Heap(array, array.size()-1);
		for(int i = array.size()-1; i > 0; i--) {
			Collections.swap(array, 0, i);
			heapify.Max_Heapify(array, 0, i-1);
		}
	}
	
	public void Min_Heap_Sort() {
		bh.Min_Build_Heap(array, array.size()-1);
		for(int i = array.size()-1; i > 0; i--) {
			Collections.swap(array, 0, i);
			heapify.Min_Heapify(array, 0, i-1);
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
	
	// 100라인(max)에 대한 정렬 후 파일 저장 함수
	public void test100_Max_save() {
		String path = System.getProperty("user.dir");
		File file = new File(path + "/src/Resource/Heap_Max_100.txt");
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
	
	// 1000라인(max)에 대한 정렬 후 파일 저장 함수
	public void test1000_Max_save() {
		String path = System.getProperty("user.dir");
		File file = new File(path + "/src/Resource/Heap_Max_1000.txt");
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
	
	// 100라인(min)에 대한 정렬 후 파일 저장 함수
		public void test100_Min_save() {
			String path = System.getProperty("user.dir");
			File file = new File(path + "/src/Resource/Heap_Min_100.txt");
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
		
		// 1000라인(min)에 대한 정렬 후 파일 저장 함수
		public void test1000_Min_save() {
			String path = System.getProperty("user.dir");
			File file = new File(path + "/src/Resource/Heap_Min_1000.txt");
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
