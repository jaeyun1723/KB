package com.itskb.ws02;

import java.io.FileInputStream;
import java.util.Scanner;

public class EvenOddSum {

	public static void main(String[] args) {
		// System.setIn(new FileInputStream("src/EvenOddSumInput.txt"));
		Scanner sc = new Scanner(System.in);
		// Scanner sc = new Scanner(new File("data.txt")); // 경로 기준 : 프로젝트폴더
		int n = sc.nextInt();
		int[][] arr = new int[n][n];

		for (int i = 0; i < n; i++)
			for (int j = 0; j < n; j++)
				arr[i][j] = sc.nextInt();
		// delta 사용
		int[] xidx = { -1, 1, 0, 0 };
		int[] yidx = { 0, 0, 1, -1 };
		int result = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				int sum = 0;
				for (int k = 0; k < 4; k++) {
					int x = i + xidx[k];
					int y = j + yidx[k];
					if (x < 0 || y < 0 || x >= n || y >= n)
						continue;
					sum += arr[x][y];
				}
				if (sum % 2 == 0)
					result += arr[i][j];
			}
		}
		System.out.println(result);

	}// em

}// ec
