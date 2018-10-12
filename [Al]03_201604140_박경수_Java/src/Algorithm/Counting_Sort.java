package Algorithm;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Counting_Sort {
	ArrayList<Integer> array = new ArrayList<>(); //A - 정렬 할 배열
	ArrayList<Integer> temp_array = new ArrayList<>(); //C - 임시 배열
	ArrayList<Integer> sorted_array = new ArrayList<>(); //B - 정렬 된 배열
	
	/*
	 * 100줄에 대해 읽어와 Counting_Sort를 진행하고 저장한다.
	 * 1000줄에 대해서 정렬하기 위해 ArrayList 초기화한다.
	 * 1000줄에 대해 읽어와 Counting_Sort를 진행하고 저장한다.
	 */
	public Counting_Sort() {
		System.out.println("Counting_Sort is starting..."+ "\n");
		test100_read();
		Counting_Sort();
		test100_save();
		init_array(); // 1000줄에 대해서 정렬하기 위해 ArrayList 초기화
		test1000_read();
		Counting_Sort();
		test1000_save();
		System.out.println("Counting_Sort save successful");
		System.out.println("------------------------------------------------");
	}
	
	// ArrayList의 원소 중 가장 큰 값을 찾는 함수
	public int max(ArrayList<Integer> arr) {
		int temp = arr.get(0);
		for(int i = 1; i < arr.size(); i++) {
			if(temp < arr.get(i)) {
				temp = arr.get(i);
			}
		}
		return temp;
	}
	
	// ArrayList들을 초기화하는 함수
	public void init_array() {
		array.clear();
		temp_array.clear();
		sorted_array.clear();
	}
	
	// 계수정렬을 실행하는 함수
	public void Counting_Sort() {
		// 먼저 sorted_array를 초기화 시킨다.
		for(int i = 0; i < array.size(); i++) {
			sorted_array.add(0);
		}
		for(int i = 0; i <= max(array); i++) {
			temp_array.add(0);
		}
		for(int i = 0; i < array.size(); i++) {
			int temp_val = temp_array.get(array.get(i));
			temp_array.set(array.get(i), ++temp_val);
		}
		for(int i = 1; i <= max(array); i++) {
			int temp_val = temp_array.get(i) + temp_array.get(i-1);
			temp_array.set(i, temp_val);
		}
		for(int i = array.size()-1; i >= 0; i--) {
			int temp_index = temp_array.get(array.get(i));
			int temp_val = temp_array.get(array.get(i));
			sorted_array.set(temp_index-1, array.get(i));
			temp_array.set(array.get(i), --temp_val);
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
		File file = new File(path + "/src/Resource/Counting_100.txt");
		FileWriter writer = null;
		try {
			writer = new FileWriter(file, false);

			for (int i = 0; i < sorted_array.size(); i++) {
				writer.write(sorted_array.get(i) + "\r\n");
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
		File file = new File(path + "/src/Resource/Counting_1000.txt");
		FileWriter writer = null;
		try {
			writer = new FileWriter(file, false);

			for (int i = 0; i < sorted_array.size(); i++) {
				writer.write(sorted_array.get(i) + "\r\n");
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
