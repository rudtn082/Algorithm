package Algorithm;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Merge_Sort {
	Merge Mg = new Merge();
	ArrayList<Integer> array_100 = new ArrayList<>();
	ArrayList<Integer> array_1000 = new ArrayList<>();
	int p = 0; // ó�� �ε���
	int r = 0; // ������ �ε���
	int div_times = 0; // List�� ������ Ƚ���� �����ϱ� ���� ����
	int times = 0; // List�� ������ Ƚ��
	
	/*
	 * �����ڰ� ����Ǹ� ���� Resource���� ������ �о�´�.
	 * test_100.txt�� ���� ������ ���� �Ѵ�.
	 * test_1000.txt�� ���� ������ �Ѵ�.
	 */
	public Merge_Sort() {
		System.out.println("MergeSort is starting..."+ "\n");
		//Merge_Sort_test100();
		Merge_Sort_test1000();
		System.out.println("MergeSort save successful");
		System.out.println("------------------------------------------------");
	}

	public void Merge_Sort_test100() {
		test100_read();
		r = array_100.size()-1;
		div_times = 5; // �ִ� 5�� ����
		times = 0; // ���� Ƚ�� �ʱ�ȭ
		
		Merge_Sorting(array_100, p, r);
		int repeat_div5 = Mg.repeat_times();
		Mg.repeat_init();
		div_times = 3;
		times = 0;
		
		Merge_Sorting(array_100, p, r);
		int repeat_div3 = Mg.repeat_times();
		Mg.repeat_init();
		div_times = 1;
		times = 0;
		
		Merge_Sorting(array_100, p, r);
		int repeat_div1 = Mg.repeat_times();
		Mg.repeat_init();
		times = 0;
		
		test100_save();
		
		System.out.println("test_100.txt�� ���ؼ� �ִ� 5ȸ ���� �� �������� �� " + repeat_div5 + "ȸ �ݺ��ϸ�");
		System.out.println("�ִ� 3ȸ ���� �� �������� �� " + repeat_div3 + "ȸ �ݺ��ϸ�");
		System.out.println("�ִ� 1ȸ ���� �� �������� �� " + repeat_div1 + "ȸ �ݺ��մϴ�.\n");
	}
	
	public void Merge_Sort_test1000() {
		long start = System.currentTimeMillis();
		test1000_read();
		r = array_1000.size()-1;
		div_times = 5; // �ִ� 5�� ����
		times = 0; // ���� Ƚ�� �ʱ�ȭ

		long end = System.currentTimeMillis();
		System.out.println( "���� �ð� : " + ( end - start )/1000.0);
		
		Merge_Sorting(array_1000, p, r);
		int repeat_div5 = Mg.repeat_times();
		Mg.repeat_init();
		div_times = 3;
		times = 0;
		
		Merge_Sorting(array_1000, p, r);
		int repeat_div3 = Mg.repeat_times();
		Mg.repeat_init();
		div_times = 1;
		times = 0;
		
		Merge_Sorting(array_1000, p, r);
		int repeat_div1 = Mg.repeat_times();
		Mg.repeat_init();
		times = 0;
		
		test1000_save();
		
		System.out.println("test_1000.txt�� ���ؼ� �ִ� 5ȸ ���� �� �������� �� " + repeat_div5 + "ȸ �ݺ��ϸ�");
		System.out.println("�ִ� 3ȸ ���� �� �������� �� " + repeat_div3 + "ȸ �ݺ��ϸ�");
		System.out.println("�ִ� 1ȸ ���� �� �������� �� " + repeat_div1 + "ȸ �ݺ��մϴ�.\n");
	}
	
	public void Merge_Sorting(ArrayList array, int p, int r){
		if(p < r) {
			int mid = (p + r) / 2;
			if(times < div_times) {
				times++;
				Merge_Sorting(array, p, mid);
				Merge_Sorting(array, mid+1, r);
			}
			Mg.merge(array, p, mid, r);
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
		File file = new File(path + "/src/Resource/Merge_100.txt");
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
		File file = new File(path + "/src/Resource/Merge_1000.txt");
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