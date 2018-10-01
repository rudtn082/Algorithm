package Algorithm;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import Sort.file_input;
import List.Double_Linked_List;

public class Selection_Sort {
	file_input fi = new file_input();
	Double_Linked_List DLL100 = fi.get_test100();
	Double_Linked_List DLL1000 = fi.get_test1000();
	Double_Linked_List DLL10000 = fi.get_test10000();

	// �����ڰ� ȣ��Ǹ� ���� �� ��������
	public Selection_Sort() {
		System.out.println("Selection Sort is starting..." + "\n");
		Sorting();
		Save_file_test100();
		Save_file_test1000();
		Save_file_test10000();
		System.out.println("SelectionSort save successful");
		System.out.println("------------------------------------------------");
	}
	
	public void Sorting() {
		// 100���� ����
		for (int i = 0; i < DLL100.length(); i++) {
			String temp_Str = DLL100.get(i);
			int temp_int = i;
			for (int j = i+1; j < DLL100.length(); j++) {
				if(Integer.parseInt(temp_Str) > Integer.parseInt(DLL100.get(j))) {
					temp_Str = DLL100.get(j);
					temp_int = j;
				}
			}
			DLL100.remove(temp_int);
			DLL100.add(temp_int, DLL100.get(i));
			DLL100.remove(i);
			DLL100.add(i, temp_Str);
		}
		System.out.println("test_100_SelectionSort_DONE");
		// 1000���� ����
		for (int i = 0; i < DLL1000.length(); i++) {
			String temp_Str = DLL1000.get(i);
			int temp_int = i;
			for (int j = i+1; j < DLL1000.length(); j++) {
				if(Integer.parseInt(temp_Str) > Integer.parseInt(DLL1000.get(j))) {
					temp_Str = DLL1000.get(j);
					temp_int = j;
				}
			}
			DLL1000.remove(temp_int);
			DLL1000.add(temp_int, DLL1000.get(i));
			DLL1000.remove(i);
			DLL1000.add(i, temp_Str);
		}
		System.out.println("test_1000_SelectionSort_DONE");
		// 10000���� ����
		for (int i = 0; i < DLL10000.length(); i++) {
			String temp_Str = DLL10000.get(i);
			int temp_int = i;
			for (int j = i+1; j < DLL10000.length(); j++) {
				if(Integer.parseInt(temp_Str) > Integer.parseInt(DLL10000.get(j))) {
					temp_Str = DLL10000.get(j);
					temp_int = j;
				}
			}
			DLL10000.remove(temp_int);
			DLL10000.add(temp_int, DLL10000.get(i));
			DLL10000.remove(i);
			DLL10000.add(i, temp_Str);
			

			if(i % 1000 == 0) {
				System.out.println("test_10000 �������Դϴ�... " + i + " / 10000");
			}
		}
		System.out.println("test_10000_SelectionSort_DONE");
	}
	
	// 100���ο� ���� ���� �� ���� ���� �Լ�
	public void Save_file_test100() {
		String path = System.getProperty("user.dir");
		File file = new File(path + "/src/Resource/Select_100.txt");
		FileWriter writer = null;
		try {
			writer = new FileWriter(file, false);

			for (int i = 0; i < DLL100.length(); i++) {
				writer.write(DLL100.get(i) + "\r\n");
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
	public void Save_file_test1000() {
		String path = System.getProperty("user.dir");
		File file = new File(path + "/src/Resource/Select_1000.txt");
		FileWriter writer = null;
		try {
			writer = new FileWriter(file, false);

			for (int i = 0; i < DLL1000.length(); i++) {
				writer.write(DLL1000.get(i) + "\r\n");
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
	
	// 10000���ο� ���� ���� �� ���� ���� �Լ�
	public void Save_file_test10000() {
		String path = System.getProperty("user.dir");
		File file = new File(path + "/src/Resource/Select_10000.txt");
		FileWriter writer = null;
		try {
			writer = new FileWriter(file, false);

			for (int i = 0; i < DLL10000.length(); i++) {
				writer.write(DLL10000.get(i) + "\r\n");
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
