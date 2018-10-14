package Algorithm;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Counting_Sort {
	ArrayList<Integer> array = new ArrayList<>(); //A - ���� �� �迭
	ArrayList<Integer> temp_array = new ArrayList<>(); //C - �ӽ� �迭
	ArrayList<Integer> sorted_array = new ArrayList<>(); //B - ���� �� �迭
	
	/*
	 * 100�ٿ� ���� �о�� Counting_Sort�� �����ϰ� �����Ѵ�.
	 * 1000�ٿ� ���ؼ� �����ϱ� ���� ArrayList �ʱ�ȭ�Ѵ�.
	 * 1000�ٿ� ���� �о�� Counting_Sort�� �����ϰ� �����Ѵ�.
	 */
	public Counting_Sort() {
		System.out.println("Counting_Sort is starting..."+ "\n");
		test100_read();
		Counting_Sort();
		test100_save();
		init_array(); // 1000�ٿ� ���ؼ� �����ϱ� ���� ArrayList �ʱ�ȭ
		test1000_read();
		long start = System.nanoTime();
		Counting_Sort();
		long end = System.nanoTime();
		long time1 = end - start;
		test1000_save();
		System.out.println("�ð��� " + ((long)time1 / 1000000000.0));
		System.out.println("Counting_Sort save successful");
		System.out.println("------------------------------------------------");
	}
	
	// ArrayList�� ���� �� ���� ū ���� ã�� �Լ�
	public int max(ArrayList<Integer> arr) {
		int temp = arr.get(0);
		for(int i = 1; i < arr.size(); i++) {
			if(temp < arr.get(i)) {
				temp = arr.get(i);
			}
		}
		return temp;
	}
	
	// ArrayList���� �ʱ�ȭ�ϴ� �Լ�
	public void init_array() {
		array.clear();
		temp_array.clear();
		sorted_array.clear();
	}
	
	// ��������� �����ϴ� �Լ�
	public void Counting_Sort() {
		// ���� sorted_array�� �ʱ�ȭ ��Ų��.
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
	
	// 100���ο� ���� �о���� �Լ�
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
	
	// 1000���ο� ���� �о���� �Լ�
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
	
	// 100���ο� ���� ���� �� ���� ���� �Լ�
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
	
	// 1000���ο� ���� ���� �� ���� ���� �Լ�
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
