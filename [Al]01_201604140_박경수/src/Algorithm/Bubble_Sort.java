package Algorithm;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import Sort.file_input;
import List.Double_Linked_List;

public class Bubble_Sort {
	file_input fi = new file_input();
	Double_Linked_List DLL100 = fi.get_test100();
	Double_Linked_List DLL1000 = fi.get_test1000();
	Double_Linked_List DLL10000 = fi.get_test10000();

	// �����ڰ� ȣ��Ǹ� ���� �� ��������
	public Bubble_Sort() {
		System.out.println("Bubble Sort is starting..."+ "\n");
		Sorting();
		Save_file_test100();
		Save_file_test1000();
		Save_file_test10000();
		System.out.println("BubbleSort save successful");
		System.out.println("------------------------------------------------");
	}

	// ���������� �ϱ����� �Լ�
	public void Sorting() {
		// 100���� ����
		for (int i = 0; i < DLL100.length(); i++) {
			for (int j = 0; j < DLL100.length() - i; j++) {
				if (Integer.parseInt(DLL100.get(j)) > Integer.parseInt(DLL100.get(j+1))) {
					String temp_Str = "";
					temp_Str = DLL100.get(j);
					DLL100.remove(j);
					DLL100.add(j+1, temp_Str);
				}
			}
		}
		System.out.println("test_100_BubbleSort_DONE");
		// 1000���� ����
		for (int i = 0; i < DLL1000.length(); i++) {
			for (int j = 0; j < DLL1000.length() - i; j++) {
				if (Integer.parseInt(DLL1000.get(j)) > Integer.parseInt(DLL1000.get(j+1))) {
					String temp_Str = "";
					temp_Str = DLL1000.get(j);
					DLL1000.remove(j);
					DLL1000.add(j+1, temp_Str);
				}
			}
		}
		System.out.println("test_1000_BubbleSort_DONE");
		// 10000���� ����
		for (int i = 0; i < DLL10000.length(); i++) {
			for (int j = 0; j < DLL10000.length() - i; j++) {
				if (Integer.parseInt(DLL10000.get(j)) > Integer.parseInt(DLL10000.get(j+1))) {
					String temp_Str = "";
					temp_Str = DLL10000.get(j);
					DLL10000.remove(j);
					DLL10000.add(j+1, temp_Str);
				}
			}
			

			if(i % 1000 == 0) {
				System.out.println("test_10000 �������Դϴ�... " + i + " / 10000");
			}
		}
		System.out.println("test_10000_BubbleSort_DONE");
	}
	

	// 100���ο� ���� ���� �� ���� ���� �Լ�
	public void Save_file_test100() {
		String path = System.getProperty("user.dir");
		File file = new File(path + "/src/Resource/Bubble_100.txt");
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
		File file = new File(path + "/src/Resource/Bubble_1000.txt");
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
		File file = new File(path + "/src/Resource/Bubble_10000.txt");
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
