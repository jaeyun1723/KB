package day2;

import java.util.ArrayList;
import java.util.LinkedList;

public class LinkedListTest {

	public static void main(String[] args) {
		
		int N = 100000;
		long start, end;
		ArrayList<Integer> arr = new ArrayList<>();
		LinkedList<Integer> list = new LinkedList<>();
		
		// 리스트 값
		start = System.currentTimeMillis();
		for (int i = 0; i < N; i++)
			list.add(0, i);
		end = System.currentTimeMillis();
		System.out.println("실행 시간 : " + (end - start));

		// 배열 값
		start = System.currentTimeMillis();
		for (int i = 0; i < N; i++)
			arr.add(i);
		end = System.currentTimeMillis();
		System.out.println("실행 시간 : " + (end - start));

	}// etc

}// etc
