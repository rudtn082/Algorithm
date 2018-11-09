package Algorithm;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Hash_Table {
	final static int SIZE = 59;
	final static int SIZE2 = 97;
	final static int NIL = -98765;
	ArrayList<Integer> data1 = new ArrayList<>();
	ArrayList<Integer> data2 = new ArrayList<>();
	ArrayList<Integer> data3 = new ArrayList<>();
	Linear_Insert LI = new Linear_Insert();
	Linear_Search LI_search = new Linear_Search();
	Linear_Delete LI_delete = new Linear_Delete();
	Quadratic_Insert QI = new Quadratic_Insert();
	Quadratic_Search QI_search = new Quadratic_Search();
	Quadratic_Delete QI_delete = new Quadratic_Delete();
	Double_Insert DI = new Double_Insert();
	Double_Search DI_search = new Double_Search();
	Double_Delete DI_delete = new Double_Delete();
	
	
	public Hash_Table() {
		System.out.println("\nLinear_Probing is starting...");
		init_Hash_table(data1);
		Data1_Linear_Insert();
		Data2_Linear_delete();
		Linear_Search();
		LI_search.save();
		System.out.println("------------------------------------------------");
		System.out.println("Quadratic_Probing is starting...");
		init_Hash_table(data1);
		Data1_Quadratic_Insert();
		Data2_Quadratic_delete();
		Quadratic_Search();
		QI_search.save();
		System.out.println("------------------------------------------------");
		System.out.println("Double_Hashing is starting...");
		init_Hash_table_for_size2(data1);
		Data1_Double_Insert();
		Data2_Double_delete();
		Double_Search();
		DI_search.save();
		System.out.println("------------------------------------------------");
		System.out.println("선형 조사 방법의 충돌 횟수는 " + LI.crash_times() + "번 입니다."
				+ "\n이차원 조사 방법의 충돌 횟수는 " + QI.crash_times() + "번 입니다."
				+ "\n더블해싱 방법의 충돌 횟수는 " + DI.crash_times() + "번 입니다.");
		
	}
	
	
	// 테이블을 nil 값으로 초기화 하는 함수
	public void init_Hash_table(ArrayList<Integer> Hash) {
		if(Hash.isEmpty() == false) {
			Hash.removeAll(Hash);
		}
		for(int i = 0; i < SIZE; i++) {
			Hash.add(i, NIL);
		}
	}
	
	// 테이블을 nil 값으로 초기화 하는 함수(Double)
	public void init_Hash_table_for_size2(ArrayList<Integer> Hash) {
		if(Hash.isEmpty() == false) {
			Hash.removeAll(Hash);
		}
		for(int i = 0; i < SIZE2; i++) {
			Hash.add(i, NIL);
		}
	}
	
	
	// Data1에 파일 읽어오기 함수 (Linear_Insert)
	public void Data1_Linear_Insert() {
		try {
			String path = System.getProperty("user.dir");
			File file = new File(path + "/src/Resource/Data1.txt");
			FileReader filereader = new FileReader(file);
			BufferedReader bufreader = new BufferedReader(filereader);
			String line = "";
			while ((line = bufreader.readLine()) != null) {
				LI.Linear_Insert_Start(data1, Integer.parseInt(line));
			}
			System.out.println("Linear_Insert is completed!");
			bufreader.close();
			filereader.close();
		} catch (FileNotFoundException e) {
			System.out.println(e);
		} catch (IOException e) {
			System.out.println(e);
		}
	}
	
	// Data1에 파일 읽어오기 함수 (Quadratic_Insert)
	public void Data1_Quadratic_Insert() {
		try {
			String path = System.getProperty("user.dir");
			File file = new File(path + "/src/Resource/Data1.txt");
			FileReader filereader = new FileReader(file);
			BufferedReader bufreader = new BufferedReader(filereader);
			String line = "";
			while ((line = bufreader.readLine()) != null) {
				QI.Quadratic_Insert_Start(data1, Integer.parseInt(line));
			}
			System.out.println("Quadratic_Insert is completed!");
			bufreader.close();
			filereader.close();
		} catch (FileNotFoundException e) {
			System.out.println(e);
		} catch (IOException e) {
			System.out.println(e);
		}
	}
	
	// Data1에 파일 읽어오기 함수 (Double_Insert)
	public void Data1_Double_Insert() {
		try {
			String path = System.getProperty("user.dir");
			File file = new File(path + "/src/Resource/Data1.txt");
			FileReader filereader = new FileReader(file);
			BufferedReader bufreader = new BufferedReader(filereader);
			String line = "";
			while ((line = bufreader.readLine()) != null) {
				DI.Double_Insert_Start(data1, Integer.parseInt(line));
			}
			System.out.println("Double_Insert is completed!");
			bufreader.close();
			filereader.close();
		} catch (FileNotFoundException e) {
			System.out.println(e);
		} catch (IOException e) {
			System.out.println(e);
		}
	}
	
	
	// Data1에 Data2삭제 함수 (Linear_Delete)
	public void Data2_Linear_delete() {
		try {
			String path = System.getProperty("user.dir");
			File file = new File(path + "/src/Resource/Data2.txt");
			FileReader filereader = new FileReader(file);
			BufferedReader bufreader = new BufferedReader(filereader);
			String line = "";
			while ((line = bufreader.readLine()) != null) {
				LI_delete.Linear_Delete_Start(data1, Integer.parseInt(line));
			}
			System.out.println("Linear_Delete is completed!");
			bufreader.close();
			filereader.close();
		} catch (FileNotFoundException e) {
			System.out.println(e);
		} catch (IOException e) {
			System.out.println(e);
		}
	}
	
	// Data1에 Data2삭제 함수 (Quadratic_Delete)
	public void Data2_Quadratic_delete() {
		try {
			String path = System.getProperty("user.dir");
			File file = new File(path + "/src/Resource/Data2.txt");
			FileReader filereader = new FileReader(file);
			BufferedReader bufreader = new BufferedReader(filereader);
			String line = "";
			while ((line = bufreader.readLine()) != null) {
				QI_delete.Quadratic_Delete_Start(data1, Integer.parseInt(line));
			}
			System.out.println("Quadratic_Delete is completed!");
			bufreader.close();
			filereader.close();
		} catch (FileNotFoundException e) {
			System.out.println(e);
		} catch (IOException e) {
			System.out.println(e);
		}
	}
	
	// Data1에 Data2삭제 함수 (Double_Delete)
	public void Data2_Double_delete() {
		try {
			String path = System.getProperty("user.dir");
			File file = new File(path + "/src/Resource/Data2.txt");
			FileReader filereader = new FileReader(file);
			BufferedReader bufreader = new BufferedReader(filereader);
			String line = "";
			while ((line = bufreader.readLine()) != null) {
				DI_delete.Double_Delete_Start(data1, Integer.parseInt(line));
			}
			System.out.println("Double_delete is completed!");
			bufreader.close();
			filereader.close();
		} catch (FileNotFoundException e) {
			System.out.println(e);
		} catch (IOException e) {
			System.out.println(e);
		}
	}
	
	// Linear_Search를 이용해 검색하는 함수
	public void Linear_Search() {
		try {
			String path = System.getProperty("user.dir");
			File file = new File(path + "/src/Resource/Data3.txt");
			FileReader filereader = new FileReader(file);
			BufferedReader bufreader = new BufferedReader(filereader);
			String line = "";
			while ((line = bufreader.readLine()) != null) {
				LI_search.Linear_Search_Start(data1, Integer.parseInt(line));
			}
			bufreader.close();
			filereader.close();
		} catch (FileNotFoundException e) {
			System.out.println(e);
		} catch (IOException e) {
			System.out.println(e);
		}
	}
	
	// Quadratic_Search를 이용해 검색하는 함수
	public void Quadratic_Search() {
		try {
			String path = System.getProperty("user.dir");
			File file = new File(path + "/src/Resource/Data3.txt");
			FileReader filereader = new FileReader(file);
			BufferedReader bufreader = new BufferedReader(filereader);
			String line = "";
			while ((line = bufreader.readLine()) != null) {
				QI_search.Quadratic_Search_Start(data1, Integer.parseInt(line));
			}
			bufreader.close();
			filereader.close();
		} catch (FileNotFoundException e) {
			System.out.println(e);
		} catch (IOException e) {
			System.out.println(e);
		}
	}
	
	// Double_Search를 이용해 검색하는 함수
	public void Double_Search() {
		try {
			String path = System.getProperty("user.dir");
			File file = new File(path + "/src/Resource/Data3.txt");
			FileReader filereader = new FileReader(file);
			BufferedReader bufreader = new BufferedReader(filereader);
			String line = "";
			while ((line = bufreader.readLine()) != null) {
				DI_search.Double_Search_Start(data1, Integer.parseInt(line));
			}
			bufreader.close();
			filereader.close();
		} catch (FileNotFoundException e) {
			System.out.println(e);
		} catch (IOException e) {
			System.out.println(e);
		}
	}
}
