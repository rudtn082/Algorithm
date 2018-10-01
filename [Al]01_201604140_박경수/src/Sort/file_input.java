package Sort;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import List.Double_Linked_List;

public class file_input {
	Double_Linked_List DLL100 = new Double_Linked_List();
	Double_Linked_List DLL1000 = new Double_Linked_List();
	Double_Linked_List DLL10000 = new Double_Linked_List();
	String arr100[] = new String[100];
	String arr1000[] = new String[1000];
	String arr10000[] = new String[10000];
	int temp_num = 0;

	// 생성자가 호출되면 파일을 읽어옴.
	public file_input() {
		test100();
		test1000();
		test10000();
	}
	
	// 100라인에 대한 파일 읽기함수
	public void test100() {
		try {
			String path = System.getProperty("user.dir");
			File file = new File(path + "/src/Resource/test_100.txt");
			FileReader filereader = new FileReader(file);
			BufferedReader bufreader = new BufferedReader(filereader);
			String line = "";
			while ((line = bufreader.readLine()) != null) {
				DLL100.addLast(line);
			}
			bufreader.close();
			filereader.close();
		} catch (FileNotFoundException e) {
			System.out.println(e);
		} catch (IOException e) {
			System.out.println(e);
		}
	}
	// 1000라인에 대한 파일 읽기함수
	public void test1000() {
		try {
			String path = System.getProperty("user.dir");
			File file = new File(path + "/src/Resource/test_1000.txt");
			FileReader filereader = new FileReader(file);
			BufferedReader bufreader = new BufferedReader(filereader);
			String line = "";
			while ((line = bufreader.readLine()) != null) {
				DLL1000.addLast(line);
			}
			bufreader.close();
			filereader.close();
		} catch (FileNotFoundException e) {
			System.out.println(e);
		} catch (IOException e) {
			System.out.println(e);
		}
	}
	// 10000라인에 대한 파일 읽기함수
	public void test10000() {
		try {
			String path = System.getProperty("user.dir");
			File file = new File(path + "/src/Resource/test_10000.txt");
			FileReader filereader = new FileReader(file);
			BufferedReader bufreader = new BufferedReader(filereader);
			String line = "";
			while ((line = bufreader.readLine()) != null) {
				DLL10000.addLast(line);
			}
			bufreader.close();
			filereader.close();
		} catch (FileNotFoundException e) {
			System.out.println(e);
		} catch (IOException e) {
			System.out.println(e);
		}
	}
	
	public Double_Linked_List get_test100() {
		return DLL100;
	}
	
	public Double_Linked_List get_test1000() {
		return DLL1000;
	}
	
	public Double_Linked_List get_test10000() {
		return DLL10000;
	}
}
