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
	ArrayList<Integer> array = new ArrayList<>();
	int p = 0; // 처음 인덱스
	int r = 0; // 마지막 인덱스
	int div_times = 0; // List를 나누는 횟수를 조정하기 위한 변수
	
	/*
	 * 생성자가 실행되면 먼저 Resource에서 파일을 읽어온다.
	 * test_100.txt에 대한 정렬을 먼저 한다.
	 * test_1000.txt에 대한 정렬을 한다.
	 * 시간비교를 하기위해 10000줄에 대해서도 정렬한다.
	 */
	public Merge_Sort() {
		System.out.println("MergeSort is starting..."+ "\n");
		Merge_Sort_test100();
		Merge_Sort_test1000();
		Merge_Sort_test10000();
		System.out.println("MergeSort save successful");
		System.out.println("------------------------------------------------");
	}

	public void Merge_Sort_test100() {
		test100_read();
		r = array.size()-1;
		Merge_Sorting(array, p, r);
		test100_save();
	}
	
	public void Merge_Sort_test1000() {
		array.clear();
		p=0;r=0;
		test1000_read();
		r = array.size()-1;
		Merge_Sorting(array, p, r);
		test1000_save();
	}
	
	public void Merge_Sort_test10000() {
		array.clear();
		p=0;r=0;
		test10000_read();
		r = array.size()-1;
		div_times = 5000;
		long start = System.nanoTime();
		Merge_Sorting(array, p, r);
		long end = System.nanoTime();
		long time1 = end - start;
		
		array.clear();
		p=0;r=0;
		test10000_read();
		r = array.size()-1;
		div_times = 312;
		start = System.nanoTime();
		Merge_Sorting(array, p, r);
		end = System.nanoTime();
		long time2 = end - start;
		
		array.clear();
		p=0;r=0;
		test10000_read();
		r = array.size()-1;
		div_times = 9;
		start = System.nanoTime();
		Merge_Sorting(array, p, r);
		end = System.nanoTime();
		long time3 = end - start;
		System.out.println("10000줄에 대하여");
		System.out.println("총 1번만 분할 후 삽입정렬 하였을 때 시간은 " + ((long)time1 / 1000000000.0) + "초이며");
		System.out.println("총 5번 분할 후 삽입정렬 하였을 때 시간은 " + ((long)time2 / 1000000000.0) + "초이며");
		System.out.println("총 10번 분할 후 삽입정렬 하였을 때 시간은 " + ((long)time3 / 1000000000.0) + "초입니다.");
		
		test10000_save();
	}
	
	public void Merge_Sorting(ArrayList array, int p, int r){
		if(p < r) {
			int mid = (p + r) / 2;
			if(mid-p+1 >= div_times && r-mid >= div_times) {
				Merge_Sorting(array, p, mid);
				Merge_Sorting(array, mid+1, r);
				Mg.merge(array, p, mid, r);
			}
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
	
	// 10000라인에 파일 읽어오기 함수
	public void test10000_read() {
		try {
			String path = System.getProperty("user.dir");
			File file = new File(path + "/src/Resource/test_10000.txt");
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
	
	// 10000라인에 대한 정렬 후 파일 저장 함수
		public void test10000_save() {
			String path = System.getProperty("user.dir");
			File file = new File(path + "/src/Resource/Merge_10000.txt");
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