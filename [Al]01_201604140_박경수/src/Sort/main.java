package Sort;

import Algorithm.*;

public class main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("정렬 후 Resource 폴더에  txt 파일로 저장합니다...");
		System.out.println("1만라인 버블정렬, 선택정렬은 2시간이상이 소요됩니다...ㅠ");
		System.out.println("1만라인은 진행상황을 1000라인 마다 표시합니다.");
		System.out.println("------------------------------------------------");
		Insertion_Sort Insert = new Insertion_Sort();
		Bubble_Sort bubble = new Bubble_Sort();
		Selection_Sort Select = new Selection_Sort();
		System.out.println("완료되었습니다!");
	}
}
