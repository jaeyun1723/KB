package day7;

import java.util.Arrays;

public class SumNumbers {
	static int N = 100, M = 5, target = 150, res = 0;
	static int[] arr = new int[N];
	static int[] select = new int[M];

	public static void main(String[] args) {
		for (int i = 0; i < N; i++)
			arr[i] = i + 1;

		backtracking(0, 0);
		System.out.println(res);
	}//

	static void backtracking(int cnt, int startIndex) {
		if (cnt == M) {
			int total = 0;
			for (int x : select)
				total += x;
			if (total == target) {
				System.out.println(Arrays.toString(select));
				res++;
			}
			return;
		}
		for (int i = startIndex; i < N; i++) {
			select[cnt] = arr[i];
			int total = 0;
			for (int j = 0; j <= cnt; j++)
				total += select[j];
			if (total <= target)
				backtracking(cnt + 1, i + 1);
		}

	}

}//
