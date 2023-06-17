package day5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class kb1반_알고리즘1번_김재윤 {

	static int[] arr;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		arr = new int[N];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			arr[i] = Integer.parseInt(st.nextToken());
		}
		int midx;
		for (int i = 0; i < N; i++) {
			midx = i;
			for (int j = i + 1; j < N; j++) {
				if (arr[midx] < arr[j])
					midx = j;
			}
			swap(i, midx);
		}

		for (int i = 0; i < N; i++)
			System.out.println(arr[i]);
	}//

	static void swap(int i, int j) {
		int tmp = arr[i];
		arr[i] = arr[j];
		arr[j] = tmp;
	}
}//
