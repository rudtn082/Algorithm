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
	int p = 0; // 처음 인덱스
	int r = 0; // 마지막 인덱스

	/*
	 * 생성자가 실행되면 먼저 Resource에서 파일을 읽어온다.
	 * test_100.txt에 대한 정렬을 먼저 한다.
	 * test_1000.txt에 대한 정렬을 한다.
	 */
	public Quick_Sort() {
		System.out.println("QuickSort is starting..."+ "\n");
		Quick_Sort_test100();
		Quick_Sort_test1000();
		System.out.println("QuickSort save successful");
		System.out.println("------------------------------------------------");
	}
	
	// 피벗의 위치에 따른 정렬을 두 번하고 비교를 하며 파일로 저장한다.
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
			System.out.println("-> 피벗이 마지막에 있을 경우 반복 횟수는 " + repeat_last +"번으로 " + repeat_random + "번인 랜덤 피벗보다 빠릅니다.\n");
		else
			System.out.println("-> 피벗이 랜덤일 경우 반복 횟수는 " + repeat_random +"번으로 " + repeat_last + "번인 마지막에 있을 경우보다 빠릅니다.\n");
	}

	// 피벗의 위치에 따른 정렬을 두 번하고 비교를 하며 파일로 저장한다.
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
			System.out.println("-> 피벗이 마지막에 있을 경우 반복 횟수는 " + repeat_last +"번으로 " + repeat_random + "번인 랜덤 피벗보다 빠릅니다.\n");
		else
			System.out.println("-> 피벗이 랜덤일 경우 반복 횟수는 " + repeat_random +"번으로 " + repeat_last + "번인 마지막에 있을 경우보다 빠릅니다.\n");
	}
	
	// 피벗이 마지막에 있을 때
	public void Quick_Sorting_Pivotislast(ArrayList array, int p, int r) {
		if(p < r) {
			int q = Pt.Partition_Pivotislast(array, p, r);
			Quick_Sorting_Pivotislast(array, p, q-1);
			Quick_Sorting_Pivotislast(array, q+1, r);
		}
	}
	
	// 피벗이 랜덤일 때
	public void Quick_Sorting_Pivotisrandom(ArrayList array, int p, int r) {
		if(p < r) {
			int q = Pt.Partition_Pivotisrandom(array, p, r);
			Quick_Sorting_Pivotisrandom(array, p, q-1);
			Quick_Sorting_Pivotisrandom(array, q+1, r);
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
	
	// 100라인에 대한 정렬 후 파일 저장 함수
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
	
	// 1000라인에 대한 정렬 후 파일 저장 함수
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
