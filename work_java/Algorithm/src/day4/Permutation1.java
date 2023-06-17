package day4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Permutation1 {

	static int N, R, totalCnt;
	static int[] numbers;
	static List<Integer> list;
	static boolean[] isSelected;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		numbers = new int[N];
		list = new ArrayList<>();
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++)
			numbers[i] = Integer.parseInt(st.nextToken());
		isSelected = new boolean[N];
		perm(0);
		System.out.println(totalCnt);
	}// s

	static void perm(int cnt) { // cnt : 현재 뽑아야 하는 카드 위치
		if (cnt == R) {
			totalCnt++;
			System.out.println(list.toString());
			System.out.println(Arrays.toString(isSelected));
			return;
		}
		for (int idx = 0; idx < N; idx++) {
			if (!isSelected[idx]) {
				isSelected[idx] = true;
				list.add(numbers[idx]);
				perm(cnt + 1);
				list.remove(list.size()-1);
				isSelected[idx] = false;
			}
		}
	}
}//
