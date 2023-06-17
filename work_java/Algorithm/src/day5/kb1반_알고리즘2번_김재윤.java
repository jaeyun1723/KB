package day5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class kb1반_알고리즘2번_김재윤 {

	static int N, M, COUNT = 3, result = -1;
	static int[] arr;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(br.readLine());
		arr = new int[N];
		for (int i = 0; i < N; i++)
			arr[i] = Integer.parseInt(st.nextToken());
		nearValue(0, 0, 0);
		System.out.println(result);
	}//

	static void nearValue(int cnt, int idx, int value) {
		if (cnt == COUNT) {
			if (Math.abs(M - value) < Math.abs(M - result)) 
				result = value;
			return;
		}
		for (int i = idx; i < N; i++) {
			value += arr[i];
			nearValue(cnt + 1, i + 1, value);
			value -= arr[i];
		}
	}
}//
