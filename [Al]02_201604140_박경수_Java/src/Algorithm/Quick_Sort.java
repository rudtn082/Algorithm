package Algorithm;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import Algorithm.Partition;

public class Quick_Sort {
	Partition Pt = new Partition();
	ArrayList<Integer> array_100 = new ArrayList<>();
	ArrayList<Integer> array_1000 = new ArrayList<>();
	int p = 0; // ó�� �ε���
	int r = 0; // ������ �ε���

	/*
	 * �����ڰ� ����Ǹ� ���� Resource���� ������ �о�´�.
	 * test_100.txt�� ���� ������ ���� �Ѵ�.
	 * test_1000.txt�� ���� ������ �Ѵ�.
	 */
	public Quick_Sort() {
		System.out.println("QuickSort is starting..."+ "\n");
		Quick_Sort_test100();
		Quick_Sort_test1000();
		System.out.println("QuickSort save successful");
		System.out.println("------------------------------------------------");
	}
	
	// �ǹ��� ��ġ�� ���� ������ �� ���ϰ� �񱳸� �ϸ� ���Ϸ� �����Ѵ�.
	public void Quick_Sort_test100() {
		test100_read();
		r = array_100.size()-1;
		Quick_Sorting_Pivotislast(array_100,p,r);
		int repeat_last = Pt.repeat_times();
		Pt.repeat_init();
		Quick_Sorting_Pivotisrandom(array_100,p,r);
		int repeat_random = Pt.repeat_times();
		Pt.repeat_init();
		test100_save();
		System.out.println("test100_QuickSort_DONE");
		if(repeat_last <= repeat_random)
			System.out.println("-> �ǹ��� �������� ���� ��� �ݺ� Ƚ���� " + repeat_last +"������ " + repeat_random + "���� ���� �ǹ����� �����ϴ�.\n");
		else
			System.out.println("-> �ǹ��� ������ ��� �ݺ� Ƚ���� " + repeat_random +"������ " + repeat_last + "���� �������� ���� ��캸�� �����ϴ�.\n");
	}

	// �ǹ��� ��ġ�� ���� ������ �� ���ϰ� �񱳸� �ϸ� ���Ϸ� �����Ѵ�.
	public void Quick_Sort_test1000() {
		test1000_read();
		r = array_1000.size()-1;
		Quick_Sorting_Pivotislast(array_1000,p,r);
		int repeat_last = Pt.repeat_times();
		Pt.repeat_init();
		Quick_Sorting_Pivotisrandom(array_1000,p,r);
		int repeat_random = Pt.repeat_times();
		Pt.repeat_init();
		test1000_save();
		System.out.println("test1000_QuickSort_DONE");
		if(repeat_last <= repeat_random)
			System.out.println("-> �ǹ��� �������� ���� ��� �ݺ� Ƚ���� " + repeat_last +"������ " + repeat_random + "���� ���� �ǹ����� �����ϴ�.\n");
		else
			System.out.println("-> �ǹ��� ������ ��� �ݺ� Ƚ���� " + repeat_random +"������ " + repeat_last + "���� �������� ���� ��캸�� �����ϴ�.\n");
	}
	
	// �ǹ��� �������� ���� ��
	public void Quick_Sorting_Pivotislast(ArrayList array, int p, int r) {
		if(p < r) {
			int q = Pt.Partition_Pivotislast(array, p, r);
			Quick_Sorting_Pivotislast(array, p, q-1);
			Quick_Sorting_Pivotislast(array, q+1, r);
		}
	}
	
	// �ǹ��� ������ ��
	public void Quick_Sorting_Pivotisrandom(ArrayList array, int p, int r) {
		if(p < r) {
			int q = Pt.Partition_Pivotisrandom(array, p, r);
			Quick_Sorting_Pivotisrandom(array, p, q-1);
			Quick_Sorting_Pivotisrandom(array, q+1, r);
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
				array_100.add(index, Integer.parseInt(line));
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
				array_1000.add(index, Integer.parseInt(line));
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
		File file = new File(path + "/src/Resource/Quick_100.txt");
		FileWriter writer = null;
		try {
			writer = new FileWriter(file, false);

			for (int i = 0; i < array_100.size(); i++) {
				writer.write(array_100.get(i) + "\r\n");
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
		File file = new File(path + "/src/Resource/Quick_1000.txt");
		FileWriter writer = null;
		try {
			writer = new FileWriter(file, false);

			for (int i = 0; i < array_1000.size(); i++) {
				writer.write(array_1000.get(i) + "\r\n");
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
